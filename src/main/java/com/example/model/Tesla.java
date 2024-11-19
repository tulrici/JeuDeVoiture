package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Tesla extends Vehicle {
    public Tesla() {
        super();
    }

    public Tesla(int x, int y) {
        super(x, y, 0, "Tesla", "/images/tesla.png", false, 15, 2);
    }

    @Override
    public void move() {
        this.y += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < this.maxSpeed) { // Tesla accélère plus vite
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