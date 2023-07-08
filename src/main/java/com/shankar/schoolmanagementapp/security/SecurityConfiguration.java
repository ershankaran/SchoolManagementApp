package com.shankar.schoolmanagementapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user1 = users
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

        UserDetails user2 = users
                    .username("user2")
                    .password("password2")
                    .roles("USER")
                    .build();

        UserDetails user3 = users
                    .username("user3")
                    .password("password3")
                    .roles("USER","ADMIN")
                    .build();

            return new InMemoryUserDetailsManager(user1,user2,user3);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/classrooms/save").hasRole("ADMIN")
            .requestMatchers("/students/save").hasRole("ADMIN")
            .requestMatchers("/teachers/save").hasRole("ADMIN")
            .requestMatchers("*/*").hasRole("USER")
            .anyRequest().authenticated()
        )       
        .httpBasic(Customizer.withDefaults())
        .build();
    }

         
}
