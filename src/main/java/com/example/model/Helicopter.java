package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Helicopter extends Vehicle {
    public Helicopter() {
        super();
    }

    public Helicopter(int x, int y) {
        super(x, y, 0, "Helicopter", "/images/Helicopter.png", true);
    }

    @Override
    public void move() {
        this.x += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < 30) { // Helicopter accélère très vite
            this.speed += 5;
        }
    }

    @Override
    public void brake() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
} 