/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import ConexionPGadmin.Conexion;
import java.sql.*;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arana
 */
public class Administrador implements CRUDGestionable, Gestionable, Verificable, Observable {

    private String username;
    private String password;

    public Administrador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Administrador() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//Implementacion de metodos

    @Override
    public void agregarSegundos(Object o) {
        Segundos s = (Segundos) o;
        String sql = "CALL agregarProductos(?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConexion(); CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, s.getId());
            stmt.setString(2, s.getDecripcion());
            stmt.setBigDecimal(3, new BigDecimal(s.getPrecio()));
            stmt.setString(4, "Segundo");
            stmt.setBoolean(5, true);

            stmt.execute();
            System.out.println("Producto agregado");//Simula un raise notice en postgress

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void agregarSopas(Object o) {
        Sopas so = (Sopas) o;
        String sql = "CALL agregarProductos(?,?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement ctmt = conn.prepareCall(sql)) {
            ctmt.setInt(1, so.getId());
            ctmt.setString(2, so.getDecripcion());
            ctmt.setBigDecimal(3, new BigDecimal(so.getPrecio()));
            ctmt.setString(4, "Sopa");
            ctmt.setBoolean(5, true);

            //Ejecucion
            ctmt.execute();
            System.out.println("Producto Agregago: Tipo: Sopa");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void agregarBebidas(Object o) {
        Bebidas b = (Bebidas) o;
        String sql = "CALL agregarProductos (?,?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            //asignacion de parametros
            cstmt.setInt(1, b.getId());
            cstmt.setString(2, b.getDecripcion());
            cstmt.setBigDecimal(3, new BigDecimal(b.getPrecio()));
            cstmt.setString(4, "Bebidas");
            cstmt.setBoolean(5, true);
            //ejecucion
            cstmt.execute();
            System.out.println("Producto Agregado: Tipo: Bebida");
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void actualizarSegundos(Object o, String tipo) {
        Segundos s = (Segundos) o;
        String sql = "CALL actualizarProductos (?,?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
//Preparamos el llamado del procedimietno de la sentencia CallableStatement            
//asignacion de parametros para la consulta
            cstmt.setInt(1, s.getId());
            cstmt.setString(2, s.getDecripcion());
            cstmt.setBigDecimal(3, new BigDecimal(s.getPrecio()));
            cstmt.setString(4, tipo);
            cstmt.setBoolean(5, true);
            //ejecucion
            cstmt.execute();
            System.out.println("Producto Actualizado Exitosamente");
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        }

    }

    @Override
    public void actualizarSopas(Object o, String tipo) {
        Sopas so = (Sopas) o;
        String sql = "CALL actualizarProductos(?,?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, so.getId());
            cstmt.setString(2, so.getDecripcion());
            cstmt.setBigDecimal(3, new BigDecimal(so.getPrecio()));
            cstmt.setString(4, tipo);
            cstmt.setBoolean(5, true);
            //ejecucion
            cstmt.execute();
            System.out.println("Producto Actualizado Exitosamente");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        }
    }

    @Override
    public void actualizarBebidas(Object o, String tipo) {
        Bebidas b = (Bebidas) o;
        String sql = "CALL actualizarProductos (?,?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, b.getId());
            cstmt.setString(2, b.getDecripcion());
            cstmt.setBigDecimal(3, new BigDecimal(b.getPrecio()));
            cstmt.setString(4, tipo);
            cstmt.setBoolean(5, true);
            //ejecucion
            cstmt.execute();
            System.out.println("Producto Actualizado Exitosamente");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
        }
    }

    @Override
    public void eliminarSegundos(Object o) {
        String sql = "CALL eliminarProductos (?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setBoolean(2, false);

            cstmt.execute();
            System.out.println("Eliminacion Procesada: Deshabilitación");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void eliminarSopas(Object o) {
        String sql = "CALL eliminarProductos (?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setBoolean(2, false);

            cstmt.execute();
            System.out.println("Eliminacion Procesada: Deshabilitación");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void eliminarBebidas(Object o) {
        String sql = "CALL eliminarProductos (?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setBoolean(2, false);

            cstmt.execute();
            System.out.println("Eliminacion Procesada: Deshabilitación");

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public DefaultTableModel observarPedido() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_CLIENTE");
        modelo.addColumn("NOMBRE_CLIENTE");
        modelo.addColumn("ID_MESA");
        modelo.addColumn("PAGO");

        String sql = "select * from vista_clientes_pedidos";

        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getInt("id_mesa"),
                    rs.getDouble("pago")

                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());

        }
        return modelo;
    }

    @Override
    public DefaultTableModel observarMesa() {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cliente");
        modelo.addColumn("ID_MESA");
        modelo.addColumn("Estado");
        String sql = "select * from vista_cliente_mesa";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                nombre = (nombre == null || nombre.trim().isEmpty()) ? "<No asignado>" : nombre;
                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    nombre,
                    rs.getInt("id_mesa"),
                    estado
                };
                modelo.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;
    }

    @Override
    public DefaultTableModel listaMesadesocupada() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cliente");
        modelo.addColumn("ID_MESA");
        modelo.addColumn("Estado");
        String sql = "select * from vista_cliente_mesa where actividad = false";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                nombre = (nombre == null || nombre.trim().isEmpty()) ? "<No asignado>" : nombre;
                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    nombre,
                    rs.getInt("id_mesa"),
                    estado
                };
                modelo.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;

    }

    @Override
    public DefaultTableModel listaMesaocupadas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cliente");
        modelo.addColumn("ID_MESA");
        modelo.addColumn("Estado");
        String sql = "select * from vista_cliente_mesa where actividad = true";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                nombre = (nombre == null || nombre.trim().isEmpty()) ? "<No asignado>" : nombre;
                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    nombre,
                    rs.getInt("id_mesa"),
                    estado
                };
                modelo.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return modelo;

    }

    @Override
    public int numMesadesocupada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
