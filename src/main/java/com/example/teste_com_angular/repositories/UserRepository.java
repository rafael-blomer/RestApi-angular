package com.example.teste_com_angular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste_com_angular.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
