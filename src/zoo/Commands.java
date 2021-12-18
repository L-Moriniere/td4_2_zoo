package zoo;

import animal.*;
import employee.EmployeeGender;
import enclosure.Aquarium;
import enclosure.Aviary;
import enclosure.Default_enclosure;
import enclosure.Enclosure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Commands {
    /**
     * Récupérer l'instances courant du zoo à l'aide du singleton
     */
    private final Zoo zoo = Zoo.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    /**
     * Lire la prochaine chaîne de caractère non vide
     * @param input
     * @return String value
     */
    public String getUserLine(Scanner input){
        String value;
        value = "";
        while (true) {
            try {
                value = input.next();
                if(value.isEmpty()){
                    System.out.println(coloredText(RED, "La chaine de caractère ne dois pas être vide"));
                }else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Seulement une chaine de caractère sont accepté"));
                input.nextLine();
            }
        }
        return (value);
    }

    /**
     * Lire le genre de l'animal et vérifie que la valeur rentré fait partie de l'enum
     * @param input
     * @param allow
     * @return Gender
     */
    public Gender getUserGender(Scanner input, Gender[] allow){
        Gender value;
        value = Gender.M;
        while (true) {
            try {
                String userInput = input.next().toUpperCase();
                HashSet<String> values = new HashSet<String>();

                for (Gender c : allow) {
                    values.add(c.name());
                }

                if(!values.contains(userInput)){
                    System.out.println(coloredText(RED, "Seulement " + Arrays.toString(allow) + " sont accepté"));
                }else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Seulement les chaîne de caractère sont accepté"));
                input.nextLine();
            }
        }
        return (value);
    }

    /**
     * Lire le genre de l'animal et vérifie que la valeur rentré fait partie de l'enum
     * @param input  un scanner
     * @param allow
     * @return EmployeeGender
     */
    public EmployeeGender getUserEmployeeGender(Scanner input, EmployeeGender[] allow){
        EmployeeGender value;
        value = EmployeeGender.M;
        while (true) {
            try {
                String userInput = input.next().toUpperCase();
                HashSet<String> values = new HashSet<String>();

                for (EmployeeGender c : allow) {
                    values.add(c.name());
                }

                if(!values.contains(userInput)){
                    System.out.println(coloredText(RED, "Seulement " + Arrays.toString(allow) + " sont accepté"));
                }else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Seulement les chaîne de caractère sont accepté"));
                input.nextLine();
            }
        }
        return (value);
    }

    /**
     * Lire un entier compris entre une valeur minimum et maximum
     * @param input
     * @param minValue
     * @param maxValue
     * @return
     */
    public Integer getUserInt(Scanner input, int minValue, int maxValue) {
        int value;
        value = 0;
        while (true) {
            try {
                value = input.nextInt();
                if((value < minValue) || (value > maxValue)) {
                    System.out.println(coloredText(RED, "Vous devez choisir un numéro entre " + minValue + "-" + maxValue));
                } else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Seulement les entier son accepté"));
                input.nextLine();
            }
        }
        return (value);
    }

    /**
     * Lire un nombre flottant compris entre une valeur minimum et maximum
     * @param input
     * @param minValue
     * @param maxValue
     * @return true
     */
    public Double getUserDouble(Scanner input, double minValue, double maxValue){
        double value;
        value = 0.0;
        while (true) {
            try {
                value = input.nextDouble();
                if((value < minValue) || (value > maxValue)) {
                    System.out.println(coloredText(RED, "Vous devez choisir un numéro entre " + minValue + "-" + maxValue));
                } else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Seulement les nombre flottant sont accepté"));
                input.nextLine();
            }
        }
        return (value);
    }

    public String coloredText(String color, String Text){
        return color + Text + RESET;
    }

    /**
     * Cette commande permet au joueur d'afficher l'état du zoo
     * @return true
     */
    public boolean viewZoo(){
        zoo.printEnclosure();
        return true;
    }

    /**
     * Cette commande permet au joueur de connaître l'ensemble des commandes disponible
     * @return False l'action ne sera donc pas comptabilisé
     */
    public boolean help(){
        System.out.println(coloredText(RED, "!leave"));
        System.out.println("    Quitter le jeu");

        System.out.println(coloredText(RED, "!zoo"));
        System.out.println("    Cette commande vous permet de voir l'état du zoo");

        System.out.println(coloredText(RED, "!feed"));
        System.out.println("    Cette commande vous permet de nourrir tous les animaux de l'enclos.");

        System.out.println(coloredText(RED, "!clean"));
        System.out.println("    Cette commande vous permet de nettoyer cette enclos");

        System.out.println(coloredText(RED, "!heal"));
        System.out.println("    Cette commande permet de soigner un animal.");

        System.out.println(coloredText(RED, "!wakeup"));
        System.out.println("    Cette commande vous permet de réveiller un animal");

        System.out.println(coloredText(RED, "!addEnclosure "));
        System.out.println("    Cette commande vous permet d'ajouter un nouvel enclos au zoo.");

        System.out.println(coloredText(RED, "!moveAnimal "));
        System.out.println("    Cette commande permet de déplacer un animal d'un enclos à un autre.");

        System.out.println(coloredText(RED, "!addAnimal "));
        System.out.println("    Cette commande permet d'ajouter un animal dans un enclos.");

        return false;
    }

    /**
     * Cette commande permet au joueur de nourrir les animaux d'un enclos
     * @return True l'action sera donc comptabilisé
     */
    public boolean feed() {
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos que vous souhaiter nettoyer (index)"));
        int from = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure e = zoo.getListOfEnclosure().get(from - 1);

        zoo.getEmployee().toFeed(e);
        return true;
    }

    /**
     * Cette commande permet au joueur de nettoyer une enceinte spécifique
     * @return True l'action sera donc comptabilisé
     */
    public boolean clean() {
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos que vous souhaiter nettoyer (index)"));
        int from = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure e = zoo.getListOfEnclosure().get(from - 1);

        zoo.getEmployee().toClean(e);
        return true;
    }

    /**
     * Cette commande permet au joueur d'ajouter un enclos au Zoo
     * @return True l'action sera donc comptabilisé
     */
    public boolean addEnclosure(){
        System.out.println(coloredText(PURPLE, "Quel enclos voulez-vous ajouter ?"));
        System.out.println("""
                    1. Aquarium
                    2. Volière
                    3. Terrestre""");
        int type = getUserInt(scanner, 1, 3);

        System.out.println(coloredText(PURPLE, "Quel est le nom de l'enclos ?"));
        String name = getUserLine(scanner);

        System.out.println(coloredText(PURPLE, "Quel la superficie de l'enclos ? (en m ex: 20,0)"));
        Double area = getUserDouble(scanner, 0.0, 200.0);

        System.out.println(coloredText(PURPLE, "Quel est la capacité max de l'enclos ? "));
        Integer nb_max = getUserInt(scanner, 2, 10);

        if(type == 1){
            System.out.println(coloredText(PURPLE, "Quel est la profondeur de l'enclos ? (en m ex: 10,0)"));
            Double depth = getUserDouble(scanner, 2, 100);
            zoo.addEnclosure(new Aquarium(name, area, nb_max, depth));
        }

        else if (type == 2){
            System.out.println(coloredText(PURPLE, "Quel est la Hauteur de la volière ? (en m ex: 10,0)"));
            Double height = getUserDouble(scanner, 2, 100);
            zoo.addEnclosure(new Aviary(name, area, nb_max, height));
        }else {
            zoo.addEnclosure(new Default_enclosure(name, area, nb_max));
        }

        return true;
    }

    /**
     * Cette commande permet au joueur de déplacer un animal d'un enclos à un autre
     * @return True l'action sera donc comptabilisé
     */
    public boolean moveAnimal(){
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos où se trouve l'animal que vous voulez déplacer. (index)"));
        int from = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure eFrom = zoo.getListOfEnclosure().get(from - 1);

        System.out.println(coloredText(PURPLE, "Quel animal voulez-vous transférer ? (index)"));
        int animalIndex = getUserInt(scanner, 0,eFrom.getListOfAnimal().size());
        Animal animal = eFrom.getListOfAnimal().get(animalIndex - 1);

        System.out.println(coloredText(PURPLE, "Dans quel enclos voulez-vous transférer l'animal ? (index)"));
        int to = getUserInt(scanner, 1,  zoo.getListOfEnclosure().size());
        Enclosure eTo = zoo.getListOfEnclosure().get(to - 1);

        zoo.getEmployee().toTransfer(eFrom, animal, eTo);

        return true;
    }

    /**
     * Cette commande permet au joueur d'ajouter un animal dans un enclos
     * @return True l'action sera donc comptabilisé
     */
    public boolean addAnimal(){
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos où vous voulez ajouter un animal"));
        int from = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure eWhere = zoo.getListOfEnclosure().get(from - 1);

        System.out.println(coloredText(PURPLE, "Quel animal voulez-vous ajouter ?"));
        System.out.println("""
                1. Pingouin
                2. Ours
                3. Aigle
                4. Poisson
                5. Requin
                6. Tigre
                7. Baleine
                8. Loup""");
        int type = getUserInt(scanner, 1, 8);

        System.out.println(coloredText(PURPLE, "Quel est le nom de l'animal ?"));
        String name = getUserLine(scanner);

        System.out.println(coloredText(PURPLE, "Quel est le sexe de l'animal (M/F)"));
        Gender gender = getUserGender(scanner, Gender.values());

        System.out.println(coloredText(PURPLE, "Quel est le poids de l'animal ? (en kg ex: 20)"));
        Integer weight = getUserInt(scanner, 0, 10000);

        System.out.println(coloredText(PURPLE, "Quel est l'âge de l'animal ? (en années)"));
        Integer age = getUserInt(scanner, 0, 200);

        System.out.println(coloredText(PURPLE, "Quel est la taille de l'animal ? (en m ex: 1,5)"));
        Double size = getUserDouble(scanner, 0, 1000);

        if (type == 1) eWhere.addAnimal(new Auk(name, gender, weight, age, size));
        if (type == 2) eWhere.addAnimal(new Bear(name, gender, weight, age, size));
        if (type == 3) eWhere.addAnimal(new Eagle(name, gender, weight, age, size));
        if (type == 4) eWhere.addAnimal(new Fish(name, gender, weight, age, size));
        if (type == 5) eWhere.addAnimal(new Shark(name, gender, weight, age, size));
        if (type == 6) eWhere.addAnimal(new Tiger(name, gender, weight, age, size));
        if (type == 7) eWhere.addAnimal(new Whale(name, gender, weight, age, size));
        if (type == 8) eWhere.addAnimal(new Wolf(name, gender, weight, age, size));

        return true;
    }

    /**
     * Cette commande permet au joueur de soigner un animal d'un enclos
     * @return True l'action sera donc comptabilisé
     */
    public boolean heal(){
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos où se trouve l'animal que vous voulez soigner. (index)"));
        int where = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure eWhere = zoo.getListOfEnclosure().get(where - 1);

        System.out.println(coloredText(PURPLE, "Quel animal voulez-vous soigner ? (index)"));
        int animalIndex = getUserInt(scanner, 1, eWhere.getListOfAnimal().size());
        Animal animal = eWhere.getListOfAnimal().get(animalIndex - 1);

        animal.toHeal();

        return true;
    }


    /**
     * Cette commande permet au joueur de réveiller un animal d'un enclos
     * @return True l'action sera donc comptabilisé
     */
    public boolean wakeUp(){
        viewZoo();

        System.out.println(coloredText(PURPLE, "Choisissez l'enclos où se trouve l'animal que vous voulez réveiller. (index)"));
        int where = getUserInt(scanner, 1, zoo.getListOfEnclosure().size());
        Enclosure eWhere = zoo.getListOfEnclosure().get(where - 1);

        System.out.println(coloredText(PURPLE, "Quel animal voulez-vous réveiller ? (index)"));
        int animalIndex = getUserInt(scanner, 1, eWhere.getListOfAnimal().size());
        Animal animal = eWhere.getListOfAnimal().get(animalIndex - 1);

        animal.toWakeUp();

        return true;
    }
}
