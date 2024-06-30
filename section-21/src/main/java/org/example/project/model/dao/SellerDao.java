package org.example.project.model.dao;

import org.example.project.model.entities.Department;
import org.example.project.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    Seller insert(Seller department);
    void update(Seller department);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
