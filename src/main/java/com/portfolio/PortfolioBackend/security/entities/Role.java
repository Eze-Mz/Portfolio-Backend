package com.portfolio.PortfolioBackend.security.entities;

import com.portfolio.PortfolioBackend.security.enums.RoleList;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleList roleName;

    public Role() {
    }

    public Role(RoleList roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleList getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleList roleName) {
        this.roleName = roleName;
    }

}
