package com.cuzzkale.Franchise_Savior.entities.history;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class season_history_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;

    // Awards
    private String mvp;
    private String oroty;
    private String droty;
    private String dpoty;
    private String opoty;
    private String coty;

    // Winners
    private String superBowlWinner;
    private String afcChampionshipWinner;
    private String nfcChampionshipWinner;

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

    public String getMvp() {
        return mvp;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }

    public String getOroty() {
        return oroty;
    }

    public void setOroty(String oroty) {
        this.oroty = oroty;
    }

    public String getDroty() {
        return droty;
    }

    public void setDroty(String droty) {
        this.droty = droty;
    }

    public String getDpoty() {
        return dpoty;
    }

    public void setDpoty(String dpoty) {
        this.dpoty = dpoty;
    }

    public String getOpoty() {
        return opoty;
    }

    public void setOpoty(String opoty) {
        this.opoty = opoty;
    }

    public String getCoty() {
        return coty;
    }

    public void setCoty(String coty) {
        this.coty = coty;
    }

    public String getSuperBowlWinner() {
        return superBowlWinner;
    }

    public void setSuperBowlWinner(String superBowlWinner) {
        this.superBowlWinner = superBowlWinner;
    }

    public String getAfcChampionshipWinner() {
        return afcChampionshipWinner;
    }

    public void setAfcChampionshipWinner(String afcChampionshipWinner) {
        this.afcChampionshipWinner = afcChampionshipWinner;
    }

    public String getNfcChampionshipWinner() {
        return nfcChampionshipWinner;
    }

    public void setNfcChampionshipWinner(String nfcChampionshipWinner) {
        this.nfcChampionshipWinner = nfcChampionshipWinner;
    }
}
