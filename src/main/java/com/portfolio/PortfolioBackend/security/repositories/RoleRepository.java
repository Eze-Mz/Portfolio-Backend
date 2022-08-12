package com.portfolio.PortfolioBackend.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.PortfolioBackend.security.entities.Role;
import com.portfolio.PortfolioBackend.security.enums.RoleList;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
}
