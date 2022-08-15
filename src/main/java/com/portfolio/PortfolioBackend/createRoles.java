package com.portfolio.PortfolioBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfolio.PortfolioBackend.security.entities.Role;
import com.portfolio.PortfolioBackend.security.enums.RoleList;
import com.portfolio.PortfolioBackend.security.repositories.RoleRepository;

@Component
public class createRoles implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleUser = new Role(RoleList.ROLE_USER);
        roleRepository.save(roleUser);

    }

}
