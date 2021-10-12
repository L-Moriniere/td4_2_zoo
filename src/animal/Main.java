/**
 * 
 */
package animal;

/**
 * @author logan
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wolf w;
		w = new Wolf("blanc" , Gender.M, 50,2, 2.35,false,false,false);
		
		w.sound();
		w.eat();
		w.setHungry(true);
		w.eat();
		w.toGiveBirth();
		w.toVagabound();
		w.toWakeUp();
		w.toSleep();
		w.toHeal();
		
		Whale w2;
		w2 = new Whale("bleue", Gender.F, 100,500, 15.6, false, true, false);
		w2.sound();
		w2.toGiveBirth();


	}

}
