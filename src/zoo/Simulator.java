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
    private Commands commandsList = new Commands();
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "!";
    private final Zoo zoo = Zoo.getInstance();


    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    /**
     * Cette methode est appelé au démarrage du Thread dans le main du Zoo
     * Elle s'occupe de faire alterner entre une action aléatoire et le tour du joueur
     */
    public void run() {
        commandsList.help();
        System.out.println("Tu as un total de " + GREEN + nbMaxAction + RESET + " action à toi de bien les utiliser :");

        while (true){
            randomAction();
            while (nbAction < nbMaxAction) {
                userAction();
            }
            nbAction = 0;
        }
    }

    private void userAction() {
        System.out.println(PURPLE + "Action restante : " + RESET +
                (nbMaxAction - nbAction) + "/" + nbMaxAction);
        // Reading data using readLine
        try {
            String userInput = reader.readLine();
            boolean Action = true;

            if (userInput.startsWith(prefix)) {

                String[] command = userInput.substring(this.prefix.length()).split(" +");
                String commandName = command[0].toLowerCase();

                switch (commandName) {
                    case "feed" -> Action = commandsList.feed();
                    case "clean" -> Action = commandsList.clean();
                    case "addenclosure" -> Action = commandsList.addEnclosure();
                    case "moveanimal" -> Action = commandsList.moveAnimal();
                    case "zoo" -> Action = commandsList.viewZoo();
                    case "addanimal" -> Action = commandsList.addAnimal();
                    case "heal" -> Action = commandsList.heal();
                    case "wakeup" -> Action = commandsList.wakeUp();
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

    /**
     * Permet de rendre un animal aléatoire malade, si l'animal est déjà malade il meurt
     */
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

    /**
     * Permet d'endormir un animal aléatoire
     */
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

    /**
     * Fonction qui permet de rendre un animal aléatoire affamé
     */
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

    /**
     * Fonction qui salit un enclos aléatoire, si l'enclos est correct il devient sale et si il est déjà sale un animal aléatoire tombe malade
     */
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

    /**
     * Permet d'effectuer des évenement aléatoires quand l'utilisateur a fini de jouer
     */
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



