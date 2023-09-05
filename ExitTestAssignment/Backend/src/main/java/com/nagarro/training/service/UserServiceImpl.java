package com.nagarro.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.entity.User;
import com.nagarro.training.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

//	@Autowired
//	private RoleRepository roleRepo;

	@Override
	public User createUser(User user) throws Exception {

		User u = this.userRepo.findByUsername(user.getUsername());
		if (u != null) {
			System.out.println("User is already there!!!");
			throw new Exception("User already present!!!");
		} else {
//			for (UserType ut : userTypes) {
//				roleRepo.save(ut.getRole());
//			}
//			user.getUserType().addAll(userTypes);
			u = this.userRepo.save(user);
		}
		return u;
	}

	@Override
	public User getUser(String username) {

		return this.userRepo.findByUsername(username);
	}

	@Override
	public void deleteUser(int userId) {
		this.userRepo.deleteById(userId);
	}

	@Override
	public void updateUser(int userId) {
//		this.userRepo.save(null)

	}

	@Override
	public User fetchUserByUsernameAndPassword(String uname, String upass) {
		return userRepo.findByUsernameAndPassword(uname, upass);

	}
}
