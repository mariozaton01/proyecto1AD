package Ficheros;

import Clases.Asignatura;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class crearAsignaturas {

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
