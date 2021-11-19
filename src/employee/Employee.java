/**
 * 
 */
package employee;

import java.util.ArrayList;

import animal.Animal;
import enclosure.Enclosure;

/**
 * @author logan
 *
 */
public class Employee {
	
	private String name;
	private EmployeeGender gender;
	private int age;

	/**
	 * 
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param m
	 * @param age
	 */
	public Employee(String name, EmployeeGender gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public EmployeeGender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(EmployeeGender gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public void toExaminate(Enclosure e) {
		System.out.println(e.toString());
	}
	
	public void toClean(Enclosure e) {
		e.toClean();
	}
	
	public void toFeed(Enclosure e) {
		e.feedAllAnimals();
	}
	
	public void toTransfer(Enclosure from, Animal a, Enclosure to ) {
		
		if (from.getListOfAnimal().contains(a)) {
			ArrayList<Animal> list = from.getListOfAnimal();
			int animalIndex = list.indexOf(a);
			if (to.addAnimal(list.get(animalIndex))) {
				from.removeAnimal(a);
			}
			
			this.toExaminate(from);
			this.toExaminate(to);			
		}else {
			System.out.println("nope");
		}
	}
	
	

}
