/**
 *
 */
package animal;

import zoo.Zoo;
import zoo.Commands;

import java.util.Scanner;

/**
 * @author logan
 * Classe ours qui étend d'Animal et implémente Mammifère
 */
public class Bear extends Animal implements Mammal {
    private final Zoo zoo = Zoo.getInstance();


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
        super(specie, gender, weight, age, size, 3);
        // TODO Auto-generated constructor stub
    }



    /**
     * Donne naissance à un bébé
     * @return nouvel animal
     */
    @Override
    public Animal toGiveBirth() {
        // TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.println(Commands.coloredText(PURPLE, "Quel est le nom de l'animal ?"));
        String name = Commands.getUserLine(scanner);

        System.out.println(Commands.coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
        Gender gender = Commands.getUserGender(scanner, Gender.values());

		return new Bear(name, gender, 10, 0, 1);
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
