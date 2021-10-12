/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Wolf extends Animal implements CanVagabound, Mammal {
	
	private final int pregnancy = 60;

	/**
	 * 
	 */
	public Wolf() {
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
	public Wolf(String specie, Gender gender, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super(specie, gender, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public int getPregnancy() {
		return pregnancy;
	}

	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			System.out.println("New wolf appeared !");
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
		System.out.println("AHOUUUUUUUUUUU");
	}

}
