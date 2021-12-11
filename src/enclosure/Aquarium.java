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
		if(this.getNb_max() >= this.getNb_animal()) {			
			if (a instanceof CanSwim)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(a.getSpecie()+" ajouté");
				return true;
			}
			else {
				System.out.println("Ce n'est pas un poisson");
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
			
			
		}
		else System.out.println("L'enclos est plein");
	}


}
