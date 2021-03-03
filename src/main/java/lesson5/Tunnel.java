package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private int competitors;
    private Semaphore smp;
    public Tunnel(int competitors) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.competitors = competitors;
        smp = new Semaphore(competitors/2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
