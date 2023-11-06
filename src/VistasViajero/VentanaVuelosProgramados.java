package VistasViajero;

import Controladores.ControladorVentanaVuelosProgramados;
import Modelos.Aerolinea;
import Modelos.Avion;
import Modelos.Viajero;
import Modelos.Vuelo;
import Util.LSE;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diaza
 */
public class VentanaVuelosProgramados extends javax.swing.JFrame {

    private Viajero viajero;
    private ControladorVentanaVuelosProgramados controlador;
    DefaultTableModel modelo;
        
    /**
     * Creates new form VentanaVuelosProgramados
     */
    public VentanaVuelosProgramados(Viajero viajero) {
        initComponents();
        this.viajero = viajero;
        this.controlador = new ControladorVentanaVuelosProgramados();
        modelo = (DefaultTableModel)tabla.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cboAerolineas = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboOrigen = new javax.swing.JComboBox<>();
        cboDestino = new javax.swing.JComboBox<>();
        dataChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBackground(new java.awt.Color(255, 255, 255));
        tabla.setForeground(new java.awt.Color(65, 92, 117));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Avión", "Duración", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(5).setResizable(false);
            tabla.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 560, 220));

        cboAerolineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAerolineasActionPerformed(evt);
            }
        });
        jPanel1.add(cboAerolineas, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Seleccione una Aerolínea");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 190, -1));

        jPanel2.setBackground(new java.awt.Color(65, 92, 117));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar reserva");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 190, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(65, 92, 117));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fecha");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 50, -1));

        txtNum.setEditable(false);
        jPanel1.add(txtNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 50, -1));

        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setText("N° vuelo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, 20));

        cboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Argentina", "Brasil", "Peru", "Chile", "Ecuador", "Colombia", "Uruguay", "Venezuela", "Paraguay", "Bolivia" }));
        cboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOrigenActionPerformed(evt);
            }
        });
        jPanel1.add(cboOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 130, -1));

        cboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Argentina", "Brasil", "Peru", "Chile", "Ecuador", "Colombia", "Uruguay", "Venezuela", "Paraguay", "Bolivia" }));
        cboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDestinoActionPerformed(evt);
            }
        });
        jPanel1.add(cboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 130, -1));

        dataChooserFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dataChooserFechaPropertyChange(evt);
            }
        });
        jPanel1.add(dataChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 130, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Filtros");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 50, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(65, 92, 117));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Origen");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Origen");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 50, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(65, 92, 117));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Destino");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 50, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
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

    private void cboAerolineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAerolineasActionPerformed
        String nombre = (String) cboAerolineas.getSelectedItem();
        if(nombre.equals("-Ver Todos-")){
            String[] titulos8 = new String[] {"N° Avión", "Duración", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolínea"};
            modelo.setColumnIdentifiers(titulos8);
            tabla.setModel(modelo);
            actualizarTablaTodos();
        }else {
            Aerolinea aerolineaBuscada = controlador.buscarAerolineaNombre(nombre);
            actualizarTablaUno(aerolineaBuscada.getCodigoAerolinea());
        }
    }//GEN-LAST:event_cboAerolineasActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int numero = Integer.parseInt(txtNum.getText());
        Avion avion = controlador.buscarNumeroAvion(numero);
        if(avion != null){
            this.dispose();
            JFrame v2 = new VentanaReservaVueloViajero(viajero, avion);
            v2.setVisible(true); 
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int row = tabla.getSelectedRow();
        txtNum.setText(modelo.getValueAt(row,5).toString());
    }//GEN-LAST:event_tablaMouseClicked

    private void cboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrigenActionPerformed
         filtrarVuelos();
    }//GEN-LAST:event_cboOrigenActionPerformed

    private void dataChooserFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dataChooserFechaPropertyChange
        filtrarVuelos();
    }//GEN-LAST:event_dataChooserFechaPropertyChange

    private void cboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDestinoActionPerformed
        filtrarVuelos();
    }//GEN-LAST:event_cboDestinoActionPerformed

    public void filtrarVuelos() {
        int filtrosSeleccionados = 0;
        Date x = dataChooserFecha.getDate();
        String origen = "";
        String destino = "";

        if (cboOrigen.getSelectedIndex() != 0) {
            filtrosSeleccionados++;
            origen = String.valueOf(cboOrigen.getSelectedItem());
        }
        if (cboDestino.getSelectedIndex() != 0) {
            filtrosSeleccionados++;
            destino = String.valueOf(cboDestino.getSelectedItem());
        }
        if (x != null) {
            filtrosSeleccionados++;
        }

        switch (filtrosSeleccionados) {
            case 3:
                LocalDate fecha = new java.sql.Date(x.getTime()).toLocalDate();
                String [] titulos = new String[] {"Fecha", "Origen", "Destino", "Hora Inicio", "Hora Final", "N° Vuelo"};
                modelo.setColumnIdentifiers(titulos);
                tabla.setModel(modelo);
                actualizarTabla3Radio(origen, destino, fecha);
                break;
            case 2:
                if (cboOrigen.getSelectedIndex() != 0 && cboDestino.getSelectedIndex() != 0) {
                    String [] titulos2 = new String[] {"Origen", "Destino", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos2);
                    tabla.setModel(modelo);
                    actualizarTablaDesIni(origen, destino);
                } else if (x != null && cboOrigen.getSelectedIndex() != 0) {
                    LocalDate fecha2 = new java.sql.Date(x.getTime()).toLocalDate();
                    String [] titulos3 = new String[] {"Fecha", "Origen", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos3);
                    tabla.setModel(modelo);
                    actualizarTablaFechaOri(origen, fecha2);
                } else if (x != null && cboDestino.getSelectedIndex() != 0) {
                    LocalDate fecha3 = new java.sql.Date(x.getTime()).toLocalDate();
                    String [] titulos4 = new String[] {"Fecha", "Destino", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos4);
                    tabla.setModel(modelo);
                    actualizarTablaFechaDestino(destino, fecha3);
                }
                break;
            case 1:
                if (x != null) {
                    LocalDate fecha4 = new java.sql.Date(x.getTime()).toLocalDate();
                    String[] titulos5 = new String[] {"Fecha", "Duración", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos5);
                    tabla.setModel(modelo);
                    actualizaFecha(fecha4);
                } else if (cboOrigen.getSelectedIndex() != 0) {
                     String [] titulos6 = new String[] {"Origen", "Duración", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos6);
                    tabla.setModel(modelo);
                    actualizaOrigen(origen);
                } else if (cboDestino.getSelectedIndex() != 0) {
                    String [] titulos7 = new String[] {"Destino", "Duración", "Capitan", "Hora Inicio", "Hora Final", "N° Vuelo", "Aerolinea"};
                    modelo.setColumnIdentifiers(titulos7);
                    tabla.setModel(modelo);
                    actualizaDestino(destino);
                }
                break;
            default:
        }
    }
    
    public void actualizarComboBox() {
        cboAerolineas.removeAllItems();
        LSE<String> lista = new LSE<>();

        try {
            LSE<Aerolinea> listaAerolineas = controlador.traerAerolineas();
            for (int i = 0; i < listaAerolineas.size(); i++) {
                Aerolinea aerlineas = listaAerolineas.get(i);
                String nombres = aerlineas.getNombreAerolinea();
                lista.add(nombres);
            }
            cboAerolineas.addItem("-Ver Todos-");
            for (int i = 0; i < lista.size(); i++) {
                String item = lista.get(i);
                cboAerolineas.addItem(item);
            }
        } catch (Exception e) {
        }
    }
    
    private void actualizarTablaUno(int codigo){
        LSE<Vuelo> vuelos = controlador.obtenerVuelosUnaAerolinea(codigo);
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                Object[] ob = {aux.getAvion().getNumero(), aux.getDuracion(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                modelo.addRow(ob);                    
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizarTablaTodos(){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                Object[] ob = {aux.getAvion().getNumero(), aux.getDuracion(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(),  aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                modelo.addRow(ob);                    
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizarTabla3Radio(String origen, String destino, LocalDate fecha){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getDestino(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob); 
                }                   
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizarTablaDesIni(String origen, String destino){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getOrigen().equals(origen) && aux.getDestino().equals(destino)){
                    Object[] ob = {aux.getOrigen(), aux.getDestino(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);   
                }                     
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizarTablaFechaOri(String origen, LocalDate fecha){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getFechaVuelo().equals(fecha) && aux.getOrigen().equals(origen)){
                    Object[] ob = {aux.getFechaVuelo(), aux.getOrigen(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);    
                }                  
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizarTablaFechaDestino(String destino, LocalDate fecha){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getFechaVuelo().equals(fecha) && aux.getDestino().equals(destino)){
                    Object[] ob = {aux.getFechaVuelo(), aux.getDestino(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);    
                }                   
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizaFecha(LocalDate fecha){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getFechaVuelo().equals(fecha)){
                   Object[] ob = {aux.getFechaVuelo(), aux.getDuracion(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);    
                }                                
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizaOrigen(String origen){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i);
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getOrigen().equals(origen)){
                  Object[] ob = {aux.getOrigen(), aux.getDuracion(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);    
                }                               
            }
        }catch(NullPointerException e){        
        }
    }
    
    private void actualizaDestino(String destino){
        LSE<Vuelo> vuelos = controlador.obtenerTodosVuelos();
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }   
            }
        }catch(NullPointerException e){
        }
        try{
            for (int i = 0; i < vuelos.size() ; i++) {
                Vuelo aux = vuelos.get(i); 
                Aerolinea aerolinea = controlador.buscarAerolineaNumeroAvion(aux.getAvion().getNumero());
                if(aux.getDestino().equals(destino)){
                    Object[] ob = {aux.getDestino(), aux.getDuracion(), aux.getCapitan().getNombres(), aux.getHoraVuelo(), aux.getTiempoFin(), aux.getNumVuelo(), aerolinea.getNombreAerolinea()};
                    modelo.addRow(ob);   
                }                       
            }
        }catch(NullPointerException e){        
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JComboBox<String> cboAerolineas;
    private javax.swing.JComboBox<String> cboDestino;
    private javax.swing.JComboBox<String> cboOrigen;
    private com.toedter.calendar.JDateChooser dataChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
