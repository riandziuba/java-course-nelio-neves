package org.example.db;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws Exception;
}