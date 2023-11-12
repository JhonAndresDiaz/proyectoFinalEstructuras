package VistasViajero;

import Controladores.ControladorVentanaReservaActivas;
import Excepciones.Minimo2DiasDiferenciaException;
import Modelos.Aerolinea;
import Modelos.Reserva;
import Modelos.Viajero;
import Modelos.Vuelo;
import Util.LSE;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diaza
 */
public class VentanaReservaActivas extends javax.swing.JFrame {

    private Viajero viajero;
    private ControladorVentanaReservaActivas controlador;
    DefaultTableModel modelo;

    /**
     * Creates new form VentanaReservaActivas
     */
    public VentanaReservaActivas(Viajero viajero) {
        initComponents();
        this.viajero = viajero;
        this.controlador = new ControladorVentanaReservaActivas();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelarReserva = new javax.swing.JButton();
        txtNumVuelo = new javax.swing.JTextField();
        txtPosicion = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Num Vuelo", "Código", "Posición", "Fecha Inicio", "Hora Inicio", "Origen", "Fecha Fin", "Hora Fin", "Destino", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            tabla.getColumnModel().getColumn(6).setResizable(false);
            tabla.getColumnModel().getColumn(7).setResizable(false);
            tabla.getColumnModel().getColumn(8).setResizable(false);
            tabla.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 740, 230));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reservas activas");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 730, -1));

        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Si desea cancelar una reserva seleccionela (2 dias habiles)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 390, -1));

        btnCancelarReserva.setBackground(new java.awt.Color(65, 92, 117));
        btnCancelarReserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarReserva.setText("Cancelar Reserva");
        btnCancelarReserva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 170, 30));

        txtNumVuelo.setEditable(false);
        txtNumVuelo.setBackground(new java.awt.Color(255, 255, 255));
        txtNumVuelo.setForeground(new java.awt.Color(255, 255, 255));
        txtNumVuelo.setBorder(null);
        jPanel1.add(txtNumVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 80, 30));

        txtPosicion.setBackground(new java.awt.Color(255, 255, 255));
        txtPosicion.setForeground(new java.awt.Color(255, 255, 255));
        txtPosicion.setBorder(null);
        jPanel1.add(txtPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 362, 80, 30));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaMenuPrincipalViajero(viajero);
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

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        if(txtNumVuelo.getText().isEmpty() || txtPosicion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una reserva para cancelarla");
        }else {
            int numeroVuelo = Integer.parseInt(txtNumVuelo.getText());
            int numPosicion = Integer.parseInt(txtPosicion.getText());
            Vuelo vuelo = controlador.vueloBuscado(numeroVuelo);
            try {
                controlador.cancelarReserva(numPosicion, vuelo, viajero);
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente la reserva");
                actualizarTabla();
            } catch (Minimo2DiasDiferenciaException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } 
        }   
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla");
            return; 
        }
        txtNumVuelo.setText(modelo.getValueAt(row,0).toString());
        txtPosicion.setText(modelo.getValueAt(row,2).toString());

    }//GEN-LAST:event_tablaMouseClicked

    private void actualizarTabla(){
        
        LSE<Reserva> reservas = controlador.obtenerReservas(viajero);
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
            try{
                for (int i = 0; i < reservas.size() ; i++) {
                    Reserva aux = reservas.get(i);                   
                    Object[] ob = {aux.getVuelo().getNumVuelo(), aux.getCodigo(), aux.getPosicion(), aux.getVuelo().getFechaVuelo()  ,aux.getVuelo().getHoraVuelo(), aux.getVuelo().getOrigen(), aux.getVuelo().getDiaFinVuelo(), aux.getVuelo().getTiempoFin(), aux.getVuelo().getDestino(), aux.getEstado()};
                    modelo.addRow(ob);                
                }
            }catch(NullPointerException e){        
            }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNumVuelo;
    private javax.swing.JTextField txtPosicion;
    // End of variables declaration//GEN-END:variables
}
