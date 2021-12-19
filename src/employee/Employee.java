package employee;

import animal.Animal;
import enclosure.Enclosure;

import java.util.ArrayList;

/**
 * @author logan
 * Classe employée qui implémente Runnable
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
	 * String nom
	 * @param gender
	 * Enum genre
	 * @param age
	 * int age
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

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", gender=" + gender +
				", age=" + age +
				'}';
	}

	/**
	 * Permet d'examiner tous les enclos
	 * @param enclosure
	 * Enclos
	 */
	public void toExaminate(Enclosure enclosure) {
		System.out.println(enclosure.toString());
	}

	/**
	 * Permet de nettoyer les enclos
	 * @param enclosure
	 * enclos
	 */
	public void toClean(Enclosure enclosure) {
		enclosure.toClean();
	}

	/**
	 * Permet de nourrir tous les animaux d'un enclos
	 * @param enclosure
	 * Enclos
	 */
	public void toFeed(Enclosure enclosure) {
		enclosure.feedAllAnimals();
	}

	/**
	 * Permet de transferer un animal d'un enclos à un autre
	 * @param from
	 * Enclos qui contient l'animal à tranferer
	 * @param a
	 * Animal à transferer
	 * @param to
	 * Enclos qui va recevoir l'animal
	 */
	public void toTransfer(Enclosure from, Animal a, Enclosure to ) {
		
		if (from.getListOfAnimal().contains(a)) {
			ArrayList<Animal> list = from.getListOfAnimal();
			int animalIndex = list.indexOf(a);
			if (to.addAnimal(list.get(animalIndex))) {
				from.removeAnimal(a);
				this.toExaminate(from);
				this.toExaminate(to);
				System.out.println("The transfer was successful");
			}
		}else {
			System.out.println("nope");
		}
	}
	
	

}
