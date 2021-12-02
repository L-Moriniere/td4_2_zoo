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
 *
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int nbMaxEnclosure;
    private ArrayList<Enclosure> listOfEnclosure = new ArrayList<Enclosure>();

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
        for (Enclosure e : this.listOfEnclosure) {
            nbTotal += e.getNb_animal();
        }
        System.out.println("Il y a " + nbTotal + " animaux dans le zoo");
        return nbTotal;
    }

    public void printAnimals() {
        for (Enclosure e : this.listOfEnclosure) {
            System.out.println(e.getName() + " -- " + e.getListOfAnimal());
        }
    }

    public void makePreset(){
        System.out.println("preset");
        RandomName r = new RandomName();

        this.setNbMaxEnclosure(3);
        Enclosure savane = new Default_enclosure("Savane", 30, 5);
        Aquarium lagon = new Aquarium("Lagon", 100,4);
        Aviary canyon = new Aviary("Canyon", 40,4);

        savane.addAnimal(new Tiger(r.getFemaleName(), Gender.F, 120, 9, .9, false, false, false));
        lagon.addAnimal( new Whale(r.getFemaleName(), Gender.F, 100,500, 15.6, false, true, false));
        savane.addAnimal( new Wolf(r.getFemaleName(), Gender.F,20,20,10,false,false,false));
        lagon.addAnimal( new Shark(r.getMaleName(), Gender.M, 120, 9, .9, false, false, false));
        lagon.addAnimal( new Fish(r.getFemaleName(), Gender.F, 100,500, 15.6, false, true, false));
        canyon.addAnimal( new Auk(r.getMaleName(), Gender.M,20,20,10,false,false,false));
        canyon.addAnimal( new Eagle(r.getFemaleName(), Gender.F,20,20,10,false,false,false));
        savane.addAnimal(new Bear(r.getMaleName(), Gender.M, 100, 10, 2, false, false, false));

        this.addEnclosure(savane);
        this.addEnclosure(lagon);
        this.addEnclosure(canyon);


    }

    public void makeCustom(){
        System.out.println("custom");

    }

    public void startGame () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bonjour, vous avez lancé une nouvelle partie de Zootopia ! " +
                "Quel est ton nom d'employé ?");
        String name = scanner.next();
        System.out.println("Quel est ton age ?");
        int age = scanner.nextInt();
        System.out.println("Quel est ton genre (M/F)?");
        String genre = scanner.next();
        Employee user = new Employee(name, EmployeeGender.valueOf(genre) , age);
        this.setEmployee(user);
        System.out.println("Voulez-vous utiliser un preset défini (1) ou bien créer votre propre zoo (2)?");
        int reponseGame = scanner.nextInt();
        switch (reponseGame) {
            case 1 -> makePreset();
            case 2 -> makeCustom();
            default -> System.out.println("Il faut mettre 1 ou 2");
        }

    }

    public static void main(String[] args) {
		/*
		Employee michel = new Employee("Michel", EmployeeGender.M, 50);
		Zoo zootopia = new Zoo("Zootopia", michel, 20, new ArrayList<Enclosure>());
		Enclosure e1 = new Default_enclosure("Enclos 1", 30, 5);
		Enclosure e2 = new Default_enclosure("Enclos 2", 30, 5);
		Aquarium a1 = new Aquarium("Aquarium 1", 50,2);
		Animal bear = new Bear("bear", Gender.M, 100, 10, 2, false, false, false);
		Animal tiger = new Tiger("tiger", Gender.F, 120, 9, .9, false, false, false);
		Whale whale=new Whale("bleue", Gender.F, 100,500, 15.6, false, true, false);
		Wolf wolf= new Wolf("loup", Gender.F,20,20,10,false,false,false);

		zootopia.addEnclosure(e1);
		zootopia.addEnclosure(e2);
		zootopia.addEnclosure(a1);

		e1.addAnimal(bear);
		e1.addAnimal(tiger);
		e2.addAnimal(wolf);
		a1.addAnimal(whale);
		michel.toExaminate(e1);

		zootopia.printNbAnimals();
		zootopia.printAnimals();

        //TODO Faire prompt - Preset zoo/zoo custom - thread event random

        Zoo zootopia = new Zoo();

        Enclosure e1 = new Default_enclosure("Enclos 1", 30, 5);
        Animal bear = new Bear("bear", Gender.M, 100, 10, 2, false, false, false);

        zootopia.addEnclosure(e1);
        e1.addAnimal(bear);

//		zootopia.clock.start();

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (zootopia.printNbAnimals() == 3) {
                    System.out.println("oui");
                    timer.cancel();
                } else {
                    System.out.println("non");
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*
        // TODO : Create preset game
        // TODO : User scanner
        // TODO : Lunch game
        // TODO : Runnable Employee, Animal, Enclosure

        e1.addAnimal(bear);
        e1.addAnimal(bear); */

        Zoo zootopia = new Zoo();
        zootopia.startGame();
        zootopia.printAnimals();

    }


}
