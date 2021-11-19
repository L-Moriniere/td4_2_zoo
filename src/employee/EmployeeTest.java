/**
 * 
 */
package employee;

import animal.*;
import enclosure.*;

/**
 * @author logan
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Employee jean = new Employee("Jean", EmployeeGender.M, 33);
		Enclosure e1 = new Default_enclosure("Enclos 1", 30, 5);
		Enclosure e2 = new Default_enclosure("Enclos 2", 30, 5);
		Aquarium a1 = new Aquarium("Aquarium 1", 50,2);
		Animal bear = new Bear("bear", Gender.M, 100, 10, 2, false, false, false);
		Animal tiger = new Tiger("tiger", Gender.F, 120, 9, .9, false, false, false);
		Whale whale=new Whale("bleue", Gender.F, 100,500, 15.6, false, true, false);
		Wolf wolf= new Wolf("loup", Gender.F,20,20,10,false,false,false);
		
		e1.addAnimal(bear);
		e1.addAnimal(tiger);
		e2.addAnimal(wolf);
		a1.addAnimal(whale);
		
		jean.toExaminate(e1);
		jean.toExaminate(e2);
		
		jean.toClean(e2);
		e2.setCleanness(Cleanness.BAD);
		jean.toClean(e2);
		
		jean.toFeed(e1);
		bear.setHungry(true);
		jean.toFeed(e1);
		
		jean.toTransfer(e1, bear, a1);
	}
}
