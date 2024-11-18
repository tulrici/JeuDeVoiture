package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    protected int x;
    protected int y;
    protected int speed;
    protected String type;
    protected String imageUrl;
    protected Boolean flying;

    protected Vehicle() {
        // Constructeur vide nécessaire pour JPA
    }

    public Vehicle(int x, int y, int speed, String type, String imageUrl, boolean flying) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.type = type;
        this.imageUrl = imageUrl;
        this.flying = flying;
    }


    public abstract void move();
    public abstract void accelerate();
    public abstract void brake();

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
    public String getType() { return type; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public boolean getFlying() { return flying; }
    public void setFlying(boolean flying) { this.flying = flying; }
} 