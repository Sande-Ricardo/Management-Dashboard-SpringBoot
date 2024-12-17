package com.managementDashboard.RestAPI.config;


import com.managementDashboard.RestAPI.service.UserDetailsServiceImpl;
//import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http -> {
////                    Public endpoints configuration
//                    http.requestMatchers(HttpMethod.GET, "/user/get").permitAll();
//
////                    Private endpoints configuration
//                    http.requestMatchers(HttpMethod.GET, "/user/get/1").hasAuthority("READ");
//                    http.requestMatchers(HttpMethod.POST, "/user/set").hasAuthority("CREATE");
//                    http.requestMatchers(HttpMethod.POST, "/user/set").hasRole("ADMIN");
//                    http.requestMatchers(HttpMethod.POST, "/user/set").hasAnyRole("ADMIN", "DEVELOPER");
//
////                    Rest of endpoints configuration
//                    http.anyRequest().denyAll();
////                    http.anyRequest().authenticated();
//
//
//                })
//                .build();
//    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    };

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    };

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    };

    @Bean
    public PasswordEncoder passwordEncoder(){

//        return NoOpPasswordEncoder.getInstance();

        return new BCryptPasswordEncoder();

    };

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("1234"));
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<UserDetails> userDetailsList = new ArrayList<>();
//        userDetailsList.add(
//                User
//                        .withUsername("admin")
//                        .password("1234")
//                        .roles("ADMIN")
//                        .authorities("READ", "CREATE")
//                        .build()
//        );
//        userDetailsList.add(
//                User
//                        .withUsername("user")
//                        .password("1234")
//                        .roles("USER")
//                        .authorities("READ")
//                        .build()
//        );
//        return new InMemoryUserDetailsManager(userDetailsList);
//    };

}
