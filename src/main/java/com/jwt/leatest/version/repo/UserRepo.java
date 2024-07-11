package com.jwt.leatest.version.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.leatest.version.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> getUserByUsername(String username);
}
