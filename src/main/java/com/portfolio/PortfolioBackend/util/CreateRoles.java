package com.portfolio.PortfolioBackend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfolio.PortfolioBackend.security.entities.Role;
import com.portfolio.PortfolioBackend.security.enums.RoleList;
import com.portfolio.PortfolioBackend.security.repositories.RoleRepository;

@Component
public class CreateRoles implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role rolUser = new Role(RoleList.ROLE_USER);
        roleRepository.save(rolUser);

    }

}
