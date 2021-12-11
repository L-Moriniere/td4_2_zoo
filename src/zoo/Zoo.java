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
 * @author logan
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int nbMaxEnclosure;
    private ArrayList<Enclosure> listOfEnclosure = new ArrayList<Enclosure>();
    private static Zoo _instance;

    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    public Clock clock = new Clock();

    /**
     *
     */
    public Zoo() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @param name
     * @param employee
     * @param nbMaxEnclosure
     */
    public Zoo(String name, Employee employee, int nbMaxEnclosure) {
        super();
        this.name = name;
        this.employee = employee;
        this.nbMaxEnclosure = nbMaxEnclosure;

    }

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
    public ArrayList<Enclosure> getListOfEnclosure() { return listOfEnclosure; }

    /**
     * @param listOfEnclosure the listOfEnclosure to set
     */
    public void setListOfEnclosure(ArrayList<Enclosure> listOfEnclosure) {
        this.listOfEnclosure = listOfEnclosure;
    }

    public void addEnclosure(Enclosure e) {
        if (this.getListOfEnclosure().size() <= this.getNbMaxEnclosure()) {
            this.getListOfEnclosure().add(e);
            System.out.println("Enclos " + e.getName() + " ajouté au zoo");
        }
    }


    public int printNbAnimals() {
        int nbTotal = 0;
        for (Enclosure e : this.getListOfEnclosure()) {
            nbTotal += e.getNb_animal();
        }
        System.out.println("Il y a " + nbTotal + " animaux dans le zoo");
        return nbTotal;
    }

    public void printAnimals() {
        for (Enclosure e : this.getListOfEnclosure()) {
            System.out.println(e.getName() + " -- " + e.getListOfAnimal());
        }
    }

    public void makePreset() {
        System.out.println("preset");
        RandomName r = new RandomName();

        this.setNbMaxEnclosure(3);
        Enclosure savane = new Default_enclosure("Savane", 30, 5);
        Aquarium lagon = new Aquarium("Lagon", 100, 4);
        Aviary canyon = new Aviary("Canyon", 40, 4);

        savane.addAnimal(new Tiger(r.getFemaleName(), Gender.F, 120, 9, .9, false, false, false));
        lagon.addAnimal(new Whale(r.getFemaleName(), Gender.F, 100, 500, 15.6, false, false, false));
        savane.addAnimal(new Wolf(r.getFemaleName(), Gender.F, 20, 20, 10, false, false, false));
        lagon.addAnimal(new Shark(r.getMaleName(), Gender.M, 120, 9, .9, false, false, false));
        lagon.addAnimal(new Fish(r.getFemaleName(), Gender.F, 100, 500, 15.6, false, false, false));
        canyon.addAnimal(new Auk(r.getMaleName(), Gender.M, 20, 20, 10, false, false, false));
        canyon.addAnimal(new Eagle(r.getFemaleName(), Gender.F, 20, 20, 10, false, false, false));
        savane.addAnimal(new Bear(r.getMaleName(), Gender.M, 100, 10, 2, false, false, false));

        this.addEnclosure(savane);
        this.addEnclosure(lagon);
        this.addEnclosure(canyon);


    }

    public void makeCustom() {
        System.out.println("custom");

    }

    public void promptUserGeneral() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que voulez-vous faire ? Vous occuper des animaux (1) ? Vous occuper des enclos ? (2)");

        int rep = scanner.nextInt();
        switch (rep) {
            case 1:
                promptUserAnimals();
                break;
            case 2:
                promptUserEnclosure();
                break;
            default:
                System.out.println("Animaux (1) ou enclos (2)");
        }
    }

    public void promptUserEnclosure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous vous occuper des enclos (nettoyage..) (1), en créer (2) ou les voir (3)? ");

        int rep = scanner.nextInt();
        switch (rep) {
            case 1:
                promptEnclosureManage();
                break;
            case 2:
                promptEnclosureNew();
                break;
            case 3:
                System.out.println(this.getListOfEnclosure());
                break;
            default:
                System.out.println("Voulez-vous vous occuper des enclos (nettoyage..) (1), en créer (2) ou les voir (3)? ");
        }
        promptUserGeneral();
    }

    public void promptEnclosureNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous créer une volière (v)?  Un Aquarium (a)? Un enclos terrestre (t)?");
        String rep = scanner.next();

        switch (rep.charAt(0)){
            case 'v':
                System.out.println("Quel nom d'enclos ?");
                String name = scanner.next();
                System.out.println("Quel aire d'enclos ?");
                double area = scanner.nextDouble();
                System.out.println("Capacité max ?");
                int nb_max = scanner.nextInt();
                System.out.println("Hauteur ?");
                double height = scanner.nextDouble();
                this.addEnclosure(new Aviary(name, area, nb_max, height));
                break;
            case 'a':
                System.out.println("Quel nom d'enclos ?");
                name = scanner.next();
                System.out.println("Quel aire d'enclos ?");
                area = scanner.nextFloat();
                System.out.println("Capacité max ?");
                nb_max = scanner.nextInt();
                System.out.println("Profondeur ?");
                double depth = scanner.nextDouble();
                this.addEnclosure(new Aquarium(name, area, nb_max, depth));
                break;
            case 't':
                System.out.println("Quel nom d'enclos ?");
                name = scanner.next();
                System.out.println("Quel aire d'enclos ?");
                area = scanner.nextFloat();
                System.out.println("Capacité max ?");
                nb_max = scanner.nextInt();
                System.out.println("Profondeur ?");
                this.addEnclosure(new Default_enclosure(name, area, nb_max));
                break;
            default:
        promptUserGeneral();
        }
    }

    public void promptEnclosureManage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voici les différentes possibilités: \n" +
                "(1) Ajouter un animal à un enclos \n" +
                "(2) Nettoyer un enclos \n" +
                "(3) Nourrir tous les animaux d'un enclos \n" +
                "(4) Voir l'état d'un enclos \n" +
                "(5) Déplacer un animal \n" +
                "(6) Revenir au menu" +
                "");

        int rep = scanner.nextInt();
        switch (rep){
            case 1:

                break;
            case 2:
                System.out.println("Quel enclos souhaitez vous nettoyer ?");
                System.out.println(this.getListOfEnclosure());
                int enclosureIndex = scanner.nextInt();
                this.getEmployee().toClean(this.getListOfEnclosure().get(enclosureIndex-1));
                break;
            case 3:
                System.out.println("Quel enclos souhaitez vous nourrir ?");
                System.out.println(this.getListOfEnclosure());
                enclosureIndex = scanner.nextInt();
               this.getEmployee().toFeed( this.getListOfEnclosure().get(enclosureIndex-1));
                break;
            case 4:
                System.out.println("Quel enclos souhaitez vous voir ?");
                enclosureIndex = scanner.nextInt();
                this.getEmployee().toExaminate(this.getListOfEnclosure().get(enclosureIndex-1));
                break;
            case 5:
                System.out.println("Quel enclos possède l'animal que vous voulez enlever ?");
                int enclosureFrom = scanner.nextInt();
                Enclosure e1 =this.getListOfEnclosure().get(enclosureFrom-1);

                System.out.println("Quel animal souhaitez vous transférer ?");
                System.out.println(this.getListOfEnclosure().get(enclosureFrom-1).getListOfAnimal());
                int animal = scanner.nextInt();
                Animal a = this.getListOfEnclosure().get(enclosureFrom-1).getListOfAnimal().get(animal);

                System.out.println("Dans quel enclos voulez vous transférer l'animal ?");
                int enclosureTo = scanner.nextInt();
                Enclosure e2 =this.getListOfEnclosure().get(enclosureTo-1);

                this.getEmployee().toTransfer(e1,a, e2);

                break;
            case 6:
                promptUserGeneral();
                break;

        }
        promptUserGeneral();
    }

    public void promptUserAnimals() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous vous occuper des animaux (soin, nourriture..) (1), en ajouter (2) ou les voir ?");

        int rep = scanner.nextInt();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PURPLE + "Bonjour, vous avez lancé une nouvelle partie de Zootopia ! " +
                "Quel est ton nom d'employé ?" + RESET);
        String name = scanner.next();
        System.out.println("Quel est ton age ?");
        int age = scanner.nextInt();
        System.out.println("Quel est ton genre (M/F)?");
        String genre = scanner.next();
        Employee user = new Employee(name, EmployeeGender.valueOf(genre), age);
        this.setEmployee(user);
        System.out.println("Voulez-vous utiliser un preset défini (1) ou bien créer votre propre zoo (2)?");
        int reponseGame = scanner.nextInt();
        switch (reponseGame) {
            case 1 -> makePreset();
            case 2 -> makeCustom();
            default -> System.out.println("Il faut mettre 1 ou 2");
        }
        promptUserGeneral();

    }

    public static void main(String[] args) {

        // TODO : User scanner
        // TODO : Launch game
        // TODO : Runnable Employee, Animal, Enclosure


        Simulator Game = new Simulator();
        Thread t1 = new Thread(Game);
        t1.start();


    }


}
