package VistasGestorMantenimiento;

import Modelos.GestorMantenimiento;
import Vistas.VentanaLogin;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author diaza
 */
public class VentanaPrincipalGestorMantenimiento extends javax.swing.JFrame {

    private GestorMantenimiento gestorMantenimiento;
    /**
     * Creates new form VentanaPrincipalGestorMantenimiento
     */
    public VentanaPrincipalGestorMantenimiento(GestorMantenimiento gestorMantenimiento) {
        initComponents();
        this.gestorMantenimiento = gestorMantenimiento;
        txtNombre.setText(gestorMantenimiento.getNombres() + " " + gestorMantenimiento.getApellidos());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jMenuBar = new javax.swing.JMenuBar();
        btnVolver5 = new javax.swing.JMenu();
        btnRegresar5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarioimagen.png"))); // NOI18N
        jLabel1.setText("GESTOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 20, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 92, 117));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("en el sistema");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 330, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Actualmente no cumple");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 330, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ninguna funcionalidad");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 330, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/error.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 70, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setText("Gestor de mantenimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 40));

        txtNombre.setEditable(false);
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 110, -1));

        jMenuBar.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar.setForeground(new java.awt.Color(65, 92, 117));

        btnVolver5.setBackground(new java.awt.Color(0, 0, 0));
        btnVolver5.setForeground(new java.awt.Color(65, 92, 117));
        btnVolver5.setText("Mas opciones");
        btnVolver5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVolver5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnVolver5MouseReleased(evt);
            }
        });

        btnRegresar5.setBackground(new java.awt.Color(65, 92, 117));
        btnRegresar5.setForeground(new java.awt.Color(65, 92, 117));
        btnRegresar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoVolver.png"))); // NOI18N
        btnRegresar5.setText("Volver");
        btnRegresar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresar5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresar5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresar5MouseExited(evt);
            }
        });
        btnVolver5.add(btnRegresar5);

        jMenuBar.add(btnVolver5);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar5MouseClicked
        this.dispose();
        JFrame v2 = new VentanaLogin();
        v2.setVisible(true);
    }//GEN-LAST:event_btnRegresar5MouseClicked

    private void btnRegresar5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar5MouseEntered
        btnRegresar5.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRegresar5MouseEntered

    private void btnRegresar5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar5MouseExited
        btnRegresar5.setForeground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnRegresar5MouseExited

    private void btnVolver5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolver5MousePressed
        btnVolver5.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVolver5MousePressed

    private void btnVolver5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolver5MouseReleased
        btnVolver5.setForeground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnVolver5MouseReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnRegresar5;
    private javax.swing.JMenu btnVolver5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
