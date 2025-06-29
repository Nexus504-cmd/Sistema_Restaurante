/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Arana
 */
public abstract class Producto {
    protected String decripcion;
    protected double precio;
    protected int id;

    public Producto(String decripcion, double precio, int id) {
        this.decripcion = decripcion;
        this.precio = precio;
        this.id = id;
    }
    
    
    
    public abstract String mostrarDescripcion();


    
}
