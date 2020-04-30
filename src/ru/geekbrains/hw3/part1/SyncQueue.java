/**
 * @author Ostrovskiy Dmitriy
 * @created 30.04.2020
 * SyncQueuePingPong
 * @version v1.0
 */

package ru.geekbrains.hw3.part1;

public class SyncQueue {
    boolean flag = false;

    synchronized void ping(){
        while (flag){
            try{
                wait();
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Ping");
        flag = true;
        notify();
    }

    synchronized void pong(){
        while (!flag){
            try{
                wait();
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Pong");
        flag = false;
        notify();
    }
}
