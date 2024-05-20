package com.salesianostriana.dam.mendezespanapabloproyecto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationSuccessHandler authenticationSuccessHandler;
	
	
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	
	@Bean
	public AuthenticationManager 
			authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
	}
	
	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 
		 	RequestCache requestCache = new NullRequestCache();
		 
	        http.authorizeHttpRequests(
	                        (authz) -> authz.requestMatchers("/css/**", "/js/**", "/h2-console/**", "/img/**").permitAll()
	                                .requestMatchers("/admin/**").hasRole("ADMIN")
	                                .anyRequest().authenticated())
	        						.requestCache(cache -> cache.requestCache(requestCache))
	                .formLogin((loginz) -> loginz
	                        .loginPage("/login").successHandler(authenticationSuccessHandler).permitAll())
	                .logout((logoutz) -> logoutz
	                        .logoutUrl("/logout")
	                        .logoutSuccessUrl("/login")
	                        .permitAll());

	        http.csrf(csrfz -> csrfz.disable());
	        http.headers(headersz -> headersz
	                .frameOptions(frameOptionsz -> frameOptionsz.disable()));

	        return http.build();
	    }
	 
	 @Bean
		InMemoryUserDetailsManager userDetailsService() {
			UserDetails admin = User.builder()
					.username("admin")
					.password("{noop}admin")
					.roles("ADMIN", "USER").build();
			
			UserDetails user = User.builder()
					.username("user")
					.password("{noop}1234")
					.roles("USER").build();
			
			UserDetails user2 = User.builder()
					.username("user2")
					.password("{noop}5678")
					.roles("OTHER").build();
			
			
			return new InMemoryUserDetailsManager(user, admin, user2);
		}
	
}
