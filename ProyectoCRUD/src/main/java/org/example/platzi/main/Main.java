package org.example.platzi.main;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "";

        try (Connection myConn = DriverManager.getConnection(url, user, password)){
            Statement myStamt =  myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees ORDER BY pa_surname");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conexión fallida");
        }
    }
}
