package com.xuzhi.pojo;

public class Car {
    private String name;
    private double price;
    private double speed;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Car(double price, double speed) {
        this.price = price;
        this.speed = speed;
    }

    public Car(String name, double price, double speed) {
        this.name = name;
        this.price = price;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
