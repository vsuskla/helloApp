package com.springapp.batch;

import com.springapp.batch.dto.TestDto;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SampleReader implements ItemReader<List<TestDto>> {
    private DataSource dataSource;
    private Connection con;
    private List<TestDto> medlemmer;
    private JdbcTemplate jdbcTemplate;


    public SampleReader(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.con = dataSource.getConnection();
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);

    }

    public SampleReader() {
        SampleReader reader;
        try {
            reader = new SampleReader(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String[] input = {"Hello world!", null};

    private int index = 0;

    /**
     * Reads next record from input
     */
    @Override
    public List<TestDto> read() throws Exception {
        String sql = "SELECT KTONR, FORNAVN, ETTERNAVN FROM TEST.TEST";

        medlemmer = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TestDto.class));
        if (!medlemmer.isEmpty()) {
            System.out.println(medlemmer.toString());
            return medlemmer;
        }
        else {
            return null;
        }

    }

}
