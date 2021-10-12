/**
 * 
 */
package animal;

/**
 * @author logan
 *	
 */
public abstract class Animal {
	
	private String specie;
	private Gender gender;
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
	 * @param gender
	 * @param weight
	 * @param age
	 * @param size
	 * @param isHungry
	 * @param isSick
	 * @param isSleeping
	 */
	public Animal(String specie, Gender gender, int weight, int age, double size, boolean isHungry, boolean isSick,
			boolean isSleeping) {
		super();
		this.specie = specie;
		this.gender = gender;
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
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
		if (!this.isSleeping() && this.isHungry()) {
			this.setHungry(false);
			System.out.println("It was some good fucking food");
		}
		else
			System.out.println("I'm not hungry");
	}
	
	
	/**
	 * make an animal to talk
	 */
	public abstract void sound();
	
	/**
	 * make an animal to get healed
	 */
	public void toHeal() {
		this.setSick(false);
		System.out.println("Thank you master");
	}
	
	
	/**
	 * make an animal to wake up 
	 */
	public void toWakeUp() {
		if (this.isSleeping())
		{
			this.setSleeping(false);
			System.out.println("I wake up");
		}
		else
			System.out.println("I'm awake");
			
	}
	
	/**
	 * make an animal to fell asleep
	 */
	public void toSleep() {
		if (!this.isSleeping())
		{
			this.setSleeping(true);
			System.out.println("I sleep");
		}
		else
			System.out.println("I'm sleeping");
			
	}


	
}
