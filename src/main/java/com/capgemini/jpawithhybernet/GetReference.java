package com.capgemini.jpawithhybernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpa.dto.Product;

public class GetReference {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.getReference(Product.class, 101);
		System.out.println(product);
//		System.out.println("Product Id : "+product.getPid());
//		System.out.println("Product Name : "+product.getPname());
//		System.out.println("Product Quantity : "+product.getQuantity());
		entityManager.close();
		
	}// End of main method
	
}//End of GetReference
