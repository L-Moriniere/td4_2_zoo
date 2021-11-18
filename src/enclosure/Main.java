package enclosure;

import java.util.ArrayList;

import animal.Animal;
import animal.Eagle;
import animal.Gender;
import animal.Whale;
import animal.Wolf;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wolf w;
		w = new Wolf("blanc" , Gender.M, 50,2, 2.35,false,false,false);
		w.setHungry(true);
		Whale w2;
		w2 = new Whale("bleue", Gender.F, 100,500, 15.6, false, true, false);
		Eagle eagle = new Eagle();
	/*
		Default_enclosure e;
		e = new Default_enclosure("Enclos",50,10);
		e.addAnimal(w);
		e.addAnimal(w2);
		e.feedAllAnimal();
		e.setCleanness(Cleanness.BAD);
		e.toClean();
		*/
	/*
		Aquarium a;
		a = new Aquarium("aquarium");
		a.setDeep(20);
		a.setSalinity(10);
		a.addAnimal(w2);
		a.addAnimal(w);
		a.toClean();
		a.removeAnimal(w2);
		a.toClean();
	*/
		Aviary a;
		a = new Aviary("Aviary");
		a.setHeight(20);
		a.addAnimal(eagle);
		a.toClean();
		a.removeAnimal(eagle);
		a.toClean();
	}
}
