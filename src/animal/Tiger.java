
package animal;

/**
 * @author logan
 * Classe Tigre etent d'Animal impélement peut vagabonder et mammifère
 */
public class Tiger extends Animal implements CanVagabound, Mammal {

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
	public Tiger(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size,  2);
		// TODO Auto-generated constructor stub
	}


	/**
	 * Peut donner naissance
	 */
	@Override
	public void toGiveBirth() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("Tu n'es pas une femelle bro désolé !");
		}else {
			System.out.println("New tiger appeared !");
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
	 * Parle en tigre
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("GRRRRRRRRRRR");
	}
	
	

}
