package com.cuzzkale.Franchise_Savior.entities.team;

import com.cuzzkale.Franchise_Savior.entities.history.player_history_entity;
import jakarta.persistence.*;

@Entity
public class player_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private team_entity team;


    //  General Attributes
    private String name;
    private int age;
    private String position;

    //  Potential
    private String potentialLetter;
    private double potential;

    //  Skills

    // QB
    private double passingAccuracy;
    private double passingPower;
    private double qbIQ;

    // RB
    private double elusiveness;
    private double vision;

    // WR & RB
    private double speed;

    // WR & TE
    private double catching;
    private double routeRunning;

    // OL
    private double passBlocking;

    // OL & DL
    private double strength;

    // DL
    private double runStopping;

    // All Defensive Players
    private double tackling;

    //DE
    private double passRushMoves;

    //LB & DE
    private double passRush;

    //LB
    private double awareness;

    // CB
    private double manCoverage;
    private double press;

    // S
    private double zoneCoverage;
    private double pursuit;

    // K
    private double kickAccuracy;
    private double kickPower;
    private double kickConsistency;

    // Overall
    private double overall;

    // Personality
    private String personalityTrait;

    //    Contract
    private int contractLength;
    private double contract;

    //    Booleans
    private boolean rookieOrNot;
    private boolean tradeable;
    private boolean cuttable;
    private boolean inDraft;
    private boolean inDraftOwnerFav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public team_entity getTeam() {
        return team;
    }

    public void setTeam(team_entity team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPotentialLetter() {
        return potentialLetter;
    }

    public void setPotentialLetter(String potentialLetter) {
        this.potentialLetter = potentialLetter;
    }

    public double getPotential() {
        return potential;
    }

    public void setPotential(double potential) {
        this.potential = potential;
    }

    public double getPassingAccuracy() {
        return passingAccuracy;
    }

    public void setPassingAccuracy(double passingAccuracy) {
        this.passingAccuracy = passingAccuracy;
    }

    public double getPassingPower() {
        return passingPower;
    }

    public void setPassingPower(double passingPower) {
        this.passingPower = passingPower;
    }

    public double getQbIQ() {
        return qbIQ;
    }

    public void setQbIQ(double qbIQ) {
        this.qbIQ = qbIQ;
    }

    public double getElusiveness() {
        return elusiveness;
    }

    public void setElusiveness(double elusiveness) {
        this.elusiveness = elusiveness;
    }

    public double getVision() {
        return vision;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCatching() {
        return catching;
    }

    public void setCatching(double catching) {
        this.catching = catching;
    }

    public double getRouteRunning() {
        return routeRunning;
    }

    public void setRouteRunning(double routeRunning) {
        this.routeRunning = routeRunning;
    }

    public double getPassBlocking() {
        return passBlocking;
    }

    public void setPassBlocking(double passBlocking) {
        this.passBlocking = passBlocking;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getRunStopping() {
        return runStopping;
    }

    public void setRunStopping(double runStopping) {
        this.runStopping = runStopping;
    }

    public double getTackling() {
        return tackling;
    }

    public void setTackling(double tackling) {
        this.tackling = tackling;
    }

    public double getPassRushMoves() {
        return passRushMoves;
    }

    public void setPassRushMoves(double passRushMoves) {
        this.passRushMoves = passRushMoves;
    }

    public double getPassRush() {
        return passRush;
    }

    public void setPassRush(double passRush) {
        this.passRush = passRush;
    }

    public double getAwareness() {
        return awareness;
    }

    public void setAwareness(double awareness) {
        this.awareness = awareness;
    }

    public double getManCoverage() {
        return manCoverage;
    }

    public void setManCoverage(double manCoverage) {
        this.manCoverage = manCoverage;
    }

    public double getPress() {
        return press;
    }

    public void setPress(double press) {
        this.press = press;
    }

    public double getZoneCoverage() {
        return zoneCoverage;
    }

    public void setZoneCoverage(double zoneCoverage) {
        this.zoneCoverage = zoneCoverage;
    }

    public double getPursuit() {
        return pursuit;
    }

    public void setPursuit(double pursuit) {
        this.pursuit = pursuit;
    }

    public double getKickAccuracy() {
        return kickAccuracy;
    }

    public void setKickAccuracy(double kickAccuracy) {
        this.kickAccuracy = kickAccuracy;
    }

    public double getKickPower() {
        return kickPower;
    }

    public void setKickPower(double kickPower) {
        this.kickPower = kickPower;
    }

    public double getKickConsistency() {
        return kickConsistency;
    }

    public void setKickConsistency(double kickConsistency) {
        this.kickConsistency = kickConsistency;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public String getPersonalityTrait() {
        return personalityTrait;
    }

    public void setPersonalityTrait(String personalityTrait) {
        this.personalityTrait = personalityTrait;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public double getContract() {
        return contract;
    }

    public void setContract(double contract) {
        this.contract = contract;
    }

    public boolean isRookieOrNot() {
        return rookieOrNot;
    }

    public void setRookieOrNot(boolean rookieOrNot) {
        this.rookieOrNot = rookieOrNot;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public void setTradeable(boolean tradeable) {
        this.tradeable = tradeable;
    }

    public boolean isCuttable() {
        return cuttable;
    }

    public void setCuttable(boolean cuttable) {
        this.cuttable = cuttable;
    }

    public boolean isInDraft() {
        return inDraft;
    }

    public void setInDraft(boolean inDraft) {
        this.inDraft = inDraft;
    }

    public boolean isInDraftOwnerFav() {
        return inDraftOwnerFav;
    }

    public void setInDraftOwnerFav(boolean inDraftOwnerFav) {
        this.inDraftOwnerFav = inDraftOwnerFav;
    }
}
