package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Database එක්ක වැඩ කරන class එක
public interface UserRepo extends JpaRepository<User,Integer> {

}
