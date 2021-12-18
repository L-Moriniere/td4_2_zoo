/**
 * 
 */
package enclosure;

import animal.Animal;

import java.util.ArrayList;

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

	public static final String RESET = "\u001B[0m";
	// Regular Colors
	public static final String BLACK = "\033[0;30m";   // BLACK
	public static final String RED = "\033[0;31m";     // RED
	public static final String GREEN = "\033[0;32m";   // GREEN
	public static final String YELLOW = "\033[0;33m";  // YELLOW
	public static final String BLUE = "\033[0;34m";    // BLUE
	public static final String PURPLE = "\033[0;35m";  // PURPLE
	public static final String CYAN = "\033[0;36m";    // CYAN
	public static final String WHITE = "\033[0;37m";   // WHITE
	
	
	
	
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
		String name = GREEN + getName() + RESET;
		String capacity = getNb_animal() + "/" + getNb_max();
		String type = getClass().getSimpleName();
		String cleanness = getCleanness().toString();

		StringBuilder stringOfAnimal;
		stringOfAnimal = new StringBuilder(String.join(" ", name, type, capacity, cleanness) + "\n");

		String[] ArrayAnimal = new String[listOfAnimal.size()];
		int index = 0;
		for (Animal a : listOfAnimal) {
			String animalIndex = "(" + (index++ + 1) + ").";

			stringOfAnimal.append(String.join(" ", "   ├──", animalIndex, a.toString())).append("\n");
		}

		return String.join("", stringOfAnimal);
	}

	public String toString(double height) {
		String name = GREEN + getName() + RESET;
		String capacity = getNb_animal() + "/" + getNb_max();
		String type = getClass().getSimpleName();
		String sHeight = CYAN + Double.toString(height) + RESET;
		String cleanness = getCleanness().toString();

		StringBuilder stringOfAnimal;
		stringOfAnimal = new StringBuilder(String.join(" ", name, type, capacity, sHeight, cleanness) + "\n");

		String[] ArrayAnimal = new String[listOfAnimal.size()];
		int index = 0;
		for (Animal a : listOfAnimal) {
			String animalIndex = "(" + (index++ + 1) + ").";

			stringOfAnimal.append(String.join(" ", "   ├──", animalIndex, a.toString())).append("\n");
		}

		return String.join("", stringOfAnimal);
	}

	public String toString(double salinity, double depth) {
		String name = GREEN + getName() + RESET;
		String capacity = getNb_animal() + "/" + getNb_max();
		String type = getClass().getSimpleName();
		String sSalinity = CYAN + Double.toString(salinity) + RESET;
		String sDepth = YELLOW + Double.toString(depth) + RESET;
		String cleanness = getCleanness().toString();

		StringBuilder stringOfAnimal;
		stringOfAnimal = new StringBuilder(String.join(" ", name, type, capacity, sSalinity, sDepth, cleanness) + "\n");

		String[] ArrayAnimal = new String[listOfAnimal.size()];
		int index = 0;
		for (Animal a : listOfAnimal) {
			String animalIndex = "(" + (index++ + 1) + ").";

			stringOfAnimal.append(String.join(" ", "   ├──", animalIndex, a.toString())).append("\n");
		}

		return String.join("", stringOfAnimal);
	}



	/**
	 * Function to implement
	 * @param a
	 * @return 
	 */
	public abstract boolean addAnimal(Animal a);
	
	public void removeAnimal(Animal a) {
		getListOfAnimal().remove(a);
		System.out.println(a.getClass().getSimpleName()+" Remove");
	};

	public void printAnimals() {
		for (Animal animal : getListOfAnimal())
			System.out.println((listOfAnimal.indexOf(animal) + 1) + ". " + animal);
	}


	public void feedAllAnimals() {
		for (Animal li : getListOfAnimal()){
			li.toFeed();
		}
	};
	
	public abstract void toClean();
}
