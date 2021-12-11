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
		if(this.getNb_max() >= this.getNb_animal()) {			
			if (a instanceof CanFly)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(a.getClass().getSimpleName()+" ajouté");
				return true;
			}
			else {
				System.out.println("Ce n'est pas un oiseau");
				return false;
			}
		}else {
			System.out.println("L'enclos est plein !");				
			return false;
		}	
		
		
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
