/**
 * 
 */
package animaux;

/**
 * @author logan
 *
 */
public class Tiger extends Mammal {
	
	private boolean isVagabond;

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
	public Tiger(String specie, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the isVagabond
	 */
	public boolean isVagabond() {
		return isVagabond;
	}

	/**
	 * @param isVagabond the isVagabond to set
	 */
	public void setVagabond(boolean isVagabond) {
		this.isVagabond = isVagabond;
	}

}
