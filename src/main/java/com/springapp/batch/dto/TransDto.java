package com.springapp.batch.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by klaus on 15.02.14.
 */
public class TransDto {

    private String ktonr;
    private String type;
    private BigDecimal antall;
    private Date behandlet;

    public String getKtonr() {
        return ktonr;
    }

    public void setKtonr(String ktonr) {
        this.ktonr = ktonr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAntall() {
        return antall;
    }

    public void setAntall(BigDecimal antall) {
        this.antall = antall;
    }

    public Date getBehandlet() {
        return behandlet;
    }

    public void setBehandlet(Date behandlet) {
        this.behandlet = behandlet;
    }


}
