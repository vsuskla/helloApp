package com.springapp.batch;

import com.springapp.batch.dto.BankDto;
import com.springapp.batch.dto.BeholdningsDto;
import com.springapp.batch.dto.KundeDto;
import com.springapp.batch.dto.TransDto;
import org.springframework.batch.item.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleReader implements ItemStreamReader<List<BankDto>> {
    private DataSource dataSource;
    private Connection con;
    private JdbcTemplate jdbcTemplate;
    private List<KundeDto> medlemmer;
    private List<BeholdningsDto> beholdningsDtos;
    private List<BankDto> bankDtos;
    private Boolean ferdig = false;
    private List<TransDto> transDtos;


    public SampleReader(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.con = dataSource.getConnection();
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);

    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        String sql = "SELECT KTONR, FORNAVN, ETTERNAVN FROM TEST.TEST";
        medlemmer = jdbcTemplate.query(sql, new BeanPropertyRowMapper(KundeDto.class));
        sql = "SELECT KTONR, BEHOLDNING FROM TEST.BEHOLDNING";
        beholdningsDtos = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BeholdningsDto.class));
        sql = "SELECT KTONR, TYPE, ANTALL FROM TEST.TRANS WHERE BEHANDLET IS NULL";
        transDtos = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TransDto.class));
        System.out.println("BONGO!");
    }

    /**
     * Reads next record from input
     */
    @Override
    public List<BankDto> read() throws Exception {
        BankDto bankDto = new BankDto();
        bankDtos = new ArrayList<BankDto>();
        if (ferdig) {
            return null;
        }
        bankDto.setKundeDto(medlemmer);
        bankDto.setBeholdningsDto(beholdningsDtos);
        bankDto.setTransDto(transDtos);
        bankDtos.add(bankDto);
        ferdig = true;
        return bankDtos;
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {
         medlemmer.clear();
    }

}
