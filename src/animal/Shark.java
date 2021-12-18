package animal;

/**
 * @author logan
 * Classe Requin étend d'Animal implémente ovipare et peut nager
 */
public class Shark extends Animal implements Oviparous, CanSwim {


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
	public Shark(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, 2);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Peut nager
	 */
	@Override
	public void toSwim() {
		// TODO Auto-generated method stub
		System.out.println("Beaux poissons icib");
	}

	/**
	 * Peut pondre des oeufs
	 */
	@Override
	public void toLayEggs() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("Tu n'es pas une femelle bro désolé !");
		}else {
			System.out.println("New shark appeared !");
		}
	}


	/**
	 * Parle en requin
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("Je suis le mechant requin");
	}

}
