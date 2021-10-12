/**
 * 
 */
package animaux;

/**
 * @author logan
 *	
 */
public class Animal {
	
	private String specie;
	private enum sex{ M, F;};
	private int weight, age;
	private double size;
	private boolean isHungry, isSick, isSleeping;
	
	/**
	 * 
	 */
	public Animal() {
		super();
	}



	/**
	 * @param specie
	 */
	public Animal(String specie) {
		super();
		this.specie = specie;
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
	public Animal(String specie, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super();
		this.specie = specie;
		this.weight = weight;
		this.age = age;
		this.size = size;
		this.isHungry = isHungry;
		this.isSick = isSick;
		this.isSleeping = isSleeping;
	}
	/**
	 * @return the specie
	 */
	public String getSpecie() {
		return specie;
	}
	/**
	 * @param specie the specie to set
	 */
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}
	/**
	 * @return the isHungry
	 */
	public boolean isHungry() {
		return isHungry;
	}
	/**
	 * @param isHungry the isHungry to set
	 */
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	/**
	 * @return the isSick
	 */
	public boolean isSick() {
		return isSick;
	}
	/**
	 * @param isSick the isSick to set
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	/**
	 * @return the isSleeping
	 */
	public boolean isSleeping() {
		return isSleeping;
	}
	/**
	 * @param isSleeping the isSleeping to set
	 */
	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}	
	
	
	
	/**
	 * make an animal to eat
	 */
	public void eat() {
		if (!this.isSleeping()) {
			this.setHungry(false);
		}
	}
	
	
	/**
	 * make an animal to talk
	 */
	public void sound() {
		System.out.println("Grrrrrrrrrrrrrrr");
	}
	
	/**
	 * make an animal to get healed
	 */
	public void toHeal() {
		this.setSick(false);
	}
	
	
	/**
	 * make an animal to wake up or to fell asleep
	 */
	public void toWake() {
		if (this.isSleeping())
			this.setSleeping(false);
		else
			this.setSleeping(true);
	}
	
}
