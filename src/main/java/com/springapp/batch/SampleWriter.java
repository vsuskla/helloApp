package com.springapp.batch;

import com.springapp.batch.dto.KundeDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SampleWriter implements ItemWriter<List<KundeDto>> {
    @Override
    public void write(List<? extends List<KundeDto>> itemsLists) throws Exception {
        System.out.println("Writer begynner!");
        for (List<KundeDto> itemList : itemsLists) {
            for (KundeDto item : itemList){
                System.out.println("writer: " + item.toString());
            }
            System.out.println("Writer avsluttes!");
        }
    }
}
