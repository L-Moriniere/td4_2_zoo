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
			System.out.println(String.join(" ", a.getClass().getSimpleName(), "\u001B[0;35m" + a.getSpecie() + "\u001B[0m", "Was added"));
			return true;
		}else {
			System.out.println("\033[0;31m" + "The enclosure is full !" + "\u001B[0m");
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
			if (this.getCleanness() == Cleanness.BAD || this.getCleanness() == Cleanness.CORRECT)
			{
				this.setCleanness(Cleanness.GOOD);
				System.out.println("The enclosure has been cleaned");
			}
			else System.out.println("The enclosure is already clean");
		}
		else System.out.println("\033[0;31m" + "You must empty the enclosure to clean it" + "\u001B[0m");
	}

}
