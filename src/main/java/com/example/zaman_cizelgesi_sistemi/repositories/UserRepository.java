package com.example.zaman_cizelgesi_sistemi.repositories;

import com.example.zaman_cizelgesi_sistemi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByEposta(String eposta);
}
