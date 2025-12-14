package com.soni.lockr.service;

import com.soni.lockr.entity.Password;
import com.soni.lockr.repository.PasswordRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    public Password savePassword(String username, String rawPassword) {
        String encrypted = encoder.encode(rawPassword);
        Password password = new Password(username, encrypted);
        return passwordRepository.save(password);
    }

    public List<Password> getAllPasswords() {
        return passwordRepository.findAll();
    }
}
