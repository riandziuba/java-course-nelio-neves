package org.example.project.model.dao;

import org.example.db.DBActions;
import org.example.db.JDBCActions;
import org.example.project.model.entities.Department;
import org.example.project.model.entities.Seller;

import java.sql.ResultSet;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private JDBCActions<Seller> actions = new JDBCActions<>();

    @Override
    public void insert(Seller department) {

    }

    @Override
    public void update(Seller department) {

    }

    @Override
    public void deleteById(Integer id) {

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
       return actions.select(sql, List.of(id), (ResultSet rs) -> {
            Seller seller = new Seller();
            seller.setId(rs.getInt("id"));
            seller.setName(rs.getString("name"));
            seller.setEmail(rs.getString("email"));
            seller.setBirthDate(rs.getDate("birthDate"));
            seller.setBaseSalary(rs.getDouble("baseSalary"));
            seller.setDepartment(new Department());
            seller.getDepartment().setId(rs.getInt("departmentId"));
            seller.getDepartment().setName(rs.getString("departmentName"));
            return seller;
        }).getFirst();

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
        return actions.select(sql, List.of(), (ResultSet rs) -> {
            Seller seller = new Seller();
            seller.setId(rs.getInt("id"));
            seller.setName(rs.getString("name"));
            seller.setEmail(rs.getString("email"));
            seller.setBirthDate(rs.getDate("birthDate"));
            seller.setBaseSalary(rs.getDouble("baseSalary"));
            seller.setDepartment(new Department());
            seller.getDepartment().setId(rs.getInt("departmentId"));
            seller.getDepartment().setName(rs.getString("departmentName"));
            return seller;
        });
    }
}
