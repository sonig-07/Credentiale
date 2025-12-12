package com.soni.password_manager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "passwords")
public class Password {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, updatable = false)
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 50, message = "Username must be 3-50 characters")
    private String username;
    
    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false, length = 255)
    private String encryptedPassword;
    
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Default constructor (JPA requirement)
    public Password() {}
    
    public Password(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }

    public String getEncryptedPassword() { return encryptedPassword; }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    // compatibility methods used by service layer
    public String getEncryptedValue() { return encryptedPassword; }
    public void setEncryptedValue(String encryptedValue) { this.encryptedPassword = encryptedValue; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    @Override
    public String toString() {
        return "password{id=" + id + ", username='" + username + "'}";
    }
}

