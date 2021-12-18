package zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator implements Runnable {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Commands commandsList = new Commands();
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "!";

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

    private void randomAction() {
        System.out.println("random action");
    }


}
