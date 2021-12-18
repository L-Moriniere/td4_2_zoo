package enclosure;

import animal.Animal;
import animal.CanFly;

import java.util.ArrayList;

/**
 * @author logan
 * Classe Volière étend d'Enclos
 */
public class Aviary extends Enclosure {
	
	private double height;

	/**
	 * Autre paramètres
	 * Liste d'animaux vide
	 * Propreté= Good
	 * @param name
	 * String name
	 * @param area
	 * double area
	 * @param nb_max
	 * int nb_max
	 * @param height
	 * double hauteur
	 *
	 */
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


	/**
	 * @return toString
	 */
	@Override
	public String toString() {
		return super.toString(this.getHeight());
	}


	/**
	 * Permet d'ajouter un animal
	 * @param a
	 * Animal à ajouter
	 * @return
	 */
	@Override
	public boolean addAnimal(Animal a) {
		if(this.getNb_max() > this.getNb_animal()) {
			if (a instanceof CanFly)
			{
				this.getListOfAnimal().add(a);
				this.setNb_animal(this.getNb_animal()+1);
				System.out.println(a.getClass().getSimpleName()+" ajouté");
			}
			else {
				System.out.println("Ce n'est pas un oiseau");
			}
		}else {
			System.out.println("L'enclos est plein !");				
		}


		return false;
	}

	/**
	 * Permet de nettoyer l'enclos
	 */
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
