/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Arana
 */
public class Ordenes {
    private int id;
    private String estado;
    private int id_producto;
    Pedido p;
    Cliente c;

    public Ordenes(int id, String estado, int id_producto, Pedido p, Cliente c) {
        this.id = id;
        this.estado = estado;
        this.id_producto = id_producto;
        this.p = p;
        this.c = c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    


    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }
    
    
    
}
