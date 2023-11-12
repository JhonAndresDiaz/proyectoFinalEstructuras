package VistasViajero;

import Controladores.ControladorVerAvion;
import Modelos.Avion;
import Modelos.Reserva;
import Modelos.Viajero;
import Modelos.Vuelo;
import Util.LSE;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class VentanaReservaVueloViajero extends javax.swing.JFrame implements ActionListener {

    private Viajero viajero;
    private Vuelo vuelo;
    private ControladorVerAvion controlador;
    JButton[][] botones;
    
    /**
     * Creates new form VentanaReservaVueloViajero
     */
    public VentanaReservaVueloViajero(Viajero viajero, Vuelo vuelo) {
        initComponents();
        this.viajero = viajero;
        this.vuelo = vuelo;
        this.controlador = new ControladorVerAvion();
        Avion avion = vuelo.getAvion();
        if (avion != null) { 
            int columnas = 0;
            if (avion.getBloque() == 2) {
                columnas = 4;
            } else {
                columnas = 6;
            }
            botones = new JButton[avion.getFila()][columnas];
            cargarAsientos();
        } else {
        }
        txtNumVuelo.setText(String.valueOf(vuelo.getNumVuelo()));
        txtOrigen.setText(vuelo.getOrigen());
        txtDestino.setText(vuelo.getDestino());
        txtFechaIni.setText(String.valueOf(vuelo.getFechaVuelo()));
        txtFechaFin.setText(String.valueOf(vuelo.getDiaFinVuelo()));
        txtHoraInicio.setText(String.valueOf(vuelo.getHoraVuelo()));
        txtHoraFin.setText(String.valueOf(vuelo.getTiempoFin()));
        modificarAsientos(vuelo.getListaReservas());
        bloquear();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumVuelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtFechaIni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoraFin = new javax.swing.JTextField();
        txtHoraInicio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(65, 92, 117));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 30, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 92, 117));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estado de asientos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 92, 117));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Propio");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 70, 20));

        txtNumVuelo.setEditable(false);
        txtNumVuelo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtNumVuelo.setForeground(new java.awt.Color(65, 92, 117));
        txtNumVuelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtNumVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 100, -1));

        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setText("N° vuelo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setText("Origen");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        jLabel5.setForeground(new java.awt.Color(65, 92, 117));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Destino");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 50, 20));

        txtFechaFin.setEditable(false);
        txtFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtFechaFin.setForeground(new java.awt.Color(65, 92, 117));
        txtFechaFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 100, -1));

        txtOrigen.setEditable(false);
        txtOrigen.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtOrigen.setForeground(new java.awt.Color(65, 92, 117));
        txtOrigen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 100, -1));

        txtDestino.setEditable(false);
        txtDestino.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtDestino.setForeground(new java.awt.Color(65, 92, 117));
        txtDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 100, -1));

        txtFechaIni.setEditable(false);
        txtFechaIni.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtFechaIni.setForeground(new java.awt.Color(65, 92, 117));
        txtFechaIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtFechaIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, -1));

        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha Ini");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 70, 20));

        jLabel7.setForeground(new java.awt.Color(65, 92, 117));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fecha Fin");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 20));

        jLabel8.setForeground(new java.awt.Color(65, 92, 117));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hora inicio");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, 20));

        txtHoraFin.setEditable(false);
        txtHoraFin.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtHoraFin.setForeground(new java.awt.Color(65, 92, 117));
        txtHoraFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 100, -1));

        txtHoraInicio.setEditable(false);
        txtHoraInicio.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtHoraInicio.setForeground(new java.awt.Color(65, 92, 117));
        txtHoraInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 100, -1));

        jPanel4.setBackground(java.awt.Color.blue);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 30, 20));

        jPanel5.setBackground(java.awt.Color.green);
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 30, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(65, 92, 117));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Información del vuelo");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, -1));

        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Hora fin");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 70, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reservado");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 70, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Desocupado");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 70, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(441, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaVuelosProgramados(viajero);
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
   
    private void cargarAsientos() {
        int ancho = 55;
        int alto = 55;
        int separado = 30;
        int separadoAlt = 25;
        int texto = 1;
        boolean espacioEnMedio = true;

        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBounds(
                    (j * ancho + separado),
                    (i * alto + separadoAlt),
                    ancho, alto);
                botones[i][j].setText(String.valueOf(texto));
                botones[i][j].addActionListener(this);
                jPanel1.add(botones[i][j]);
                texto++;

                if (espacioEnMedio && j == botones[i].length / 2 - 1) {
                    separado += ancho; 
                }
            }
            separado = 30;
            separadoAlt += 7;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        if (boton.getBackground() == Color.BLUE) {
            
        }else if (boton.getBackground() == Color.WHITE) {
            int numeroAsiento = Integer.parseInt(boton.getText());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea reservar el asiento #" + numeroAsiento + "?", "Reservar asiento", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    controlador.generarReserva(numeroAsiento,vuelo ,viajero);
                    modificarAsientos(vuelo.getListaReservas());
                    bloquear();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }else if(boton.getBackground() == Color.GREEN){
            JOptionPane.showMessageDialog(null, "Este asiento esta reservado por usted"
                    + "\n La información es "
                    + "\n Nombres y apellidos: "+ viajero.getNombres() + " " + viajero.getApellidos()
                    + "\n Número de identificación: " + viajero.getIdentificacion()
                    + "\n Edad: " + viajero.getEdad()
                    + "\n Género: " + viajero.getGenero()
                    + "\n Teléfono: " + viajero.getNumTelefono()
                    + "\n Pais de nacimiento: " + viajero.getPaisNacimiento());
        }
    }
    
    public void modificarAsientos(LSE<Reserva> listaReservas) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                JButton boton = botones[i][j];
                int numeroAsiento = Integer.parseInt(boton.getText());
                boolean estaReservado = controlador.verificarReserva(numeroAsiento, vuelo.getListaReservas());
                boolean estaReservado2 = controlador.verificarReservaPropia(numeroAsiento, vuelo.getListaReservas(), viajero);
                if (estaReservado && !estaReservado2) {   
                    boton.setBackground(Color.BLUE);
                }else if(estaReservado && estaReservado2){    
                    boton.setBackground(Color.GREEN);
                }else {                 
                    boton.setBackground(Color.WHITE); 
                }
            }
        }
    }
     
    public void bloquear(){
        
        LSE<Reserva> contador = controlador.validar1ReservaVuelo(viajero, vuelo);
        
        if(contador.size() >= 1) {
            JOptionPane.showMessageDialog(null, "Ha cumplido el máximo de 1 reserva por vuelo");
            for (int i = 0; i < botones.length; i++) {
                for (int j = 0; j < botones[i].length; j++) {
                    JButton boton = botones[i][j];
                    int numeroAsiento = Integer.parseInt(boton.getText());
                    boolean estaReservado = controlador.verificarReserva(numeroAsiento, vuelo.getListaReservas());
                    boolean estaReservado2 = controlador.verificarReservaPropia(numeroAsiento, vuelo.getListaReservas(), viajero);
                    if (estaReservado && !estaReservado2) {   
                        boton.setBackground(Color.BLUE);
                    }else if(estaReservado && estaReservado2){    
                        boton.setBackground(Color.GREEN);
                    }else {                 
                        boton.setEnabled(false); 
                    }
                }
            }
        }        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaIni;
    private javax.swing.JTextField txtHoraFin;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtNumVuelo;
    private javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables

}
