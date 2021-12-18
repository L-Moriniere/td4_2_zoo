
package animal;

/**
 * @author logan
 * Classe aigle qu ihérite d'animal et implémente Ovipare et peut voler
 */
public class Eagle extends Animal implements Oviparous, CanFly {


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
	public Eagle(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size, 1);
	
		// TODO Auto-generated constructor stub
	}


	/**
	 * Peut voler
	 */
	@Override
	public void toFly() {
		// TODO Auto-generated method stub
		System.out.println("Je suis trop haut");
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
			System.out.println("New eagle appeared !");
		}
	}


	/**
	 * Parle en aigle
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("KIIIIIIIIIIIIIIIIIIIII");
	}



}
