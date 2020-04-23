/**
 * @author Ostrovskiy Dmitriy
 * @created 23/04/2020
 * Main class
 * @version v1.0
 */

package ru.geekbrains;

import ru.geekbrains.hw1.part1.*;
import ru.geekbrains.hw1.part3.*;

import java.util.ArrayList;
import java.util.List;
//Создать builder для класса Person со следующими полями: String firstName, String lastName,
//        String middleName, String country, String address, String phone, int age, String gender.

public class Main {

    public static void main(String[] args) {
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
    }
}











