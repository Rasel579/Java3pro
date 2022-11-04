package lesson5;
//Все участники должны стартовать одновременно, несмотря на то, что на подготовку
// у каждого их них уходит разное время.
//В тоннель не может заехать одновременно больше половины участников (условность).
//Попробуйте все это синхронизировать.
//Только после того, как все завершат гонку, нужно выдать объявление об окончании.
//Можете корректировать классы (в т.ч. конструктор машин)
// и добавлять объекты классов из пакета util.concurrent.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch readyCdl = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch finishCdl= new CountDownLatch(CARS_COUNT);
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), CARS_COUNT, readyCdl, finishCdl);
        }
        ExecutorService pool = Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            pool.execute(new Thread(cars[i]));

        }
        readyCdl.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        finishCdl.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        pool.shutdown();
    }
}

