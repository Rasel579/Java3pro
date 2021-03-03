package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private int competitors;
    private CountDownLatch cdl;
    private CountDownLatch finishCdl;
    private Semaphore smp = new Semaphore(1);

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, int competitors, CountDownLatch cdl, CountDownLatch finishCdl) {
        this.race = race;
        this.cdl = cdl;
        this.finishCdl = finishCdl;
        this.competitors = competitors;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
            cdl.await();

        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finishCdl.countDown();
        try {
            smp.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (finishCdl.getCount() == competitors - 1){
            System.out.println("Выйграл " + this.name);
        } else {
            smp.release();
        }
    }
}
