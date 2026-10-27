package ru.geekbrains.hw1_OOP.part2;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class Part2 {
}

interface Moveable{
    void move();
}

interface Stopable{
    void stop();
}

abstract class Car{
    public Engine engine;
    private String color;
    private String name;

    //TODO если есть поля класса, то и должен быт ьконструктор
    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    protected void start(){
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Moveable{

//TODO необходим конструктор из класса родителя(суперкласса)
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }
//TODO если интерфейс реализован, то необходимо в классе реализовать и его все методы
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}
 //TODO нет множественного наследование, интерфейсы лучше реализовывать, а не наследовать.
//class Lorry extends Car, Moveable, Stopable {

class Lorry extends Car implements Moveable, Stopable{

    //TODO необходим конструктор из класса родителя(суперкласса)
    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }

    //TODO либо делать класс также абстрактным,
    // либо переопределять метод open() из родителя
    @Override
    void open() {
        System.out.println("Car is open fast!");
    }
}




