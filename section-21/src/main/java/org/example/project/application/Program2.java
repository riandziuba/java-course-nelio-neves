package org.example.project.application;

import org.example.project.model.dao.DaoFactory;
import org.example.project.model.entities.Department;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("Select department by id");

        Department department = DaoFactory.createDepartmentDao().findById(1);
        System.out.println(department);

        System.out.println("insert department");
        Department department2 = new Department();
        department2.setName("department2");
        department2 = DaoFactory.createDepartmentDao().insert(department2);
        System.out.println(department2);

        System.out.println("update department");
        department2.setName("department3");
        DaoFactory.createDepartmentDao().update(department2);
        System.out.println(department2);

        System.out.println("delete department");
        DaoFactory.createDepartmentDao().deleteById(department2.getId());

        System.out.println("find all departments");
        System.out.println(DaoFactory.createDepartmentDao().findAll());
    }
}
