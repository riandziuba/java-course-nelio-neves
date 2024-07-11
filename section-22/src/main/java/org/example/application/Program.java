package org.example.application;

import org.example.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Person person = new Person(null, "John", "john@example.com");
//        Person person2 = new Person(null, "Jane", "jane@example.com");
//        Person person3 = new Person(null, "Bob", "bob@example.com");

//        entityManager.getTransaction().begin();
//        entityManager.persist(person);
//        entityManager.persist(person2);
//        entityManager.persist(person3);
//        entityManager.getTransaction().commit();

        Person searchedPerson = entityManager.find(Person.class, 1);
        System.out.println(searchedPerson);

        entityManager.getTransaction().begin();
        Person personToDelete = entityManager.find(Person.class, 2);
        entityManager.remove(personToDelete);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}