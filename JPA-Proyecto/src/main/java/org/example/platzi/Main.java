package org.example.platzi;

import org.example.platzi.Util.UtilEntity;
import org.example.platzi.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager em = UtilEntity.getEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("---LISTAR TODOS----");
        employees.forEach(System.out::println);
    }
}