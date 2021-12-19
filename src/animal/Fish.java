/**
 * 
 */
package animal;

import zoo.Commands;

import java.util.Scanner;

/**
 * @author logan
 * Classe Poisson étend d'Animal et implémente ovipare et peut nager
 */
public class Fish extends Animal implements Oviparous, CanSwim {

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
	public Fish(String specie, Gender gender, int weight, int age, double size) {
		super(specie, gender, weight, age, size,  1);
		// TODO Auto-generated constructor stub
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


		return new Fish(name, gender, 1, 0, 0.1);
	}


	/**
	 * Parle en poisson
	 */
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("POPOPOPOPO");
	}

}
