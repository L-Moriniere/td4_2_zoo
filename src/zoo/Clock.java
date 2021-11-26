package zoo;

import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Runnable{
    private Timer mTimer = new Timer();

    private int mSecondsPassed = 0;

    public void run(){

    }

    private TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            mSecondsPassed++;
            System.out.println("!!Seconds passed: " + mSecondsPassed);
            System.out.println();
        }
    };

    public void start() {
        mTimer.scheduleAtFixedRate(mTask, 1000, 1000);
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        c.start();
    }
}