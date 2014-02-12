package com.springapp.batch.dto;

/**
 * Created by klaus on 05/01/14.
 */
public class TestDto {
    public String kontohaverId;
    public String forNavn;
    public String etterNavn;

    public String getKontohaverId() {
        return kontohaverId;
    }

    public void setKontohaverId(String kontohaverId) {
        this.kontohaverId = kontohaverId;
    }

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEtterNavn() {
        return etterNavn;
    }

    public void setEtterNavn(String etterNavn) {
        this.etterNavn = etterNavn;
    }

    public String toString(){
        return "Kontohaver ID: " + kontohaverId + " Navn: " + forNavn + " " + etterNavn;

    }
}
