package com.springapp.batch;

import com.springapp.batch.dto.BankDto;
import com.springapp.batch.dto.BeholdningsDto;
import com.springapp.batch.dto.KundeDto;
import com.springapp.batch.dto.TransDto;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus on 15.02.14.
 */
public class BankProcessor  implements ItemProcessor<List<BankDto>, List<KundeDto>>{


    @Override
    public List<KundeDto> process(List<BankDto> itemList) throws Exception {
        List<KundeDto> kundeDtos;
        List<BeholdningsDto> beholdningsDtos = new ArrayList<BeholdningsDto>();
        List<TransDto> transDtos = new ArrayList<TransDto>();
        List<KundeDto> kundeDtoList = new ArrayList<KundeDto>();
        System.out.println("Start Processor....");
        for(BankDto item : itemList) {
            kundeDtos = item.getKundeDto();
            beholdningsDtos = item.getBeholdningsDto();
            transDtos = item.getTransDto();
            for(KundeDto kundeDto1 : kundeDtos){
                for(BeholdningsDto beholdningsDto : beholdningsDtos){
                    if(kundeDto1.ktonr.equals(beholdningsDto.getKtonr())){
                        kundeDto1.setBeholdning(beholdningsDto.getBeholdning());
                    }
                    for(TransDto transDto : transDtos){
                        if(transDto.getKtonr().equals(kundeDto1.ktonr) && kundeDto1.ktonr.equals(beholdningsDto.getKtonr())){
                            if(transDto.getType().equals("TEGN")){
                                kundeDto1.setBeholdning(kundeDto1.beholdning.add(transDto.getAntall()));

                                break;
                            }
                        }
                    }
                }
                kundeDtoList.add(kundeDto1);
            }

        }
        System.out.println("End processor....");
        return kundeDtoList;
    }
}
