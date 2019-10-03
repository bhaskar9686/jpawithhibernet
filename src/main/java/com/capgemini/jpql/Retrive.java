package com.capgemini.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpa.dto.Product;

public class Retrive {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Product";
		Query query = entityManager.createQuery(jpql);
		List<Product> list = query.getResultList();
		for(Product p : list ) {
			System.out.println(p);
		}
		
		
		
		
	}//End of main 

}// End of Retrive class
