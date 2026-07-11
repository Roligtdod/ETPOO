package data;

import model.Registrable;
import java.util.*;
import java.io.*;


public class GestorDatos implements Registrable {

    public static String escribirArchivo(String nombreArchivo, String contenido) {
        try {
            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(contenido);
            bufferedWriter.newLine();
            bufferedWriter.close();

            return "Datos guardados correctamente.";

        } catch (IOException e) {
            return "Error al escribir en el archivo: " + e.getMessage();
        }
    } //EN PROCESO

    public String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();

        try {
            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                return "El archivo no existe.";
            }

            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            bufferedReader.close();

            if (contenido.isEmpty()) {
                return "El archivo está vacío.";
            }

            return contenido.toString();

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    } //EN PROCESO




    @Override
    public String registrar() {
        return "";
    }

    @Override
    public String MostrarDatos() {
        return "";
    }
}
