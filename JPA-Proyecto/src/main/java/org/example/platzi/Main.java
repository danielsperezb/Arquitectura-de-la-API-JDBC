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

        System.out.println("---BUSCAR  UNO----");
        int employeeId = 3;
        Employee employee = em.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado: " + employee);

        /*System.out.println("-----CREAR UNO----");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Leonardo");
        newEmployee.setPaSurname("Rodrihuez");
        newEmployee.setMaSurname("Orejuela");
        newEmployee.setEmail("leo@gmail.com");
        newEmployee.setSalary((float) 3000);
        em.getTransaction().begin(); //Iniciarla
        em.persist(newEmployee); //guardarla
        em.getTransaction().commit(); //confirmarla

        System.out.println("Nuevo empleado creado " + newEmployee);*/

        /*System.out.println("----ACTUALIZAR----");
        int employeeToUpdateId = 2; //numero de id
        Employee employeeToUpdate = em.find(Employee.class, employeeToUpdateId); //Podriamos hacerlo solo pasandole el 2
        System.out.println("Empelado a modificar " + employeeToUpdate);

        employeeToUpdate.setFirstName("Irving");
        employeeToUpdate.setPaSurname("Juarez");
        employeeToUpdate.setSalary(3000F);

        em.getTransaction().begin();
        em.merge(employeeToUpdate);
        em.getTransaction().commit();

        System.out.println("Empelado actualizado " + employeeToUpdate);*/

        System.out.println("---ELIMINAR---");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = em.find(Employee.class, employeeToDeleteId);
        System.out.println("Empelado a eliminar " + employeeToDelete);

        //COmenzamos nuestra transaccion
        em.getTransaction().begin();
        em.remove(employeeToDelete);
        em.getTransaction().commit();
        em.close();





    }
}