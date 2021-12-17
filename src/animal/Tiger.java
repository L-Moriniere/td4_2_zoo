/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Tiger extends Animal implements CanVagabound, Mammal {
	

	/**
	 * 
	 */
	public Tiger() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 */
	public Tiger(String specie) {
		super();
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
	public Tiger(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, false, false, false, 2);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			System.out.println("New tiger appeared !");
		}
	}

	@Override
	public void toVagabound() {
		// TODO Auto-generated method stub
		System.out.println("I'm discovering the world");

	}

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("GRRRRRRRRRRR");
	}
	
	

}
