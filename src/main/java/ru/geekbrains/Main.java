/**
 * @author Ostrovskiy Dmitriy
 * @created 23/04/2020
 * Main class
 * @version v1.0
 */

package ru.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.hw1_OOP.part1.*;
import ru.geekbrains.hw1_OOP.part3.*;
import ru.geekbrains.hw3_thread.part1.Ping;
import ru.geekbrains.hw3_thread.part1.Pong;
import ru.geekbrains.hw3_thread.part1.SyncQueue;
import ru.geekbrains.hw3_thread.part2.Counter;
import ru.geekbrains.hw3_thread.part2.LockExample;
import ru.geekbrains.hw5_hibernate.CrudApp;
import ru.geekbrains.hw5_hibernate.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Person person = new Person.Builder().
                addFirstName(new FirstName()).
                addMiddleName(new MiddleName()).
                addLastName(new LastName()).
                addCountry(new Country()).
                addAddress(new Address()).
                addPhone(new Phone()).
                addAge(new Age()).
                addGender(new Gender()).build();

        //Part3
        List<Shape> listShapes = new ArrayList<>();
        // добавляем конкретные фигуры в список общих любых фигур
        listShapes.add(new Circle());
        listShapes.add(new Triangle());
        listShapes.add(new Circle());
        listShapes.add(new Square());
        // работаем со списком
        for (Shape shape : listShapes) {
            shape.doSomething();
        }
        System.out.println("===execution completed_1===");

        for (Shape shape : listShapes) {
            shape.erase();
        }
        System.out.println("===execution completed_2===");
//************************************************
        System.out.println("==============Less3 start==============");
        System.out.println("===Part1===");
        SyncQueue syncQueue = new SyncQueue();
        new Ping(syncQueue);
        new Pong(syncQueue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
        }
//************************************************
        System.out.println("===Part2===");
        Counter counter = new Counter();
        LockExample lockExample = new LockExample(counter);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 2; j++) {
                        lockExample.run();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Less3 stop");
            System.exit(0);
        }

    }

}











