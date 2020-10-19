package com.cos.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //시큐리티 설정 파일 활성화 (기록)
@Configuration //IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean //메소드의 return 값을 IoC에 등록
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder(); //salt 값을 새로 가져옴
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); //기억 : form태그 요청만 가능한 것을 비활성화한다.
		
		http.authorizeRequests().antMatchers("/user/**").authenticated()
		.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER')or hasRole('ROLE_ADMIN')") //manager, admin만 접근가능   
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") //admin만 접근가능  
		.anyRequest().permitAll()
		.and().formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/loginProc")// 이주소를 시크리티필터가 가로채감
		.defaultSuccessUrl("/") // 로그인이 완료되서 어느페이지로 갈지.
		.and()
		.logout().logoutSuccessUrl("/logoutProc");
	}
}
