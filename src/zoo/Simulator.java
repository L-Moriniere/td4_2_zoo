package zoo;

import animal.Animal;
import enclosure.Cleanness;
import enclosure.Enclosure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Class simulator impélemente runnable
 */
public class Simulator implements Runnable {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Commands commandsList = new Commands();
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "";
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

    /**
     * Cette methode est appelé au démarrage du Thread dans le main du Zoo
     * Elle s'occupe de faire alterner entre une action aléatoire et le tour du joueur
     */
    public void run() {
        commandsList.help();

        while (true){
            randomAction();
            while (nbAction < nbMaxAction) {
                userAction();
            }
            nbAction = 0;
        }
    }

    /**
     * action de l'utilisateur
     */
    private void userAction() {
        System.out.println(PURPLE + "Action restante : " + RESET +
                (nbMaxAction - nbAction) + "/" + nbMaxAction);
        System.out.print(">");
        // Reading data using readLine
        try {
            String userInput = reader.readLine();
            boolean Action = true;
            boolean endTurn = false;

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
                    case "end" -> endTurn = commandsList.endTurn();
                    case "leave" -> {
                        System.out.println("GoodBye");
                        System.exit(0);
                    }
                    default -> Action = commandsList.help();
                }

                if (Action && !endTurn) nbAction++;
                if (endTurn) nbAction = nbMaxAction;
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
                System.out.println(animal.toSimpleString() + YELLOW + " a faim" + RESET);
            }
            else
                System.out.println(animal.toSimpleString() + RED + " a déjà faim" + RESET);
        }
        else System.out.println("L'enclos est vide");
    }

    /**
     * Fonction qui salit un enclos aléatoire, si l'enclos est correct il devient sale et si il est déjà sale un animal aléatoire tombe malade
     */
    public void getEnclosureDirty() {
        Random random = new Random();

        int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
        Enclosure enclos = zoo.getListOfEnclosure().get(randEnclosure);

        if (!enclos.getListOfAnimal().isEmpty()) {

            if (enclos.getCleanness() == Cleanness.GOOD) {
                enclos.setCleanness(Cleanness.CORRECT);
                System.out.println(enclos.toSimpleString());

            }
            else if (enclos.getCleanness() == Cleanness.CORRECT) {
                enclos.setCleanness(Cleanness.BAD);
                System.out.println(enclos.toSimpleString());
            }
            else {
                getAnimalSick();
            }
        }
    }

    /**
     * Permet d'effectuer des évenement aléatoires quand l'utilisateur a fini de jouer
     * 1. rendre un animal affamé
     * 2. rendre un animal malade
     * 3. endormir un animal
     * 4. salir un enclos
     * 5. 60% de chance de faire tomber enceinte une femelle
     */
    private void randomAction() {
        Random random = new Random();
        System.out.println();
        zoo.setDays(zoo.getDays()+1);
        System.out.println("Et poof ! Nous somme le lendemain - Jour "+zoo.getDays());
        System.out.println();

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
        if (random.nextFloat() < 0.6) {
            // 60% de chance de rentrer ici
            zoo.getPregnant();
        }
        if (!zoo.getListOfPregnantAnimal().isEmpty()){
            zoo.giveBirthOrLayEggs();
            zoo.getListOfPregnantAnimal().removeIf(animal -> !animal.isPregnant());
        }
    }




}



