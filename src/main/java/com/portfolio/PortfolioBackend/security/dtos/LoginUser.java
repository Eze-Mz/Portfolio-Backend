package com.portfolio.PortfolioBackend.security.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginUser {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
