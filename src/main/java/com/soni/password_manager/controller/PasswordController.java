package com.soni.password_manager.controller;

import com.soni.password_manager.entity.Password;
import com.soni.password_manager.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passwords")
@CrossOrigin(origins = "*")
public class PasswordController {
    
    @Autowired
    private PasswordService passwordService;

    // CREATE - POST /api/v1/passwords
    @PostMapping
    public ResponseEntity<Password> createPassword(
            @RequestParam String serviceName,
            @RequestParam String username,
            @RequestParam String password) {
        try {
            Password created = passwordService.createPassword(serviceName, username, password);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // READ ALL - GET /api/v1/passwords
    @GetMapping
    public ResponseEntity<List<Password>> getAllPasswords() {
        return ResponseEntity.ok(passwordService.getAllPasswords());
    }

    // READ BY ID - GET /api/v1/passwords/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Password> getPasswordById(@PathVariable Long id) {
        return passwordService.getPasswordById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // READ BY USERNAME - GET /api/v1/passwords/username/{username}
    @GetMapping("/username/{username}")
    public ResponseEntity<Password> getPasswordByUsername(@PathVariable String username) {
        return passwordService.getPasswordByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE PASSWORD - PUT /api/v1/passwords/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Password> updatePassword(
            @PathVariable Long id,
            @RequestParam String newPassword) {
        try {
            Password updated = passwordService.updatePassword(id, newPassword);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // DELETE - DELETE /api/v1/passwords/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassword(@PathVariable Long id) {
        try {
            passwordService.deletePassword(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
