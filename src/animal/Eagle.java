/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Eagle extends Animal implements Oviparous, CanFly {
	

	/**
	 * 
	 */
	public Eagle() {
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
	public Eagle(String specie, Gender gender, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super(specie, gender, weight, age, size, isHungry, isSick, isSleeping, 35);
	
		// TODO Auto-generated constructor stub
	}


	@Override
	public void toFly() {
		// TODO Auto-generated method stub
		System.out.println("I'm too high");
	}

	@Override
	public void toLayEggs() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			System.out.println("New eagle appeared !");
		}
	}



	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("KIIIIIIIIIIIIIIIIIIIII");
	}



}
