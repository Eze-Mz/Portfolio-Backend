package com.portfolio.PortfolioBackend.security.dtos;

import javax.validation.constraints.NotNull;

public class LoginUser {
    @NotNull
    private String email;
    @NotNull
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
