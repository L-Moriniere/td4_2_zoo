package animal;

/**
 * @author logan
 * Classe Baleine étend d'Animal implémente mammifère et peut nager
 */
public class Whale extends Animal implements Mammal, CanSwim {


	/**
	 * @param specie
	 * String specie
	 * @param gender
	 * Enum gender
	 * @param weight
	 * int poids
	 * @param age
	 * int age
	 * @param size
	 * double taille
	 */
	public Whale(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size,  4);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Donne naissance
	 */
	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("Tu n'es pas une femelle bro désolé !");
		}else {
			System.out.println("New whale appeared !");
		}
	}


	/**
	 * Peut nager
	 */
	@Override
	public void toSwim() {
		// TODO Auto-generated method stub
		System.out.println("Nice fishes here");
	}


	/**
	 * Parle en baleine
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("MMMMMMMMMHHHHHHHHHHHHHHHHHH");
	}

}
