package org.example.platzi.main;

import org.example.platzi.model.Employee;
import org.example.platzi.repository.EmployeeRepository;
import org.example.platzi.repository.Repository;
import org.example.platzi.util.DatabaseConnection;
//import org.example.platzi.view.SwingApp;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        //SwingApp app =new SwingApp();
        //app.setVisible(true);

        //PROBANDO EL CURL Y TRANSACCIONES
        try(Connection myConn = DatabaseConnection.getInstance()) {
            //auto commit falso
            if(myConn.getAutoCommit()){
                myConn.setAutoCommit(false);
            }

            try{
                Repository<Employee> repository = new EmployeeRepository(myConn);

                System.out.println("---INSERTAR UN NUEVO CLIENTE----");

                Employee employee = new Employee();
                /*
                employee.setFirst_name("America");
                employee.setPa_surname("Lopez");
                employee.setMa_surname("Villa");
                employee.setEmail("america@example.com");
                employee.setSalary( (float) 1000);
                employee.setCurp("ADM235GJPSE56FJ6JG");
                repository.save(employee);
                myConn.commit();
                 */

                employee.setFirst_name("David");
                employee.setPa_surname("Gutierrez");
                employee.setMa_surname("Olvera");
                employee.setEmail("raul@example.com");
                employee.setSalary( (float) 1000);
                employee.setCurp("ADM235GJPSE56FJ6JG");
                repository.save(employee);
                myConn.commit();

            }catch (SQLException e){
                myConn.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
