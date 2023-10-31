package VistasAdminAerolinea;

import Modelos.AdministradorAerolinea;
import Vistas.VentanaLogin;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author diaza
 */
public class VentanaMenuPrincipalAdAerolinea extends javax.swing.JFrame {

    private AdministradorAerolinea administradorAerolinea;

    /**
     * Creates new form VentanaMenuPrincipalAdAerolinea
     */
    public VentanaMenuPrincipalAdAerolinea(AdministradorAerolinea adminAerolinea) {
        initComponents();
        this.administradorAerolinea = adminAerolinea; 
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelGestEmpleado = new javax.swing.JPanel();
        btnGestionEmpleadosLog = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        panelGestCapitan = new javax.swing.JPanel();
        btnGestionCapitanes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        panelAviones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelVuelos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Empleados");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gestionar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleado.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 60, -1));

        panelGestEmpleado.setBackground(new java.awt.Color(65, 92, 117));

        btnGestionEmpleadosLog.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGestionEmpleadosLog.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionEmpleadosLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGestionEmpleadosLog.setText("Gestionar empleado de logistica");
        btnGestionEmpleadosLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionEmpleadosLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionEmpleadosLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionEmpleadosLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionEmpleadosLogMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelGestEmpleadoLayout = new javax.swing.GroupLayout(panelGestEmpleado);
        panelGestEmpleado.setLayout(panelGestEmpleadoLayout);
        panelGestEmpleadoLayout.setHorizontalGroup(
            panelGestEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGestionEmpleadosLog, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        panelGestEmpleadoLayout.setVerticalGroup(
            panelGestEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGestionEmpleadosLog, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(panelGestEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 230, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 230, 10));

        panelGestCapitan.setBackground(new java.awt.Color(65, 92, 117));

        btnGestionCapitanes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGestionCapitanes.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionCapitanes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGestionCapitanes.setText("Gestionar capitan de vuelo");
        btnGestionCapitanes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionCapitanes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionCapitanesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionCapitanesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionCapitanesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelGestCapitanLayout = new javax.swing.GroupLayout(panelGestCapitan);
        panelGestCapitan.setLayout(panelGestCapitanLayout);
        panelGestCapitanLayout.setHorizontalGroup(
            panelGestCapitanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestCapitanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGestionCapitanes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelGestCapitanLayout.setVerticalGroup(
            panelGestCapitanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGestCapitanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGestionCapitanes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelGestCapitan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(65, 92, 117));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADMIN AEROLÍNEA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 120, 30));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 120, 10));

        panelAviones.setBackground(new java.awt.Color(65, 92, 117));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gestionar aviones");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAvionesLayout = new javax.swing.GroupLayout(panelAviones);
        panelAviones.setLayout(panelAvionesLayout);
        panelAvionesLayout.setHorizontalGroup(
            panelAvionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAvionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelAvionesLayout.setVerticalGroup(
            panelAvionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAvionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 230, 30));

        panelVuelos.setBackground(new java.awt.Color(65, 92, 117));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Vuelos generados");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelVuelosLayout = new javax.swing.GroupLayout(panelVuelos);
        panelVuelos.setLayout(panelVuelosLayout);
        panelVuelosLayout.setHorizontalGroup(
            panelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVuelosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelVuelosLayout.setVerticalGroup(
            panelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVuelosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(panelVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 230, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aviones.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 70, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vueloTerminado.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 60, -1));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 230, 10));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarioimagen.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 30, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(65, 92, 117));

        btnVolver.setBackground(new java.awt.Color(0, 0, 0));
        btnVolver.setForeground(new java.awt.Color(65, 92, 117));
        btnVolver.setText("Mas opciones");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVolverMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVolverMouseReleased(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(65, 92, 117));
        btnRegresar.setForeground(new java.awt.Color(65, 92, 117));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoVolver.png"))); // NOI18N
        btnRegresar.setText("Volver");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });
        btnVolver.add(btnRegresar);

        jMenuBar1.add(btnVolver);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaLogin();
        v2.setVisible(true);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        btnRegresar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        btnRegresar.setForeground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnRegresarMouseExited

    private void btnVolverMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMousePressed
        btnVolver.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVolverMousePressed

    private void btnVolverMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseReleased
        btnVolver.setForeground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnVolverMouseReleased

    private void btnGestionEmpleadosLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosLogMouseEntered
        panelGestEmpleado.setBackground(new Color(100, 128, 152));
    }//GEN-LAST:event_btnGestionEmpleadosLogMouseEntered

    private void btnGestionEmpleadosLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosLogMouseExited
        panelGestEmpleado.setBackground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnGestionEmpleadosLogMouseExited

    private void btnGestionCapitanesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionCapitanesMouseEntered
        panelGestCapitan.setBackground(new Color(100, 128, 152));
    }//GEN-LAST:event_btnGestionCapitanesMouseEntered

    private void btnGestionCapitanesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionCapitanesMouseExited
        panelGestCapitan.setBackground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnGestionCapitanesMouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        panelAviones.setBackground(new Color(100, 128, 152));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        panelAviones.setBackground(new Color(65, 92, 117));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        panelVuelos.setBackground(new Color(100, 128, 152));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        panelVuelos.setBackground(new Color(65, 92, 117));
    }//GEN-LAST:event_jLabel7MouseExited

    private void btnGestionEmpleadosLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionEmpleadosLogMouseClicked
        this.dispose();
        JFrame v2 = new VentanaGestionEmpleadoLogistica(administradorAerolinea);
        v2.setVisible(true);
    }//GEN-LAST:event_btnGestionEmpleadosLogMouseClicked

    private void btnGestionCapitanesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionCapitanesMouseClicked
        this.dispose();
        JFrame v2 = new VentanaGestionCapitanVuelo(administradorAerolinea);
        v2.setVisible(true);
    }//GEN-LAST:event_btnGestionCapitanesMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.dispose();
        JFrame v2 = new VentanaGestionAviones(administradorAerolinea);
        v2.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGestionCapitanes;
    private javax.swing.JLabel btnGestionEmpleadosLog;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel panelAviones;
    private javax.swing.JPanel panelGestCapitan;
    private javax.swing.JPanel panelGestEmpleado;
    private javax.swing.JPanel panelVuelos;
    // End of variables declaration//GEN-END:variables
}
