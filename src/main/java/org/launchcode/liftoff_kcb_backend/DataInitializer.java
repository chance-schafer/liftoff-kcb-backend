package org.launchcode.liftoff_kcb_backend;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.liftoff_kcb_backend.services.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final RoleService roleService;
    @NonNull
    private final boolean shouldGenerateRoles;

    public DataInitializer(RoleService roleService, @Value("${app.generate-roles-on-startup}") boolean shouldGenerateRoles) {
        this.roleService = roleService;
        this.shouldGenerateRoles = shouldGenerateRoles;
    }


    @Override
    public void run(String... args) {
        if (shouldGenerateRoles) {
            roleService.createRoleIfNotExists("USER");
            roleService.createRoleIfNotExists("BUSINESS_OWNER");
        }
    }
}
