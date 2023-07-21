package com.shankar.schoolmanagementapp.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
        .csrf(csrf -> csrf.disable())        
        // .headers(hdrs -> hdrs.frameOptions().sameOrigin())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/classrooms/save").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/students/save").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/teachers/save").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/register").hasAnyAuthority("ROLE_ADMIN")
            .requestMatchers("/classrooms").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
            .requestMatchers("/teachers").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
            .requestMatchers("/students").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
            // .requestMatchers("/classrooms").permitAll()
            .requestMatchers("/home","*/**").permitAll()
            .anyRequest().authenticated()            
            
        )               
        .formLogin( form -> form.permitAll() )
        // .logout(logout -> logout
        //         .addLogoutHandler(clearSiteData)
        //         .logoutUrl("/appLogout")
        //         .logoutSuccessUrl("/appLogout"))
             
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
