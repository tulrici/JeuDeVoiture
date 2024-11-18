package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Tesla extends Vehicle {
    public Tesla() {
        super();
    }

    public Tesla(int x, int y) {
        super(x, y, 0, "Tesla", "/images/tesla.png");
    }

    @Override
    public void move() {
        this.x += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < 15) { // Tesla accélère plus vite
            this.speed += 2;
        }
    }

    @Override
    public void brake() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
} 