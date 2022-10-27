/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BaseDatos.*;
import Ventanas.*;
import Clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author mario
 */
public class Controlador {

    

    /**
     * @param args the command line arguments
     */
    //Relacionado con las ventanas 
    private static VentanaInicio vInicio;
     private static VentanaElegirAñadirRetirar vElegirAñadirRetirar;
     private static VentanaAñadirRetirarAlum vAñadirRetirarAlum;
     private static VentanaRenunciarAsig vRenunciarAsig;
     private static VentanaAlumnos vAlumnos;
     private static VentanaAlumnoPorAsignatura vAlumPorAsig;
     private static VentanaAsignaturasaDeAlumno vAsigDeAlum;
     private static javax.swing.JFrame vAnterior;
     //Para guardar fecha_alta
     private static  LocalDate fecha;
     //Relacionado con la base de datos
     private static Conexion bd;
     private static TablaAlumnos ta;
     private static TablaAsignaturas tasig;
     private static tablaRelacion trelacion;  
     private static ArrayList<Alumno> listaAlum;
     private static ArrayList<Asignatura> listaAsig;
    public static void main(String[] args) {
        // TODO code application logic here
        bd= new Conexion();
        bd.conectar();
        ta= new TablaAlumnos(bd.getCon());
        tasig= new TablaAsignaturas(bd.getCon());
        trelacion= new tablaRelacion(bd.getCon());
        vInicio = new VentanaInicio();
        
        
        vInicio.setVisible(true);
        vInicio.setLocationRelativeTo(null);
    }
    
    //Metodos de la ventana vInicio:
        
        public static void bAnadirRetirar() {
            vInicio.setVisible(false);
            
            vElegirAñadirRetirar= new VentanaElegirAñadirRetirar();
            vElegirAñadirRetirar.setVisible(true);
            vElegirAñadirRetirar.setLocationRelativeTo(null);
            
            vAnterior= vInicio;
        
    }

    public static void bVerAlumnos() {
        vInicio.setVisible(false);
        
        vAlumnos = new VentanaAlumnos();
        vAlumnos.setVisible(true);
        vAlumnos.setLocationRelativeTo(null);
        
        vAnterior= vInicio;
        
    }

    
    
    
    //Metodos de la ventana vElegirAñadirRetirar

    public static void bAnadir( ) {
        try{
           
            LocalDate fechaInicioAltas;
            String fechaString= JOptionPane.showInputDialog("Introduce la fecha en la que añades al alumno.\nSigue el siguiente formato: yyyy-mm-dd");               
                fecha= LocalDate.parse(fechaString);
                LocalDate fechaLimite=LocalDate.of(2019, 10, 15) ;
                fechaInicioAltas= LocalDate.of(2019, 07, 01);
                
                if(fecha.isBefore(fechaInicioAltas)){
                   throw new Excepciones.fechaLimite();               
                }
                else{
                     if(fecha.isBefore(fechaLimite)){
                        vElegirAñadirRetirar.setVisible(false);

                        vAñadirRetirarAlum = new VentanaAñadirRetirarAlum();
                        vAñadirRetirarAlum.setVisible(true);
                        vAñadirRetirarAlum.setLocationRelativeTo(null);
                        vAñadirRetirarAlum.añadir();

                        vAnterior=vElegirAñadirRetirar;
                    }
                    else{
                        throw new Exception();
                    }
                }              
        }   
        catch (Excepciones.fechaLimite e){
            JOptionPane.showMessageDialog(null, "Todavia no ha iniciado el periodo de matriculacion");
        }        
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha pasado el tiempo limite para iniciar en el curso");
        }   
        
        
        
    }

    public static void bRetirar() {
        vElegirAñadirRetirar.setVisible(false);
        
        vAñadirRetirarAlum = new VentanaAñadirRetirarAlum();
        vAñadirRetirarAlum.setVisible(true);
        vAñadirRetirarAlum.setLocationRelativeTo(null);
        vAñadirRetirarAlum.retirar();
        
        vAnterior=vElegirAñadirRetirar;
        
        
        
    }

    public static void bRenunciar() {
        vElegirAñadirRetirar.setVisible(false);
        
        vRenunciarAsig = new VentanaRenunciarAsig();
        vRenunciarAsig.setVisible(true);
        vRenunciarAsig.setLocationRelativeTo(null);
        
        vAnterior=vElegirAñadirRetirar;
    }

    
    
    //Metodos de la ventana vAlumnos
    public static void bAlumPorAsig() {
        vAlumnos.setVisible(false);
        
        vAlumPorAsig = new VentanaAlumnoPorAsignatura();
        vAlumPorAsig.setVisible(true);
        vAlumPorAsig.setLocationRelativeTo(null);
        
        vAnterior=vAlumnos;
    }

    public static void bAsigDeAlum() {
        vAlumnos.setVisible(false);
        
        vAsigDeAlum = new VentanaAsignaturasaDeAlumno();
        vAsigDeAlum.setVisible(true);
        vAsigDeAlum.setLocationRelativeTo(null);
        
        vAnterior=vAlumnos;
    }

    
    public static void bCancelar(javax.swing.JFrame v) {
        if(v.isVisible()){
            v.setVisible(false);
            vAnterior.setVisible(true);
        }
        if (v==vElegirAñadirRetirar){
            vAnterior=vInicio;
            v.setVisible(false);
            vAnterior.setVisible(true);
        }
        if(v==vAlumnos){
            vAnterior=vInicio;
            v.setVisible(false);
            vAnterior.setVisible(true);
        }
        
    }     

    public static LocalDate conseguirFecha() {
        return fecha;
    }

    public static void insertar(Alumno alum)throws Exception {
        ta.insertar(alum);
        String dni= alum.getDNI();
        ArrayList <Asignatura> asignaturasDeAlumNuevo= new ArrayList();
        asignaturasDeAlumNuevo=tasig.seleccionarAsignaturas(asignaturasDeAlumNuevo);
        trelacion.insertarAsignaturas(dni, asignaturasDeAlumNuevo);
    }

    public static boolean comprobarDNIenBD(String dni)throws Exception {
        
            return ta.comprobarDNI(dni);
            
        
    }

    public static void listaAlumnos(JComboBox combobox)throws Exception {
         listaAlum= new ArrayList();
        listaAlum= ta.seleccionarAlumnos(listaAlum);
        for (int x = 0; x < listaAlum.size(); x++) {
            String nombre= listaAlum.get(x).getNombre() +" "+listaAlum.get(x).getApellido();
            combobox.addItem(nombre);
        }
    }

    public static String setearDNI(int selectedIndex) {
        return listaAlum.get(selectedIndex).getDNI();
    }

    public static void borrarAlumno(int selectedIndex) {
        try {
            ta.borrar(listaAlum.get(selectedIndex).getDNI());
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void volverInicio(JFrame v) {
        v.dispose();
        vInicio.setVisible(true);
    }

    public static String verListaAlumnos(String texto)throws Exception {
        listaAlum= new ArrayList();
        listaAlum= ta.seleccionarAlumnos(listaAlum);
        for (int x = 0; x < listaAlum.size(); x++) {
            String nombre= listaAlum.get(x).getNombre() +" "+listaAlum.get(x).getApellido();
            texto="" +texto;
            texto= texto+"\n"+ nombre;
            
        }
        return texto;
    }

    public static void comprobardniconRelacion(int selectedIndex)throws Exception {
        
        String dni= listaAlum.get(selectedIndex).getDNI();
        listaAsig= new ArrayList();       
        listaAsig=trelacion.comprobarAlumno(dni);
        tasig.conseguirNombre(listaAsig);
    }

    public static void asignarAsignaturas(JComboBox combobox) {
        combobox.removeAllItems();
        for (int x = 0; x < listaAsig.size(); x++) {
            String asignatura= listaAsig.get(x).getNombre();
            combobox.addItem(asignatura);
        }
    }

    public static void borrarAsig(int selectedIndex, int selectedIndex0, JComboBox cbAsig) {
        String dni= listaAlum.get(selectedIndex).getDNI();
        int id_asig= listaAsig.get(selectedIndex0).getID();
        try {
            trelacion.renunciarAsig(dni, id_asig);
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
    }

    public static void setearTexto(JTextArea textarea) {
        String texto="";
        String asignatura;
        for (int x = listaAsig.size()-1; x>=0; x--) {
            asignatura= listaAsig.get(x).getNombre();
            texto=asignatura +"\n"+texto;
        }
        textarea.setText(texto);
        
    }

    public static void conseguirListaAlum(JMenuItem menuProgramacion, JTextArea textArea) {
        String nombreAsig= menuProgramacion.getText();
        try {
            int codigoAsig=tasig.conseguirNombreAsig(nombreAsig);
            ArrayList<Alumno> listaalumnos= new ArrayList();
        listaalumnos=trelacion.conseguirDNIalum(codigoAsig,listaalumnos);
        
        ArrayList <Alumno>listaOrdenada= new ArrayList();
        listaOrdenada=ta.seleccionarNombreAlumno(listaalumnos,listaOrdenada);//preguntar como ordenar el arraylist alfabeticamente
        
        String texto="";
            for (int i = 0; i < listaOrdenada.size(); i++) {
                String nombre= listaOrdenada.get(i).getNombre()+" "+ listaOrdenada.get(i).getApellido();
                texto= nombre +"\n"+ texto;
            }
            textArea.setText(texto);
        
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    }
    

