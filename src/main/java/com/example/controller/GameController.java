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
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        return "home";
    }
    
    @PostMapping("/addTesla")
    public String addTesla() {
        Tesla tesla = new Tesla(50, 300);
        vehicleRepository.save(tesla);
        return "redirect:/";
    }

    @PostMapping("/addHelicopter")
    public String addHelicopter() {
        Helicopter helicopter = new Helicopter(50, 300);
        vehicleRepository.save(helicopter);
        return "redirect:/";
    }

    @GetMapping("/removeVehicle")
    public String removeVehicle(@RequestParam("id") Long id) {
        vehicleRepository.deleteById(id);
        return "redirect:/";
    }    

    @GetMapping("/startRace")
    public String startRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            vehicle.accelerate();
            vehicle.move();
        }
        return "redirect:/";
    }

    @GetMapping("/stopRace")
    public String stopRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            
            while (vehicle.getSpeed() > 0) {
                vehicle.brake();
                vehicle.move();
            }
        }
        return "redirect:/";
    }

    @GetMapping("/resetRace")
    public String resetRace() {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            vehicle.setX(50);
            vehicle.setY(300);
            vehicle.setSpeed(0);
        }
        return "redirect:/";
    }
    
}
