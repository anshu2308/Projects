package com.nagarro.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.User;
import com.nagarro.training.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepo.findByUsername(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user found!!");

		}

		return user;

//		if (user != null) {
//			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//					getAuthorities(user));
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
//
//	public Collection<? extends GrantedAuthority> getAuthorities(User user) {
//
//		Set<Authority> set = new HashSet<>();
//		set.add(new Authority(user.getUserType().getRoleName()));
//
//		return set;
	}
}
