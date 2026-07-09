package com.cuzzkale.Franchise_Savior.entities.team;

import com.cuzzkale.Franchise_Savior.entities.league.division_entity;
import jakarta.persistence.*;
@Entity
public class team_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double overall;

    private double offenseOVR;

    private double defenseOVR;

    private double specialTeamsOVR;

    private double prestige;

    private int injuries;

    private int currentWins;

    private int currentLosses;

    private int currentTies;

    private String coach;

    private String owner;

    private double balance;

    private double teamChemistry;



    @ManyToOne
    @JoinColumn(name = "division_id")
    private division_entity division;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public double getOffenseOVR() {
        return offenseOVR;
    }

    public void setOffenseOVR(double offenseOVR) {
        this.offenseOVR = offenseOVR;
    }

    public double getDefenseOVR() {
        return defenseOVR;
    }

    public void setDefenseOVR(double defenseOVR) {
        this.defenseOVR = defenseOVR;
    }

    public double getSpecialTeamsOVR() {
        return specialTeamsOVR;
    }

    public void setSpecialTeamsOVR(double specialTeamsOVR) {
        this.specialTeamsOVR = specialTeamsOVR;
    }

    public double getPrestige() {
        return prestige;
    }

    public void setPrestige(double prestige) {
        this.prestige = prestige;
    }

    public int getCurrentWins() {
        return currentWins;
    }

    public void setCurrentWins(int currentWins) {
        this.currentWins = currentWins;
    }

    public int getCurrentLosses() {
        return currentLosses;
    }

    public void setCurrentLosses(int currentLosses) {
        this.currentLosses = currentLosses;
    }

    public int getCurrentTies() {
        return currentTies;
    }

    public void setCurrentTies(int currentTies) {
        this.currentTies = currentTies;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTeamChemistry() {
        return teamChemistry;
    }

    public void setTeamChemistry(double teamChemistry) {
        this.teamChemistry = teamChemistry;
    }

    public division_entity getDivision() {
        return division;
    }

    public void setDivision(division_entity division) {
        this.division = division;
    }
}
