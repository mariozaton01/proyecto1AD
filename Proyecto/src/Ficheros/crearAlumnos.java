package Ficheros;

import Clases.Asignatura;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class crearAlumnos {
    public static void main() throws IOException {

        String listaAsignaturas[] = {"Progamacion", "Sistemas", "Acceso a datos","EIE"};

        File fich = new File("Asignaturas.dat");
        FileOutputStream fOutput = new FileOutputStream(fich);
        ObjectOutputStream objOutput = new ObjectOutputStream(fOutput);

        int id = 1;
        for (String nombre: listaAsignaturas) {

            Asignatura asig = new Asignatura(nombre,id);
            objOutput.writeObject(asig);
            id ++;
        }
    }
}
