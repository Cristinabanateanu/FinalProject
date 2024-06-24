package com.example.FinalProject.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeHttpRequests(auth -> {
            auth
                    .requestMatchers("/final_project/v1/register").permitAll()
                    .requestMatchers("/final_project/v1/signin").permitAll()
                    .requestMatchers("/final_project/v1/accountType/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/final_project/v1/auction/")
                    .hasAuthority("ADMIN") // endpoint protejat( doar un user il poate accesa)
                    .requestMatchers(HttpMethod.POST, "/final_project/v1/usersAccount/")
                    .hasAuthority("ADMIN") //endpoint protejat(doar un admin il poate accesa)
                    .requestMatchers(HttpMethod.DELETE,"/final_project/v1/usersAccount/")
                    .hasAuthority("ADMIN")
                    .anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder()

    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager
            (HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder
                = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
