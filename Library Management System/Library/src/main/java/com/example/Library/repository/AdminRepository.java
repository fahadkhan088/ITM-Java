package com.example.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.model.admin;

public interface AdminRepository extends JpaRepository<admin, Integer>,AdminRepositoryCustom{
}
