package com.springapp.batch;

import com.springapp.batch.dto.TestDto;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SampleWriter implements ItemWriter<TestDto> {
    @Override
    public void write(List<? extends TestDto> items) throws Exception {
        for (TestDto item : items) {
            System.out.println("writer: " + item.toString());
        }
    }
}
