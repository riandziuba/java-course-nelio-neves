package org.example.project.model.dao;

import org.example.db.DBActions;
import org.example.db.JDBCActions;
import org.example.project.model.entities.Department;
import org.example.project.model.entities.Seller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private JDBCActions<Seller> actions = new JDBCActions<>();

    @Override
    public Seller insert(Seller seller) {
        String sql = """
                INSERT INTO
                	seller (name, email, birthDate, baseSalary, departmentId)
                VALUES
                	(?, ?, ?, ?, ?)
                """;
        List<Integer> ids = actions.insertAndGetIds(sql, List.of(seller.getName(), seller.getEmail(), new Date(seller.getBirthDate().getTime()), seller.getBaseSalary(), seller.getDepartment().getId()));
        seller.setId(ids.getFirst());
        return seller;
    }

    @Override
    public void update(Seller seller) {
        String sql = """
                UPDATE
                    seller
                SET
                    name = ?,
                    email = ?,
                    birthDate = ?,
                    baseSalary = ?,
                    departmentId = ?
                WHERE
                    id = ?
                """;
        actions.execute(sql, List.of(seller.getName(), seller.getEmail(), new Date(seller.getBirthDate().getTime()), seller.getBaseSalary(), seller.getDepartment().getId(), seller.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        String sql = """
                DELETE FROM
                    seller
                WHERE
                    id = ?
                """;
        actions.execute(sql, List.of(id));
    }

    @Override
    public Seller findById(Integer id) {
        String sql = """
                SELECT
                	s.*,
                	d.id AS departmentId,
                	d."name" AS departmentName
                FROM
                	seller s
                INNER JOIN department d ON
                	d.id = s.departmentid
                WHERE
                	s.id = ?
                """;
       return actions.select(sql, List.of(id), SellerDaoJDBC::mapper).getFirst();

    }

    @Override
    public List<Seller> findAll() {
        String sql = """
                SELECT
                	s.*,
                	d.id AS departmentId,
                	d."name" AS departmentName
                FROM
                	seller s
                INNER JOIN department d ON
                	d.id = s.departmentid
                """;
        return actions.select(sql, List.of(), SellerDaoJDBC::mapper);
    }

    public static List<Seller> mapper(ResultSet rs) throws SQLException {
        List<Seller> sellers = new ArrayList<>();
        Map<Integer, Department> departments = new HashMap<>();
        while (rs.next()) {
            Seller seller = new Seller();
            seller.setId(rs.getInt("id"));
            seller.setName(rs.getString("name"));
            seller.setEmail(rs.getString("email"));
            seller.setBirthDate(rs.getDate("birthDate"));
            seller.setBaseSalary(rs.getDouble("baseSalary"));
            Department department = departments.get(rs.getInt("departmentId"));
            if (department == null) {
                department = new Department();
                department.setId(rs.getInt("departmentId"));
                department.setName(rs.getString("departmentName"));
                departments.put(rs.getInt("departmentId"), department);
            }
            seller.setDepartment(department);
            sellers.add(seller);
        }
        return sellers;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        String sql = """
            SELECT
                s.*,
                d.id AS departmentId,
                d."name" AS departmentName
            FROM
                seller s
            INNER JOIN department d ON
                d.id = s.departmentid
            WHERE
                d.id = ?
            """;
        return actions.select(sql, List.of(department.getId()), SellerDaoJDBC::mapper);
    }
}
