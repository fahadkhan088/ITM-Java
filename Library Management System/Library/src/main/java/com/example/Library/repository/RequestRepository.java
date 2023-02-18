package com.example.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.model.request;

public interface RequestRepository extends JpaRepository<request, Integer> {
}
