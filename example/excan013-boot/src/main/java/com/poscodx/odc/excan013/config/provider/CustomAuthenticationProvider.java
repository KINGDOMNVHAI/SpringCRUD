package com.poscodx.odc.excan013.config.provider;

import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.store.ExcanPermissionStore;
import com.poscdx.odc.excan013.domain.store.ExcanUserStore;
import com.poscodx.odc.excan013.config.services.UserDetailsServiceImpl;
import com.poscodx.odc.excan013.store.jpo.ExcanUserJpo;
import com.poscodx.odc.excan013.store.repository.ExcanPermissionRepository;
import com.poscodx.odc.excan013.store.repository.ExcanUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder encoder;
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String id = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        UserDetails currentUser = userDetailsService.loadUserById(id);
        if (currentUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Example: validating credentials
        if (!encoder.matches(password, currentUser.getPassword())) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        // Create a fully authenticated Authentication object
        return new UsernamePasswordAuthenticationToken(currentUser, password, currentUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
