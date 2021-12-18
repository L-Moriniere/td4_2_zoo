package zoo;

import animal.Animal;
import enclosure.Cleanness;
import enclosure.Enclosure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Simulator implements Runnable {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "!";
    private final Zoo zoo = Zoo.getInstance();


    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    public void run() {
        while (true) {
            randomAction();
            while (nbAction < nbMaxAction) {
                userAction();
            }
            nbAction = 0;
        }
    }

    private void userAction() {
        System.out.println("Tu as un total de " + GREEN + (nbMaxAction - nbAction) + RESET + " action à toi de bien les utiliser :");
        // Reading data using readLine
        try {
            String userInput = reader.readLine();
            boolean Action = true;

            if (userInput.startsWith(prefix)) {

                String[] command = userInput.substring(this.prefix.length()).split(" +");
                String commandName = command[0].toLowerCase();

                String[] args = new String[command.length - 1];

                for (int i = 1, k = 0; i < command.length; i++) {
                    args[k++] = command[i];
                }

                Commands commandsList = new Commands();

                switch (commandName) {
                    case "feed" -> Action = commandsList.feed(args);
                    case "clean" -> Action = commandsList.clean(args);
                    case "addaviary" -> Action = commandsList.addAviary(args);
                    case "addaquarium" -> Action = commandsList.addAquarium(args);
                    case "addenclosure" -> Action = commandsList.addEnclosure(args);
                    case "moveanimal" -> Action = commandsList.moveAnimal();
                    case "zoo" -> Action = commandsList.viewZoo();
                    case "leave" -> {
                        System.out.println("GoodBye");
                        System.exit(0);
                    }
                    default -> Action = commandsList.help();
                }

                if (Action) nbAction++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getAnimalSick() {
        Random random = new Random();

        int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
        Enclosure enclos = zoo.getListOfEnclosure().get(randEnclosure);

        if (!enclos.getListOfAnimal().isEmpty()) {

            int randAnimal = random.nextInt(enclos.getListOfAnimal().size());
            Animal animal = enclos.getListOfAnimal().get(randAnimal);

            if (!animal.isSick()) {
                animal.setSick(true);
                System.out.println(animal + " est malade, si vous ne le soignez pas il risque de mourir");
            }

            else {
                System.out.println(animal + " est mort.. :(");
                zoo.setNbDeadAnimal(zoo.getNbDeadAnimal() + 1);
                enclos.getListOfAnimal().remove(animal);
            }
        }

    }

    public void getAnimalSleep() {
        Random random = new Random();

        int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
        Enclosure enclos = zoo.getListOfEnclosure().get(randEnclosure);

        if (!enclos.getListOfAnimal().isEmpty()) {

            int randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
            Animal animal = zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal);

            if (!animal.isSleeping())
            {
                animal.setSleeping(true);
                System.out.println(animal + " est très fatigué");
            }
            else
                System.out.println(animal + " est déjà endormi");
        }
        else System.out.println("L'enclos est vide");

    }

    public void getAnimalHungry() {
        Random random = new Random();

        int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
        Enclosure enclos = zoo.getListOfEnclosure().get(randEnclosure);

        if (!enclos.getListOfAnimal().isEmpty()) {

            int randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
            Animal animal = zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal);

            if (!animal.isHungry()) {
                animal.setHungry(true);
                System.out.println(animal+ " a faim");
            }
            else
                System.out.println(animal + "a déjà faim");
        }
        System.out.println("L'enclos est vide");
    }

    public void getEnclosureDirty() {
        Random random = new Random();

        int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
        Enclosure enclos = zoo.getListOfEnclosure().get(randEnclosure);

        if (enclos.getListOfAnimal().isEmpty()) {

            if (enclos.getCleanness() == Cleanness.GOOD) {
                enclos.setCleanness(Cleanness.CORRECT);
                System.out.println(enclos.getName() + " s'est sali");

            }
            else if (enclos.getCleanness() == Cleanness.CORRECT) {
                enclos.setCleanness(Cleanness.BAD);
                System.out.println(enclos.getName() + " nuit à la santé des animaux");
            }
            else {
                getAnimalSick();
            }
        }
    }

    private void randomAction() {
        Random random = new Random();
        int nbEventRand = random.nextInt(3) ;
        for (int i = 0; i <= nbEventRand; i++) {
            if (zoo.getNbDeadAnimal() == 3) {
                System.out.println(RED + "GAME OVER, tous les animaux sont morts" + RESET);
                System.exit(0);
            }
            int randEvent = random.nextInt(4) + 1;
            switch (randEvent) {
                case 1 -> getAnimalHungry();
                case 2 -> getAnimalSick();
                case 3 -> getAnimalSleep();
                case 4 -> getEnclosureDirty();
            }
        }
    }


}



