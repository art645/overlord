package com.example.GreatLord.repository;

import com.example.GreatLord.model.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepo extends CrudRepository<Planet,Long> {
    @Query(value = "select max(a.id) from planets a",nativeQuery = true)
    Long findMaxId();

}
