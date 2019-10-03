package com.capgemini.jpql;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdation {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String jpql = "Update Product SET pname =:name WHERE pid =:id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", 100);
		query.setParameter("name", "Mobile");
		int count = query.executeUpdate();
		System.out.println(count+" Row Updated");
		entityTransaction.commit();
		
	}//End of main 

}// End of class
