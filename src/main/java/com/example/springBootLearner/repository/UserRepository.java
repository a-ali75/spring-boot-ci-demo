package com.example.springBootLearner.repository;

import com.example.springBootLearner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
