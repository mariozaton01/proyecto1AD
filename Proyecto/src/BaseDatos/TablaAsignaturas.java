/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Clases.Alumno;
import Clases.Asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class TablaAsignaturas {
    
    private Connection con;
    public TablaAsignaturas(Connection con){
        this.con=con;
    }
    

    public ArrayList<Asignatura> conseguirNombre(ArrayList<Asignatura> listaAsig)throws Exception {
        
        String plantilla= "SELECT Nombre FROM asignaturas WHERE ID=? ORDER BY ID;";
        for(int x=0;x <listaAsig.size();x++){
            PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, listaAsig.get(x).getID());
        ResultSet resultado= ps.executeQuery();
        
        if(resultado.next()){
            
            listaAsig.get(x).setNombre(resultado.getString("Nombre"));
            
            
        }
        }
        
        return listaAsig;
    }

    public ArrayList<Asignatura> seleccionarAsignaturas(ArrayList<Asignatura> listaAsignturas)throws Exception {
        String plantilla= "SELECT ID FROM asignaturas ORDER BY ID;";
        PreparedStatement ps= con.prepareStatement(plantilla);
        
        ResultSet resultado= ps.executeQuery();
        
        while(resultado.next()){
            Asignatura asig= new Asignatura();
            asig.setID(resultado.getInt("ID"));
            
            listaAsignturas.add(asig);
        }
        return listaAsignturas;
        
    }
    public int conseguirNombreAsig(String nombreAsig)throws Exception{
        String plantilla ="SELECT ID FROM asignaturas where Nombre=?;";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, nombreAsig);
        
        ResultSet resultado= ps.executeQuery();
        int idAsig=0;
        if(resultado.next()){
            idAsig= resultado.getInt("ID");
            
        }
        return idAsig;
    }
    
}
