
package animal;

import zoo.Commands;

import java.util.Scanner;

import static zoo.Commands.coloredText;

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
     * @return
     */
	@Override
	public Animal toGiveBirth() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println(coloredText(PURPLE, "Quel est le nom de l'animal ?"));
		String name = Commands.getUserLine(scanner);

		System.out.println(coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
		Gender gender = Commands.getUserGender(scanner, Gender.values());


		return new Tiger(name, gender, 2, 0, 1.3);
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
