package com.poscodx.odc.excan013.rest;

import com.poscdx.odc.excan013.domain.entity.ExcanAccessToken;
import com.poscdx.odc.excan013.domain.entity.ExcanPermission;
import com.poscdx.odc.excan013.domain.entity.ExcanRole;
import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.payload.request.LoginRequest;
import com.poscdx.odc.excan013.domain.entity.payload.response.JwtResponse;
import com.poscdx.odc.excan013.domain.entity.payload.response.LoginUserInfo;
import com.poscdx.odc.excan013.domain.entity.payload.response.UserResponse;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.Level2UserService;
import com.poscodx.odc.excan013.config.jwt.JwtUtils;
import com.poscodx.odc.excan013.config.services.UserDetailsImpl;
import com.poscodx.odc.excan013.store.jpo.ExcanPermissionJpo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthResource {

  private final AuthenticationManager authenticationManager;
  private final ServiceLifecycle serviceLifecycle;
  private final PasswordEncoder encoder;
  private final JwtUtils jwtUtils;

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody ExcanUser signUpRequest) {
    signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
    Level2UserService level2UserService = serviceLifecycle.requestLevel2UserService();
    UserResponse result = level2UserService.addUser(signUpRequest);
    return ResponseEntity.status(result.getCode()).body(result);
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ExcanRole userRole = serviceLifecycle.requestExcanRoleService().find(userDetails.getRole());
    Set<ExcanPermission> userPers = userRole.getPermissions();
    Map<Integer, List<ExcanPermission>> permissions = userPers.stream().collect(groupingBy(ExcanPermission::getGroup));

    LoginUserInfo userInfo = LoginUserInfo.builder()
            .id(userDetails.getId())
            .username(userDetails.getUsername())
            .email(userDetails.getEmail())
            .roleId(userRole.getId())
            .roleName(userRole.getName())
            .avatar(userDetails.getAvatar())
            .build();

    return ResponseEntity.ok(new JwtResponse(jwt,
            userInfo,
            permissions));
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logout(HttpServletRequest request) {
    String jwtToken = parseJwt(request);
    System.out.println("jwt token: " + jwtToken);
    if(jwtToken == null || jwtToken.isEmpty()){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not logged in yet!");
    } else {
      if(serviceLifecycle.requestExcanAccessTokenService().findByToken(jwtToken).isEmpty()){
        //Save logout access token to blacklist
        ExcanAccessToken token = ExcanAccessToken.builder()
                .token(jwtToken)
                .status(1) //blacklist token
                .build();
        serviceLifecycle.requestExcanAccessTokenService().register(token);
      }
      return ResponseEntity.ok().body("Logout successfully!");
    }
  }

  private String parseJwt(HttpServletRequest request) {
    String headerAuth = request.getHeader("Authorization");
    System.out.println("Authorization: " + headerAuth);

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      return headerAuth.substring(7);
    }

    return null;
  }
}
