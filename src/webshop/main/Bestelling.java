package webshop.main;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Bestelling {
	
	@NotEmpty
	private String name;
	
	@Min(21)
	@Max(130)
	private int age;
	
	@Future
	private Date date;

	@Min(1)
	private int seats;
	
	private Date retourdate;

	private String destination;

	private String retour;

	private boolean member;

	private int priceTotal;

	private int pricePerUnit;

	private int savings;

	private Long id;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getRetourdate() {
		return retourdate;
	}

	public void setRetourdate(Date retourdate) {
		this.retourdate = retourdate;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

	public String getRetour() {
		return retour;
	}

	public void setRetour(String retour) {
		this.retour = retour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID = " + id);
		sb.append(" [name= " + name);
		sb.append(", age= " + age);
		sb.append(", destination= " + destination);
		sb.append(", Type of trip= " + retour);
		sb.append(", Price per unit = " + pricePerUnit);
		sb.append(", Member =" + member);
		sb.append(", Savings = " + savings);
		sb.append(", Number of Seats = " + seats);
		sb.append(", Total price  = " + priceTotal);
		return sb.toString();
	}

}
