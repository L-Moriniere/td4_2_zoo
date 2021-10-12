/**
 * 
 */
package animaux;

/**
 * @author logan
 *
 */
public class Mammal extends Animal {
	
	private boolean toCalve;
	private enum typeOfMove{SWIM, FLY, WALK};

	/**
	 * 
	 */
	public Mammal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 */
	public Mammal(String specie) {
		super(specie);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 * @param weight
	 * @param age
	 * @param size
	 * @param isHungry
	 * @param isSick
	 * @param isSleeping
	 */
	public Mammal(String specie, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public boolean isToCalve() {
		return toCalve;
	}

	public void setToCalve(boolean toCalve) {
		this.toCalve = toCalve;
	}
	
	

}
