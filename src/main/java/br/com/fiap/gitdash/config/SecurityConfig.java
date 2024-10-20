package br.com.fiap.gitdash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            // .oauth2Login(oauth2 -> oauth2.loginPage("/").permitAll())
            .oauth2Login(login -> login.loginPage("/").permitAll())
            .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/"));
            
        return http.build();
    }
}
