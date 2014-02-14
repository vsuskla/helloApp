package com.springapp.batch.dto;

import java.math.BigDecimal;

/**
 * Created by klaus on 14.02.14.
 */
public class BeholdningsDto {

    private String ktonr;
    private BigDecimal beholdning;

    public String getKtonr() { return ktonr; }

    public void setKtonr(String ktonr) { this.ktonr = ktonr; }

    public BigDecimal getBeholdning() {return beholdning; }

    public void setBeholdning(BigDecimal beholdning) { this.beholdning = beholdning; }


}
