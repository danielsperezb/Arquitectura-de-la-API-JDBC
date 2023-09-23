import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("¡Genial, nos conectamos!");

            myStamt = myConn.createStatement();

            int rowsAffected = myStamt.executeUpdate("UPDATE employees " + "SET email='daniel@gmail.com' " + "WHERE first_name = 'Daniel'");

            // Para ejecutar una consulta y obtener resultados, necesitas usar executeQuery
            myRes = myStamt.executeQuery("SELECT * FROM employees ORDER BY pa_surname");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name") + "," + myRes.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conexión fallida");
        }
    }
}
