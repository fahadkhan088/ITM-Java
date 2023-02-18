package com.example.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Library.model.issuedbooks;

public interface IssuedRepository extends JpaRepository<issuedbooks, Integer> ,IssuedRepositoryCustom{
}
