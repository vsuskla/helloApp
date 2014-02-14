package com.springapp.batch.dto;

import java.math.BigDecimal;

/**
 * Created by klaus on 05/01/14.
 */
public class KundeDto {
    public String ktonr;
    public String forNavn;
    public String etterNavn;
    public BigDecimal beholdning;

    public BigDecimal getBeholdning() { return beholdning; }

    public void setBeholdning(BigDecimal beholdning) { this.beholdning = beholdning; }

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
        return "Kontohaver ID: " + ktonr + " Navn: " + forNavn + " " + etterNavn + " beholdning:  " + beholdning;

    }
}
