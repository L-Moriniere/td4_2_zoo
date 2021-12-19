package enclosure;

import animal.Animal;

import java.util.ArrayList;

/**
 * @author logan
 *
 */
public class Default_enclosure extends Enclosure {


	private Animal a;

	/**
	 * @param name
	 * String name
	 * @param area
	 * double surface
	 * @param nb_max
	 * int nb_max
	 */
	public Default_enclosure(String name, double area, int nb_max) {
		super(name, area, nb_max, 0,new ArrayList<Animal>() , Cleanness.GOOD);
		// TODO Auto-generated constructor stub
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
			this.getListOfAnimal().add(a);
			this.setNb_animal(this.getNb_animal() + 1);
			System.out.println(String.join(" ", a.getClass().getSimpleName(), "\u001B[0;35m" + a.getSpecie() + "\u001B[0m", "a été ajouté"));
			return true;
		}else {
			System.out.println("\033[0;31m" + "L'enclos est plein !" + "\u001B[0m");
		}
		return false;
	}


	/**
	 * Permet de retirer un animal de l'enclos
	 * @param a
	 * Animal à enlever
	 */
	@Override
	public void removeAnimal(Animal a) {
		this.a = a;
		this.getListOfAnimal().remove(a);
		System.out.println(a.getSpecie()+" enlevé");
	}

	/**
	 * Permet de nourrir tous les animaux de l'enclos
	 */
	@Override
	public void feedAllAnimals() {

		for (Animal animal : this.getListOfAnimal()) animal.toFeed();
	}

	/**
	 * Permet de nettoyer l'enclos
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
		}
		else System.out.println("\033[0;31m" + "Vous devez vider l'enclos pour le nettoyer" + "\u001B[0m");
	}

}
