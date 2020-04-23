package ru.geekbrains.hw1.part3;

public class Square extends Shape{

    @Override
    public void draw() {
        System.out.println("Square is draw");
    }

    @Override
    public void erase() {
        System.out.println("Square is erase");
    }
}
