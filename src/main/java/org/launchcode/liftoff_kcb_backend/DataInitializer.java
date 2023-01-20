package org.launchcode.liftoff_kcb_backend;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.liftoff_kcb_backend.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final RoleServiceImpl roleService;
    @NonNull
    private final boolean shouldGenerateRoles;

    public DataInitializer(RoleServiceImpl roleService, @Value("${app.generate-roles-on-startup}") boolean shouldGenerateRoles) {
        this.roleService = roleService;
        this.shouldGenerateRoles = shouldGenerateRoles;
    }


    @Override
    public void run(String... args) {
//        if (shouldGenerateRoles) {
//            roleService.createRoleIfNotExists("USER");
//            roleService.createRoleIfNotExists("BUSINESS_OWNER");
//        }
    }
}
