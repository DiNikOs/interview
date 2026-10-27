/**
 * @author Ostrovskiy Dmitriy
 * @created 30.04.2020
 * LockExample
 * @version v1.0
 */

package ru.geekbrains.hw3_thread.part2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample implements Runnable {
    private Counter counter;
    private Lock lock;

    public LockExample(Counter counter) {
        this.counter = counter;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            // пытаемся взять лок в течении 10 секунд
            if(lock.tryLock(10, TimeUnit.SECONDS)){
                for (int j = 0; j < 2; j++) {
                    counter.increase();
                    System.out.println("IncrGet: " + counter.toString() + " "
                            + Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            //убираем лок
            lock.unlock();
        }
    }
}
