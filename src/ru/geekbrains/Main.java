/**
 * @author Ostrovskiy Dmitriy
 * @created 23/04/2020
 * Main class
 * @version v1.0
 */

package ru.geekbrains;

import ru.geekbrains.hw1.part1.*;
import ru.geekbrains.hw1.part1.Person;
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
    }
}











