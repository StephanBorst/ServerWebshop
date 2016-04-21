package webshop.main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import webshop.Calculations.PrijsBerekening;


public abstract class DataAccesObject {

private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshop");
	
	/**
	 * Maak een nieuwe bestelling aan en sla die op in de database
	 */
	public static Bestelling create(String name, int age, String destination, String retour, Date date, Date retourdate, int seats, boolean member){
		Bestelling bean = new Bestelling();
		PrijsBerekening prijs = new PrijsBerekening();
		prijs.setPrijsPerEenheid(destination, retour);
		prijs.setKorting(member, prijs.getPrijsPerEenheid());
		prijs.setTotaalprijs(prijs.getPrijsPerEenheid(), prijs.getKorting(), seats);
		bean.setName(name);
		bean.setAge(age);
		bean.setDestination(destination);
		bean.setRetour(retour);
		bean.setRetourdate(retourdate);
		bean.setDate(date);
		bean.setSeats(seats);
		bean.setMember(member);
		bean.setPricePerUnit(prijs.getPrijsPerEenheid());
		bean.setSavings(prijs.getKorting());
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(bean);
		t.commit();
		em.close();
		return bean;
	}
	
	public static List<Bestelling> all(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Bestelling> beans = em.createQuery("from Bestelling", Bestelling.class).getResultList();
		t.commit();
		em.close();
		return beans;
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

}

