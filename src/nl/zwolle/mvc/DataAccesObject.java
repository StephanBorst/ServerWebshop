package nl.zwolle.mvc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public abstract class DataAccesObject {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshop");
	
	/**
	 * Maak een nieuwe bestelling aan en sla die op in de database
	 */
	public static Bestelling create(String name, int age){
		Bestelling bean = new Bestelling();
		bean.setName(name);
		bean.setAge(age);
		
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(bean);
		t.commit();
		em.close();
		
		return bean;
	}
	
	/**
	 * Verwijder een bestelling uit de database
	 */
	public static void remove(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Bestelling bean = em.find(Bestelling.class, id);
		if(bean != null){
			em.remove(bean);
		}
		t.commit();
		em.close();
	}
	
	/**
	 * Haal een bestelling op a.d.h.v. zijn boekingscode
	 */
	public static Bestelling find(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Bestelling bean = em.find(Bestelling.class, id);
		t.commit();
		em.close();
		return bean;
	}
	
	/**
	 * Haal alle bestellingen op uit de database
	 */
	public static List<Bestelling> all(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Bestelling> beans = em.createQuery("from JavaBean", Bestelling.class).getResultList();
		t.commit();
		em.close();
		return beans;
	}
}

