/**
 * 
 */
package animaux;

/**
 * @author logan
 *
 */
public class Bird extends NotMammal {
	
	private boolean isFlying;

	/**
	 * 
	 */
	public Bird() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 */
	public Bird(String specie) {
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
	public Bird(String specie, int weight, int age, double size, boolean isHungry, boolean isSick, boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}

}
