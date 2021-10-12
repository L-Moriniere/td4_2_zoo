/**
 * 
 */
package animaux;

/**
 * @author logan
 *
 */
public class Fish extends NotMammal {
	
	private boolean isSwimming;

	/**
	 * 
	 */
	public Fish() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 */
	public Fish(String specie) {
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
	public Fish(String specie, int weight, int age, double size, boolean isHungry, boolean isSick, boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public boolean isSwimming() {
		return isSwimming;
	}

	public void setSwimming(boolean isSwimming) {
		this.isSwimming = isSwimming;
	}

}
