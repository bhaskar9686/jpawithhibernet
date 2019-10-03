package com.capgemini.jpawithhybernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.dto.Product;

public class InsertDemo {


	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager =null;
		
		Product product = new Product();
		product.setPid(100);
		product.setPname("Soap");
		product.setQuantity(11);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(product);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		}
		entityManager.close();
	}

}
