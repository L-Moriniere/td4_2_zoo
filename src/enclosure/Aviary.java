/**
 * 
 */
package enclosure;

import animal.Animal;
import animal.CanFly;

import java.util.ArrayList;

/**
 * @author logan
 *
 */
public class Aviary extends Enclosure {
	
	private double height;

	
	
	/**
	 * @param name
	 * @param area
	 * @param nb_max
	 */
	public Aviary(String name, double area, int nb_max) {
		super(name, area, nb_max, 0, new ArrayList<Animal>(), Cleanness.GOOD);
		// TODO Auto-generated constructor stub
	}


	public Aviary(String name, double area, int nb_max,  double height) {
		super(name, area, nb_max, 0, new ArrayList<Animal>(), Cleanness.GOOD);
		this.height = height;
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


	@Override
	public String toString() {
		return super.toString(this.getHeight());
	}


	@Override
	public boolean addAnimal(Animal a) {
		if(this.getNb_max() > this.getNb_animal()) {
			if (a instanceof CanFly)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(String.join(" ", a.getClass().getSimpleName(), "\u001B[0;35m" + a.getSpecie() + "\u001B[0m", "Was added"));
				return true;
			}
			else {
				System.out.println("\033[0;31m" + "It is not a bird" + "\u001B[0m");
				return false;
			}
		}else {
			System.out.println("\033[0;31m" + "The enclosure is full !" + "\u001B[0m");
			return false;
		}
	}

	@Override
	public void toClean() {
		if (this.getListOfAnimal().isEmpty()){
			if (this.getCleanness() == Cleanness.BAD || this.getCleanness() == Cleanness.CORRECT)
			{
				this.setCleanness(Cleanness.GOOD);
				System.out.println("The enclosure has been cleaned");
			}
			else System.out.println("The enclosure is already clean");
		
			System.out.println("hauteur de l'enclos " + this.getHeight());
		}else System.out.println("\033[0;31m" + "You must empty the enclosure to clean it" + "\u001B[0m");
	}


}
