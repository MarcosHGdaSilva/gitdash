// package br.com.fiap.gitdash.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.server.SecurityWebFilterChain;

// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityWebFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                 .oauth2Login(login -> login.loginPage("/login").permitAll())
//                 .logout(logout -> logout.logoutUrl("/logout").logoutSucessURL())
//                 ;            
//         return http.build();
//     }
// }
