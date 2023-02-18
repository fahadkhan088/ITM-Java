package com.example.Library.repository;

import com.example.Library.model.admin;


public interface AdminRepositoryCustom {
	public admin adminexists(String email,String password);
}
