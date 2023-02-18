package com.example.Library.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Library.model.issuedbooks;

public class IssuedRepositoryImpl implements IssuedRepositoryCustom{

	@Autowired
	private EntityManager entity;
	
	@Override
	public List<issuedbooks> getallbooks(int id) {
		// TODO Auto-generated method stub
		 try {
				
			    String sql="select i from issuedbooks i where i.user_id=?1"; 
			    final TypedQuery<issuedbooks> query=entity.createQuery(sql, issuedbooks.class);
			    query.setParameter(1, id);
	            List<issuedbooks> issue =query.getResultList();
			
			    return issue;
		       
	       }
		   catch(NoResultException e) {
				//System.out.println(email);
				return null;
			}
		
	}

}
