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
import javax.swing.JLabel;
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

        modelo.addColumn("Mesa");
        modelo.addColumn("Estado");
        modelo.addColumn("Capacidad");
        String sql = "select * from mesa ORDER BY id_mesa ASC";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    rs.getInt("id_mesa"),
                    estado,
                    rs.getInt("capacidad")
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
        modelo.addColumn("Mesa");
        modelo.addColumn("Estado");
        modelo.addColumn("Capacidad");
        String sql = "select * from mesa where actividad = false";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    rs.getInt("id_mesa"),
                    estado,
                    rs.getInt("capacidad")
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
        modelo.addColumn("Mesa");
        modelo.addColumn("Estado");
        modelo.addColumn("Capacidad");
        String sql = "select * from mesa where actividad = true";
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String estado = rs.getBoolean("actividad") ? "Reservado" : "Libre";
                Object[] fila = {
                    rs.getInt("id_mesa"),
                    estado,
                    rs.getInt("capacidad")
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

    @Override
    public void insertarCliente(int dni, String nombre, String apellido_p, String apellido_m) {
        String sql = "CALL insertar_cliente (?,?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, dni);
            cstmt.setString(2, nombre);
            cstmt.setString(3, apellido_p);
            cstmt.setString(4, apellido_m);

            cstmt.execute();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }

    @Override
    public void borrarCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void asignarmesa(int id_mesa, int dni, JLabel error) {
        String sql = "CALL asignarmesa(?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id_mesa);
            cstmt.setBoolean(2, true);

            cstmt.execute();
            String sql4 = "update clientes set id_mesa= ? where dni_cliente= ?";
            try (Connection conn1 = Conexion.getConexion(); PreparedStatement pstmt = conn1.prepareStatement(sql4);) {
                pstmt.setInt(1, id_mesa);
                pstmt.setInt(2, dni);

                pstmt.execute();

            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                error.setText(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            error.setText("Mesa ya asignada");
        }

    }

    public void registrarorden(int id_producto, int id_mesa) {
        String obteneridcliente = "select id_cliente from clientes";
        int id_cliente = 0;
        String obtenerid_pedido = "select id_pedido from pedido where id_mesa = ?";
        int id_pedido = 0;
        String sql = " insert into orden (id_producto,id_pedido,id_cliente,estado,proceso) values (?,?,?,?,?)";

        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(obteneridcliente)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id_cliente = rs.getInt("id_cliente");
                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(obtenerid_pedido)) {
            stmt.setInt(1, id_mesa);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id_pedido = rs.getInt("id_pedido");
                }
            }

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try (Connection conn = Conexion.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id_producto);
            pstmt.setInt(2, id_pedido);
            pstmt.setInt(3, id_cliente);
            pstmt.setString(4, "Proceso");
            pstmt.setBoolean(5, false);

            pstmt.execute();
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }

    }

    public DefaultTableModel observarordenesregistro(int id_mesa) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_orden");

        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Precio");

        String sql = "select * from verordenes where id_mesa = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareCall(sql);) {
            stmt.setInt(1, id_mesa);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object fila[] = {
                        rs.getInt("id_orden"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getDouble("precio")
                    };
                    modelo.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel observarclientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");

        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Mesa");

        String sql = "select * from verclientes";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareCall(sql);) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object fila[] = {
                        rs.getInt("dni_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getInt("id_mesa")
                    };
                    modelo.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel consultarcliente(int dni) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");

        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Mesa");

        String sql = "select * from verclientes where dni_cliente = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareCall(sql);) {
            stmt.setInt(1, dni);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object fila[] = {
                        rs.getInt("dni_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido_paterno"),
                        rs.getString("apellido_materno"),
                        rs.getInt("id_mesa")
                    };
                    modelo.addRow(fila);
                }
            }
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }

        return modelo;
    }

    public void actualizarordenes(int id_orden, int id_mesa) {
        String verificador = "select estado from pedido where id_mesa = ?";
        boolean estado = false;
        try (Connection conn = Conexion.getConexion(); PreparedStatement pstmt
                = conn.prepareStatement(verificador)) {
            pstmt.setInt(1, id_mesa);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                estado = rs.getBoolean("estado");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);

        }
        if (estado == false) {
            String sql = "update orden set estado = ? where id_orden = ? ";

            try (Connection conn = Conexion.getConexion(); PreparedStatement pstmt
                    = conn.prepareStatement(sql)) {

                pstmt.setString(1, "Eliminado");
                pstmt.setInt(2, id_orden);
                pstmt.execute();

            } catch (SQLException e) {
                System.out.println("Error: " + e);

            }
        } else {
            System.out.println("No se puede cambiar. Orden ya tomada [Cocina]");
        }
    }

}
