/**
 * 
 */
package enclosure;
import java.util.ArrayList;
import java.util.ListIterator;

import animal.Animal;

/**
 * @author logan
 *
 */
public abstract class Enclosure {

		
	private String name = "Default";
	private double area = 100;
	private int nb_max = 1, nb_animal = 0;
	private ArrayList<Animal> listOfAnimal = new ArrayList<Animal>();
	private Cleanness cleanness = Cleanness.GOOD;
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * @param area
	 * @param nb_max
	 * @param nb_animal
	 * @param listOfAnimal
	 * @param cleanness
	 */
	public Enclosure(String name, double area, int nb_max, int nb_animal, ArrayList<Animal> listOfAnimal,
			Cleanness cleanness) {
		super();
		this.name = name;
		this.area = area;
		this.nb_max = nb_max;
		this.nb_animal = nb_animal;
		this.listOfAnimal = listOfAnimal;
		this.cleanness = cleanness;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the nb_max
	 */
	public int getNb_max() {
		return nb_max;
	}

	/**
	 * @param nb_max the nb_max to set
	 */
	public void setNb_max(int nb_max) {
		this.nb_max = nb_max;
	}

	/**
	 * @return the nb_animal
	 */
	public int getNb_animal() {
		return nb_animal;
	}

	/**
	 * @param nb_animal the nb_animal to set
	 */
	public void setNb_animal(int nb_animal) {
		this.nb_animal = nb_animal;
	}

	/**
	 * @return the listOfAnimal
	 */
	public ArrayList<Animal> getListOfAnimal() {
		return listOfAnimal;
	}

	/**
	 * @param listOfAnimal the listOfAnimal to set
	 */
	public void setListOfAnimal(ArrayList<Animal> listOfAnimal) {
		this.listOfAnimal = listOfAnimal;
	}

	/**
	 * @return the cleanness
	 */
	public Cleanness getCleanness() {
		return cleanness;
	}

	/**
	 * @param cleanness the cleanness to set
	 */
	public void setCleanness(Cleanness cleanness) {
		this.cleanness = cleanness;
	}

	
	public String toString() {
		return "\n"+name + ": area=" + area + "\t nb_max=" + nb_max + "\t nb_animal=" + nb_animal
				+ "\n\t listOfAnimal=" + listOfAnimal + "\t cleanness=" + cleanness+"\n\n";
	}

	/**
	 * Function to implement
	 * @param a
	 * @return 
	 */
	
	public abstract boolean addAnimal(Animal a);
	
	public void removeAnimal(Animal a) {
		this.listOfAnimal.remove(a);
		System.out.println(a.getClass().getSimpleName()+" enlevé");
	};
	
	public void feedAllAnimals() {
		
		ListIterator<Animal> li = this.getListOfAnimal().listIterator();
		while (li.hasNext())
			li.next().toEat();
	};
	
	public abstract void toClean();
}
