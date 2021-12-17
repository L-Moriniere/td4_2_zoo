/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Whale extends Animal implements Mammal, CanSwim {
	

	/**
	 * 
	 */
	public Whale() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param specie
	 * @param gender
	 * @param weight
	 * @param age
	 * @param size
	 */
	public Whale(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, false, false, false, 4);
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("You have to be a female to Give Birth sorry bro !");			
		}else {
			System.out.println("New whale appeared !");
		}
	}


	@Override
	public void toSwim() {
		// TODO Auto-generated method stub
		System.out.println("Nice fishes here");
	}


	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("MMMMMMMMMHHHHHHHHHHHHHHHHHH");
	}

}
