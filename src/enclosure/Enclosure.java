/**
 * 
 */
package enclosure;
import java.util.ArrayList;
import java.util.ListIterator;

import animal.Animal;

/**
 * @author logan
 *
 */
public interface Enclosure {

	
	public String toString();
	
	/**
	 * Function to implement
	 * @param a
	 */
	
	public void addAnimal(Animal a);
	public void removeAnimal(Animal a);
	public void feedAllAnimal();
	public void toClean();
}
