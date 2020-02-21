package com.tekup.mp.web.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.tekup.mp.dao.UserRepository;
import com.tekup.mp.jpa.entities.User;
import com.tekup.mp.jpa.enums.RoleEnum;


//@EnableWebMvc

@Configuration
@EnableWebSecurity
public class WebMvcConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Qualifier("userService")
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
    protected void configure(HttpSecurity http) throws Exception {


		System.err.println(
				bCryptPasswordEncoder.encode("1234")
		);


		http
				.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll().defaultSuccessUrl("/",true)
				.and()
				.logout()
				.permitAll();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}



