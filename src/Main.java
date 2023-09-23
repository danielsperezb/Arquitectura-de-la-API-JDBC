import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamy = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("Genial, Nos conectamos");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Conexion fallida");
        }

    }
}