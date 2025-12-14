package com.soni.lockr.controller;

import com.soni.lockr.entity.Password;
import com.soni.lockr.service.PasswordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping
    public Password createPassword(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return passwordService.savePassword(username, password);
    }

    @GetMapping
    public List<Password> getAllPasswords() {
        return passwordService.getAllPasswords();
    }
}
