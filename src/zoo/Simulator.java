package zoo;

import enclosure.Cleanness;

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

    private void randomAction() {
        Random random = new Random();
        int nbEventRand = random.nextInt(5) + 1;
        for (int i = 1; i <= nbEventRand; i++) {
            if (zoo.getNbDeadAnimal() == 3) {
                System.out.println(RED+"GAME OVER, tous les animaux sont morts"+RESET);
                System.exit(0);
            }
            int randEvent = random.nextInt(4) + 1;
            switch (randEvent) {
                case 1:
                    //faim
                    int randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().isEmpty()) break;
                    int randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).isHungry()) break;
                    zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).setHungry(true);
                    System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " a faim");
                    break;
                case 2:
                    //malade
                    randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().isEmpty()) break;
                    randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
                    if (!zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).isSick()) {
                        zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).setSick(true);
                        System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " est malade, si vous ne le soignez pas il risque de mourir");
                    } else {
                        System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " est mort.. :(");
                        zoo.setNbDeadAnimal(zoo.getNbDeadAnimal()+1);
                        zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().remove(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal));
                    }
                    break;
                case 3:
                    //sleep
                    randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().isEmpty()) break;
                    randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).isSleeping()) break;
                    zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).setSleeping(true);
                    System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " est très fatigué");
                    break;
                case 4:
                    randEnclosure = random.nextInt(zoo.getListOfEnclosure().size());
                    if (zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().isEmpty()) break;
                    if (zoo.getListOfEnclosure().get(randEnclosure).getCleanness() == Cleanness.GOOD) {
                        zoo.getListOfEnclosure().get(randEnclosure).setCleanness(Cleanness.CORRECT);
                        System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getName() + " s'est sali");

                    } else if (zoo.getListOfEnclosure().get(randEnclosure).getCleanness() == Cleanness.CORRECT) {
                        zoo.getListOfEnclosure().get(randEnclosure).setCleanness(Cleanness.BAD);
                        System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getName() + " nuit à la santé des animaux");
                    } else {
                        randAnimal = random.nextInt(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().size());
                        if (!zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).isSick()) {
                            zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal).setSick(true);
                            System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " est malade, si vous ne le soignez pas il risque de mourir");
                        } else {
                            zoo.setNbDeadAnimal(zoo.getNbDeadAnimal()+1);
                            System.out.println(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal) + " est mort.. :(");
                            zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().remove(zoo.getListOfEnclosure().get(randEnclosure).getListOfAnimal().get(randAnimal));
                        }
                    }
                    break;

            }
        }
    }


}



