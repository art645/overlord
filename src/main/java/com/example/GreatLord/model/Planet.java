package com.example.GreatLord.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PLANETS")
public class Planet {
    @Id
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lord_id")
    private Lord lord;

    public Planet() {
    }

    public Planet(Long id, String name, Lord lord) {
        this.id = id;
        this.name = name;
        this.lord = lord;
    }
}
