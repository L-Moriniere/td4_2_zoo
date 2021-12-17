package animal;

/**
 * @author logan
 * Classe pingouin qu ietend d'Animal et implémente ovipare, peut nager et peut voler
 */
public class Auk extends Animal implements Oviparous, CanFly, CanSwim {

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
	public Auk(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size ,2);

		// TODO Auto-generated constructor stub
	}


	/**
	 * Permet de nager
	 */
	@Override
	public void toSwim() {
		// TODO Auto-generated method stub
		System.out.println("Sympa les poissons ici");
	}

	/**
	 * Permet de voler
	 */
	@Override
	public void toFly() {
		// TODO Auto-generated method stub
		System.out.println("Je suis trop haut");
	}

	/**
	 * Permet de pondre des oeufs
	 */
	@Override
	public void toLayEggs() {
		// TODO Auto-generated method stub
		if (this.getGender() !=  Gender.F) {
			System.out.println("Tu n'es pas une femelle bro désolé !");
		}else {
			System.out.println("New auk appeared !");
		}
	}


	/**
	 * Parle en pingouin
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("HAAAAAAAAAN");
	}

	
}
