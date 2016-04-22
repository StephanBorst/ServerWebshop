package webshop.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshop");

	public static Product create(String destination, int stock){
		Product product = new Product();
		
		product.setDestination(destination);;
		product.setStock(stock);
		
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(product);
		t.commit();
		em.close();
		return product;
	}
	
	
	public static Product update(Product newProduct){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Long id = newProduct.getId();
		Product p = em.find(Product.class, id);
		p.setStock(newProduct.getStock());
		em.persist(p);
		t.commit();
		em.close();
		return p;
	}
	
	
	public static Product find(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Product product = em.find(Product.class, id);
		t.commit();
		em.close();
		return product;
	}
}
