package ru.geekbrains.hw1.part3;

// Абстрактный класс Shape реализующий интерфейсы действий
public abstract class Shape implements Drawable, Eraseable {
    public void doSomething() {
        erase();
        draw();
    }
}
