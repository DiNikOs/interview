/**
 * @author Ostrovskiy Dmitriy
 * @created 30.04.2020
 * Counter
 * @version v1.0
 */

package ru.geekbrains.hw3_thread.part2;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger counter;

    public Counter() {
        counter = new AtomicInteger();
    }

    public void increase(){
        counter.incrementAndGet();
    }

    public void getAndIncrease(){
        counter.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Counter=" + counter;
    }
}
