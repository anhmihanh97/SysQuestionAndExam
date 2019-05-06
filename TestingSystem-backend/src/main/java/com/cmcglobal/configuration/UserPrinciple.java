package com.cmcglobal.configuration;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cmcglobal.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;

	private int userId;
	private String email;
	private String fullName;
	private String mobile;
	@JsonIgnore
	private String password;
	private int status;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrinciple(int userId, String email, String fullName, String mobile, String password, int status,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.userId = userId;
		this.email = email;
		this.fullName = fullName;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());

		return new UserPrinciple(user.getUserId(), user.getEmail(), user.getFullName(), user.getMobile(),
				user.getPassword(), user.getStatus(), authorities);
	}

	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public int getStatus() {
		return status;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email+'/'+Integer.toString(userId);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserPrinciple user = (UserPrinciple) o;
		return Objects.equals(userId, user.userId);
	}

}
