/**
 * @author Ostrovskiy Dmitriy
 * @created 30.04.2020
 * Pong
 * @version v1.0
 */

package ru.geekbrains.hw3_thread.part1;

public class Pong implements Runnable{
    SyncQueue q;

    public Pong(SyncQueue q){
        this.q = q;
        new Thread(this, "Pong").start();
    }

    @Override
    public void run() {
        while (true){
            q.pong();
        }
    }
}
