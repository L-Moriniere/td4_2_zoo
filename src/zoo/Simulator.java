package zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulator implements Runnable {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "!";

    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    public void run() {
        while (true){
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

                for (int i=1, k=0; i<command.length; i++){
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
        System.out.println("random action");
    }


}
