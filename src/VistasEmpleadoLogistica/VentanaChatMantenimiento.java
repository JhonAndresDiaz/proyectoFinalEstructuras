package VistasEmpleadoLogistica;

import Controladores.ControladorVentanaSolicitarMantenimiento;
import Modelos.Aerolinea;
import Modelos.EmpleadoLogistica;
import Modelos.Mantenimiento;
import Util.LSE;
import Util.Nodo;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class VentanaChatMantenimiento extends javax.swing.JFrame {

    private EmpleadoLogistica empleadoLogistica;
    private Mantenimiento mantenimiento;
    private Aerolinea aerolinea;
    private ControladorVentanaSolicitarMantenimiento controlador;
    
    /**
     * Creates new form VentanaChatMantenimiento
     */
    public VentanaChatMantenimiento(EmpleadoLogistica empleadoLogistica, Mantenimiento mantenimiento, Aerolinea aerolinea) {
        initComponents();
        this.empleadoLogistica = empleadoLogistica;
        this.mantenimiento = mantenimiento;
        this.aerolinea = aerolinea;
        this.controlador = new ControladorVentanaSolicitarMantenimiento(); 
        txtNumSolicitud.setText(String.valueOf(mantenimiento.getNum()));
        txtDetalles.setText(mantenimiento.getMotivo());
        txtEstado.setText(mantenimiento.getEstado());
        txtFechaIni.setText(mantenimiento.getFechaInicio().toString());
        txtFechaFin.setText(mantenimiento.getFechaFin().toString());
        txtNumAvion.setText(String.valueOf(mantenimiento.getAvion().getNumero()));
        txtNombreAerolinea.setText(aerolinea.getNombreAerolinea());
        actualizarHistorialMensajes(mantenimiento);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textHisto = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtNumSolicitud = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFechaIni = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNumAvion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNombreAerolinea = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDetalles = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 92, 117));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("del mantenimiento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 30));

        textHisto.setEditable(false);
        textHisto.setColumns(20);
        textHisto.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        textHisto.setRows(5);
        jScrollPane2.setViewportView(textHisto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 450, 230));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setText("Respuestas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        txtRespuesta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 450, 110));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(65, 92, 117));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Responder");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 450, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(65, 92, 117));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 180, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(65, 92, 117));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 180, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Número de solicitud");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 20));

        txtNumSolicitud.setEditable(false);
        jPanel1.add(txtNumSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 100, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(65, 92, 117));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Fecha inicio  ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, 20));

        txtFechaIni.setEditable(false);
        jPanel1.add(txtFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 100, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(65, 92, 117));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Fecha final  ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 80, 20));

        txtFechaFin.setEditable(false);
        jPanel1.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 100, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(65, 92, 117));
        jLabel18.setText("Numero de Avión");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 20));

        txtNumAvion.setEditable(false);
        jPanel1.add(txtNumAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 100, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(65, 92, 117));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Aerolinea");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, 20));

        txtNombreAerolinea.setEditable(false);
        jPanel1.add(txtNombreAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 100, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(65, 92, 117));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Detalles");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 300, 20));

        txtEstado.setEditable(false);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 100, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(65, 92, 117));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Estado");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 80, 20));

        txtDetalles.setEditable(false);
        txtDetalles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 300, 110));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chat");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 60, 30));

        btnEnviar.setBackground(new java.awt.Color(65, 92, 117));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mantenimiento.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 80, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Información ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 140, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 310, 10));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaSolicitarMantenimiento(empleadoLogistica);
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

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if(txtRespuesta.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar una respuesta");
            return;
        }

        String mensajeRespuesta = txtRespuesta.getText();
        int numSolicitud = Integer.parseInt(txtNumSolicitud.getText());
        Mantenimiento mantenimiento = controlador.mantenimientoBuscado(numSolicitud);

        try{
            controlador.aniadirMensajeEmpleado(mantenimiento, mensajeRespuesta);
            JOptionPane.showMessageDialog(null, "Se envio el mensaje correctamente");
            actualizarHistorialMensajes(mantenimiento);
            txtRespuesta.setText(null);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    public void actualizarHistorialMensajes(Mantenimiento mantenimiento) {
        LSE<String> historialMensajes = mantenimiento.obtenerMensajesChat();
        StringBuilder historialTexto = new StringBuilder();

        Nodo<String> actual = historialMensajes.getPrimero();

        while (actual != null) {
            historialTexto.append(actual.getDato()).append("\n");
            actual = actual.getNodoSiguiente(); 
        }
        textHisto.setText(historialTexto.toString());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea textHisto;
    private javax.swing.JTextField txtDetalles;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaIni;
    private javax.swing.JTextField txtNombreAerolinea;
    private javax.swing.JTextField txtNumAvion;
    private javax.swing.JTextField txtNumSolicitud;
    private javax.swing.JTextField txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
