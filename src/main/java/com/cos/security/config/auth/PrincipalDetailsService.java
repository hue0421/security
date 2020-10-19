package com.cos.security.config.auth;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.security.domain.user.User;
import com.cos.security.domain.user.UserRepository;

//principal : 접근 주체(인증 주체)

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override // 로그인 시도하면 loadUserByUsername
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인 요청된 아이디 -> "+ username);
		
		//Username 을 가져와서
		User user = UserRepository.findByUsername(username);
		
		//패스워드검증
		if(user ==null) {
			return null;
		}else {
			return new PrincipalDetails(user);
		}
	
		
	}

}
