/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import ConexionPGadmin.Conexion;
import Logica.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Arana
 */
public class Form_Mesas_Administrador extends javax.swing.JFrame {

    Administrador admin = new Administrador();

    /**
     * Creates new form Form_Mesas
     */
    public Form_Mesas_Administrador() {
        initComponents();

        TablaMesasVista.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = TablaMesasVista.rowAtPoint(evt.getPoint());
                if (fila >= 0) {
                    String id_mesa = TablaMesasVista.getValueAt(fila, 0).toString();
                    ID_mesa.setText(id_mesa);
                }
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMesasVista = new javax.swing.JTable();
        BotonVerMesasOcupadas = new javax.swing.JButton();
        BotonVerMesasDesocupadas = new javax.swing.JButton();
        BotonInsertarMesas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ID_mesa = new javax.swing.JTextField();
        BotonAgregarMesas = new javax.swing.JButton();
        ListarMesas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inicio = new javax.swing.JTextField();
        BotonDesocuparMesas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ID_Capacidad = new javax.swing.JTextField();
        Boton_Actualizar = new javax.swing.JButton();
        Boton_Eliminar = new javax.swing.JButton();
        Boton_Retorno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("GESTION DE MESAS");

        TablaMesasVista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cliente", "ID_MESA", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaMesasVista);
        if (TablaMesasVista.getColumnModel().getColumnCount() > 0) {
            TablaMesasVista.getColumnModel().getColumn(1).setResizable(false);
            TablaMesasVista.getColumnModel().getColumn(2).setResizable(false);
        }

        BotonVerMesasOcupadas.setText("Mesas Ocupadas");
        BotonVerMesasOcupadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerMesasOcupadasActionPerformed(evt);
            }
        });

        BotonVerMesasDesocupadas.setText("Mesas Desocupadas");
        BotonVerMesasDesocupadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerMesasDesocupadasActionPerformed(evt);
            }
        });

        BotonInsertarMesas.setText("Insertar");
        BotonInsertarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertarMesasActionPerformed(evt);
            }
        });

        jLabel2.setText("Mesa:");

        ID_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_mesaActionPerformed(evt);
            }
        });

        BotonAgregarMesas.setText("Agregar Mesas");
        BotonAgregarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarMesasActionPerformed(evt);
            }
        });

        ListarMesas.setText("ListarMesas");
        ListarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarMesasActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        jLabel4.setText("Inicio:");

        BotonDesocuparMesas.setText("Desocupar");
        BotonDesocuparMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDesocuparMesasActionPerformed(evt);
            }
        });

        jLabel5.setText("Capacidad:");

        Boton_Actualizar.setText("Actualizar");
        Boton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ActualizarActionPerformed(evt);
            }
        });

        Boton_Eliminar.setText("Eliminar");
        Boton_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminarActionPerformed(evt);
            }
        });

        Boton_Retorno.setText("RETORNO");
        Boton_Retorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_RetornoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ID_Capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ID_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton_Actualizar)
                            .addComponent(Boton_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BotonInsertarMesas, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonDesocuparMesas)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BotonAgregarMesas)
                    .addComponent(Boton_Retorno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVerMesasDesocupadas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ListarMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BotonVerMesasOcupadas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListarMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(BotonVerMesasOcupadas)
                                .addGap(18, 18, 18)
                                .addComponent(BotonVerMesasDesocupadas)))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ID_Capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Actualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonDesocuparMesas)
                    .addComponent(BotonInsertarMesas))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(BotonAgregarMesas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Boton_Retorno)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonVerMesasOcupadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerMesasOcupadasActionPerformed
        TablaMesasVista.setModel(admin.listaMesaocupadas());
    }//GEN-LAST:event_BotonVerMesasOcupadasActionPerformed

    private void BotonVerMesasDesocupadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerMesasDesocupadasActionPerformed
        TablaMesasVista.setModel(admin.listaMesadesocupada());
    }//GEN-LAST:event_BotonVerMesasDesocupadasActionPerformed

    private void BotonInsertarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertarMesasActionPerformed
        String sql3 = "insert into mesa(id_mesa,actividad,capacidad) values (?,?,?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql3);) {
            stmt.setInt(1, Integer.parseInt(ID_mesa.getText()));
            stmt.setBoolean(2, false);
            stmt.setInt(3, Integer.parseInt(ID_Capacidad.getText()));
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Inserccion correcta");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar" + e);

        }
        TablaMesasVista.setModel(admin.observarMesa());
    }//GEN-LAST:event_BotonInsertarMesasActionPerformed

    private void ListarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarMesasActionPerformed
        TablaMesasVista.setModel(admin.observarMesa());
    }//GEN-LAST:event_ListarMesasActionPerformed

    private void BotonAgregarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarMesasActionPerformed
        int id;

        String sql3 = "insert into mesa(id_mesa,actividad) values (?,?)";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql3);) {
            for (int i = 0; i < Integer.parseInt(cantidad.getText()); i++) {
                id = Integer.parseInt(inicio.getText()) + i;
                stmt.setInt(1, id);
                stmt.setBoolean(2, false);
                stmt.execute();

            }
            JOptionPane.showMessageDialog(null, "Insercion correcta");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insercion incorrecta" + e);
            System.out.println("Error: " + e.getMessage());

        }

        TablaMesasVista.setModel(admin.observarMesa());
    }//GEN-LAST:event_BotonAgregarMesasActionPerformed

    private void BotonDesocuparMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDesocuparMesasActionPerformed
        // TODO add your handling code here:

        String sql = "update mesa set actividad = ? where id_mesa =?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, false);
            stmt.setInt(2, Integer.parseInt(ID_mesa.getText()));
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

        String sql4 = "select id_pedido from pedido where id_mesa= ?";
        int id_pedido = 0;
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql4)) {

            stmt.setInt(1, Integer.parseInt(ID_mesa.getText()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id_pedido = rs.getInt("id_pedido");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        String sql2 = "delete from orden where id_pedido = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql2)) {

            stmt.setInt(1, id_pedido);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        String sql11 = "update clientes set id_pedido = ? where id_mesa =?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql11)) {

            stmt.setNull(1, java.sql.Types.INTEGER);
            stmt.setInt(2, Integer.parseInt(ID_mesa.getText()));
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }
        String sql1 = "update clientes set id_mesa = ? where id_mesa =?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql1)) {

            stmt.setNull(1, java.sql.Types.INTEGER);
            stmt.setInt(2, Integer.parseInt(ID_mesa.getText()));
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

        String sql3 = "delete from pedido where id_mesa = ?";
        try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql3)) {

            stmt.setInt(1, Integer.parseInt(ID_mesa.getText()));
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Mesa desocupada");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al desocupar " + e);

        }
        TablaMesasVista.setModel(admin.observarMesa());


    }//GEN-LAST:event_BotonDesocuparMesasActionPerformed

    private void ID_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_mesaActionPerformed

    private void Boton_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarActionPerformed
        // TODO add your handling code here:
        try {
            int mesa = Integer.parseInt(ID_mesa.getText());
            String sql = "delete from mesa where id_mesa =?";
            try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, Integer.parseInt(ID_mesa.getText()));
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Eliminado");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error Ingrese un valor válido " + e);

            }
            

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor válido");
        }
        TablaMesasVista.setModel(admin.observarMesa());

    }//GEN-LAST:event_Boton_EliminarActionPerformed

    private void Boton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ActualizarActionPerformed
        // TODO add your handling code here:
        try {
            int capa = Integer.parseInt(ID_Capacidad.getText());
            int mesa = Integer.parseInt(ID_mesa.getText());
            String sql = "update mesa set capacidad = ? where id_mesa =?";
            try (Connection conn = Conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, Integer.parseInt(ID_Capacidad.getText()));
                stmt.setInt(2, Integer.parseInt(ID_mesa.getText()));
                stmt.execute();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + e);

            }
            

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor valido");

        }
        TablaMesasVista.setModel(admin.observarMesa());
    }//GEN-LAST:event_Boton_ActualizarActionPerformed

    private void Boton_RetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_RetornoActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_Boton_RetornoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarMesas;
    private javax.swing.JButton BotonDesocuparMesas;
    private javax.swing.JButton BotonInsertarMesas;
    private javax.swing.JButton BotonVerMesasDesocupadas;
    private javax.swing.JButton BotonVerMesasOcupadas;
    private javax.swing.JButton Boton_Actualizar;
    private javax.swing.JButton Boton_Eliminar;
    private javax.swing.JButton Boton_Retorno;
    private javax.swing.JTextField ID_Capacidad;
    private javax.swing.JTextField ID_mesa;
    private javax.swing.JButton ListarMesas;
    private javax.swing.JTable TablaMesasVista;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
