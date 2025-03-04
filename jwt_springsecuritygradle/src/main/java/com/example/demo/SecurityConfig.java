package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Value("${jwt.secretkey}")
	String mykey;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		System.out.println("filter 실행 중");
		return httpSecurity
				.httpBasic(AbstractHttpConfigurer::disable)
				.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(new JwtTokenFilter(mykey, encoder), UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests(
				request -> request
				.requestMatchers("/userinfo").authenticated()
				.anyRequest().permitAll()
				/*.requestMatchers("/b", '/error", "/js/**", "/images/**").permitAll()
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/a", "/").authenticated()
				.requestMatchers("/b", "/error", "/c").permitAll()
				.requestMatchers("/adminpage").hasRole(UserRole.ADMIN.name())
				.requestMatchers("/userpage").hasRole(UserRole.USER.name())
				//.requestMatchers("/userpage").hasRole(UserRole.ADMIN.name())
				//.anyRequest().permitAll()*/
				)
				//.formLogin(Customizer.withDefaults())
				.csrf(csrf -> csrf.disable())
				.build();
	}
}
