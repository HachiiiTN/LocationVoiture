package com.tekup.mp.tools;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class BCryptManagerTool {

	private final PasswordEncoder passwordEncoder;
@Autowired
public BCryptManagerTool(PasswordEncoder passwordEncoder) {
	this.passwordEncoder = passwordEncoder;
}
@Bean(name = "passwordEncoder")
public static PasswordEncoder passwordencoder(){
	return new BCryptPasswordEncoder();
}
}
