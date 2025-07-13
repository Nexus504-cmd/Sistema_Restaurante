/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
    private Image imagenFondo;

    public PanelConFondo() {
        // Asegúrate de tener la imagen en la carpeta src/imagenes/
        imagenFondo = new ImageIcon(getClass().getResource("/img/fondo_donrico.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}