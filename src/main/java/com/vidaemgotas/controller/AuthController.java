
package com.vidaemgotas.controller;

import com.vidaemgotas.dto.JwtResponse;
import com.vidaemgotas.dto.LoginRequest;
import com.vidaemgotas.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return authService.autenticar(request);
    }
}
