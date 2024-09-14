package com.example.teste_com_angular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste_com_angular.entities.User;
import com.example.teste_com_angular.repositories.UserRepository;
import com.example.teste_com_angular.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public User findById(Long id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<User> findAll() {
		List<User> list = repo.findAll();
		return list;
	}

	public User insert(User obj) {
		return repo.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repo.deleteById(id);
	}

	@Transactional
	public User update(Long id, User user) {
		User obj = findById(id);
		updateData(obj, user);
		return repo.save(obj);
	}

	private void updateData(User obj, User user) {
		obj.setName(user.getName());
		obj.setEmail(user.getEmail());
		obj.setNumber(user.getNumber());
	}
}
