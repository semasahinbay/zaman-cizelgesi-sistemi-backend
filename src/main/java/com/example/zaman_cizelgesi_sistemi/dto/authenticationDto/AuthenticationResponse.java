package com.example.zaman_cizelgesi_sistemi.dto.authenticationDto;


public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}