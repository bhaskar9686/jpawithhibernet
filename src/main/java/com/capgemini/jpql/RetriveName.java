package com.capgemini.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpa.dto.Product;

public class RetriveName {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "Select pname from Product";
		Query query = entityManager.createQuery(jpql);
		List<String> list = query.getResultList();
		for(String p : list ) {
			System.out.println(p);
		}
		
	}//End of main 

}// End of Retrive class
