package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.enums.Role;
import com.codewithproject.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE tb_bb_user", nativeQuery = true)
    void truncateTable();

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT u.* "
            + " FROM tb_bb_user u "
            + " WHERE u.email LIKE :emailOrUsername "
            + " OR u.username LIKE :emailOrUsername ", nativeQuery = true)
    Optional<User> getUserByEmailOrUsername(@Param("emailOrUsername") String emailOrUsername);

    User findByRole(Role role);

    @Query(value = "SELECT id, email, firstname, lastname, role, username, password "
            + " FROM tb_bb_user "
            + " WHERE role = :role", nativeQuery = true)
    List<User> getListByRole(Role role);
}
