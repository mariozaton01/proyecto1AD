/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Alumno;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

import Controlador.Controlador;
import Clases.*;
import creacionFicheros.AlumnosRelated;

import static creacionFicheros.AlumnosRelated.readFile;

/**
 *
 * @author mario
 */
public class VentanaAñadirRetirarAlum extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAradirRetirarAlum
     */private int opcion;


    public VentanaAñadirRetirarAlum() {
        initComponents();
        try {
                listadoAlumnos(cbAlumnoRetirar);
                // old Controlador.listaAlumnos(cbAlumnoRetirar);
            } catch (Exception ex) {
                Logger.getLogger(VentanaAñadirRetirarAlum.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void listadoAlumnos(JComboBox comboBox) throws IOException {
        //Leemos el fichero de alumnos.
        File file = new File("src/Ficheros/Alumnos.dat");
        ArrayList<Alumno> listaAlum =  readFile(file);
        //Agregamos al comboBox todos los alumnos.
        for (Alumno alum: listaAlum) {
            String nombre= alum.getNombre() +" "+alum.getApellido();
            comboBox.addItem(nombre);
        }
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
        etiquetaAñadirRetirar = new javax.swing.JLabel();
        etNombre = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        etApellido = new javax.swing.JLabel();
        tApellido = new javax.swing.JTextField();
        etiquetaBuscarAlumBorrar = new javax.swing.JLabel();
        cbAlumnoRetirar = new javax.swing.JComboBox<>();
        etFechaNac = new javax.swing.JLabel();
        etDNI = new javax.swing.JLabel();
        tDNI = new javax.swing.JTextField();
        etiquetaDNIborrar = new javax.swing.JLabel();
        tDNIborrar = new javax.swing.JTextField();
        etDireccion = new javax.swing.JLabel();
        tDireccion = new javax.swing.JTextField();
        etCP = new javax.swing.JLabel();
        tCodigoPostal = new javax.swing.JTextField();
        etTelefono = new javax.swing.JLabel();
        tTelefono = new javax.swing.JTextField();
        etEmail = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        bAñadir = new javax.swing.JButton();
        bCancelarAñadir = new javax.swing.JButton();
        tFechaNac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dniusado = new javax.swing.JLabel();
        bBuscarDNI = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etiquetaAñadirRetirar.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        etiquetaAñadirRetirar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaAñadirRetirar.setText("Añadir Alumno");

        etNombre.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etNombre.setText("Nombre:");

        tNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tNombreFocusGained(evt);
            }
        });

        etApellido.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etApellido.setText("Apellido:");

        tApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tApellidoFocusGained(evt);
            }
        });

        etiquetaBuscarAlumBorrar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etiquetaBuscarAlumBorrar.setText("Buscar Alumno:");

        etFechaNac.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etFechaNac.setText("Fecha Nac:");

        etDNI.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etDNI.setText("DNI :");

        tDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tDNIFocusGained(evt);
            }
        });
        tDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDNIActionPerformed(evt);
            }
        });

        etiquetaDNIborrar.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etiquetaDNIborrar.setText("DNI :");

        tDNIborrar.setEditable(false);

        etDireccion.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etDireccion.setText("Direccion:");

        tDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tDireccionFocusGained(evt);
            }
        });

        etCP.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etCP.setText("Codigo Postal:");

        tCodigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tCodigoPostalFocusGained(evt);
            }
        });

        etTelefono.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etTelefono.setText("Telefono:");

        tTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tTelefonoFocusGained(evt);
            }
        });

        etEmail.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        etEmail.setText("Email:");

        tEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tEmailFocusGained(evt);
            }
        });

        bAñadir.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bAñadir.setText("Aceptar");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bAñadirActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        bCancelarAñadir.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bCancelarAñadir.setText("Cancelar");
        bCancelarAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarAñadirActionPerformed(evt);
            }
        });

        tFechaNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tFechaNacFocusGained(evt);
            }
        });

        dniusado.setForeground(new java.awt.Color(255, 51, 51));
        dniusado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dniusado.setText("El DNI ya esta usado*");
        dniusado.setFocusCycleRoot(true);

        bBuscarDNI.setText("Buscar DNI");
        bBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bBuscarDNIActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etTelefono)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(etDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                            .addComponent(tFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(etDNI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(etEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(etCP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(bCancelarAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(etiquetaBuscarAlumBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAlumnoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(etApellido)))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscarDNI)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiquetaDNIborrar)
                        .addGap(28, 28, 28)
                        .addComponent(tDNIborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniusado, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiquetaAñadirRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(etiquetaAñadirRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etNombre)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etApellido)
                    .addComponent(tApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaBuscarAlumBorrar)
                    .addComponent(cbAlumnoRetirar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscarDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etFechaNac)
                    .addComponent(etDNI)
                    .addComponent(tFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniusado))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDNIborrar)
                    .addComponent(tDNIborrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etDireccion)
                    .addComponent(tDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etCP)
                    .addComponent(tCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etTelefono)
                    .addComponent(tTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etEmail)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelarAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tFechaNacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tFechaNacFocusGained
        // TODO add your handling code here:
        tFechaNac.setText("");
        tFechaNac.setForeground(Color.black);
    }//GEN-LAST:event_tFechaNacFocusGained

    private void bCancelarAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarAñadirActionPerformed
        // TODO add your handling code here:
        Controlador.bCancelar(this);
    }//GEN-LAST:event_bCancelarAñadirActionPerformed

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_bAñadirActionPerformed
        // opcion añadir alumno
        if(opcion==0){
            int contErrores = 0;

            if(validarNombre(tNombre.getText())==false){
                tNombre.setText(tNombre.getText()+"*");
                tNombre.setForeground(Color.red);

                contErrores ++;
            }
            else {
                tNombre.setForeground(Color.black);
            }

            if(validarApellido(tApellido.getText())==false){
                tApellido.setText(tApellido.getText()+"*");
                tApellido.setForeground(Color.red);

                contErrores ++;
            }

            if(validarDireccion(tDireccion.getText())==false){
                tDireccion.setText(tDireccion.getText()+"*");
                tDireccion.setForeground(Color.red);

                contErrores ++;
            }

            if( validarCodigoPostal(tCodigoPostal.getText())==false){
                tCodigoPostal.setText(tCodigoPostal.getText()+"*");
                tCodigoPostal.setForeground(Color.red);

                contErrores ++;
            }

            if(validarTelefono(tTelefono.getText())==false){
                tTelefono.setText(tTelefono.getText()+"*");
                tTelefono.setForeground(Color.red);

                contErrores ++;
            }

            if(validarEmail(tEmail.getText())==false){
                tEmail.setText(tEmail.getText()+"*");
                tEmail.setForeground(Color.red);

                contErrores ++;
            }

            if(validarDNI(tDNI.getText())==false){
                tDNI.setText(tDNI.getText()+"*");
                tDNI.setForeground(Color.red);

                contErrores ++;
            }

            if(validarFechaNac(tFechaNac.getText())==false){
                tFechaNac.setText(tFechaNac.getText()+"*");
                tFechaNac.setForeground(Color.red);

                contErrores ++;

            }

            //if(Controlador.comprobarDNIenBD(tDNI.getText())){

            if(!AlumnosRelated.comprobarDNIExistente(tDNI.getText())){

                dniusado.setVisible(true);
                contErrores ++;
            }

            if (contErrores == 0){
                LocalDate fechaLD = LocalDate.parse(tFechaNac.getText());
                LocalDate fecha_alta = Controlador.conseguirFecha();

                Alumno alum = new Alumno(tNombre.getText(), tApellido.getText(), fechaLD, tDNI.getText(), tDireccion.getText(), tCodigoPostal.getText(), Integer.parseInt(tTelefono.getText()), tEmail.getText(), fecha_alta);
                try{
                    AlumnosRelated.insertar(alum);
                    //Controlador.insertar(alum);
                    JOptionPane.showMessageDialog(null, "El alumno ha sido añadido con exito");
                    Controlador.volverInicio(this);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la inserción del usuario");
                }




            }


        }
        //Opcion borrar alumno.
        if(opcion==1){
            AlumnosRelated.borrarPorIndex(cbAlumnoRetirar.getSelectedIndex());
            JOptionPane.showMessageDialog(null, "El alumno ha sido borrado con exito");
            
            Controlador.volverInicio(this);
            
        }
    }//GEN-LAST:event_bAñadirActionPerformed

    private void tEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tEmailFocusGained
        // TODO add your handling code here:
        tEmail.setText("");
        tEmail.setForeground(Color.black);
    }//GEN-LAST:event_tEmailFocusGained

    private void tTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tTelefonoFocusGained
        // TODO add your handling code here:
        tTelefono.setText("");
        tTelefono.setForeground(Color.black);
    }//GEN-LAST:event_tTelefonoFocusGained

    private void tCodigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tCodigoPostalFocusGained
        // TODO add your handling code here:
        tCodigoPostal.setText("");
        tCodigoPostal.setForeground(Color.black);
    }//GEN-LAST:event_tCodigoPostalFocusGained

    private void tDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDireccionFocusGained
        // TODO add your handling code here:
        tDireccion.setText("");
        tDireccion.setForeground(Color.black);
    }//GEN-LAST:event_tDireccionFocusGained

    private void tDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tDNIActionPerformed

    private void tDNIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDNIFocusGained
        // TODO add your handling code here:
        tDNI.setText("");
        tDNI.setForeground(Color.black);
    }//GEN-LAST:event_tDNIFocusGained

    private void tApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tApellidoFocusGained
        // TODO add your handling code here:
        tApellido.setText("");
        tApellido.setForeground(Color.black);
    }//GEN-LAST:event_tApellidoFocusGained

    private void tNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNombreFocusGained
        // TODO add your handling code here:
        tNombre.setText("");
        tNombre.setForeground(Color.black);
    }//GEN-LAST:event_tNombreFocusGained

    private void bBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_bBuscarDNIActionPerformed
        // TODO add your handling code here:

        String dni= AlumnosRelated.getDNI(cbAlumnoRetirar.getSelectedIndex());
                //Controlador.setearDNI(cbAlumnoRetirar.getSelectedIndex());
        tDNIborrar.setText(dni);
        
    }//GEN-LAST:event_bBuscarDNIActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAñadirRetirarAlum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAñadirRetirarAlum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAñadirRetirarAlum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAñadirRetirarAlum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAñadirRetirarAlum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bBuscarDNI;
    private javax.swing.JButton bCancelarAñadir;
    private javax.swing.JComboBox<String> cbAlumnoRetirar;
    private javax.swing.JLabel dniusado;
    private javax.swing.JLabel etApellido;
    private javax.swing.JLabel etCP;
    private javax.swing.JLabel etDNI;
    private javax.swing.JLabel etDireccion;
    private javax.swing.JLabel etEmail;
    private javax.swing.JLabel etFechaNac;
    private javax.swing.JLabel etNombre;
    private javax.swing.JLabel etTelefono;
    private javax.swing.JLabel etiquetaAñadirRetirar;
    private javax.swing.JLabel etiquetaBuscarAlumBorrar;
    private javax.swing.JLabel etiquetaDNIborrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tApellido;
    private javax.swing.JTextField tCodigoPostal;
    private javax.swing.JTextField tDNI;
    private javax.swing.JTextField tDNIborrar;
    private javax.swing.JTextField tDireccion;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tFechaNac;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tTelefono;
    // End of variables declaration//GEN-END:variables

    public void añadir() {
        opcion=0;
        etiquetaAñadirRetirar.setText("Añadir Alumno");
        
        etiquetaDNIborrar.setVisible(false);
        etiquetaDNIborrar.setFocusable(false);
        tDNIborrar.setVisible(false);
        tDNIborrar.setFocusable(false);
        
        etiquetaBuscarAlumBorrar.setVisible(false);
        etiquetaBuscarAlumBorrar.setFocusable(false);
        cbAlumnoRetirar.setVisible(false);
        cbAlumnoRetirar.setFocusable(false);
        
        dniusado.setVisible(false);
        
        bBuscarDNI.setVisible(false);
        
        
        
        
    }

    public void retirar() {
        opcion=1;
        etiquetaAñadirRetirar.setText("Retirar Alumno");
        
        etNombre.setVisible(false);etNombre.setFocusable(false);
        
        tNombre.setVisible(false);
        tNombre.setFocusable(false);
        
        etApellido.setVisible(false);
        etApellido.setFocusable(false);
        tApellido.setVisible(false);
        tApellido.setFocusable(false);
        
        etFechaNac.setVisible(false);
        etFechaNac.setFocusable(false);
        tFechaNac.setVisible(false);
        tFechaNac.setFocusable(false);
        
        etDNI.setVisible(false);
        etDNI.setFocusable(false);
        tDNI.setVisible(false);
        tDNI.setFocusable(false);
        
        etDireccion.setVisible(false);
        etDireccion.setFocusable(false);
        tDireccion.setVisible(false);
        tDireccion.setFocusable(false);
        
        etCP.setVisible(false);
        etCP.setFocusable(false);
        tCodigoPostal.setVisible(false);
        tCodigoPostal.setFocusable(false);
        
        etTelefono.setVisible(false);
        etTelefono.setFocusable(false);
        tTelefono.setVisible(false);
        tTelefono.setFocusable(false);
        
        etEmail.setVisible(false);
        etEmail.setFocusable(false);
        tEmail.setVisible(false);
        tEmail.setFocusable(false);
        
        dniusado.setVisible(false);
    }

    private boolean validarNombre(String nombre) {
        
            Pattern pnombre= Pattern.compile("^[A-Z][a-z]+$");
            Matcher mnombre= pnombre.matcher(nombre);
            
            if(mnombre.matches()){
                return true;
            }
            else
                return false;
                          
    }

    private boolean validarApellido(String apellido) {
        Pattern papellido = Pattern.compile("^[A-Z][a-z]+$");
        Matcher mapellido= papellido.matcher(apellido);
        
        if(mapellido.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean validarFechaNac(String fecha ) {
        Pattern pfecha= Pattern.compile("^(((19[4-9][0-9]|200[0-4])-(0[13578]|10)-(0[1-9]|[1-2][0-9]|3[0-1]))|((19[4-9][0-9]|200[0-4])-(0[469]|11)-(0[1-9]|[1-2][0-9]|30))|((19[4-9][0-9]|200[0-4])-02-(0-1][1-9]|2[0-8])))");
        Matcher mfecha= pfecha.matcher(fecha);
        if(mfecha.matches())
            return true;
        else
            return false;
            
        }
        
    

    private boolean validarDNI(String dni) {
        Pattern pDNI = Pattern.compile("^[0-9]{8}[QWRTYPSDFGHJKLÑZXCVBNM]$");
        Matcher mdni= pDNI.matcher(dni);
        if(mdni.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean validarDireccion(String direccion) {
        Pattern pdireccion= Pattern.compile("^[A-Z][a-z]+?([ ][A-z0-9]+)+$");
        Matcher mdireccion= pdireccion.matcher(direccion);
        if(mdireccion.matches()){
                return true;
        }
          else
            return false;
    }

    private boolean validarCodigoPostal(String codigopostal) {
        Pattern pCP= Pattern.compile("^01(0|1|5)(1|2|9|0)[0-9]$");
        Matcher mCp= pCP.matcher(codigopostal);
        if (mCp.matches())
            return true;
        else
            return false;
    }

    private boolean validarTelefono(String telefono) {
        Pattern ptelefono = Pattern.compile("^(945[0-9]{6})|((6|7)[0-9]{8})$");
        Matcher mtlfn= ptelefono.matcher(telefono);
        if(mtlfn.matches())
            return true;
        else
            return false;
    }

    private boolean validarEmail(String email) {
        Pattern pEmail= Pattern.compile("^[A-z0-9,._-]+@(ikasle.egibide.org|gmail.com)$");
        Matcher mEmail = pEmail.matcher(email);
        if(mEmail.matches())
            return true;
        else 
            return false;
    }

    
    }
    

