package org.example.project.application;

import org.example.project.model.dao.DaoFactory;
import org.example.project.model.entities.Department;
import org.example.project.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "IT");
        System.out.println(department);

        Seller seller = new Seller(1, "John", "john@example.com", new Date(), 1000.0, department);
        System.out.println(seller);

        Seller seller2 = DaoFactory.CreateSellerDao().findById(1);
        System.out.println(seller2);

        System.out.println("Finding seller by department");
        Department department2 = new Department(2, "Electronics");
        List<Seller> sellers = DaoFactory.CreateSellerDao().findByDepartment(department2);
        System.out.println(sellers);

        System.out.println("Finding all sellers");
        sellers = DaoFactory.CreateSellerDao().findAll();
        System.out.println(sellers);

        System.out.println("Inserting seller");
        Seller seller3 = new Seller(null, "John", "john@example.com", new Date(), 1000.0, department2);
        Seller insertedSeller = DaoFactory.CreateSellerDao().insert(seller3);
        System.out.println(insertedSeller);

        System.out.println("Updating seller");
        Seller seller4 = DaoFactory.CreateSellerDao().findById(insertedSeller.getId());
        seller4.setName("John Doe");
        DaoFactory.CreateSellerDao().update(seller4);
        System.out.println(DaoFactory.CreateSellerDao().findById(insertedSeller.getId()));

    }
}
