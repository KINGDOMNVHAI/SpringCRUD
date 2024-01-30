package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.enums.Role;
import com.codewithproject.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE user", nativeQuery = true)
    void truncateTable();

    Optional<User> findByEmail(String username);

    User findByRole(Role role);
}
