package com.portfolio.PortfolioBackend.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.PortfolioBackend.security.entities.Role;
import com.portfolio.PortfolioBackend.security.enums.RoleList;
import com.portfolio.PortfolioBackend.security.repositories.RoleRepository;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleList roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
