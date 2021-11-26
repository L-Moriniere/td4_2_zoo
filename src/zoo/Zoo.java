/**
 *
 */
package zoo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import animal.*;
import employee.*;
import enclosure.*;

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
     * @param listOfEnclosure
     */
    public Zoo(String name, Employee employee, int nbMaxEnclosure, ArrayList<Enclosure> listOfEnclosure) {
        super();
        this.name = name;
        this.employee = employee;
        this.nbMaxEnclosure = nbMaxEnclosure;
        this.listOfEnclosure = listOfEnclosure;
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
		zootopia.printAnimals(); */

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
        }
        // TODO : Create preset game
        // TODO : User scanner
        // TODO : Lunch game
        // TODO : Runable Employee, Animal, Enclosure

        e1.addAnimal(bear);
        e1.addAnimal(bear);
    }


}
