package com.tp2.SecurityController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.logout();
        http.authorizeRequests().antMatchers("/save**/**","/edit**/**","/delete**/**","/form**/**").hasAnyRole("ADMIN");

        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = passwordEncoder() ;
        auth.inMemoryAuthentication().withUser("user1").password(pe.encode("1234")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user2").password(pe.encode("1234")).roles("USER");

    }
    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder() ;
    }
}
