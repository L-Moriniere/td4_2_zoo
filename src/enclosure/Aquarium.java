package enclosure;

import animal.Animal;
import animal.CanSwim;

import java.util.ArrayList;

/**
 * @author logan
 * Classe Aquarium étend d'Enclos
 */
public class Aquarium extends Enclosure {

	/**
	 * profondeur
	 */
	private double depth;
	/**
	 * salinité
	 */
	private double salinity;


	
	/**
	 * Autre paramètres
	 * Liste d'animaux vide
	 * Propreté= Good
	 * salinité = 50.0
	 * @param name
	 * String name
	 * @param area
	 * double area
	 * @param nb_max
	 * int nb_max
	 * @param depth
	 * double profondeur
	 *
	 */
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


	/**
	 * @return To string
	 */
	@Override
	public String toString() {
		return super.toString(this.getDepth(), this.getSalinity());
	}


	/**
	 * @param a
	 * Animal à ajouter
	 * @return boolean
	 */
	@Override
	public boolean addAnimal(Animal a) {
		if(this.getNb_max() > this.getNb_animal()) {
			if (a instanceof CanSwim)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(String.join(" ", a.getClass().getSimpleName(), "\u001B[0;35m" + a.getSpecie() + "\u001B[0m", "A été ajouté"));
				return true;
			}
			else {
				System.out.println("\033[0;31m" + "Ce n'est pas un poisson !" + "\u001B[0m");
			}
		}else {
			System.out.println("\033[0;31m" + "L'enclos est plein !" + "\u001B[0m");
		}
		return false;
	}

	/**
	 * Permet de nettoyer un enclos
	 */
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
