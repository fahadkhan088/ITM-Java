package com.example.Library.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Library.model.admin;
import com.example.Library.model.user;

public class AdminRepositoryImpl implements AdminRepositoryCustom {

	@Autowired
	private EntityManager entity;
	@Override
	public admin adminexists(String email, String password) {
		// TODO Auto-generated method stub
    try {
			
		    String sql="select a from admin a where a.email=?1 and a.password=?2"; 
		    final TypedQuery<admin> query=entity.createQuery(sql, admin.class);
		    query.setParameter(1, email);
		    query.setParameter(2, password);
            admin admin=query.getSingleResult();
		
		    return admin;
	       
       }
	   catch(NoResultException e) {
			//System.out.println(email);
			return null;
		}
	}

}
