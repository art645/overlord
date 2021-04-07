package com.example.GreatLord.controller;

import com.example.GreatLord.model.Lord;
import com.example.GreatLord.model.Planet;
import com.example.GreatLord.repository.LordRepo;
import com.example.GreatLord.repository.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/overlord")
public class GreatLordController {

    private LordRepo lordRepo;
    private PlanetRepo planetRepo;

    @Autowired
    public GreatLordController(LordRepo lordRepo, PlanetRepo planetRepo) {
        this.lordRepo = lordRepo;
        this.planetRepo = planetRepo;
    }

    @GetMapping("/")
    public String showLordsAndPlanets(Model model) {
        List<Lord> lords = new ArrayList<>();
        List<Planet> planets = new ArrayList<>();
        lordRepo.findAll().forEach(lords::add);
        planetRepo.findAll().forEach(planets::add);
        model.addAttribute("lords",lords);
        model.addAttribute("planets",planets);
        return  "overlord";
    }
    @GetMapping("lord/add")
    public String showAddLordForm(Lord lord) {
        return "lordadd";
    }
    @PostMapping("lord/add")
    public String addLord(Lord lord) {
        System.out.println(lordRepo.findMaxId());
        Long newId = lordRepo.findMaxId() + 1;
        lord.setId(newId);
        lordRepo.save(lord);
        return "redirect:/overlord/";
    }
    @GetMapping("planet/add")
    public String showAddPlanetForm(Planet planet) {
        return "planetadd";
    }
    @PostMapping("planet/add")
    public String addPlanet(Planet planet) {
        System.out.println(planetRepo.findMaxId());
        Long newId = planetRepo.findMaxId() + 1;
        planet.setId(newId);
        planetRepo.save(planet);
        return "redirect:/overlord/";
    }
    @GetMapping("/planet/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        planetRepo.deleteById(id);
        return "redirect:/overlord/";
    }
    @GetMapping("/planet/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Planet> planet = planetRepo.findById(id);
        List<Lord> lords = new ArrayList<>();
        lordRepo.findAll().forEach(lords::add);
        model.addAttribute("updatedPlanet", planet.get());
        model.addAttribute("lords",lords);
        return "setLordToPlanet";
    }
    @PostMapping("/planet/update/{id}")
    public String setLordToPlanet(@PathVariable("id") Long id, Planet planet) {
        System.out.println(planet.toString());
        planetRepo.save(planet);
        return "redirect:/overlord/";
    }
    @GetMapping("/lord/top/young")
    public String showTopTenYoungestLords(Model model) {
        List <Lord> lords;
        lords = lordRepo.findTop10ByOrderByAgeAsc();
        model.addAttribute("younglord",lords);
        return "yunglords";
    }
    @GetMapping("/lord/slacker")
    public String showSlackersLords(Model model) {
        List <Lord> lords;
        lords = lordRepo.findSlackerLords();
        model.addAttribute("slackersLords", lords);
        return "slackersLords";
    }
}
