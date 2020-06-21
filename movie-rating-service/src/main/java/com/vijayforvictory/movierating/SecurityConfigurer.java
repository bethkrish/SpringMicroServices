package com.vijayforvictory.movierating;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	// This value is retrieved from application.properties
	@Value("${app.userconfig.superuser.username: superuser}")
	private String superUserName;

	// This value is retrieved from application.properties
	@Value("${app.userconfig.superuser.password: superuser}")
	private String superUserPassword;

	/**
	 * Configure Authentication to SpringBoot App
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("vijay").password("vijay").roles("ADMIN").and().withUser(superUserName).password(superUserPassword).roles("USER");
	}

	/**
	 * Configure Authorisation Roles to SpringBoot App
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/hello").hasAnyRole("USER",
		// "ADMIN").antMatchers("/user").hasAnyRole("USER", "ADMIN")
		// .antMatchers("/").permitAll().and().formLogin();
		http.authorizeRequests().antMatchers("/user").hasAnyRole("USER", "ADMIN").antMatchers("/").permitAll().and().formLogin();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
