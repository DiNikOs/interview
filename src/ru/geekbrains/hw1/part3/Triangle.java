package ru.geekbrains.hw1.part3;

/*
 * Класс Triangle наследует класс Shape
 */
public class Triangle extends Shape {

    //необязательно писать @Override
    @Override
    public void draw() {
        System.out.println("Triangle is draw");
    }

    @Override
    public void erase() {
        System.out.println("Triangle is erase");
    }
}
