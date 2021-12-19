package zoo;

import animal.*;
import employee.Employee;
import employee.EmployeeGender;
import enclosure.Aquarium;
import enclosure.Aviary;
import enclosure.Default_enclosure;
import enclosure.Enclosure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Zoo
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int nbMaxEnclosure;
    private ArrayList<Enclosure> listOfEnclosure = new ArrayList<Enclosure>();

    private Scanner scanner = new Scanner(System.in);
    private static Zoo _instance;
    private int nbDeadAnimal =0;



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
     * Créer un nouveau Zoo vide
     */
    public Zoo() {
    }

    /**
     * Constructeur
     * @param name
     * String name
     * @param employee
     * Employé du zoo
     * @param nbMaxEnclosure
     * Nombre max d'enclos
     */
    public Zoo(String name, Employee employee, int nbMaxEnclosure) {
        super();
        this.name = name;
        this.employee = employee;
        this.nbMaxEnclosure = nbMaxEnclosure;
    }

    /**
     * @return instance of Zoo
     */
    public static Zoo getInstance() {
        if (_instance == null) {
            _instance = new Zoo();
        }
        return _instance;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the nbMaxEnclosure
     */
    public int getNbMaxEnclosure() {
        return nbMaxEnclosure;
    }

    /**
     * @param nbMaxEnclosure the nbMaxEnclosure to set
     */
    public void setNbMaxEnclosure(int nbMaxEnclosure) {
        this.nbMaxEnclosure = nbMaxEnclosure;
    }

    /**
     * @return the listOfEnclosure
     */
    public ArrayList<Enclosure> getListOfEnclosure() {
        return listOfEnclosure;
    }

    /**
     * @return nombre animaux morts
     */
    public int getNbDeadAnimal() {
        return nbDeadAnimal;
    }

    /**
     * @param nbDeadAnimal nombre animaux morts
     */
    public void setNbDeadAnimal(int nbDeadAnimal) {
        this.nbDeadAnimal = nbDeadAnimal;
    }

    /**
     * @param listOfEnclosure the listOfEnclosure to set
     */
    public void setListOfEnclosure(ArrayList<Enclosure> listOfEnclosure) {
        this.listOfEnclosure = listOfEnclosure;
    }

    /**
     * Ajout d'un enclos au zoo
     * @param enclosure
     * enclos à ajouter
     */
    public void addEnclosure(Enclosure enclosure) {
        if (this.getListOfEnclosure().size() < this.getNbMaxEnclosure()) {
            this.getListOfEnclosure().add(e);
            System.out.println("Enclos " + GREEN + e.getName() + RESET + " Was added");
        }
        else System.out.println("Le zoo a trop d'enclos");
    }


    public void printEnclosure(){
        for (Enclosure e : listOfEnclosure) {
            System.out.println(String.join(" ", "(" + ((listOfEnclosure.indexOf(e) + 1)) + ").", e.toString()));
        }
    }

    /**
     * @return int
     * Nombre d'animaux dans le zoo
     */
    public int printNbAnimals() {
        int nbTotal = 0;
        for (Enclosure e : getListOfEnclosure()) {
            nbTotal += e.getNb_animal();
        }
        System.out.println("Il y a " + nbTotal + " animaux dans le zoo");
        return nbTotal;
    }

    /**
     * Affiche les animaux du zoo
     */
    public void printAnimals() {
        for (Enclosure e : getListOfEnclosure()) {
            System.out.println(e.getName() + " -- " + e.getListOfAnimal());
        }
    }

    /**
     * @param e1 enclos 1
     * @param e2 enclos 2
     * @return boolen si nb animal de e1 est > à nb_animal d'e2
     */
    public boolean compareNbAnimal(Enclosure e1, Enclosure e2){
        return e1.getNb_animal() >= e2.getNb_animal();
    }

    /**
     * Affiche les enclos triés par nb_animal
     */
    public void printSortedEnclosure(){

        ArrayList<Enclosure> listSortedEnclosure = new ArrayList<>(this.getListOfEnclosure());

        int size = this.getListOfEnclosure().size();

        for (int i =1; i < size; i++){
            Enclosure current = this.getListOfEnclosure().get(i);

            int j = i-1;

            while ((j > -1 ) && (compareNbAnimal(this.getListOfEnclosure().get(j), current))){
                listSortedEnclosure.set(j+1, listSortedEnclosure.get((j)));
                j--;
            }
            listSortedEnclosure.set(j+1, current);
        }

        System.out.println(listSortedEnclosure);
    }

    /**
     * Faire un zoo prédéfini
     */
    public void makePreset() {
        System.out.println("preset");
        RandomName r = new RandomName();

        setNbMaxEnclosure(5);
        Enclosure savane = new Default_enclosure("Savane", 30, 5);
        Aquarium lagon = new Aquarium("Lagon", 100, 4, 50);
        Aviary canyon = new Aviary("Canyon", 40, 4, 20);

//        savane.addAnimal(new Tiger(r.getFemaleName(), Gender.F, 120, 9, .9));
        lagon.addAnimal(new Whale(r.getFemaleName(), Gender.F, 100, 500, 15.6));
//        savane.addAnimal(new Wolf(r.getFemaleName(), Gender.F, 20, 20, 10));
        lagon.addAnimal(new Shark(r.getMaleName(), Gender.M, 120, 9, .9));
        lagon.addAnimal(new Fish(r.getFemaleName(), Gender.F, 100, 500, 15.6));
        canyon.addAnimal(new Auk(r.getMaleName(), Gender.M, 20, 20, 10));
        canyon.addAnimal(new Eagle(r.getFemaleName(), Gender.F, 20, 20, 10));
        savane.addAnimal(new Bear(r.getMaleName(), Gender.M, 100, 10, 2));

        this.addEnclosure(savane);
        this.addEnclosure(lagon);
        this.addEnclosure(canyon);
        this.printSortedEnclosure();


    }

    /**
     * Faire un zoo customisé
     */
    public void makeCustom() {
        Commands commands = new Commands();

        System.out.println(commands.coloredText(PURPLE, "Que voulez vous faire ?"));
        System.out.println("""
                1. Créer un enclos
                2. Ajouter un animal
                3. Lancer la partie""");

        int rep = commands.getUserInt(scanner, 1, 3);
        switch (rep) {
            case 1 -> {
                commands.addEnclosure();
                makeCustom();
            }
            case 2 -> {
                commands.addAnimal();
                makeCustom();
            }
            case 3 -> {}
            default -> makeCustom();
        }
    }

    public void startGame() {
        Commands commands = new Commands();
        System.out.println(commands.coloredText(PURPLE, "Bonjour, vous avez lancé une nouvelle partie de Zootopia ! "));

        System.out.println(commands.coloredText(PURPLE, "Quel est ton nom d'employé ?"));
        String name = commands.getUserLine(scanner);

        System.out.println(commands.coloredText(PURPLE,"Quel est ton age ?"));
        int age = commands.getUserInt(scanner, 1, 1000);

        System.out.println(commands.coloredText(PURPLE,"Quel est ton genre (M/F)?"));
        EmployeeGender genre = commands.getUserEmployeeGender(scanner, EmployeeGender.values());

        Employee user = new Employee(name, genre, age);
        setEmployee(user);

        System.out.println(PURPLE + "Voulez-vous utiliser un preset défini (1) ou bien créer votre propre zoo (2)?" + RESET);
        int reponseGame = commands.getUserInt(scanner, 1,2);

        switch (reponseGame) {
            case 1 -> makePreset();
            case 2 -> {
                System.out.println(commands.coloredText(PURPLE, "Combien voulez vous d'enclos max dans votre zoo ?"));
                setNbMaxEnclosure(commands.getUserInt(scanner, 2, 10));
                makeCustom();
            }
        }
    }

    public static void main(String[] args) {
        getInstance().startGame();

        Simulator Game = new Simulator();
        Thread t1 = new Thread(Game);
        t1.start();
    }


}
