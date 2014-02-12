package com.springapp.batch.dto;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by klaus on 05/01/14.
 */
public class TestDtoRowMapper implements RowMapper {

    public TestDto mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        TestDto person = new TestDto();
        person.setKontohaverId(resultSet.getString(1));
        person.setForNavn(resultSet.getString(2));
        person.setEtterNavn(resultSet.getString(3));
        return person;
    }

    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
