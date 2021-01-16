package com.kaya.authorizationserver.repository;

import com.kaya.authorizationserver.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
  Optional<AuthUser> findByUsername(String username);
}
