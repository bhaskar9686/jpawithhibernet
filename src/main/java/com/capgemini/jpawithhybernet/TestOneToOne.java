package com.capgemini.jpawithhybernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.onetoone.Person;
import com.capgemini.jpa.onetoone.VoterCard;

public class TestOneToOne {

	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager =null;
		
		VoterCard voterCard = new VoterCard();
		voterCard.setVcard(10);
		voterCard.setVname("Bhaskar");
		
		Person person = new Person();
		person.setPname("Bhaskar");
		person.setPid(12);
		person.setAge(25);
		person.setVoterCard(voterCard);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			//entityManager.persist(person);q
			// bidirectional
			VoterCard vc = entityManager.find(VoterCard.class, 10);
			System.out.println("Person Name : "+vc.getPerson().getPname());
			System.out.println("Person Id : "+vc.getPerson().getPid());
			System.out.println("Person Age : "+vc.getPerson().getAge());
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		}
		entityManager.close();
	}

}
