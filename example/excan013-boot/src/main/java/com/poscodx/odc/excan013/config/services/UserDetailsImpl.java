package com.poscodx.odc.excan013.config.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poscodx.odc.excan013.store.jpo.ExcanUserJpo;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private String id;

  private String username;

  private String email;

  private int role;

  private String avatar;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(String id,
                         String username,
                         String email,
                         String password,
                         int role,
                         String avatar,
                         Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
//    this.avatar = avatar;
    this.password = password;
    this.role = role;
    this.avatar = avatar;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(ExcanUserJpo user, Set<String> perNames) {

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    for (String per : perNames) {
      authorities.add(new SimpleGrantedAuthority(per));
    }
//    Collections.singleton(new SimpleGrantedAuthority(roleName));

    return new UserDetailsImpl(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRoleId(),
            user.getAvatar(),
            authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
