package com.springapp.batch;

import com.springapp.batch.dto.BankDto;
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
        KundeDto kundeDto;
        List<KundeDto> kundeDtoList = new ArrayList<KundeDto>();
        System.out.println("Start Processor....");
        for(BankDto item : itemList) {
            kundeDto = item.getKundeDto();
            kundeDtoList.add(kundeDto);
        }
        System.out.println("End processor....");
        return kundeDtoList;
    }
}
