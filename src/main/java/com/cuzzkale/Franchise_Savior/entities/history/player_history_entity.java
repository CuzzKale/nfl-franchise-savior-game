package com.cuzzkale.Franchise_Savior.entities.history;

import com.cuzzkale.Franchise_Savior.entities.team.player_entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class player_history_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  // Connecting To Player -> Putting Stats In Player
    @ManyToOne
    @JoinColumn(name = "player_id")
    private player_entity player;



    private int year;

    // Stats

    //All
    private int gamesPlayed;

    // QB
    private int passingYards;
    private int passingTDS;
    private int throwingInterceptions;

    //RB
    private int rushingTDS;
    private int rushingYards;
    private int fumbles;

    //WR & TE
    private int receivingYards;
    private int receivingTDS;
    private int receptions;

    //OL
    private int pancakes;
    private int sacksAllowed;
    private int pressuresAllowed;

    // All Defensive Players
    private int tackles;

    // DE & LB
    private int sacks;

    // LB & DT
    private int tacklesForLoss;

    // DE & DT
    private int pressures;

    // CB & S
    private int interceptions;
    private int passesDefended;

    // K
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private int longestFieldGoal;

    // Awards
    private boolean mvp;
    private boolean oroty;
    private boolean droty;
    private boolean dpoty;
    private boolean opoty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(int passingYards) {
        this.passingYards = passingYards;
    }

    public int getPassingTDS() {
        return passingTDS;
    }

    public void setPassingTDS(int passingTDS) {
        this.passingTDS = passingTDS;
    }

    public int getThrowingInterceptions() {
        return throwingInterceptions;
    }

    public void setThrowingInterceptions(int throwingInterceptions) {
        this.throwingInterceptions = throwingInterceptions;
    }

    public int getRushingTDS() {
        return rushingTDS;
    }

    public void setRushingTDS(int rushingTDS) {
        this.rushingTDS = rushingTDS;
    }

    public int getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(int rushingYards) {
        this.rushingYards = rushingYards;
    }

    public int getFumbles() {
        return fumbles;
    }

    public void setFumbles(int fumbles) {
        this.fumbles = fumbles;
    }

    public int getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(int receivingYards) {
        this.receivingYards = receivingYards;
    }

    public int getReceivingTDS() {
        return receivingTDS;
    }

    public void setReceivingTDS(int receivingTDS) {
        this.receivingTDS = receivingTDS;
    }

    public int getReceptions() {
        return receptions;
    }

    public void setReceptions(int receptions) {
        this.receptions = receptions;
    }

    public int getPancakes() {
        return pancakes;
    }

    public void setPancakes(int pancakes) {
        this.pancakes = pancakes;
    }

    public int getSacksAllowed() {
        return sacksAllowed;
    }

    public void setSacksAllowed(int sacksAllowed) {
        this.sacksAllowed = sacksAllowed;
    }

    public int getPressuresAllowed() {
        return pressuresAllowed;
    }

    public void setPressuresAllowed(int pressuresAllowed) {
        this.pressuresAllowed = pressuresAllowed;
    }

    public int getTackles() {
        return tackles;
    }

    public void setTackles(int tackles) {
        this.tackles = tackles;
    }

    public int getSacks() {
        return sacks;
    }

    public void setSacks(int sacks) {
        this.sacks = sacks;
    }

    public int getTacklesForLoss() {
        return tacklesForLoss;
    }

    public void setTacklesForLoss(int tacklesForLoss) {
        this.tacklesForLoss = tacklesForLoss;
    }

    public int getPressures() {
        return pressures;
    }

    public void setPressures(int pressures) {
        this.pressures = pressures;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getPassesDefended() {
        return passesDefended;
    }

    public void setPassesDefended(int passesDefended) {
        this.passesDefended = passesDefended;
    }

    public int getFieldGoalsMade() {
        return fieldGoalsMade;
    }

    public void setFieldGoalsMade(int fieldGoalsMade) {
        this.fieldGoalsMade = fieldGoalsMade;
    }

    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }

    public void setFieldGoalsAttempted(int fieldGoalsAttempted) {
        this.fieldGoalsAttempted = fieldGoalsAttempted;
    }

    public int getLongestFieldGoal() {
        return longestFieldGoal;
    }

    public void setLongestFieldGoal(int longestFieldGoal) {
        this.longestFieldGoal = longestFieldGoal;
    }

    public boolean isMvp() {
        return mvp;
    }

    public void setMvp(boolean mvp) {
        this.mvp = mvp;
    }

    public boolean isOroty() {
        return oroty;
    }

    public void setOroty(boolean oroty) {
        this.oroty = oroty;
    }

    public boolean isDroty() {
        return droty;
    }

    public void setDroty(boolean droty) {
        this.droty = droty;
    }

    public boolean isDpoty() {
        return dpoty;
    }

    public void setDpoty(boolean dpoty) {
        this.dpoty = dpoty;
    }

    public boolean isOpoty() {
        return opoty;
    }

    public void setOpoty(boolean opoty) {
        this.opoty = opoty;
    }

    public player_entity getPlayer() {
        return player;
    }

    public void setPlayer(player_entity player) {
        this.player = player;
    }
}
