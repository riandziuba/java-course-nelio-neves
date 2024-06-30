package org.example.project.application;

import org.example.project.model.dao.DaoFactory;
import org.example.project.model.entities.Department;
import org.example.project.model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "IT");
        System.out.println(department);

        Seller seller = new Seller(1, "John", "john@example.com", new Date(), 1000.0, department);
        System.out.println(seller);

        Seller seller2 = DaoFactory.CreateSellerDao().findById(1);
        System.out.println(seller2);
    }
}
