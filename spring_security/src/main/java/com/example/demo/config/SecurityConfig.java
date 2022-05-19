package com.example.demo.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired 
	DataSource datasource;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		String sql = "Select u.username,a.authority from abi_authorities17 a, abi_User2 u where u.username = ? AND u.username = a.username";
//		auth.inMemoryAuthentication().withUser("abishek").password(encoder.encode("abi")).roles("ADMIN")
//		.and().withUser("india").password(encoder.encode("ind")).roles("GUEST");
		auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery
		("select username,password ,enabled from abi_User2 where username=? ").authoritiesByUsernameQuery(sql).passwordEncoder(encoder); 
 	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.authorizeHttpRequests().antMatchers("/api/v1/**").authenticated().and().httpBasic();
		
	}
	
	
	

}


