/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionPGadmin;

/**
 *
 * @author Arana
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    private static final String URL = "jdbc:postgresql://localhost:5432/restaurante";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConexion() {
        try {
            Class.forName("org.postgresql.Driver");
           
            return DriverManager.getConnection(URL, USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
