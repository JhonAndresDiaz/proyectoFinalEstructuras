package VistasAdminGeneral;

import Controladores.ControladorVentanaSolicitarMantenimiento;
import Modelos.*;
import Util.LSE;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diaza
 */
public class VentanaAtenderSolicitudesMantenimiento extends javax.swing.JFrame {

    private ControladorVentanaSolicitarMantenimiento controlador;
    DefaultTableModel modelo;
    
    /**
     * Creates new form VentanaAtenderSolicitudesMantenimiento
     */
    public VentanaAtenderSolicitudesMantenimiento() {
        initComponents();
        this.controlador = new ControladorVentanaSolicitarMantenimiento();
        modelo = (DefaultTableModel)tabla.getModel();
        actualizarTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDuracionDias = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGestion = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNumeroSolicitud = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Fecha inicio", "Avion", "Detalles", "Estado", "Aerolinea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 500, 140));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(65, 92, 117));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("En espera");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 70, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 92, 117));
        jLabel14.setText("Solicitudes de");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 210, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(65, 92, 117));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Mantenimiento");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mante.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 70, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 10));

        jPanel2.setBackground(new java.awt.Color(65, 92, 117));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setText("Aceptar solicitud");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 130, 30));

        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Solicitud seleccionada");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, 30));

        txtDuracionDias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtDuracionDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 100, 30));

        jPanel3.setBackground(new java.awt.Color(65, 92, 117));

        btnGestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGestion.setForeground(new java.awt.Color(255, 255, 255));
        btnGestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGestion.setText("Gestionar solicitudes");
        btnGestion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        jLabel13.setForeground(new java.awt.Color(65, 92, 117));
        jLabel13.setText("Ingrese la duración de días que tardará la solicitud");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 30));

        txtNumeroSolicitud.setEditable(false);
        jPanel1.add(txtNumeroSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 282, 80, 30));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaMenuPrincipalAdmGeneral();
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

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked

        if(txtDuracionDias.getText().isEmpty() || txtNumeroSolicitud.getText().isEmpty()){
            JOptionPane.showMessageDialog( null , "Complete todos los campos");
            return;
        }

        int num = Integer.parseInt(txtNumeroSolicitud.getText());
        int dias = Integer.parseInt(txtDuracionDias.getText());
        
        Mantenimiento mante = controlador.mantenimientoBuscado(num);
        LocalDate fechaFin = mante.getFechaInicio().plusDays(dias);
        Mantenimiento mantenimiento = new Mantenimiento(num, mante.getMotivo(), mante.getFechaInicio(), fechaFin, mante.getAvion(), "En progreso");

        try{
            controlador.actulizarMantenimiento(mantenimiento);
            JOptionPane.showMessageDialog(null, "Se acepto correctamente la solicitud");
            txtDuracionDias.setText(null);
            txtNumeroSolicitud.setText(null);
            actualizarTabla();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla");
            return; 
        }
        txtNumeroSolicitud.setText(modelo.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void btnGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseClicked
        this.dispose();
        JFrame v2 = new VentanaGestionSolicitudesMant();
        v2.setVisible(true);
    }//GEN-LAST:event_btnGestionMouseClicked


    private void actualizarTabla() {
        LSE<Mantenimiento> mantenimientos = controlador.obtenerTODOSMantenimientos();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < mantenimientos.size(); i++) {
            Mantenimiento aux = mantenimientos.get(i);
            Aerolinea aerolinea = controlador.buscarAerolineaAvion(aux);
            if(aux.getEstado().equals("Pendiente")){
                Object[] ob = {aux.getNum(), aux.getFechaInicio(), aux.getAvion().getNumero(), aux.getMotivo(), aux.getEstado(), aerolinea.getNombreAerolinea()};
                modelo.addRow(ob); 
            }
        }
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnGestion;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDuracionDias;
    private javax.swing.JTextField txtNumeroSolicitud;
    // End of variables declaration//GEN-END:variables
}
