package animal;

import zoo.Commands;

import java.util.Scanner;

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
	public Animal toLayEggs() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le nom de l'animal ?"));
		String name = Commands.getUserLine(scanner);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
		Gender gender = Commands.getUserGender(scanner, Gender.values());

		return new Auk(name, gender, 1, 0, 0.2);
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
