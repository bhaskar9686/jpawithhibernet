package com.capgemini.jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpa.dto.Product;

public class Updation {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String jpql = "Update Product SET pname = 'Shampoo' WHERE pid = 101";
		Query query = entityManager.createQuery(jpql);
		int count = query.executeUpdate();
		System.out.println(count+" Row Updated");
		entityTransaction.commit();
		
	}//End of main 

}// End of Retrive class
