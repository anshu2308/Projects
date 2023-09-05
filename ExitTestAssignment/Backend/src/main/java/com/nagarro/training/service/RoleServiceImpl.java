package com.nagarro.training.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.Role;
import com.nagarro.training.repo.RoleRepository;

@Service
public class RoleServiceImpl {

	@Autowired
	private RoleRepository roleRepo;

	public Role getRoleById(Long id) {
		Role role = this.roleRepo.findById(id).get();
		return role;
	}

	public Set<Role> getAllRoles() {
		return new HashSet<>(this.roleRepo.findAll());
	}
}
