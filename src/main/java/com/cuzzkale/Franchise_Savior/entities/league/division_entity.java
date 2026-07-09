package com.cuzzkale.Franchise_Savior.entities.league;

import jakarta.persistence.*;

@Entity
public class division_entity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private conference_entity conference;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public conference_entity getConference() {
        return conference;
    }

    public void setConference(conference_entity conference) {
        this.conference = conference;
    }
}
