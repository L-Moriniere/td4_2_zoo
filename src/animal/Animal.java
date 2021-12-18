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
	private int weight, age, pregnancy;
	private double size;
	private boolean isHungry, isSick, isSleeping;

	public static final String RESET = "\u001B[0m";
	// Regular Colors
	public static final String BLACK = "\033[0;30m";   // BLACK
	public static final String RED = "\033[0;31m";     // RED
	public static final String GREEN = "\033[0;32m";   // GREEN
	public static final String YELLOW = "\033[0;33m";  // YELLOW
	public static final String BLUE = "\033[0;34m";    // BLUE
	public static final String PURPLE = "\033[0;35m";  // PURPLE
	public static final String CYAN = "\033[0;36m";    // CYAN
	public static final String WHITE = "\033[0;37m";   // WHITE
	
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
			boolean isSleeping, int pregnancy) {
		super();
		this.specie = specie;
		this.gender = gender;
		this.weight = weight;
		this.age = age;
		this.size = size;
		this.isHungry = isHungry;
		this.isSick = isSick;
		this.isSleeping = isSleeping;
		this.pregnancy = pregnancy;
	}




	/**
	 * @return the pregnancy
	 */
	public int getPregnancy() {
		return pregnancy;
	}

	/**
	 * @param pregnancy the pregnancy to set
	 */
	public void setPregnancy(int pregnancy) {
		this.pregnancy = pregnancy;
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
	
	public String animalSays() {
		return this.getClass().getSimpleName()+" says: ";
	}
	
	
	public void finalize()  {
		System.out.println(this.animalSays()+"FATALITY");
	}
	
	
	/**
	 * make an animal to eat
	 */
	public void toFeed() {
		if (!this.isSleeping() && this.isHungry()) {
			this.setHungry(false);
			System.out.println(this.animalSays()+"Miam miam");
		}
		else
			System.out.println(this.animalSays()+ RED + "Je n'ai pas faim" + RESET);
	}
	
	
	/**
	 * make an animal to talk
	 */
	public abstract void sound();
	
	/**
	 * make an animal to get healed
	 */
	public void toHeal() {
		if (this.isSick) {
			this.setSick(false);
			System.out.println(this.animalSays() + "Merci maître");
		}
		else System.out.println(RED +"Je suis déjà en pleine forme" + RESET);
	}
	
	
	/**
	 * make an animal to wake up 
	 */
	public void toWakeUp() {
		if (this.isSleeping())
		{
			this.setSleeping(false);
			System.out.println(this.animalSays()+"Je me réveille");
		}
		else
			System.out.println(this.animalSays()+ RED + "Je ne dors pas" + RESET);
			
	}
	
	/**
	 * make an animal to fell asleep
	 */
	public void toSleep() {
		if (!this.isSleeping())
		{
			this.setSleeping(true);
			System.out.println(this.animalSays()+"Je vais dormir");
		}
		else
			System.out.println(this.animalSays()+"zzzzzzzzzzzzzzzzzzzzzz");
			
	}

	@Override
	public String toString() {
		String animalName = PURPLE + getSpecie() + RESET;
		String specie = getClass().getSimpleName();
		String animalGender = getGender().toString();
		String weight = YELLOW + getWeight() + "kg" + RESET;
		String age = CYAN + getAge() + "Years" + RESET;
		String size = RED + getSize() + "m" + RESET;
		String hungry = isHungry() ? YELLOW + " Hungry" + RESET: "";
		String sick = isSick() ? GREEN + " Sick" + RESET : "";
		String sleeping = isSleeping() ? BLUE + " Sleeping" + RESET: "";

		return (String.join(" ", animalName, specie, animalGender, weight, age, size) + hungry + sick + sleeping);
	}

	public String toSimpleString() {
		String animalName = PURPLE + getSpecie() + RESET;
		String specie = getClass().getSimpleName();

		return (String.join(" ", animalName, specie));
	}

	
	
	

	
}
