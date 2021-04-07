package com.example.GreatLord.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "LORDS")
public class Lord {

    @Id
    private Long id;
    private String name;
    private int age;

    public Lord() {
    }

    public Lord(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
