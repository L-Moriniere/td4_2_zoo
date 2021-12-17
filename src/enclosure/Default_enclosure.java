/**
 * 
 */
package enclosure;

import animal.Animal;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author logan
 *
 */
public class Default_enclosure extends Enclosure {
		

	/**
	 * @param name
	 * @param area
	 * @param nb_max
	 */
	public Default_enclosure(String name, double area, int nb_max) {
		super(name, area, nb_max, 0,new ArrayList<Animal>() , Cleanness.GOOD);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAnimal(Animal a) {
		if(this.getNb_max() > this.getNb_animal()) {
			this.getListOfAnimal().add(a);
			this.setNb_animal(this.getNb_animal() + 1);
			System.out.println(a.getSpecie()+" ajouté");
			return true;
		}else {
			System.out.println("L'enclos est plein !");				
			return false;

		}
	}
	

	@Override
	public void removeAnimal(Animal a) {
		this.getListOfAnimal().remove(a);
		System.out.println(a.getSpecie()+" enlevé");
	}

	@Override
	public void feedAllAnimals() {
		ListIterator<Animal> li = this.getListOfAnimal().listIterator();
		
		while (li.hasNext())
			li.next().toFeed();
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
			else {
				System.out.println("L'enclos est déjà propre");
			}
		}
		else System.out.println("L'enclos est plein");
	}

}
