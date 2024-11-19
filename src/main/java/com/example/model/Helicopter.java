package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Helicopter extends Vehicle {
    public Helicopter() {
        super();
    }

    public Helicopter(int x, int y) {
        super(x, y, 0, "Helicopter", "/images/Helicopter.png", true, 30, 5);
    }

    @Override
    public void move() {
        this.y += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < this.maxSpeed) { // Helicopter accélère très vite
            this.speed += this.acceleration;
        }
    }

    @Override
    public void brake() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
} 