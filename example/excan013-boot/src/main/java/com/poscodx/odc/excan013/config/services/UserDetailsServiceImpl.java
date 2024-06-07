package com.poscodx.odc.excan013.config.services;

import com.poscodx.odc.excan013.store.jpo.ExcanPerRoleJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanRoleJpo;
import com.poscodx.odc.excan013.store.jpo.ExcanUserJpo;
import com.poscodx.odc.excan013.store.repository.ExcanPerRoleRepository;
import com.poscodx.odc.excan013.store.repository.ExcanPermissionRepository;
import com.poscodx.odc.excan013.store.repository.ExcanRoleRepository;
import com.poscodx.odc.excan013.store.repository.ExcanUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  ExcanUserRepository userRepository;

  @Autowired
  ExcanRoleRepository roleRepository;
  @Autowired
  ExcanPerRoleRepository perRoleRepository;

  @Autowired
  ExcanPermissionRepository permissionRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ExcanUserJpo user = userRepository.findByName(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with UserName: " + username));
    Optional<ExcanRoleJpo> role = roleRepository.findById(user.getRoleId());
    String roleName = "ROLE_STAFF";
    if (role.isPresent()) {
      roleName = role.get().getName();
    }
    return UserDetailsImpl.build(user, null);
  }

  @Transactional
  public UserDetails loadUserById(String id) throws RuntimeException {
    ExcanUserJpo user = userRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with Id: " + id));
    Optional<ExcanRoleJpo> role = roleRepository.findById(user.getRoleId());
    if (role.isPresent()) {
      List<Integer> perIds = perRoleRepository.findByRoleId(user.getRoleId()).stream().map(ExcanPerRoleJpo::getPermissionId).collect(Collectors.toList());
      Set<String> perName = perIds.stream().map(i -> Objects.requireNonNull(permissionRepository.findById(i).orElse(null)).getName()).collect(Collectors.toSet());
      return UserDetailsImpl.build(user, perName);
    }
    return new UserDetailsImpl(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRoleId(),
            user.getAvatar(),
            null);
  }

}
