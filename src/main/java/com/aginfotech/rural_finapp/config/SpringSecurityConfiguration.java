package com.aginfotech.rural_finapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .anyRequest().authenticated() .and() .oauth2Login()
	 * .and() .csrf().disable() .logout() .logoutUrl("/signout")
	 * .logoutSuccessUrl("/") .invalidateHttpSession(true)
	 * .deleteCookies("JSESSIONID");
	 * 
	 * }
	 */

	@Bean
	public UserDetailsService users() {
		// The builder will ensure the passwords are encoded before saving in memory
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
			.username("user")
			.password("password")
			.roles("group1")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("password")
			.roles("group1")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authz) -> authz.anyRequest()
								.authenticated())
								.httpBasic()
								.and()
								.csrf()
								.disable()
								.logout()
								.logoutUrl("/signout")
								.logoutSuccessUrl("/") .invalidateHttpSession(true)
								.deleteCookies("JSESSIONID")
								.and()
								.headers().frameOptions().disable();
		return http.build();
	}

}
