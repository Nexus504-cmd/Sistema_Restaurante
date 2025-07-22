/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logica;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arana
 */
public interface Gestionable {
    DefaultTableModel observarPedido();
    DefaultTableModel observarMesa();
    public void asignarmesa(int id_mesa, int dni, JLabel error);
    void insertarCliente(int dni, String nombre, String apellido_p, String apellido_m);
    void borrarCliente();
    public void registrarorden(int id_producto, int id_mesa);
    public void actualizarordenes(int id_orden, int id_mesa);
}
