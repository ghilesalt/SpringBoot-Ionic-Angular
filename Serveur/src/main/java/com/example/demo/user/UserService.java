package com.example.demo.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo){
		this.userRepo = userRepo;
	}
	public List<User> getUser(){
		return userRepo.findAll();

	}

	public void ajouterUser(User user) {
		Optional<User> userByUsername = userRepo.findUserByUsername(user.getUsername());
		if(userByUsername.isPresent()){
			throw new IllegalStateException(user.getUsername()+ " existe déjà !");
		}
		userRepo.save(user);
	}

	public void suppUser(Long userId) {
		userRepo.findById(userId);
			boolean exists = userRepo.existsById(userId);
			if(!exists){
				throw new IllegalStateException("L'utilisateur avec l'ID n° " + userId + " n'existe pas ou a déjà été supprimé !");
			}
			userRepo.deleteById(userId);
	}

	@Transactional
	public void majUser(Long userId, String username) {

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new IllegalStateException(
						"L'utilisateur avec l'ID n° " + userId + " n'existe pas ou a déjà été supprimé !"));

		if(username != null &&
				username.length() > 0 &&
				!Objects.equals(user.getUsername(), username)){
			user.setUsername(username);
		}


		}

}
