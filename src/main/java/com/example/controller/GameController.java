package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.VehicleRepository;
import com.example.model.Tesla;
import com.example.model.Helicopter;
import com.example.model.Vehicle;

@Controller
public class GameController {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    private int initialPositionx = -15;
    private int initialPositiony = 160;
    private int maxXPosition = 700;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "home";
    }

    @PostMapping("/addTesla")
    public String addTesla() {
        // Adjust initialPositionx to ensure no null values
        if (vehicleRepository.count() == 0) {
            initialPositionx = -15; // Place the first vehicle at a fixed position
        } else if (initialPositionx < maxXPosition) {
            initialPositionx += 50; // Increment position for subsequent vehicles
        } else {
            return "redirect:/"; // Reset if exceeding maximum
        }
        Tesla tesla = new Tesla(initialPositionx, initialPositiony);
        vehicleRepository.save(tesla);
        return "redirect:/";
    }

    @PostMapping("/addHelicopter")
    public String addHelicopter() {
        // Adjust initialPositionx to ensure no null values
        if (vehicleRepository.count() == 0) {
            initialPositionx = -15; // Place the first vehicle at a fixed position
        } else if (initialPositionx < maxXPosition) {
            initialPositionx += 50; // Increment position for subsequent vehicles
        } else {
            return "redirect:/"; // Reset if exceeding maximum
        }
        Helicopter helicopter = new Helicopter(initialPositionx, initialPositiony);
        vehicleRepository.save(helicopter);
        return "redirect:/";
    }

    @PostMapping("/removeVehicle")
    public String removeVehicle(@RequestParam("id") Long id) {
        vehicleRepository.deleteById(id);
        return "redirect:/";
    }    

    @PostMapping("/startRace")
    public String startRace() {

        for (Vehicle vehicle : vehicleRepository.findAll()) {
            vehicle.accelerate();
            vehicle.move();
        }
        return "redirect:/";
    }

    @PostMapping("/stopRace")
    public String stopRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            
            while (vehicle.getSpeed() > 0) {
                vehicle.brake();
                vehicle.move();
            }
        }
        return "redirect:/";
    }

    @PostMapping("/resetRace")
    public String resetRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            removeVehicle(vehicle.getId());
        }
        return "redirect:/";
    }

    @PostMapping("/endRace")
    public String endRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            vehicle.setSpeed(0);
        }
        return "redirect:/";
    }
}
