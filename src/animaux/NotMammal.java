/**
 * 
 */
package animaux;

/**
 * @author logan
 *
 */
public class NotMammal extends Animal {
	
	private boolean toLay;

	/**
	 * 
	 */
	public NotMammal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param specie
	 */
	public NotMammal(String specie) {
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
	public NotMammal(String specie, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public boolean isToLay() {
		return toLay;
	}

	public void setToLay(boolean toLay) {
		this.toLay = toLay;
	}

}
