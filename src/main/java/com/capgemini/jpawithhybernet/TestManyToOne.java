package com.capgemini.jpawithhybernet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.onetomany.Pencil;
import com.capgemini.jpa.onetomany.PencilBox;


public class TestManyToOne {

	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager =null;

		PencilBox pencilBox = new PencilBox();
		pencilBox.setBoxId(10);
		pencilBox.setBoxName("Camalin");

		Pencil pencil = new Pencil();
		pencil.setPencilId(11);;
		pencil.setColor("Green");
		pencil.setPencilBox(pencilBox);

		Pencil pencil1 = new Pencil();
		pencil1.setPencilId(12);;
		pencil1.setColor("Red");
		pencil1.setPencilBox(pencilBox);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			PencilBox box = entityManager.find(PencilBox.class, 10);
			System.out.println("Pencil Id : "+box.getPencils().get(0).getPencilId());
			System.out.println("Pencil Color : "+box.getPencils().get(0).getColor());
			/*
			 * entityManager.persist(pencil); entityManager.persist(pencil1);
			 */
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		}
		entityManager.close();
	}

}
