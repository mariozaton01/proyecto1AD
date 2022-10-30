package creacionFicheros;

import Clases.Alumno;
import Clases.Asignatura;

import java.io.*;
import java.util.ArrayList;

public class AsignaturasRelated {

    static File fich = new File("src/Ficheros/Asignaturas.dat");

    public static void main() throws IOException {

        ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
        String[] asigStrings = {"Progamacion", "Sistemas", "Acceso a datos","EIE"};

        File alumFile = new File("src/Ficheros/Alumnos.dat");

        ArrayList<Alumno> listaAlum = AlumnosRelated.readFile(alumFile);

        int id = 1;
        for (String nombre: asigStrings) {

            Asignatura asig = new Asignatura(nombre,id);
            asig.setAlumnosPorAsig(listaAlum);
            listaAsignaturas.add(asig);
            id ++;
        }

        writeFile(listaAsignaturas);

    }

    public  static ArrayList<Asignatura> readFile(File fich) throws IOException {
        ArrayList<Asignatura> listaAsig = new ArrayList<>();

        FileInputStream fInput = new FileInputStream(fich);
        ObjectInputStream objInput = new ObjectInputStream(fInput);

        boolean cont = true;
        while (cont){
            try{
                Asignatura asig = (Asignatura) objInput.readObject();

                if(asig != null){
                    listaAsig.add(asig);
                }
                else {
                }
            }
            catch ( Exception e){
                if (e.getMessage() == null) {
                    cont = false;
                }
            }
        }
        return listaAsig;

    }
    public  static void writeFile( ArrayList<Asignatura> listaAsig) throws IOException {

        FileOutputStream fOutput = new FileOutputStream(fich);
        ObjectOutputStream objOutput = new ObjectOutputStream(fOutput);
        for (Asignatura asig: listaAsig ) {
            objOutput.writeObject(asig);
        }

    }
}
