package VistasEmpleadoLogistica;

import Controladores.ControladorVentanaGestionVuelos;
import Excepciones.*;
import Modelos.*;
import Util.Cola;
import Util.LSE;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class VentanaGestionVuelos extends javax.swing.JFrame {

    private EmpleadoLogistica empleadoLogistica;
    private ControladorVentanaGestionVuelos controlador;

    /**
     * Creates new form VentanaGestionVuelos
     */
    public VentanaGestionVuelos(EmpleadoLogistica empleadoLogistica) {
        initComponents();
        this.empleadoLogistica = empleadoLogistica;
        this.controlador = new ControladorVentanaGestionVuelos();
        dataChooserFecha.setMinSelectableDate(new Date());
        actualizarComboBoxAviones();
        actualizarComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroVuelo = new javax.swing.JTextField();
        cboCapitanVuelo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dataChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cboInicioHora = new javax.swing.JComboBox<>();
        cboInicioMin = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGestion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDuracionHoras = new javax.swing.JTextField();
        cboDestino = new javax.swing.JComboBox<>();
        cboOrigen = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cboAviones = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();
        btZ = new javax.swing.JMenuItem();
        btY = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vuelos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 92, 117));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Agregar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 110, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 330, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aleta.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, 70));

        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setText("N° vuelo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));
        jPanel1.add(txtNumeroVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 130, -1));

        jPanel1.add(cboCapitanVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 130, -1));

        jLabel8.setForeground(new java.awt.Color(65, 92, 117));
        jLabel8.setText("Min Inicio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jLabel9.setForeground(new java.awt.Color(65, 92, 117));
        jLabel9.setText("Capitán de vuelo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setText("Destino");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        dataChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dataChooserFechaPropertyChange(evt);
            }
        });
        jPanel1.add(dataChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 130, -1));

        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setText("Aviones de la Aerolínea");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        cboInicioHora.setForeground(new java.awt.Color(0, 0, 0));
        cboInicioHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboInicioHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboInicioHoraActionPerformed(evt);
            }
        });
        jPanel1.add(cboInicioHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 70, 30));

        cboInicioMin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cboInicioMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 70, 30));

        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Duración (En horas)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        jPanel2.setBackground(new java.awt.Color(65, 92, 117));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 160, 30));

        jPanel3.setBackground(new java.awt.Color(65, 92, 117));

        btnGestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGestion.setForeground(new java.awt.Color(255, 255, 255));
        btnGestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGestion.setText("Gestionar vuelos");
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
            .addComponent(btnGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 160, -1));

        jPanel4.setBackground(new java.awt.Color(65, 92, 117));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 160, -1));

        jLabel13.setForeground(new java.awt.Color(65, 92, 117));
        jLabel13.setText("Origen");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));
        jPanel1.add(txtDuracionHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 100, 30));

        cboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Argentina", "Brasil", "Peru", "Chile", "Ecuador", "Colombia", "Uruguay", "Venezuela", "Paraguay", "Bolivia" }));
        jPanel1.add(cboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, -1));

        cboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Argentina", "Brasil", "Peru", "Chile", "Ecuador", "Colombia", "Uruguay", "Venezuela", "Paraguay", "Bolivia" }));
        jPanel1.add(cboOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 130, -1));

        jLabel15.setForeground(new java.awt.Color(65, 92, 117));
        jLabel15.setText("Hora Inicio");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jPanel5.setBackground(new java.awt.Color(65, 92, 117));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 20, 70));

        jPanel6.setBackground(new java.awt.Color(65, 92, 117));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 10, -1));

        jPanel7.setBackground(new java.awt.Color(65, 92, 117));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 10, -1));

        jPanel8.setBackground(new java.awt.Color(65, 92, 117));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jPanel1.add(cboAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 130, -1));

        jLabel16.setForeground(new java.awt.Color(65, 92, 117));
        jLabel16.setText("Fecha");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

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

        btZ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btZ.setText("Deshacer");
        btZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btZActionPerformed(evt);
            }
        });
        btnVolver.add(btZ);

        btY.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btY.setText("Rehacer");
        btY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btYActionPerformed(evt);
            }
        });
        btnVolver.add(btY);

        jMenuBar1.add(btnVolver);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        this.dispose();
        JFrame v2 = new VentanaMenuPrincipalEmpleadoLogistica(empleadoLogistica);
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

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(cboOrigen.getSelectedItem().equals(cboDestino.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Seleccione diferentes paises para realizar el vuelo"); 
            return;
        }
        
        if(cboAviones.getSelectedIndex() == 0 || txtNumeroVuelo.getText().isEmpty() || cboOrigen.getSelectedIndex() == 0 || cboDestino.getSelectedIndex() == 0 || dataChooserFecha.getDate() == null || cboInicioHora.getSelectedIndex() == -1 || cboInicioMin.getSelectedIndex() == -1 || cboCapitanVuelo.getSelectedIndex() == 0 || txtDuracionHoras.getText().isEmpty()) {
            if(cboCapitanVuelo.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione un capitán de vuelo");
            }else if(cboInicioHora.getSelectedIndex() == -1 || cboInicioMin.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos de horarios");
            }else if(dataChooserFecha.getDate() == null){
                JOptionPane.showMessageDialog(null, "Seleccione una fecha para el vuelo");
            }else if(cboAviones.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione un avión");
            }else{
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        }else {
            int numero = Integer.parseInt(txtNumeroVuelo.getText());
            String origenSeleccionado = String.valueOf(cboOrigen.getSelectedItem());
            String origen = String.valueOf(origenSeleccionado.toString());
            
            String destinoSeleccionado = String.valueOf(cboDestino.getSelectedItem());
            String destino = String.valueOf(destinoSeleccionado.toString());
            
            Date x = dataChooserFecha.getDate();
            LocalDate fecha = new java.sql.Date(x.getTime()).toLocalDate();

            int hora = Integer.parseInt((String) cboInicioHora.getSelectedItem());
            int min = Integer.parseInt((String) cboInicioMin.getSelectedItem());

            LocalTime horaInicio = LocalTime.of(hora, min); 

            int duracion = Integer.parseInt(txtDuracionHoras.getText());
            LocalTime horaFin = horaInicio.plusHours(duracion);

            int xHour = horaFin.getHour(); 

            xHour = xHour % 24;

            horaFin = LocalTime.of(xHour, horaFin.getMinute());

            String capitanSeleccionado = String.valueOf(cboCapitanVuelo.getSelectedItem());
            String capitanVuelo = String.valueOf(capitanSeleccionado.toString());
            CapitanVuelo capitan = (CapitanVuelo) controlador.buscarCapitanVuelo(capitanVuelo);
            
            String avionSeleccionado = String.valueOf(cboAviones.getSelectedItem());
            int numeroAvion = Integer.parseInt(avionSeleccionado);
            Avion avionBuscado = controlador.buscarNumeroAvion(numeroAvion);
            
            Vuelo vueloFinal = new Vuelo(avionBuscado, capitan, numero, origen, destino, duracion, fecha, horaInicio, horaFin, new LSE<>(), "Programado", new Cola<>());
            Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());

            try{
                controlador.guardarVuelo(aerolinea, avionBuscado, vueloFinal);
                JOptionPane.showMessageDialog(null, "Se registró el vuelo correctamente");
                limpiarCampos();
            }catch (AvionEstaEnMantenimientoException | YaExisteNumeroVueloException | CapitanNoDisponibleException | AvionNoDisponibleException | OrigenNoCoincideConDestinoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }   
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void dataChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dataChooserFechaPropertyChange
        actualizarComboBoxHorasMinutos();
    }//GEN-LAST:event_dataChooserFechaPropertyChange

    private void btnGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseClicked
        this.dispose();
        JFrame v2 = new VentanaVerVuelos(empleadoLogistica);
        v2.setVisible(true);
    }//GEN-LAST:event_btnGestionMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void cboInicioHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboInicioHoraActionPerformed
        Object horaSeleccionadaObject = cboInicioHora.getSelectedItem();
        if (horaSeleccionadaObject != null) {
            int horaSeleccionada = Integer.parseInt(horaSeleccionadaObject.toString());
            actualizarComboBoxMinutos(horaSeleccionada);
        }
    }//GEN-LAST:event_cboInicioHoraActionPerformed

    private void btZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZActionPerformed
        Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());
        if(!controlador.getZ().isEmpty() && aerolinea != null){
            controlador.respaldoY(aerolinea.getCodigoAerolinea());
            controlador.controlZ(aerolinea.getCodigoAerolinea());
        }else{
            JOptionPane.showMessageDialog(rootPane, "No hay acciones por deshacer");
        }
    }//GEN-LAST:event_btZActionPerformed

    private void btYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btYActionPerformed
        Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());
        if(!controlador.getY().isEmpty() && aerolinea != null){
            controlador.respaldoZ(aerolinea.getCodigoAerolinea());
            controlador.controlY(aerolinea.getCodigoAerolinea());
        }else{
            JOptionPane.showMessageDialog(rootPane, "No hay acciones por rehacer");
        }
    }//GEN-LAST:event_btYActionPerformed

    public void limpiarCampos() {
        dataChooserFecha.setDate(null);
        txtNumeroVuelo.setText(null);
        cboOrigen.setSelectedIndex(0);
        cboDestino.setSelectedIndex(0);
        cboAviones.setSelectedIndex(0);
        txtDuracionHoras.setText(null);
        cboInicioHora.removeAllItems();
        cboInicioMin.removeAllItems();
        cboCapitanVuelo.setSelectedIndex(0);
    }
    
    public void actualizarComboBox() {
        cboCapitanVuelo.removeAllItems();
        Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());
        LSE<String> lista = new LSE<>();

        try {
            LSE<CapitanVuelo> listaCapitanes = controlador.conseguirCapitanes(aerolinea);
            for (int i = 0; i < listaCapitanes.size(); i++) {
                CapitanVuelo capitanes = listaCapitanes.get(i);
                String nombres = capitanes.getNombres();
                lista.add(nombres);
            }
            cboCapitanVuelo.addItem("-Seleccionar-");
            for (int i = 0; i < lista.size(); i++) {
                String item = lista.get(i);
                cboCapitanVuelo.addItem(item);
            }
        } catch (Exception e) {
        }
    }
    
    public void actualizarComboBoxAviones() {
        cboAviones.removeAllItems();
        Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());
        LSE<String> lista = new LSE<>();

        try {
            LSE<Avion> listaAviones = controlador.conseguirAviones(aerolinea);
            for (int i = 0; i < listaAviones.size(); i++) {
                Avion avion = listaAviones.get(i);
                String nombres = String.valueOf(avion.getNumero());
                lista.add(nombres);
            }
            cboAviones.addItem("-Seleccionar-");
            for (int i = 0; i < lista.size(); i++) {
                String item = lista.get(i);
                cboAviones.addItem(item);
            }
        } catch (Exception e) {
        }
    }
    
    private void actualizarComboBoxHorasMinutos() {
        Date selectedDate = dataChooserFecha.getDate();

        if (selectedDate != null) {
            Calendar calHoy = Calendar.getInstance();
            Calendar calSeleccionado = Calendar.getInstance();
            calSeleccionado.setTime(selectedDate);

            int horaActual = calHoy.get(Calendar.HOUR_OF_DAY);

            cboInicioHora.removeAllItems();

            if (calSeleccionado.get(Calendar.YEAR) == calHoy.get(Calendar.YEAR)
                    && calSeleccionado.get(Calendar.MONTH) == calHoy.get(Calendar.MONTH)
                    && calSeleccionado.get(Calendar.DAY_OF_MONTH) == calHoy.get(Calendar.DAY_OF_MONTH)) {
                for (int i = horaActual; i < 24; i++) {
                    cboInicioHora.addItem(String.format("%02d", i));
                }
            } else {
                for (int i = 0; i < 24; i++) {
                    cboInicioHora.addItem(String.format("%02d", i));
                }
            }
        }
    }

    private void actualizarComboBoxMinutos(int horaSeleccionada) {
        Date selectedDate = dataChooserFecha.getDate();

        if (selectedDate != null) {
            Calendar calHoy = Calendar.getInstance();
            Calendar calSeleccionado = Calendar.getInstance();
            calSeleccionado.setTime(selectedDate);

            int horaActual = calHoy.get(Calendar.HOUR_OF_DAY);

            cboInicioMin.removeAllItems();

            if(calSeleccionado.get(Calendar.YEAR) == calHoy.get(Calendar.YEAR)
                    && calSeleccionado.get(Calendar.MONTH) == calHoy.get(Calendar.MONTH)
                    && calSeleccionado.get(Calendar.DAY_OF_MONTH) == calHoy.get(Calendar.DAY_OF_MONTH)) {
                if (horaSeleccionada == horaActual) {
                    int minutoActual = calHoy.get(Calendar.MINUTE);
                    for (int i = minutoActual + 1; i < 60; i++) {
                        cboInicioMin.addItem(String.format("%02d", i));
                    }
                }else {
                    for (int i = 0; i < 60; i++) {
                        cboInicioMin.addItem(String.format("%02d", i));
                    }
                }
            }else {
                for (int i = 0; i < 60; i++) {
                    cboInicioMin.addItem(String.format("%02d", i));
                }
            }
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btY;
    private javax.swing.JMenuItem btZ;
    private javax.swing.JLabel btnGestion;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnLimpiar;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JComboBox<String> cboAviones;
    private javax.swing.JComboBox<String> cboCapitanVuelo;
    private javax.swing.JComboBox<String> cboDestino;
    private javax.swing.JComboBox<String> cboInicioHora;
    private javax.swing.JComboBox<String> cboInicioMin;
    private javax.swing.JComboBox<String> cboOrigen;
    private com.toedter.calendar.JDateChooser dataChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDuracionHoras;
    private javax.swing.JTextField txtNumeroVuelo;
    // End of variables declaration//GEN-END:variables
}
