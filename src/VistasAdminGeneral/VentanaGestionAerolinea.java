package VistasAdminGeneral;

import Controladores.ControladorVentanaGestionAerolinea;
import Excepciones.*;
import Modelos.*;
import Util.LSE;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diaza
 */
public class VentanaGestionAerolinea extends javax.swing.JFrame {

    private ControladorVentanaGestionAerolinea controlador;
    Date hoy = new Date();
    LocalDate fecha = new  java.sql.Date(hoy.getTime()).toLocalDate();

    /**
     * Creates new form VentanaGestionAerolinea
     */
    public VentanaGestionAerolinea() {
        initComponents();
        this.controlador = new ControladorVentanaGestionAerolinea();
        txtFechaRegistro.setText(fecha.toString());
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cboGenero = new javax.swing.JComboBox<>();
        txtFechaRegistro = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        txtConfirmarContrasenia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Código = new javax.swing.JLabel();
        txtNombreAerolinea = new javax.swing.JTextField();
        txtCodigoAerolinea = new javax.swing.JTextField();
        Código1 = new javax.swing.JLabel();
        txtPaisAerolinea = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        panelRegistro = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnVolver = new javax.swing.JMenu();
        btnRegresar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(65, 92, 117));
        jLabel4.setText("Confirme su contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        jLabel5.setForeground(new java.awt.Color(65, 92, 117));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 70, -1));

        jLabel6.setForeground(new java.awt.Color(65, 92, 117));
        jLabel6.setText("Nombres");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel9.setForeground(new java.awt.Color(65, 92, 117));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Identificación");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 80, -1));

        jLabel10.setForeground(new java.awt.Color(65, 92, 117));
        jLabel10.setText("Fecha registro");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, -1));

        jLabel11.setForeground(new java.awt.Color(65, 92, 117));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Télefono");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 60, -1));

        jLabel13.setForeground(new java.awt.Color(65, 92, 117));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Usuario ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 50, -1));

        jLabel8.setForeground(new java.awt.Color(65, 92, 117));
        jLabel8.setText("Edad");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel12.setForeground(new java.awt.Color(65, 92, 117));
        jLabel12.setText("Género");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, -1));

        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 120, -1));

        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, -1));

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Masculino", "Femenino" }));
        jPanel1.add(cboGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 120, -1));

        txtFechaRegistro.setEditable(false);
        jPanel1.add(txtFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 120, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 120, -1));
        jPanel1.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 120, -1));
        jPanel1.add(txtConfirmarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 92, 117));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Aerolinea");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(65, 92, 117));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Registrar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 270, 10));

        jLabel15.setForeground(new java.awt.Color(65, 92, 117));
        jLabel15.setText("Apellidos");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(65, 92, 117));
        jLabel16.setText("Información de la Aerolínea");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 190, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(65, 92, 117));
        jLabel17.setText("Información del administrador Aerolínea");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 30));

        jLabel7.setForeground(new java.awt.Color(65, 92, 117));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 120, -1));

        Código.setForeground(new java.awt.Color(65, 92, 117));
        Código.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Código.setText("Pais");
        jPanel1.add(Código, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 120, -1));
        jPanel1.add(txtNombreAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 120, -1));

        txtCodigoAerolinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoAerolineaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigoAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 120, -1));

        Código1.setForeground(new java.awt.Color(65, 92, 117));
        Código1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Código1.setText("Código");
        jPanel1.add(Código1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 120, -1));
        jPanel1.add(txtPaisAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 120, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 20, 440));

        panelRegistro.setBackground(new java.awt.Color(65, 92, 117));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(panelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 190, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aeropuer.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aerolinea.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 70, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
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

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        if(txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtIdentificacion.getText().isEmpty() || txtEdad.getText().isEmpty() || txtTelefono.getText().isEmpty() || cboGenero.getSelectedIndex() == 0 || txtFechaRegistro.getText().isEmpty() || txtContrasenia.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtConfirmarContrasenia.getText().isEmpty() || !txtContrasenia.getText().equals(txtConfirmarContrasenia.getText()) || txtCodigoAerolinea.getText().isEmpty() || txtNombreAerolinea.getText().isEmpty() || txtPaisAerolinea.getText().isEmpty()) {
            if(!txtContrasenia.getText().equals(txtConfirmarContrasenia.getText())){
                JOptionPane.showMessageDialog( null , "Las contraseñas NO coinciden");
                return;
            }else {
                JOptionPane.showMessageDialog(null, "Existen campos obligatorios por completar");
                return;
            }
        }else {
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String identificacion = txtIdentificacion.getText();
            String genero = String.valueOf(cboGenero.getSelectedItem());
            String telefono = txtTelefono.getText();
            String fechaRegistro = txtFechaRegistro.getText();
            String correo = txtCorreo.getText();
            String contrasenia = txtContrasenia.getText();
            String nombreAerolinea = txtNombreAerolinea.getText();
            int codigoAerolinea = Integer.parseInt(txtCodigoAerolinea.getText());
            String pais = txtPaisAerolinea.getText();
            AdministradorAerolinea administradorAerolinea = new AdministradorAerolinea(fecha, identificacion, nombres, apellidos, edad, genero, telefono, correo, contrasenia, "Administrador Aerolinea");
            Aerolinea aerolinea = new Aerolinea(nombreAerolinea, codigoAerolinea, pais, new LSE<>());

            try{
                controlador.guardarAerolinea(aerolinea, administradorAerolinea);
                JOptionPane.showMessageDialog(null, "Se registró correctamente la aerolinea " + nombreAerolinea + "\n con Administrador de Aerolinea: " + nombres + " " + apellidos);
                limpiarCampos();
            }catch (CodigoAerolineaExisteException | CorreoRegistradoException | AdminAeroRegistradoException | GestorRegistradoException | CapitanVueloRegistradoException | EmpleadoLogisticaRegistradoException | InformacionViajeroException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        panelRegistro.setBackground(new Color(100, 128, 152));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        panelRegistro.setBackground(new Color(65, 92, 117));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        JFrame v2 = new VentanaVerAerolineas();
        v2.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if(!numeros){
            evt.consume();
        }
        if(txtEdad.getText().trim().length() == 2){
            evt.consume();
        }  
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if(!numeros){
            evt.consume();
        }
        if(txtIdentificacion.getText().trim().length() == 10){
            evt.consume();
        }  
    }//GEN-LAST:event_txtIdentificacionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if(!numeros){
            evt.consume();
        }
        if(txtTelefono.getText().trim().length() == 10){
            evt.consume();
        }  
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCodigoAerolineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoAerolineaKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if(!numeros){
            evt.consume();
        }
        if(txtCodigoAerolinea.getText().trim().length() == 15){
            evt.consume();
        }  
    }//GEN-LAST:event_txtCodigoAerolineaKeyTyped

    public void limpiarCampos() {
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtEdad.setText(null);
        txtIdentificacion.setText(null);
        cboGenero.setSelectedIndex(0);
        txtTelefono.setText(null);
        txtCorreo.setText(null);
        txtContrasenia.setText(null);
        txtConfirmarContrasenia.setText(null);
        txtCodigoAerolinea.setText(null);
        txtNombreAerolinea.setText(null);
        txtPaisAerolinea.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Código;
    private javax.swing.JLabel Código1;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JMenu btnRegresar;
    private javax.swing.JMenu btnVolver;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigoAerolinea;
    private javax.swing.JTextField txtConfirmarContrasenia;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombreAerolinea;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPaisAerolinea;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
