package com.springapp.batch.dto;

/**
 * Created by klaus on 15.02.14.
 */
public class BankDto {

    private KundeDto kundeDto;
    private BeholdningsDto beholdningsDto;
    private TransDto transDto;

    public KundeDto getKundeDto() {
        return kundeDto;
    }

    public void setKundeDto(KundeDto kundeDto) {
        this.kundeDto = kundeDto;
    }

    public BeholdningsDto getBeholdningsDto() {
        return beholdningsDto;
    }

    public void setBeholdningsDto(BeholdningsDto beholdningsDto) {
        this.beholdningsDto = beholdningsDto;
    }

    public TransDto getTransDto() {
        return transDto;
    }

    public void setTransDto(TransDto transDto) {
        this.transDto = transDto;
    }
}
