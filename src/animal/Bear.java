/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Bear extends Animal implements Mammal {
	

	/**
	 * 
	 */
	public Bear() {
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
	public Bear(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, false, false, false,3);
		// TODO Auto-generated constructor stub
	}



	
	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			
		}
	}



	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("WRARWARWAR");
	}

}
