package org.example.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBActions {
    public static void select(String sql) {
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void beginTransaction() {
        try (Connection connection = DB.getConnection()) {
            connection.setAutoCommit(false);
            DB.setIsOnTransaction(true);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void commitTransaction() {
        try (Connection connection = DB.getConnection()) {
            connection.commit();
            connection.setAutoCommit(true);
            DB.setIsOnTransaction(false);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void rollbackTransaction() {
        try (Connection connection = DB.getConnection()) {
            connection.rollback();
            DB.setIsOnTransaction(false);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Integer execute(String sql, List<Object> params) {
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) instanceof String) {
                    statement.setString(i + 1, (String) params.get(i));
                } else if (params.get(i) instanceof Date) {
                    statement.setDate(i + 1, (Date) params.get(i));
                } else if (params.get(i) instanceof Double) {
                    statement.setDouble(i + 1, (Double) params.get(i));
                } else if (params.get(i) instanceof Integer) {
                    statement.setInt(i + 1, (Integer) params.get(i));
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static List<Integer> insertAndGetIds(String sql, List<Object> params) {
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i) instanceof String) {
                    statement.setString(i + 1, (String) params.get(i));
                } else if (params.get(i) instanceof Date) {
                    statement.setDate(i + 1, (Date) params.get(i));
                } else if (params.get(i) instanceof Double) {
                    statement.setDouble(i + 1, (Double) params.get(i));
                } else if (params.get(i) instanceof Integer) {
                    statement.setInt(i + 1, (Integer) params.get(i));
                }
            }
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            List<Integer> ids = new ArrayList<>();
            while (resultSet.next()) {
                ids.add(resultSet.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
