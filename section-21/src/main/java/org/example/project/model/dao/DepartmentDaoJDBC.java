package org.example.project.model.dao;

import org.example.db.JDBCActions;
import org.example.project.model.entities.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private JDBCActions<Department> actions = new JDBCActions<>();

    @Override
    public Department insert(Department department) {
        String sql = "INSERT INTO department (name) VALUES (?)";
        List<Integer> ids = actions.insertAndGetIds(sql, List.of(department.getName()));
        department.setId(ids.getFirst());
        return department;
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE department SET name = ? WHERE id = ?";
        actions.execute(sql, List.of(department.getName(), department.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM department WHERE id = ?";
        actions.execute(sql, List.of(id));
    }

    @Override
    public Department findById(Integer id) {
        String sql = "SELECT * FROM department WHERE id = ?";
        return actions.select(sql, List.of(id), DepartmentDaoJDBC::mapper).getFirst();
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        return actions.select(sql, List.of(), DepartmentDaoJDBC::mapper);
    }

    public static List<Department> mapper(ResultSet rs) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setName(rs.getString("name"));
            departments.add(department);
        }
        return departments;
    }
}
