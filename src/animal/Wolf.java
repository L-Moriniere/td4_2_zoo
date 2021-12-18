/**
 * 
 */
package animal;

/**
 * @author logan
 * Classe Loup qui étend d'Animal et implémente peut vagabonder et mammifère
 */
public class Wolf extends Animal implements CanVagabound, Mammal {


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
	public Wolf(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size,2);
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
			System.out.println("New wolf appeared !");
		}
	}

	/**
	 * Peut vagabonder
	 */
	@Override
	public void toVagabound() {
		// TODO Auto-generated method stub
		System.out.println("I'm discovering the world");
	}


	/**
	 * Parle en loup
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("AHOUUUUUUUUUUU");
	}

}
