package com.example.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.model.user;

public interface UserRepository extends JpaRepository<user, Integer>,UserRepositoryCustom{
}
