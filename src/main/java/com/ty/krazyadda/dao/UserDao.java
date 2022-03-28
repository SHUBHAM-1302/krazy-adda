package com.ty.krazyadda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.krazyadda.dto.User;
import com.ty.krazyadda.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	public boolean deleteUserById(int id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;

	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
			
		}
		return null;
		
	}

	public User updateUser(int id, User user) {
		if (getUserById(id) != null) {

			return userRepository.save(user);
		}
		return null;
	}
}
