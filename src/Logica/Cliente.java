/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.HashSet;
import java.util.Set;

import ConexionPGadmin.Conexion;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arana
 */
public class Cliente extends Persona implements Reservable {

    private Pedido p;
    private Mesa m;

    
    

    public Cliente(String nombre, int telefono, String correo, int edad, int id, Mesa m) {
        super(nombre, telefono, correo, edad, id);
        this.p = new Pedido();//Se va a jalar el objeto pedido cerado de cliente y se le va a asignar id de la mesa que ocupa
        //asignamiento de id pedido -(vinculacion)- id cliente
        //p.setId(id);--mejor que se setee por mesa

    }

    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public DefaultTableModel mostrarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        String sql = "select * from informacioncliente";
        try(Connection conn = Conexion.getConexion(); 
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()){
            while(rs.next()){
                Object fila [] = {
                    rs.getInt("dni_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno")
                };
                modelo.addRow(fila);
            }
            
            
        }catch(SQLException e){
            System.out.println("Mensaje: "+e.getMessage());
        }
        return modelo;
        
    }
//metodos implementados

   //no croe que sea necesatio esto leugo vemos

    @Override
    public void agregarSegundos(Object o) {
        Segundos s = (Segundos) o;

        String sql = "CALL asignarpedido(?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, s.getId());
            cstmt.setInt(2, this.getP().getId());
            cstmt.setInt(3, this.getId());

            cstmt.execute();

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void agregarSopas(Object o) {
        Sopas so = (Sopas) o;

        String sql = "CALL asignarpedido(?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, so.getId());
            cstmt.setInt(2, this.getP().getId());
            cstmt.setInt(3, this.getId());

            cstmt.execute();

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void agregarBebidas(Object o) {
        Bebidas b = (Bebidas) o;

        String sql = "CALL asignarpedido(?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, b.getId());
            cstmt.setInt(2, this.getP().getId());
            cstmt.setInt(3, this.getId());

            cstmt.execute();

        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLSTATE: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void actualizarSegundos(Object o, String tipo) {
        //no tenemos la clse orden, entonce snecesitaremos otro atributo de tipo int adicional para manejar el pk
        //se me ocurrio, por el nombre hacer un llamado por select aqui dentro a un cliente, y crear el objeto cliente, ademas este metodo epretenece a la calse clietne
        //puedo hacer llamado con this y ya no crees? con el this se llamara xD igual necesitare una variable para el id_producto
        //puesto cliente -> Pedido -> lista de ordenes, esto se puede solucionar creando la clase orden(int id-estado) acrear noma la clase orden _"

        Ordenes ordenes = (Ordenes) o;
        String sql = "CALL actualizarproducto_pedido (?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, ordenes.getId());
            cstmt.setInt(2, ordenes.getId_producto());
            cstmt.setString(3, tipo);

            cstmt.execute();

        } catch (SQLException e) {

            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void actualizarSopas(Object o, String tipo) {
        Ordenes ordenes = (Ordenes) o;
        String sql = "CALL actualizarproducto_pedido (?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, ordenes.getId());
            cstmt.setInt(2, ordenes.getId_producto());
            cstmt.setString(3, tipo);

            cstmt.execute();

        } catch (SQLException e) {

            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void actualizarBebidas(Object o, String tipo) {
        Ordenes ordenes = (Ordenes) o;
        String sql = "CALL actualizarproducto_pedido (?,?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, ordenes.getId());
            cstmt.setInt(2, ordenes.getId_producto());
            cstmt.setString(3, tipo);

            cstmt.execute();

        } catch (SQLException e) {

            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void eliminarSegundos(Object o) {
        String sql = "CALL eliminarproducto_pedido(?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setString(2, "Anulado");
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void eliminarSopas(Object o) {
        String sql = "CALL eliminarproducto_pedido(?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setString(2, "Anulado");
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }

    @Override
    public void eliminarBebidas(Object o) {
        String sql = "CALL eliminarproducto_pedido(?,?)";
        try (Connection conn = Conexion.getConexion(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) o);
            cstmt.setString(2, "Anulado");
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());

        }
    }


}
