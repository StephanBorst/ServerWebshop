package nl.zwolle.mvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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


	private Long id;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
	    return id;
	}
	
	public void setid(Long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return id + ": [name=" + name + ", age=" + age + "]";
	}
	

	
}
