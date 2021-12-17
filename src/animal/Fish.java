/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Fish extends Animal implements Oviparous, CanSwim {
	

	/**
	 * 
	 */
	public Fish() {
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @param specie
	 * @param gender
	 * @param weight
	 * @param age
	 * @param size
	 * @param isHungry
	 * @param isSick
	 * @param isSleeping
	 */
	public Fish(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, false, false, false, 1);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void toSwim() {
		// TODO Auto-generated method stub
		System.out.println("Nice fishes here");

	}

	@Override
	public void toLayEggs() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			System.out.println("New fishes appeared !");
		}
	}



	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("POPOPOPOPO");
	}

}
