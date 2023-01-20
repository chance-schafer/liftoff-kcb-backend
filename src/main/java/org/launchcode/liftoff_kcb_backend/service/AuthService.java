package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.dto.AuthResponseDTO;
import org.launchcode.liftoff_kcb_backend.dto.LoginDto;
import org.launchcode.liftoff_kcb_backend.dto.RegisterDto;

public interface AuthService {
    AuthResponseDTO login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
