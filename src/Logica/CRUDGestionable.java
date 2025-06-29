/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logica;

/**
 *
 * @author Arana
 */
public interface CRUDGestionable {
    void agregarSegundos(Object o);
    void agregarSopas(Object o);
    void agregarBebidas(Object o);
 
    void actualizarSegundos(Object o, String tipo);
    void actualizarSopas(Object o, String tipo);
    void actualizarBebidas(Object o, String tipo);
    void eliminarSegundos(Object o);
    void eliminarSopas(Object o);
    void eliminarBebidas(Object o);
    
    
}
