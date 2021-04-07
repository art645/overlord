package com.example.GreatLord;

import com.example.GreatLord.model.Lord;
import com.example.GreatLord.model.Planet;
import com.example.GreatLord.repository.LordRepo;
import com.example.GreatLord.repository.PlanetRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetRepoTests {

    @Autowired
    PlanetRepo planetRepo;
    @Autowired
    LordRepo lordRepo;

    @Test
    public void testSavePlanet() {
        Planet planet = new Planet(16L,"Земля",null);
        planetRepo.save(planet);
        Optional<Planet> planet1 = planetRepo.findById(16L);
        assertNotNull(planet1.get());
        assertEquals(planet.getId(),planet1.get().getId());
        assertEquals(planet.getName(),planet1.get().getName());
        assertEquals(planet.getLord(),planet1.get().getLord());
    }
    @Test
    public void testSaveLordWithPlanet() {
        Lord lord = new Lord(20L,"Вильям",27);
        lordRepo.save(lord);
        Planet planet = new Planet(16L,"Нибиру",lord);
        planetRepo.save(planet);
        Optional<Planet> planet1 = planetRepo.findById(16L);
        assertNotNull(planet1.get());
        assertEquals(planet.getId(),planet1.get().getId());
        assertEquals(planet.getName(),planet1.get().getName());
        assertEquals(planet.getLord(),planet1.get().getLord());
    }

}
