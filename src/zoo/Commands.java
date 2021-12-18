package zoo;

import animal.Animal;
import enclosure.Aquarium;
import enclosure.Default_enclosure;
import enclosure.Enclosure;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Commands {
    private final Zoo zoo = Zoo.getInstance();

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

    private Enclosure getEnclosureByName(String enclosureName){
        Enclosure e = null;
        ArrayList<Enclosure> zooEnclosure = zoo.getListOfEnclosure();
        for (int i = 0; i < zooEnclosure.toArray().length; i++) {
            if(zooEnclosure.get(i).getName().toLowerCase(Locale.ROOT).equals(enclosureName.toLowerCase(Locale.ROOT)))
                e = zooEnclosure.get(i);
        }
        return e;
    }

    private Integer getUserInt (Scanner input, int minValue, int maxValue) {
        int value;
        value = 0;
        while (true) {
            try {
                value = input.nextInt();
                if((value < minValue) || (value > maxValue)) {
                    System.out.println(coloredText(RED, "You have to choose a number Between " + minValue + "-" + maxValue));
                } else {
                    break; // Input successful, break loop.
                }
            } catch (InputMismatchException IME) {
                System.out.println(coloredText(RED, "Only Int as allow"));
                input.nextLine();
            }
        }
        return (value);
    }

    private String coloredText(String color, String Text){
        return color + Text + RESET;
    }

    public boolean help(){
        System.out.println(coloredText(RED, "!leave"));
        System.out.println("    Leave games");

        System.out.println(coloredText(RED, "!feed ") + "[" + coloredText(PURPLE, "Enclosure name") + "]");
        System.out.println("    This command allow you to feed all animals in Enclosure");

        System.out.println(coloredText(RED, "!addEnclosure ") +
                "[" + coloredText(PURPLE, "name") + "] " +
                "[" + coloredText(PURPLE, "size") + "] " +
                "[" + coloredText(PURPLE, "maxAnimal") + "]");
        System.out.println("    This command allow you to add a new Enclosure to the zoo");

        System.out.println(coloredText(RED, "!addAviary ") +
                "[" + coloredText(PURPLE, "name") + "] " +
                "[" + coloredText(PURPLE, "size") + "] " +
                "[" + coloredText(PURPLE, "maxAnimal") + "] " +
                "[" + coloredText(PURPLE, "height") + "]");
        System.out.println("    This command allow you to add a new Aviary to the zoo");

        System.out.println(coloredText(RED, "!addAquarium ") +
                "[" + coloredText(PURPLE, "name") + "] " +
                "[" + coloredText(PURPLE, "size") + "] " +
                "[" + coloredText(PURPLE, "maxAnimal") + "] " +
                "[" + coloredText(PURPLE, "depth") + "]");
        System.out.println("    This command allow you to add a new Aquarium to the zoo");

        System.out.println(coloredText(RED, "!moveAnimal ") +
                "[" + coloredText(PURPLE, "Animal") + "] " +
                "[" + coloredText(PURPLE, "Enclosure From") + "] " +
                "[" + coloredText(PURPLE, "Enclosure To") + "]");
        System.out.println("    This command allow you to move a animal from one Enclosure to another");

        return false;
    }

    public boolean feed(String[] args) {
        if (args.length != 0) {
            getEnclosureByName(args[0]).feedAllAnimals();
            System.out.println("All animal in " + getEnclosureByName(args[0]).getName() + " have been" + coloredText(PURPLE, " fed"));
        } else {
            System.out.println("""
                    /!\\ Argument missing !
                    !feed [Enclosure Name]
                    This command allow you to feed all animals in enclosure
                    You will find below the list of the enclosures""");
            for (int i = 0; i < zoo.getListOfEnclosure().toArray().length; i++) {
                System.out.println(zoo.getListOfEnclosure().get(i).getName());
            }
            return false;
        }
        return true;
    }

    public boolean clean(String[] args) {
        if (args.length != 0) {
            getEnclosureByName(args[0]).toClean();
            System.out.println(getEnclosureByName(args[0]).getName() + " have been" + coloredText(PURPLE, "cleaned"));
        } else {
            System.out.println("""
                    /!\\ Argument missing !
                    !clean [Enclosure Name]
                    This command allow you to clean this enclosure
                    You will find below the list of the enclosures""");
            for (int i = 0; i < zoo.getListOfEnclosure().toArray().length; i++) {
                System.out.println(coloredText(GREEN, zoo.getListOfEnclosure().get(i).getName()));
            }
            return false;
        }
        return true;
    }

    public boolean addAviary(String[] args){
        if (args.length <= 4) {
            String name = args[0];
            double size = Double.parseDouble(args[1]);
            int nb_max = Integer.parseInt(args[2]);
            double height = Double.parseDouble(args[3]);

            zoo.addEnclosure(new Aquarium(name, size, nb_max, height));
            System.out.println(name + " have been" + coloredText(PURPLE, "added"));
        } else {
            System.out.println("""
                    /!\\ Argument missing !
                    !addaviary [name] [size] [maxAnimal] [height]
                    This command allow you to add a new Aviary to the zoo
                    """);
            return false;
        }
        return true;
    }

    public boolean addAquarium(String[] args){
        if (args.length <= 4) {
            String name = args[0];
            double size = Double.parseDouble(args[1]);
            int nb_max = Integer.parseInt(args[2]);
            double depth = Double.parseDouble(args[3]);

            zoo.addEnclosure(new Aquarium(name, size, nb_max, depth));
            System.out.println(name + " have been" + coloredText(PURPLE, "added"));
        } else {
            System.out.println("""
                    /!\\ Argument missing !
                    !addaquarium [name] [size] [maxAnimal] [depth]
                    This command allow you to add a new Aquarium to the zoo
                    """);
            return false;
        }
        return true;
    }

    public boolean addEnclosure(String[] args){
        if (args.length <= 3) {
            String name = args[0];
            double size = Double.parseDouble(args[1]);
            int nb_max = Integer.parseInt(args[2]);

            zoo.addEnclosure(new Default_enclosure(name, size, nb_max));
            System.out.println(name + " have been" + coloredText(PURPLE, "added"));
        } else {
            System.out.println("""
                    /!\\ Argument missing !
                    !addenclosure [name] [size] [maxAnimal] [height]
                    This command allow you to add a new Enclosure to the zoo
                    """);
            return false;
        }
        return true;
    }

    public boolean moveAnimal(){
        Scanner scanner = new Scanner(System.in);

        viewZoo();

        System.out.println(coloredText(PURPLE, "Choose the enclosure where the animal you want to move is located. (index)"));
        int from = getUserInt(scanner, 0, zoo.getListOfEnclosure().size()+1);
        Enclosure efrom = zoo.getListOfEnclosure().get(from - 1);

        System.out.println(coloredText(PURPLE, "Which animal do you want to transfer ? (index)"));
        int animalIndex = getUserInt(scanner, 0, zoo.getListOfEnclosure().get(from - 1).getListOfAnimal().size()+1);
        Animal animal = zoo.getListOfEnclosure().get(from - 1).getListOfAnimal().get(animalIndex - 1);

        System.out.println(coloredText(PURPLE, "In which enclosure do you want to transfer the animal ? (index)"));
        int to = getUserInt(scanner, 0,  zoo.getListOfEnclosure().size()+1);
        Enclosure eto = zoo.getListOfEnclosure().get(to - 1);

        zoo.getEmployee().toTransfer(efrom, animal, eto);

        return true;
    }

    public boolean viewZoo(){
       zoo.printEnclosure();
       return false;
    }

}
