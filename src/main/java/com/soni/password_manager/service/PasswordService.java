package com.soni.password_manager.service;

import com.soni.password_manager.entity.Password;
import com.soni.password_manager.repository.PasswordRepository;   // FIXED (lowercase)
import com.soni.password_manager.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PasswordService {

    @Autowired
    private PasswordRepository repository;

    @Autowired
    private EncryptionUtil encryptionUtil;

    // Create a new password entry
    public Password createPassword(String serviceName, String username, String rawPassword) {

        // check unique username
        if (repository.existsByUsername(username)) {
            throw new RuntimeException("Username '" + username + "' already exists");
        }

        // encrypt password
        String encryptedValue = encryptionUtil.encryptPassword(rawPassword);

        // create entity (match your Password.java fields!)
        Password password = new Password();
        password.setServiceName(serviceName);
        password.setUsername(username);
        password.setEncryptedValue(encryptedValue);

        return repository.save(password);
    }

    public List<Password> getAllPasswords() {
        return repository.findAll();
    }

    public Optional<Password> getPasswordById(Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return repository.findById(id);
    }

    public Optional<Password> getPasswordByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Password updatePassword(Long id, String newRawPassword) {
        Objects.requireNonNull(id, "id must not be null");

        Password password = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Password not found with id: " + id));

        String newEncryptedValue = encryptionUtil.encryptPassword(newRawPassword);

        password.setEncryptedValue(newEncryptedValue);

        return repository.save(password);
    }

    public void deletePassword(Long id) {
        Objects.requireNonNull(id, "id must not be null");

        if (!repository.existsById(id)) {
            throw new RuntimeException("Password not found with id: " + id);
        }

        repository.deleteById(id);
    }
}
