package com.zensar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zensar.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication().withUser("tom").password(this.passwordEncoder.encode("tom123")).roles("USER")
//		.and().withUser("jerry").password(this.passwordEncoder.encode("123")).roles("ADMIN");
//
//	auth.userDetailsService(userDetailsService);
//
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/user").hasAnyRole("USER", "ADMIN").antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/all").permitAll().and().formLogin();

    }
}
