package animaux;

public class Loup extends Mammal {
	
	private boolean isVagabond;

	public Loup() {
		// TODO Auto-generated constructor stub
	}

	public Loup(String specie) {
		super(specie);
		// TODO Auto-generated constructor stub
	}

	public Loup(String specie, int weight, int age, double size, boolean isHungry, boolean isSick, boolean isSleeping) {
		super(specie, weight, age, size, isHungry, isSick, isSleeping);
		// TODO Auto-generated constructor stub
	}

	public boolean isVagabond() {
		return isVagabond;
	}

	public void setVagabond(boolean isVagabond) {
		this.isVagabond = isVagabond;
	}

}
