package com.tekup.mp.web.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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



@EnableWebMvc

public class WebMvcConfig implements WebMvcConfigurer {
	 @Autowired
	 public WebMvcConfig(UserRepository userRepository) {
	 // Do not copy this in production
	 List<RoleEnum> userRole = Collections.singletonList(RoleEnum.AGENT);
	 List<RoleEnum> adminRole = Arrays.asList(RoleEnum.AGENT,
	RoleEnum.ADMINISTARTOR);
	 User user = new User("user", "user", "User", "USER", userRole);
	 User adminUser = new User("admin", "admin", "Admin", "ADMIN", adminRole);
	 userRepository.save(user);
	 userRepository.save(adminUser);
	 }
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry) {
	 registry.addViewController("/").setViewName("index");
	 registry.addViewController("/login").setViewName("login");
	 registry.addViewController("/auth").setViewName("auth/auth");
	 registry.addViewController("/auth/admin").setViewName("auth/admin");
	 }
	 @Bean
	 public SpringTemplateEngine templateEngine() {
	 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 templateEngine.setTemplateResolver(thymeleafTemplateResolver());
	 templateEngine.setEnableSpringELCompiler(true);
	 templateEngine.addDialect(new SpringSecurityDialect());
	 return templateEngine;
	 }
	 @Bean
	 public SpringResourceTemplateResolver thymeleafTemplateResolver() {
	 SpringResourceTemplateResolver templateResolver = new
	SpringResourceTemplateResolver();
	 templateResolver.setPrefix("classpath:templates/");
	 templateResolver.setSuffix(".html");
	 templateResolver.setCacheable(false);
	 templateResolver.setTemplateMode(TemplateMode.HTML);
	 return templateResolver;
	 }
	 @Bean
	 public ThymeleafViewResolver thymeleafViewResolver() {
	 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 viewResolver.setTemplateEngine(templateEngine());
	 viewResolver.setCharacterEncoding("UTF-8");
	 return viewResolver;
	 }

}

