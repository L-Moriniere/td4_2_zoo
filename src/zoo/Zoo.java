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
 * @author Logan & Lorenzo
 */
public class Zoo {

    private String name;
    private Employee employee;
    private int nbMaxEnclosure;
    private ArrayList<Enclosure> listOfEnclosure = new ArrayList<Enclosure>();
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

    public void addEnclosure(Enclosure e) {
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

        savane.addAnimal(new Tiger(r.getFemaleName(), Gender.F, 120, 9, .9));
        lagon.addAnimal(new Whale(r.getFemaleName(), Gender.F, 100, 500, 15.6));
        savane.addAnimal(new Wolf(r.getFemaleName(), Gender.F, 20, 20, 10));
        lagon.addAnimal(new Shark(r.getMaleName(), Gender.M, 120, 9, .9));
        lagon.addAnimal(new Fish(r.getFemaleName(), Gender.F, 100, 500, 15.6));
        canyon.addAnimal(new Auk(r.getMaleName(), Gender.M, 20, 20, 10));
        canyon.addAnimal(new Eagle(r.getFemaleName(), Gender.F, 20, 20, 10));
        savane.addAnimal(new Bear(r.getMaleName(), Gender.M, 100, 10, 2));

        this.addEnclosure(savane);
        this.addEnclosure(lagon);
        this.addEnclosure(canyon);


    }

    public void makeCustom() {
        System.out.println(PURPLE + """
                Que voulez vous faire ?\s
                 1. Créer un enclos
                 2. Ajouter un animal\s
                 3. Lancer la partie\s
                """ + RESET);
        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        switch (rep) {
            case 1 -> {
                promptEnclosureNew();
                makeCustom();
            }
            case 2 -> {
                promptAddAnimal();
                makeCustom();
            }
            case 3 -> promptUserGeneral();
            default -> System.out.println("""
                    Que voulez vous faire ?\s
                     1. Créer un enclos
                     2. Ajouter un animal\s
                     3. Lancer la partie\s
                    """);
        }
        promptEnclosureNew();
    }

    public void promptUserGeneral() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(PURPLE + "Que voulez-vous faire ? Vous occuper des animaux (1) ? Vous occuper des enclos ? (2)" + RESET);

        int rep = scanner.nextInt();
        switch (rep) {
            case 1 -> promptUserAnimals();
            case 2 -> promptUserEnclosure();
            default -> System.out.println("Animaux (1) ou enclos (2)");
        }
    }

    public void promptUserEnclosure() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous vous occuper des enclos (nettoyage..) (1), en créer (2) ou les voir (3)? ");

        int rep = scanner.nextInt();
        switch (rep) {
            case 1 -> promptEnclosureManage();
            case 2 -> promptEnclosureNew();
            case 3 -> this.printEnclosure();
            default -> System.out.println("Voulez-vous vous occuper des enclos (nettoyage..) (1), en créer (2) ou les voir (3)? ");
        }
        promptUserGeneral();
    }

    public void promptEnclosureNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez vous créer une volière (v)?  Un Aquarium (a)? Un enclos terrestre (t)?");
        String rep = scanner.next();
        if (rep.charAt(0) != 'a' || rep.charAt(0) != 'v' || rep.charAt(0) != 't')
        {
            System.out.println("Voulez vous créer une volière (v)?  Un Aquarium (a)? Un enclos terrestre (t)?");
            rep = scanner.next();
        }

        switch (rep.charAt(0)) {
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
                this.addEnclosure(new Default_enclosure(name, area, nb_max));
                break;
            default:
                System.out.println("Voulez vous créer une volière (v)?  Un Aquarium (a)? Un enclos terrestre (t)?");
        }

    }

    public void promptEnclosureManage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Voici les différentes possibilités:\s
                (1) Ajouter un animal à un enclos\s
                (2) Nettoyer un enclos\s
                (3) Nourrir tous les animaux d'un enclos\s
                (4) Voir l'état d'un enclos\s
                (5) Déplacer un animal\s
                (6) Revenir au menu""");

        int rep = scanner.nextInt();
        switch (rep) {
            case 1:
                promptAddAnimal();
                promptUserGeneral();
                break;
            case 2:
                System.out.println("Quel enclos souhaitez vous nettoyer (index)?");
                this.printEnclosure();
                int enclosureIndex = scanner.nextInt();
                this.getEmployee().toClean(this.getListOfEnclosure().get(enclosureIndex - 1));
                break;
            case 3:
                System.out.println("Quel enclos souhaitez vous nourrir (index)?");
                this.printEnclosure();
                enclosureIndex = scanner.nextInt();
                this.getEmployee().toFeed(this.getListOfEnclosure().get(enclosureIndex - 1));
                break;
            case 4:
                System.out.println("Quel enclos souhaitez vous voir (index)?");
                this.printEnclosure();
                enclosureIndex = scanner.nextInt();
                this.getEmployee().toExaminate(this.getListOfEnclosure().get(enclosureIndex - 1));
                break;
            case 5:
                System.out.println("Quel enclos possède l'animal que vous voulez enlever (index)?");
                this.printEnclosure();
                int enclosureFrom = scanner.nextInt();
                Enclosure e1 = this.getListOfEnclosure().get(enclosureFrom - 1);

                System.out.println("Quel animal souhaitez vous transférer (index)?");
                System.out.println(this.getListOfEnclosure().get(enclosureFrom - 1).getListOfAnimal());
                int animal = scanner.nextInt();
                Animal a = this.getListOfEnclosure().get(enclosureFrom - 1).getListOfAnimal().get(animal);

                System.out.println("Dans quel enclos voulez vous transférer l'animal (index)?");
                this.printEnclosure();
                int enclosureTo = scanner.nextInt();
                Enclosure e2 = this.getListOfEnclosure().get(enclosureTo - 1);

                this.getEmployee().toTransfer(e1, a, e2);

                break;
            case 6:
                promptUserGeneral();
                break;

        }
        promptUserGeneral();
    }

    public void promptUserAnimals() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous vous occuper des animaux (soin, nourriture) (1), en ajouter (2) ou les voir (3)?");

        int rep = scanner.nextInt();
        switch (rep) {
            case 1 -> promptAnimalManage();
            case 2 -> {
                promptAddAnimal();
                promptUserGeneral();
            }
            case 3 -> this.printAnimals();
            default -> System.out.println("Voulez-vous vous occuper des animaux (soin, nourriture..) (1), en ajouter (2) ou les voir (3)?");
        }
        promptUserGeneral();
    }

    private void promptAnimalManage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Que voulez vous faire ?\s
                1. Soigner un animal\s
                2. Nourrir un animal\s
                3. Revenir au menu\s
                """);

        int rep = scanner.nextInt();
        switch (rep) {
            case 1:
                System.out.println("Choisissez l'enclos dans lequel l'animal doit être soigné");
                this.printEnclosure();
                int eIndex = scanner.nextInt();
                System.out.println("Choisissez l'animal qui doit être soigné");
                this.getListOfEnclosure().get(eIndex-1).printAnimals();
                int aIndex = scanner.nextInt();
                this.getListOfEnclosure().get(eIndex-1).getListOfAnimal().get(aIndex-1).toHeal();
                break;
            case 2:
                System.out.println("Choisissez l'enclos dans lequel l'animal doit être nourri");
                this.printEnclosure();
                eIndex = scanner.nextInt();
                System.out.println("Choisissez l'animal qui doit être soigné");
                this.getListOfEnclosure().get(eIndex-1).printAnimals();
                aIndex = scanner.nextInt();
                this.getListOfEnclosure().get(eIndex-1).getListOfAnimal().get(aIndex-1).toFeed();
                break;
            case 3:
                promptUserGeneral();
            default:
                System.out.println("""
                Que voulez vous faire ?\s
                1. Soigner un animal\s
                2. Nourrir un animal\s
                3. Revenir au menu\s
                """);
                break;
        }
        promptUserGeneral();
    }


    public void promptAddAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dans quel enclos voulez vous ajouter l'animal (index)? ");
        this.printEnclosure();
        int enclosureIndex = scanner.nextInt();
        Enclosure e = this.getListOfEnclosure().get(enclosureIndex - 1);
        System.out.println("""
                Quel animal voulez-vous ajouter ?
                1. Pingouin\s
                2. Ours
                3. Aigle
                4. Poisson
                5. Requin
                6. Tigre\s
                7. Baleine
                8. Loup\s
                9. Revenir au menu""");
        int animalRep = scanner.nextInt();
        switch (animalRep) {
            case 1:
                System.out.println("Nom de l'animal");
                String name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                String gender = scanner.next();
                System.out.println("Poids de l'animal");
                int weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                int age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                double size = scanner.nextDouble();
                e.addAnimal(new Auk(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 2:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Bear(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 3:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Eagle(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 4:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Fish(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 5:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Shark(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 6:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Tiger(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 7:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Whale(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 8:
                System.out.println("Nom de l'animal");
                name = scanner.next();
                System.out.println("Sexe de l'animal (M/F)");
                gender = scanner.next();
                System.out.println("Poids de l'animal");
                weight = scanner.nextInt();
                System.out.println("Age de l'animal");
                age = scanner.nextInt();
                System.out.println("Taille de l'animal");
                size = scanner.nextDouble();
                e.addAnimal(new Wolf(name, Gender.valueOf(gender), weight, age, size));
                break;
            case 9:
                promptUserGeneral();
                break;
            default:
                System.out.println("Entrez un chiffre");
                break;
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PURPLE + "Bonjour, vous avez lancé une nouvelle partie de Zootopia ! " +
                "Quel est ton nom d'employé ?" + RESET);
        String name = scanner.next();
        System.out.println(PURPLE + "Quel est ton age ?" + RESET);
        int age = scanner.nextInt();
        System.out.println(PURPLE + "Quel est ton genre (M/F)?" + RESET);
        String genre = scanner.next();
        Employee user = new Employee(name, EmployeeGender.valueOf(genre), age);
        this.setEmployee(user);
        System.out.println(PURPLE + "Combien voulez vous d'enclos max dans votre zoo ? (>= à 3 si vous utilisez le preset du zoo)" + RESET);
        int nbEnclosureMax = scanner.nextInt();
        this.setNbMaxEnclosure(nbEnclosureMax);
        System.out.println("Voulez-vous utiliser un preset défini (1) ou bien créer votre propre zoo (2)?");
        int reponseGame = scanner.nextInt();
        switch (reponseGame) {
            case 1 -> makePreset();
            case 2 -> makeCustom();
            default -> System.out.println("Il faut mettre 1 ou 2");
        }
    }

    public static void main(String[] args) {

        // TODO : User scanner
        // TODO : Launch game
        // TODO : Runnable Employee, Animal, Enclosure

        getInstance().startGame();

        Simulator Game = new Simulator();
        Thread t1 = new Thread(Game);
        t1.start();
    }


}
