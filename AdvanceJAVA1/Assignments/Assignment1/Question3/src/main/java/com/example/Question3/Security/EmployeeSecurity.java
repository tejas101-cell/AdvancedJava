package com.example.Question3.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.Security;

//@Configuration
//public class EmployeeSecurity {
//    // first bean to add authenticate employees insede the memory
//    // therefore use InMemoryUserDetailsManager (User details manager)
//    @Bean
//    UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }
////    @Bean
////    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
////        // using UserDetails class to set roles password and user name using user.builder method
////        UserDetails Tejas = User.builder().username("tejas").password("{noop}tejas@#$").roles("Employee").build();
////        return new InMemoryUserDetailsManager(Tejas);
////    }
//    // second bean to authorize the employee
//    // using SecurityFilterChain method to configure endpoints (define the access)
//    // adding HttpSecurity object inside it
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        // then using HttpauthorizeHttpRequests (authorzing requests) to configure endpoints
//        http.authorizeHttpRequests(configure -> configure
//                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
//        // basic authorization is used
//        http.httpBasic(Customizer.withDefaults());
//        // using csrf method and object inside it to disable the csrf
//        http.csrf(csrf->csrf.disable());
//        // building and returing
//        return http.build();
//    }
//
//}

@Configuration
public class EmployeeSecurity{
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        return new JdbcUserDetailsManager(datasource);
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.authorizeHttpRequests(configurer -> configurer
                            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER"));
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
