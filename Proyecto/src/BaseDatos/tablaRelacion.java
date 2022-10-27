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
public class tablaRelacion {

    private Connection con;
    public tablaRelacion(Connection con){
        this.con=con;
    }
  
    public ArrayList<Asignatura> comprobarAlumno(String dni)throws Exception {
        ArrayList <Asignatura> listaAsigdeAlum= new ArrayList();
       String plantilla="SELECT ID_Asignatura from relacionalumasig WHERE DNI_Alumno=? ORDER BY ID_Asignatura;";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, dni);
        
        ResultSet resultado =ps.executeQuery();
        
        while(resultado.next()){
            Asignatura asig= new Asignatura();
            asig.setID(resultado.getInt("ID_Asignatura"));
            listaAsigdeAlum.add(asig);
    }
        return listaAsigdeAlum;
            
    }

    public void renunciarAsig(String dni, int id_asig)throws Exception {
        String plantilla = "DELETE FROM relacionalumasig WHERE DNI_Alumno=? AND ID_Asignatura=?;";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, dni);
        ps.setInt(2, id_asig);
        
        int n=ps.executeUpdate();
        ps.close();
        
        if(n!=1)
            throw new Exception("El numero de filas borradas no es uno");
    }

    public void insertarAsignaturas(String dni, ArrayList <Asignatura> asignaturas)throws Exception {
        String plantilla= "INSERT INTO relacionalumasig VALUES(?,?);";
        for (int x = 0; x < asignaturas.size(); x++) {
            
            PreparedStatement ps= con.prepareStatement(plantilla);
           ps.setString(1, dni);
           ps.setInt(2,asignaturas.get(x).getID());
           
           int n = ps.executeUpdate();
            ps.close();
        }
           
           
    }

    public ArrayList<Alumno> conseguirDNIalum(int codigoAsig,ArrayList<Alumno> listaalumnos)throws Exception {
        String plantilla= "SELECT DNI_Alumno from relacionalumasig WHERE ID_Asignatura=?;";//mirar/confirmar error clase program
        
            PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setInt(1, codigoAsig);
        
        ResultSet resultado= ps.executeQuery();
        
        while(resultado.next()){
            Alumno alum= new Alumno();
            alum.setDNI(resultado.getString("DNI_Alumno"));
            listaalumnos.add(alum);
        }
        
        return listaalumnos;
    }
    }

