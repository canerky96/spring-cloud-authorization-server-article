package com.kaya.authorizationserver.service;

import com.kaya.authorizationserver.entity.AuthUser;
import com.kaya.authorizationserver.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

  private final AuthUserRepository authUserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    AuthUser user =
        authUserRepository
            .findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    new AccountStatusUserDetailsChecker().check(user);
    return user;
  }
}
