package com.nagarro.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
