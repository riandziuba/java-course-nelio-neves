package org.example.project.model.dao;

public class DaoFactory {
    public static DepartmentDao CreateDepartmentDao() {
        return new DepartmentDaoJDBC();
    }

    public static SellerDao CreateSellerDao() {
        return new SellerDaoJDBC();
    }

}
