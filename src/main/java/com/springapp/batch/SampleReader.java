package com.springapp.batch;

import com.springapp.batch.dto.BeholdningsDto;
import com.springapp.batch.dto.KundeDto;
import org.springframework.batch.item.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SampleReader implements ItemStreamReader<List<KundeDto>> {
    private DataSource dataSource;
    private Connection con;
    private List<KundeDto> medlemmer;
    private List<BeholdningsDto> beholdningsDtos;
    private Boolean ferdig = false;
    private JdbcTemplate jdbcTemplate;


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
        System.out.println("BONGO!");
    }

    /**
     * Reads next record from input
     */
    @Override
    public List<KundeDto> read() throws Exception {
        if (ferdig) {
            return null;
        }
        for(KundeDto kunde : medlemmer){
            for(BeholdningsDto beh : beholdningsDtos){
                if(kunde.ktonr.equals(beh.getKtonr())){
                    kunde.setBeholdning(beh.getBeholdning());
                }
            }
        }
        ferdig = true;
        return medlemmer;
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {
         medlemmer.clear();
    }

}
