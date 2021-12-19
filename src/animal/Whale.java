package animal;

import zoo.Commands;

import java.util.Scanner;

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
     * @return animal
     */
	@Override
	public Animal toGiveBirth() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le nom de l'animal ?"));
		String name = Commands.getUserLine(scanner);

		System.out.println(Commands.coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
		Gender gender = Commands.getUserGender(scanner, Gender.values());


		return new Whale(name, gender, 20, 0, 7);
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
