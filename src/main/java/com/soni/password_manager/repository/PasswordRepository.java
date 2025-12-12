package com.soni.password_manager.repository;

import com.soni.password_manager.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
    Optional<Password> findByUsername(String username);
    boolean existsByUsername(String username);
}

