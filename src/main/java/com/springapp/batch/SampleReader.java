package com.springapp.batch;

import com.springapp.batch.dto.TestDto;
import org.springframework.batch.item.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class SampleReader implements ItemStreamReader<List<TestDto>> {
    private DataSource dataSource;
    private Connection con;
    private List<TestDto> medlemmer;
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

        medlemmer = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TestDto.class));

    }

    /**
     * Reads next record from input
     */
    @Override
    public List<TestDto> read() throws Exception {
        if (ferdig) {
            return null;
        }
        else {
            ferdig = true;
            return medlemmer;
        }

    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {
         medlemmer.clear();
    }

}
