package org.launchcode.liftoff_kcb_backend.controller;

import lombok.AllArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.AuthResponseDTO;
import org.launchcode.liftoff_kcb_backend.dto.LoginDto;
import org.launchcode.liftoff_kcb_backend.dto.RegisterDto;
import org.launchcode.liftoff_kcb_backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    @CrossOrigin("*")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
       }

    @PostMapping("register")
    @CrossOrigin("*")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerDto));
    }
}
