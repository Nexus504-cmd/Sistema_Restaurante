/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Arana
 */
public abstract class Persona {
    protected String nombre;
    protected int telefono;
    protected String correo;
    protected int edad;
    protected int id;

    public Persona(String nombre, int telefono, String correo, int edad, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.id = id;
    }
    
    

  
    
    public abstract String mostrarDatos();
}
