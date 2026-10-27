package ru.geekbrains.hw1_OOP.part3;

/*
 * Класс Circle наследует класс Shape
 */
public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Circle is draw");
    }

    @Override
    public void erase() {
        System.out.println("Circle is erase");
    }
}
