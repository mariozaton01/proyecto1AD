/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Clases.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class TablaAlumnos {
    private Connection con;
    public TablaAlumnos(Connection con){
        this.con=con;
    }
    public void insertar(Alumno alum) throws Exception{
        
        String plantilla= "INSERT INTO alumnos VALUES(?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, alum.getNombre());
        ps.setString(2, alum.getApellido());
        ps.setDate(3, java.sql.Date.valueOf(alum.getFechaNac()));
        ps.setString(4, alum.getDNI());
        ps.setString(5, alum.getDireccion());
        ps.setString(6, alum.getCodigoPostal());
        ps.setInt(7, alum.getTelefono());
        ps.setString(8, alum.getEmail());
        ps.setDate(9, java.sql.Date.valueOf(alum.getFecha_Alta()));
        
        int n = ps.executeUpdate();
        ps.close();
        
        if(n!=1)
            throw new Exception("El numero de filas actualizadas no es uno");
    }
    
    public void borrar (String dni) throws Exception{
        
        String plantilla ="DELETE from alumnos where DNI=?;";
        PreparedStatement ps =con.prepareStatement(plantilla);
        ps.setString(1,dni);
        
        int  n=ps.executeUpdate();
        ps.close();
        if(n!=1)
            throw new Exception("El numero de filas borradas no es uno");
    }
    public boolean comprobarDNI (String dni)throws Exception{
        String plantilla="SELECT * from alumnos WHERE DNI=?;";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, dni);
        
        ResultSet resultado =ps.executeQuery();
        
        if(resultado.next()){
        return true;//ha encontrado el DNI
    }
        else
            return false;//no lo ha encontrado
    }
    
    public ArrayList <Alumno> seleccionarAlumnos(ArrayList<Alumno> listaAlum) throws Exception{
        
        String plantilla= "SELECT * FROM alumnos order by Apellido;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado= ps.executeQuery();
        
        while(resultado.next()){
            Alumno alum =new Alumno();
            alum.setNombre(resultado.getString("Nombre"));
            alum.setApellido(resultado.getString("Apellido"));
            alum.setDNI(resultado.getString("DNI"));
            
            listaAlum.add(alum);
        }
        return listaAlum;
    }

    public ArrayList<Alumno> seleccionarNombreAlumno(ArrayList<Alumno> listaalumnos,ArrayList<Alumno> listaordenada)throws Exception {
       
        String plantilla= "SELECT Nombre, Apellido,DNI FROM alumnos WHERE DNI=? ORDER BY Apellido;";//no ordena por apellido por que solo devuelveuna fila. preguntar 
        //como ordenar el arraylist mañana.
        for (int x = 0; x < listaalumnos.size(); x++) {
            PreparedStatement ps= con.prepareStatement(plantilla);
            ps.setString(1, listaalumnos.get(x).getDNI());
            
            ResultSet resultado= ps.executeQuery();
            if(resultado.next()){
                Alumno alum= new Alumno();
                alum.setNombre(resultado.getString("Nombre"));
                alum.setApellido(resultado.getString("Apellido"));
                alum.setDNI(resultado.getString("DNI"));
                listaordenada.add(alum);
            }
        }
        return listaordenada;
    }
}
