package com.nagarro.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);

	public User findByUsernameAndPassword(String userName, String password);
}
