/**
 * 
 */
package enclosure;

import java.util.ArrayList;
import java.util.ListIterator;

import animal.Animal;
import animal.CanFly;

/**
 * @author logan
 *
 */
public class Aviary implements Enclosure {
	
	private String name;
	private double area;
	private double height;
	private int nb_max, nb_animal=0;
	private ArrayList<Animal> listOfAnimal = new ArrayList<Animal>();
	private Cleanness cleanness = Cleanness.GOOD;


	/**
	 * 
	 */
	public Aviary() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 */
	public Aviary(String name) {
		super();
		this.name = name;
	}


	/**
	 * @param name
	 * @param area
	 * @param nb_max
	 */
	public Aviary(String name, double area, int nb_max) {
		super();
		this.name = name;
		this.area = area;
		this.nb_max = nb_max;
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
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
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



	@Override
	public String toString() {
		return "Enclosure [name=" + name + ", area=" + area + ", nb_max=" + nb_max + ", nb_animal=" + nb_animal
				+ ", listOfAnimal=" + listOfAnimal + ", cleanness=" + cleanness + "]";
	}


	@Override
	public void addAnimal(Animal a) {
		if (a instanceof CanFly)
		{
			this.listOfAnimal.add(a);
			System.out.println(a.getSpecie()+" ajouté");
		}
		else System.out.println("Ce n'est pas un poisson");
		
	}

	@Override
	public void removeAnimal(Animal a) {
		this.listOfAnimal.remove(a);
		System.out.println(a.getSpecie()+" enlevé");
	}

	@Override
	public void feedAllAnimal() {
		ListIterator<Animal> li = this.getListOfAnimal().listIterator();
		
		while (li.hasNext())
			li.next().eat();
			
	}

	@Override
	public void toClean() {
		if (this.getListOfAnimal().isEmpty())
		{
			if (this.getCleanness() == Cleanness.BAD)
			{
				this.setCleanness(Cleanness.GOOD);
				System.out.println("L'enclos a été nettoyé");
			}
			else System.out.println("L'enclos est déjà propre");
		
			System.out.println("hauteur de l'enclos " + this.getHeight());
			
		}
		else System.out.println("L'enclos est plein");
	}


}
