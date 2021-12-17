/**
 * 
 */
package animal;

/**
 * @author logan
 * Classe ours qui étend d'Animal et implémente Mammifère
 */
public class Bear extends Animal implements Mammal {

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
	public Bear(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size,3);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Donne naissance à un bébé
	 */
	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("Tu n'es pas une femelle bro désolé !");
		}else {
			System.out.println("bébé");
		}
	}


	/**
	 * Parle en ours
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("WRARWARWAR");
	}

}
