package com.cos.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.security.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{

	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	//권한을 체크하는 함수
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
//		collect.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				return user.getRole();
//			}
//		}); -- 이걸 약식으로 바꾸면 ▼--
		collect.add(()-> user.getRole());
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 확인 true : 만료안됨 
	@Override 
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있는지 확인 ture : 잠기지 않음.
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	
	// 비밀번호가 만료되었는지 확인 true : 만료안됨
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 활성화 되었는지 확인 true : 활성화
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
