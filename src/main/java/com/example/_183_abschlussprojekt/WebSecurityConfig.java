package com.example._183_abschlussprojekt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final Logger logger = LogManager.getLogger(InsecurePasswordEncoder.class);

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        logger.info("Creating user details...");
        UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    //https://reflectoring.io/spring-security/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring security filter chain...");

        http.formLogin(form -> form.loginPage("/login").permitAll().successForwardUrl("/secret"));
        http.logout((logout) -> logout.logoutUrl("/logout/"));
        return null;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        logger.info("Creating password encoder...");

        return new InsecurePasswordEncoder();
    }
}
