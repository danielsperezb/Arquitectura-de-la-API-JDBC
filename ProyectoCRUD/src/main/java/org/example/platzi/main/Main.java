package org.example.platzi.main;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;
//import org.example.platzi.view.SwingApp;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("---LISTANDO TODOS---");
        Repository<Employee> repository = new EmployeeRepository();

        repository.findAll().forEach(System.out::println);

        System.out.println("---BUSCANDO POR ID----");
        System.out.println(repository.getById(2));

    }
}
