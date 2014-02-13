package com.springapp.batch;

import com.springapp.batch.dto.TestDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SampleWriter implements ItemWriter<List<TestDto>> {
    @Override
    public void write(List<? extends List<TestDto>> itemsLists) throws Exception {
        for (List<TestDto> itemList : itemsLists) {
            for (TestDto item : itemList){
                System.out.println("writer: " + item.toString());
            }

        }
    }
}
