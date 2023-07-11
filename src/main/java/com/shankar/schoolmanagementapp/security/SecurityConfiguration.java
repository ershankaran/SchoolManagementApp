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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
// @EnableWebMvc
public class SecurityConfiguration {

    @Autowired
    DataSource dataSource;

    // @Bean
    // public DataSource dataSource() {
    //     return new EmbeddedDatabaseBuilder()
    //         .setType(EmbeddedDatabaseType.H2)
    //         .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    //         .build();
    // }

    @Bean
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource){
        
        JdbcUserDetailsManager usersFinal = new JdbcUserDetailsManager(dataSource);
        usersFinal.setUsersByUsernameQuery("select username,password,enabled from user_accounts WHERE username = ?");
        usersFinal.setAuthoritiesByUsernameQuery("select username,role from user_accounts wHERE username = ?");
        

        return usersFinal;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http
        // .csrf(csrf -> csrf.disable())        
        // .headers(hdrs -> hdrs.frameOptions().sameOrigin())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/classrooms/save").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/students/save").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/teachers/save").hasAuthority("ROLE_ADMIN")
            // .requestMatchers("/classrooms").hasAuthority("USER")
            // .requestMatchers("/","/**").permitAll()
            .anyRequest().authenticated()            
            
        )               
        .formLogin( form -> form.permitAll())
        // .logout(logout -> logout
        //         .deleteCookies("JSESSIONID")
        //         .logoutUrl("/logout")
        //         .logoutSuccessUrl("/logout-success"))        
             
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
