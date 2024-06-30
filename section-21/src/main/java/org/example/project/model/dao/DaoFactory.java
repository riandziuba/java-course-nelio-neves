package org.example.project.model.dao;

public class DaoFactory {
    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC();
    }

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    }

}
