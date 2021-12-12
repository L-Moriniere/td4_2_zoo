package zoo;

import enclosure.Enclosure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Simulator extends TimerTask {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int nbAction = 0;
    private int nbMaxAction = 3;
    private String prefix = "!";

    private Zoo zoo = Zoo.getInstance();

    public void run() {
        zoo.startGame();
//        zootopia.printAnimals();
//        zootopia.promptUserGeneral();

        while (true) {
            randomAction();
        }
    }

    private void userAction() {
        System.out.println("Tu as un total de 3 action à toi de bien les utiliser :");
        // Reading data using readLine
        try {
            String userInput = this.reader.readLine();

            if (userInput.startsWith(prefix)) {

                String[] command = userInput.substring(this.prefix.length()).split(" +");
                String commandName = command[0].toLowerCase(Locale.ROOT);

                String[] args = new String[command.length - 1];

                for (int i=1, k=0; i<command.length; i++){
                    args[k++] = command[i];
                }

                System.out.println(Arrays.toString(command));
                System.out.println(commandName);
                System.out.println(Arrays.toString(args));

                switch (commandName) {
                    case "leave" -> {
                        System.out.println("GoodBye");
                        System.exit(0);
                    }
                    case "feed" -> {
                        //this.zoo.getEmployee().toFeed();
                        if(getEnclosureByName(args[0]) == null){
                            System.out.println("Voici la list des enclos :");
                            for(int i = 0; i < zoo.getListOfEnclosure().toArray().length; i++){
                                System.out.println(zoo.getListOfEnclosure().get(i).getName());
                            }
                            userAction();
                        }
                        System.out.println(getEnclosureByName(args[0]));

                        System.out.println("Test");
                    }
                    case "" -> {
                        System.out.println("Test");
                    }
                    default -> {
                        System.out.println("La commande rentrer est incorrect voici la list des commande :" +
                                "\n!leave -> Quitter le jeux");
                    }
                }

                nbAction++;
                System.out.println("Il te reste " + nbAction + "/3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void randomAction() {
        System.out.println("random action");
        while (nbAction < nbMaxAction) {
            userAction();
        }
        nbAction = 0;
    }

    private Enclosure getEnclosureByName(String enclosureName){
        Enclosure e = null;
        ArrayList<Enclosure> zooEnclosure = zoo.getListOfEnclosure();
        for (int i = 0; i < zooEnclosure.toArray().length; i++) {
            if(zooEnclosure.get(i).getName().toLowerCase(Locale.ROOT).equals(enclosureName.toLowerCase(Locale.ROOT)))
                e = zooEnclosure.get(i);
        }
        return e;
    }
}
