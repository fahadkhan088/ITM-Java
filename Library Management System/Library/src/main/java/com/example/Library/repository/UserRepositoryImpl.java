package com.example.Library.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.Library.model.user;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	private EntityManager entity;
	
	@Override
	public boolean userexists(String email) {
		// TODO Auto-generated method stub
		try {
			
		    String sql="select u from user u where u.email=?1  "; 
		    final TypedQuery<user> query=entity.createQuery(sql, user.class);
		    query.setParameter(1, email);
            user user=query.getSingleResult();
		
		    String a=user.getEmail();
		   
	       if(email.equals(a)) {
	    	    return true;
	       }
	       
	       return false;
		}
		catch(NoResultException e) {
			//System.out.println(email);
			return false;
		}
		
	}

	@Override
	public user userexists(String email, String password) {
		// TODO Auto-generated method stub
       try {
			
		    String sql="select u from user u where u.email=?1 and u.password=?2"; 
		    final TypedQuery<user> query=entity.createQuery(sql, user.class);
		    query.setParameter(1, email);
		    query.setParameter(2, password);
            user user=query.getSingleResult();
		
		    return user;
	       
       }
	   catch(NoResultException e) {
			//System.out.println(email);
			return null;
		}
	}

	@Override
	public user getUser(String email) {
		// TODO Auto-generated method stub
      try {
			
		    String sql="select u from user u where u.email=?1"; 
		    
		    final TypedQuery<user> query=entity.createQuery(sql, user.class);
		    query.setParameter(1, email);
		    System.out.println(email);
            user user=query.getSingleResult();
            
		    return user;
	       
       }
	   catch(Exception e) {
			//System.out.println(email);
			return null;
		}
	}
	

}
