package org.example.db;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapper<T> {
    List<T> mapRows(ResultSet rs) throws Exception;
}