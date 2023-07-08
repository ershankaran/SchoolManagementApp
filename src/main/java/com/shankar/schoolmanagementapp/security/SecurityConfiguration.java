package com.shankar.schoolmanagementapp.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // @Autowired
    // DataSource dataSource;

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
    }

    @Bean
    public UserDetailsManager userDetailsService(DataSource dataSource){
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

        JdbcUserDetailsManager usersFinal = new JdbcUserDetailsManager(dataSource);
        usersFinal.createUser(user1);
        usersFinal.createUser(user2);
        usersFinal.createUser(user3);

        return usersFinal;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
        .csrf(csrf -> csrf.disable())
        .headers(hdrs -> hdrs.frameOptions().disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/classrooms/save").hasRole("ADMIN")
            .requestMatchers("/students/save").hasRole("ADMIN")
            .requestMatchers("/teachers/save").hasRole("ADMIN")
            .requestMatchers("*/*").hasRole("USER")
            .requestMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
        )       
        .httpBasic(Customizer.withDefaults())
        .build();
    }

//     @Bean
//     DataSource dataSource() {
// 	    return new EmbeddedDatabaseBuilder()
//                 .setType()
//                 .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                 .build();
// }

   

         
}
