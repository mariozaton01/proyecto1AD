package creacionFicheros;

import Clases.Alumno;
import Clases.Asignatura;

import java.io.*;
import java.util.ArrayList;

public class AsignaturasRelated {

    public static void main() throws IOException {

        String listaAsignaturas[] = {"Progamacion", "Sistemas", "Acceso a datos","EIE"};

        File fich = new File("src/Ficheros/Asignaturas.dat");

        writeFile(fich,listaAsignaturas);

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

    public  static void writeFile(File file, String[] listaAsig) throws IOException {

        FileOutputStream fOutput = new FileOutputStream(file);
        ObjectOutputStream objOutput = new ObjectOutputStream(fOutput);
        int id = 1;
        for (String nombre: listaAsig) {

            Asignatura asig = new Asignatura(nombre,id);
            objOutput.writeObject(asig);
            id ++;
        }
    }
}
