package com.nagarro.training.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.entity.Role;
import com.nagarro.training.entity.User;
import com.nagarro.training.service.ProductService;
import com.nagarro.training.service.RoleServiceImpl;
import com.nagarro.training.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleServiceImpl roleService;

	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
//	public User createUser() throws Exception {
//
//		Role r = new Role();
//		r.setRoleId(2L);Role
//		r.setRoleName("Customer");
//		User user = new User("anshu", "anshu", "anshu@gmail.com", true, "9839078342", r);
//		this.userService.createUser(user);
		user.setUserType(roleService.getRoleById(2L));
//		Products p = new Products("Shoe1", "Shddh", "this is a Shoe", 4000, 10, "Shoes", user);
//		this.productService.createProducts(p);
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		return this.userService.createUser(user);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	@GetMapping("/roles")
	public Set<Role> getRoles() {
		return this.roleService.getAllRoles();
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempPass = user.getPassword();
		String tempUser = user.getUsername();
		User u = null;
		if (tempUser != null && tempPass != null) {
			u = this.userService.fetchUserByUsernameAndPassword(tempUser, tempPass);
		}
		if (u == null) {
			throw new Exception("Bad Credentials");
		}
		return u;

	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		this.userService.deleteUser(userId);
	}

}
