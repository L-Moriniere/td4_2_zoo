package zoo;

import java.util.Timer;
import java.util.TimerTask;

public class Simulator extends TimerTask {
    private Timer mTimer = new Timer();

    private int mSecondsPassed = 0;

    public void run(){
        Zoo zootopia =  Zoo.getInstance();
        zootopia.startGame();
//        zootopia.printAnimals();
//        zootopia.promptUserGeneral();

        mTimer.scheduleAtFixedRate(mTask, 0, 1000);
    }


    private TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            mSecondsPassed++;
            if (mSecondsPassed > 5){
                
               // Thread t1 = new Thread(Zoo.getInstance().getEmployee());
                //t1.start();
                
                // clear le TIMER
//                mTimer.cancel();
//                mTimer.purge();
//                return;
            }
            //System.out.println("!!Seconds passed: " + mSecondsPassed);
            //System.out.println();
        }
    };
}
