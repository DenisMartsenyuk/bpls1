package ru.lab.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lab.lab1.dto.LoginReqDTO;
import ru.lab.lab1.dto.TokenRespDTO;
import ru.lab.lab1.security.jwt.JWTProvider;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO loginReqDTO) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqDTO.getLogin(), loginReqDTO.getPassword()));
        String token = tokenProvider.generateToken((UserDetails) authentication.getPrincipal());
        return new ResponseEntity<>(TokenRespDTO.builder().token(token).build(), HttpStatus.OK);
    }

}
