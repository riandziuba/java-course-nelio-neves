package org.example.demo;

import org.example.db.DBActions;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws SQLException, ParseException {
        String sql = "SELECT * FROM department";
        DBActions.select(sql);
        Integer totalRows;

        sql = "INSERT INTO seller (Name, Email, BirthDate , BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)";
        List<Object> params = List.of("John", "john@example.com", new Date(DATE_FORMAT.parse("01/01/1990").getTime()), 10000, 1);
        totalRows = DBActions.execute(sql, params);
        System.out.println("Total rows inserted: " + totalRows);

        sql = "INSERT INTO seller (Name, Email, BirthDate , BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)";
        params = List.of("John", "john@example.com", new Date(DATE_FORMAT.parse("01/01/1990").getTime()), 10000, 1);
        List<Integer> ids = DBActions.insertAndGetIds(sql, params);
        for (Integer id : ids) {
            System.out.println("Id: " + id);
        }

        sql = "UPDATE seller SET BaseSalary = BaseSalary + ? WHERE Id = ?";
        params = List.of(200.0, 13);
        totalRows = DBActions.execute(sql, params);
        System.out.println("Total rows updated: " + totalRows);

        sql = "DELETE FROM department WHERE Id = ?";
        params = List.of(2);
        totalRows = DBActions.execute(sql, params);
        System.out.println("Total rows deleted: " + totalRows);
    }
}