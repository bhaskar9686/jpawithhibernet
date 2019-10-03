package com.capgemini.jpawithhybernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.dto.Product;

public class ReAttaching {

	public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Product product = entityManager.find(Product.class, 101);
			System.out.println(entityManager.contains(product));
			entityManager.detach(product);
			product.setPname("Mobile");
			entityManager.merge(product);
			entityTransaction.commit();
			//System.out.println(entityManager.contains(product));
			//System.out.println(product);
			entityManager.close();
			
		}// End of main method
		
	}
