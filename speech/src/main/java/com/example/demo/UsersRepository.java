package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String>{

	Users findByEmail(String email);

}