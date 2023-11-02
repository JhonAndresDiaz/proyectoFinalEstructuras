package VistasEmpleadoLogistica;

import Controladores.ControladorVentanaGestionVuelos;
import Excepciones.*;
import Modelos.*;
import Util.LSE;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diaza
 */
public class VentanaGestionVuelos extends javax.swing.JFrame {

    private EmpleadoLogistica empleadoLogistica;
    private ControladorVentanaGestionVuelos controlador;
    DefaultTableModel modelo;
      
    /**
     * Creates new form VentanaGestionVuelos
     */
    public VentanaGestionVuelos(EmpleadoLogistica empleadoLogistica) {
        initComponents();
        this.empleadoLogistica = empleadoLogistica;
        this.controlador = new ControladorVentanaGestionVuelos();
        modelo = (DefaultTableModel)tabla.getModel();
        dataChooserFecha.setMinSelectableDate(new Date());
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroVuelo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        cboCapitanVuelo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtNombreAerolinea = new javax.swing.JTextField();
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
        txtOrigen = new javax.swing.JTextField();
        txtNumeroAvion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtDuracionHoras = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Vuelos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 92, 117));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Agregar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aleta.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 60, 70));

        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setText("N° vuelo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel1.add(txtNumeroVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        jLabel7.setForeground(new java.awt.Color(65, 92, 117));
        jLabel7.setText("N°");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 20, 30, -1));
        jPanel1.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 130, -1));

        jPanel1.add(cboCapitanVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 120, -1));

        jLabel8.setForeground(new java.awt.Color(65, 92, 117));
        jLabel8.setText("Hora Inicio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        tabla.setBackground(new java.awt.Color(255, 255, 255));
        tabla.setForeground(new java.awt.Color(65, 92, 117));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aerolinea", "Numero Avión", "Filas", "Bloques"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionBackground(new java.awt.Color(65, 92, 117));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
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
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 400, 150));

        jLabel9.setForeground(new java.awt.Color(65, 92, 117));
        jLabel9.setText("Capitán de vuelo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        txtNombreAerolinea.setEditable(false);
        jPanel1.add(txtNombreAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 140, -1));

        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setText("Destino");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        dataChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dataChooserFechaPropertyChange(evt);
            }
        });
        jPanel1.add(dataChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 130, -1));

        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setText("Fecha");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        cboInicioHora.setForeground(new java.awt.Color(0, 0, 0));
        cboInicioHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(cboInicioHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 70, 30));

        cboInicioMin.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cboInicioMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 70, 30));

        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Duración (En horas)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 120, 30));

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
            .addComponent(btnGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGestion, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 120, -1));

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
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, -1));

        jLabel13.setForeground(new java.awt.Color(65, 92, 117));
        jLabel13.setText("Origen");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel1.add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 130, -1));

        txtNumeroAvion.setEditable(false);
        txtNumeroAvion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtNumeroAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 50, -1));

        jLabel17.setForeground(new java.awt.Color(65, 92, 117));
        jLabel17.setText("Seleccione una Avión");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        jPanel1.add(txtDuracionHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 100, 30));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
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

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        txtNombreAerolinea.setText(modelo.getValueAt(row,0).toString());
        txtNumeroAvion.setText(modelo.getValueAt(row,1).toString());
        
        String nombre = txtNombreAerolinea.getText();
        Aerolinea aerolineaBuscada = controlador.buscarAeroNombre(nombre);
        if(aerolineaBuscada != null){
            actualizarComboBox(aerolineaBuscada);
        }else {
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(txtNumeroVuelo.getText().isEmpty() || txtOrigen.getText().isEmpty() || txtDestino.getText().isEmpty() || dataChooserFecha.getDate() == null || cboInicioHora.getSelectedIndex() == -1 || cboInicioMin.getSelectedIndex() == -1 || txtNombreAerolinea.getText().isEmpty() || cboCapitanVuelo.getSelectedIndex() == 0 || txtDuracionHoras.getText().isEmpty()) {
            if(cboCapitanVuelo.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Seleccione un capitán de vuelo");
            }else if(cboInicioHora.getSelectedIndex() == -1 || cboInicioMin.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos de horarios");
            }else if(dataChooserFecha.getDate() == null){
                JOptionPane.showMessageDialog(null, "Seleccione una fecha para el vuelo");
            }else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        }else {
            int numero = Integer.parseInt(txtNumeroVuelo.getText());
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();
            Date x = dataChooserFecha.getDate();
            LocalDate fecha = new  java.sql.Date(x.getTime()).toLocalDate();
            
            int hora = Integer.parseInt((String) cboInicioHora.getSelectedItem());
            int min = Integer.parseInt((String) cboInicioMin.getSelectedItem());
            int duracion = Integer.parseInt(txtDuracionHoras.getText());

            int xHour = duracion + hora;
                if(xHour > 24){
                    xHour  = xHour-24;  
                }else{
                    xHour  = xHour;
                }
                
            LocalTime horaInicio = LocalTime.of(hora, min); 
            LocalTime horaFin = LocalTime.of(xHour, min);

            String capitanSeleccionado = String.valueOf(cboCapitanVuelo.getSelectedItem());
            String capitanVuelo = String.valueOf(capitanSeleccionado.toString());
            CapitanVuelo capitan = (CapitanVuelo) controlador.buscarCapitanVuelo(capitanVuelo);
            
            int numeroAvion = Integer.parseInt(txtNumeroAvion.getText());
            Avion avionBuscado = controlador.buscarNumeroAvion(numeroAvion);
            
            Vuelo vueloFinal = new Vuelo(avionBuscado, capitan, numero, origen, destino, duracion, fecha, horaInicio, horaFin, new LSE<>(), "Espera");
            Aerolinea aerolinea = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());

            try{
                controlador.guardarVuelo(aerolinea, avionBuscado, vueloFinal);
                JOptionPane.showMessageDialog(null, "Se registró el vuelo correctamente");
                limpiarCampos();
                actualizarTabla();
            }catch (YaExisteNumeroVueloException | CapitanNoDisponibleException | AvionNoDisponibleException e) {
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

    public void limpiarCampos() {
        dataChooserFecha.setDate(null);
        txtNumeroVuelo.setText(null);
        txtOrigen.setText(null);
        txtDestino.setText(null);
        txtNombreAerolinea.setText(null);
        txtNumeroAvion.setText(null);
        txtDuracionHoras.setText(null);
        cboInicioHora.setSelectedIndex(0);
        cboInicioMin.setSelectedIndex(0);
        cboCapitanVuelo.setSelectedIndex(0);
    }
    
    public void actualizarComboBox(Aerolinea aerolinea) {
        cboCapitanVuelo.removeAllItems();
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
    
    private void actualizarTabla(){    
        Aerolinea aerolinea2 = controlador.buscarAerolineaPersona(empleadoLogistica.getIdentificacion());
        LSE<Avion> aviones = controlador.conseguirAviones(aerolinea2);
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
            try{
                for (int i = 0; i < aviones.size() ; i++) {
                    Avion aux = aviones.get(i); 
                    Aerolinea aerolinea = controlador.buscarAerolineaAvion(aux.getNumero());
                    Object[] ob = {aerolinea.getNombreAerolinea(), aux.getNumero(), aux.getFila(), aux.getBloque()};
                    modelo.addRow(ob);                    
                }
            }catch(NullPointerException e){        
            }
    }
    
    private void actualizarComboBoxHorasMinutos() {
        Date selectedDate = dataChooserFecha.getDate();

        if (selectedDate != null) {
            Calendar calHoy = Calendar.getInstance();
            Calendar calSeleccionado = Calendar.getInstance();
            calSeleccionado.setTime(selectedDate);

            int horaActual = calHoy.get(Calendar.HOUR_OF_DAY);
            int minutoActual = calHoy.get(Calendar.MINUTE);

            if (calSeleccionado.get(Calendar.YEAR) == calHoy.get(Calendar.YEAR)
                    && calSeleccionado.get(Calendar.MONTH) == calHoy.get(Calendar.MONTH)
                    && calSeleccionado.get(Calendar.DAY_OF_MONTH) == calHoy.get(Calendar.DAY_OF_MONTH)) {
                cboInicioHora.removeAllItems();
                cboInicioMin.removeAllItems();
                if (minutoActual < 30) {
                    for (int i = horaActual; i < 24; i++) {
                        cboInicioHora.addItem(String.valueOf(i));
                    }
                    cboInicioMin.addItem("30");
                }else {
                    for (int i = horaActual + 1; i < 24; i++) {
                        cboInicioHora.addItem(String.valueOf(i));
                    }
                    cboInicioMin.addItem("0");
                    cboInicioMin.addItem("30");
                }
            } else {
                cboInicioHora.removeAllItems();
                cboInicioMin.removeAllItems();
                for (int i = 0; i < 24; i++) {
                    cboInicioHora.addItem(String.valueOf(i));
                }
                cboInicioMin.addItem("0");
                cboInicioMin.addItem("30");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnGestion;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnLimpiar;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JComboBox<String> cboCapitanVuelo;
    private javax.swing.JComboBox<String> cboInicioHora;
    private javax.swing.JComboBox<String> cboInicioMin;
    private com.toedter.calendar.JDateChooser dataChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDuracionHoras;
    private javax.swing.JTextField txtNombreAerolinea;
    private javax.swing.JTextField txtNumeroAvion;
    private javax.swing.JTextField txtNumeroVuelo;
    private javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables
}
