package com.springapp.batch.dto;

import java.util.List;

/**
 * Created by klaus on 15.02.14.
 */
public class BankDto {

    private List<KundeDto> kundeDto;
    private List<BeholdningsDto> beholdningsDto;
    private List<TransDto> transDto;

    public List<KundeDto> getKundeDto() {
        return kundeDto;
    }

    public void setKundeDto(List<KundeDto> kundeDto) {
        this.kundeDto = kundeDto;
    }

    public List<BeholdningsDto> getBeholdningsDto() {
        return beholdningsDto;
    }

    public void setBeholdningsDto(List<BeholdningsDto> beholdningsDto) {
        this.beholdningsDto = beholdningsDto;
    }

    public List<TransDto> getTransDto() {
        return transDto;
    }

    public void setTransDto(List<TransDto> transDto) {
        this.transDto = transDto;
    }
}
