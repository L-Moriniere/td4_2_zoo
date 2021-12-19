
package animal;

import zoo.Commands;

import java.util.Scanner;

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
	public Animal toLayEggs() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le nom de l'animal ?"));
		String name = Commands.getUserLine(scanner);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
		Gender gender = Commands.getUserGender(scanner, Gender.values());


		return new Eagle(name, gender, 2, 0, 0.4);
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
