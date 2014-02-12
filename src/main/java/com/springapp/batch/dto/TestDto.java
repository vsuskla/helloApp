package com.springapp.batch.dto;

/**
 * Created by klaus on 05/01/14.
 */
public class TestDto {
    public String ktonr;
    public String forNavn;
    public String etterNavn;

    public String getKtonr() {
        return ktonr;
    }

    public void setKtonr(String ktonr) {
        this.ktonr = ktonr;
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
        return "Kontohaver ID: " + ktonr + " Navn: " + forNavn + " " + etterNavn;

    }
}
