package com.example.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.model.book;

public interface BookRepository extends JpaRepository<book, Integer> {
}
