/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logica;

import java.sql.*;
import ConexionPGadmin.Conexion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arana
 */
public interface Observable {

    static DefaultTableModel vermenu() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Plato");
        modelo.addColumn("Tipo");
        modelo.addColumn("Precio");
        String sql = "select id_producto, nombre, tipo, precio from productos where estado = ? order by id_producto asc";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, true);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Object fila []={
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("tipo"),
                    rs.getDouble("precio")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        return modelo;
    }
    public DefaultTableModel observarordenesregistro(int id_mesa);
    public DefaultTableModel observarclientes();
    public DefaultTableModel consultarcliente(int dni);
    public DefaultTableModel verSopas();

    public DefaultTableModel verSegundos();

    public DefaultTableModel verBebidas();

}
