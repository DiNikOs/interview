/**
 * @author Ostrovskiy Dmitriy
 * @created 30.04.2020
 * Ping
 * @version v1.0
 */

package ru.geekbrains.hw3.part1;

public class Ping implements Runnable{
    SyncQueue q;

    public Ping(SyncQueue q){
        this.q = q;
        new Thread(this, "Ping").start();
    }

    @Override
    public void run() {
        while (true){
            q.ping();
        }
    }
}
