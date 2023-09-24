package org.example.platzi.main;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstance()) {
            Repository<Employee> repository = new EmployeeRepository();

            System.out.println("-----LISTANDO----");
            repository.findAll().forEach(System.out::println);

            //System.out.println("---BUSCANDO POR ID----");
            //System.out.println(repository.getById(100));


            //System.out.println("----INSERTANDO UN EMPLEADO----");
            //Employee employee = new Employee();
            //employee.setFirst_name("Diego");
            //employee.setPa_surname("Alejandro ");
            //employee.setMa_surname("Martinez");
            //employee.setEmail("diego@gmail.com");
            //employee.setSalary((float)2000);
            //repository.save(employee);



            //System.out.println("----ACTUALIZANDO UN EMPLEADO, YA EXISTENTE CON ID----");
            //Employee employee = new Employee();
            //employee.setId(6);
            //employee.setFirst_name("Diego");
            //employee.setPa_surname("Esteban");
            //employee.setMa_surname("Martinez");
            //employee.setEmail("diego@gmail.com");
            //employee.setSalary((float)2000);
            //repository.save(employee);


            System.out.println("ELIMINAR UN REGISTRO");
            repository.delete(6);

            System.out.println("--VERIFIACION--");
            repository.findAll().forEach(System.out::println);



        }
    }
}
