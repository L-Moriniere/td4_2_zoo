/**
 * 
 */
package enclosure;

import animal.Animal;
import animal.CanSwim;

import java.util.ArrayList;

/**
 * @author logan
 *
 */
public class Aquarium extends Enclosure {
	
	private double depth;
	private double salinity;


	
	/**
	 * @param name
	 * @param area
	 * @param nb_max
	 * @param nb_animal
	 * @param listOfAnimal
	 * @param cleanness
	 */
	public Aquarium(String name, double area, int nb_max) {
		super(name, area, nb_max, 0, new ArrayList<Animal>(), Cleanness.GOOD);
		// TODO Auto-generated constructor stub
	}

	public Aquarium(String name, double area, int nb_max,  double depth) {
		super(name, area, nb_max, 0, new ArrayList<Animal>(), Cleanness.GOOD);
		this.depth = depth;
		this.salinity = 50.0 ;
	}

	/**
	 * @return the depth
	 */
	public double getDepth() {
		return depth;
	}



	/**
	 * @param depth the depth to set
	 */
	public void setDepth(double depth) {
		this.depth = depth;
	}



	/**
	 * @return the salinity
	 */
	public double getSalinity() {
		return salinity;
	}



	/**
	 * @param salinity the salinity to set
	 */
	public void setSalinity(double salinity) {
		this.salinity = salinity;
	}

	

	@Override
	public String toString() {
		return super.toString(this.getDepth(), this.getSalinity());
	}


	@Override
	public boolean addAnimal(Animal a) {
		if(this.getNb_max() > this.getNb_animal()) {
			if (a instanceof CanSwim)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(String.join(" ", a.getClass().getSimpleName(), "\u001B[0;35m" + a.getSpecie() + "\u001B[0m", "Was added"));
				return true;
			}
			else {
				System.out.println("\033[0;31m" + "It is not a fish" + "\u001B[0m");
				return false;
			}
		}else {
			System.out.println("\033[0;31m" + "The enclosure is full !" + "\u001B[0m");
			return false;
		}
	}

	@Override
	public void toClean() {
		if (this.getListOfAnimal().isEmpty())
		{
			if (this.getCleanness() == Cleanness.BAD || this.getCleanness() == Cleanness.CORRECT)
			{
				this.setCleanness(Cleanness.GOOD);
				System.out.println("L'enclos a été nettoyée");
			}
			else System.out.println("L'enclos est déjà propre");
		
			if (this.getDepth() < 50 )
			{
				this.setDepth(80);
				System.out.println("Le bassin a été rempli");
			}
			else System.out.println("Le bassin est assez rempli");
			
			if (this.getSalinity() <20 || this.getSalinity() > 80)
			{
				this.setSalinity(50);
				System.out.println("Le bassin a été ajusté niveau sel");
			}
			else System.out.println("Salinité normale");
		}else System.out.println("\033[0;31m" + "Vous devez vider l'enclos pour le nettoyer" + "\u001B[0m");
	}


}
