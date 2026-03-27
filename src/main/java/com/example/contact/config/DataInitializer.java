package com.example.contact.config;

import com.example.contact.model.AppUser;
import com.example.contact.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Seeds a default ADMIN user on startup if the users table is empty.
 *
 * Default credentials:
 *   Username: admin
 *   Password: admin123
 */
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.count() == 0) {
                AppUser admin = new AppUser(
                        "admin",
                        encoder.encode("admin123"),
                        "ADMIN"
                );
                userRepository.save(admin);
                System.out.println("========================================");
                System.out.println("  Default admin user created");
                System.out.println("  Username : admin");
                System.out.println("  Password : admin123");
                System.out.println("========================================");
            }
        };
    }
}
