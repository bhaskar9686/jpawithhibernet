package com.capgemini.jpawithhybernet;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.manytomany.Course;
import com.capgemini.jpa.manytomany.Student;

public class TestManyToMany {

	public static void main(String[] args) {
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager =null;
		
		Course course = new Course();
		course.setcName("JAVA");
		course.setcId(15);
		
		Course course1 = new Course();
		course1.setcName("SQL");
		course1.setcId(16);
		
		ArrayList<Course> arrayList = new ArrayList<Course>();
		arrayList.add(course);
		arrayList.add(course1);
		
		Student student = new Student();
		student.setsId(14);
		student.setsName("Nagesh");
		student.setCourse(arrayList);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
		}
		entityManager.close();
	}

}
