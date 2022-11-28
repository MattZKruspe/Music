package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.io.Buffer;

/**
 * leer archivos de texto
 *
 * @author Matthew Marquez
 */
public class Archivos {

    public static void leerArchivo(String name) {
        File archivo = null; // apunta a un archivo fisico del DD
        FileReader fr = null;
        BufferedReader bufer = null;
        try {
            //Creación de un apuntador al archivo físico
            archivo = new File("D:\\Documents\\NetBeansProjects\\" + name);
            //Abrimos el archivo para lectura
            fr = new FileReader(archivo);
            //Creación de bufer para hacer la lectura
            bufer = new BufferedReader(fr);

            //Lectura del contenido del archivo
            String linea;
            //Mientras haya información en el archivo 
            while ((linea = bufer.readLine()) != null) {
                System.out.println("Linea del archivo: " + linea);
            }

        } catch (Exception e) {
            System.out.println("No se encuentra archivo!");
            e.printStackTrace();
        } finally {
            //Esta cláusula se ejecuta siempre 
            //Se cierra el archivo 
            try {
                //Si se logró abrir el archivo, debemos cerrarlo
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo");
                e2.printStackTrace();
            }

        }

    }

    public static void escribirArchivo(String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try {

            archivo = new FileWriter("D:\\Documents" + name + ".txt");
            pw = new PrintWriter(archivo);
            BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
            String entrada;
            char respuesta;
            do {
                System.out.println("Escribe la información a guardar en el archivo: ");
                entrada = bufer2.readLine();
                //Agrega lo leído en el teclado en disco
                pw.println(entrada);
                System.out.println("Escribe s para continuar, n para parar");
                entrada = bufer2.readLine();
                respuesta = entrada.charAt(0);

            } while (respuesta != 'n');
        } catch (Exception e) {
            System.out.println("Error al escribir en archivo: " + name);
            e.printStackTrace();
        } finally {
        }
        try {
            if (null != archivo) {
                archivo.close();
            }
            //cerrar el archivo si es que se pudo abrir para escritura
        } catch (Exception e2) {
            System.out.println("Error al cerrar archivo " + name);
        }

    }
    
    public static void eliminarArchivo(String name){
        
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;

        System.out.println("Programa que manipula archivos de texto");
        System.out.println("---------------------------------------");
        System.out.println("1 - Leer un archivo de texto existente");
        System.out.println("2 - Crear un archivo de textoS");
        System.out.println("3 - Eliminar un archivo");
        System.out.println("¿Qué quieres hacer?");
        entrada = buferTeclado.readLine();
        opcion = Integer.parseInt(entrada);
        System.out.println("escribe el nombre del archivo: ");
        entrada = buferTeclado.readLine();
        fileName = entrada;
        switch (opcion) {
            case 1: {
                //Leer de un archivo de texto 
                System.out.println("Lectura de un archivo existente");
                System.out.println("Contenido de un archivo: ");
                leerArchivo(fileName);
            }
            break;
            default:
                System.out.println("Opción no válida");

            case 2: {
                System.out.println("Creación de archivo de texto");
                escribirArchivo(fileName);

            }
            case 3: {
                System.out.println("Eliminción de un archivo");
                eliminarArchivo(fileName);
            break;
            
            }

        }

        System.out.println("programa que lee un archivo de texto");
        System.out.println("Contenido del archivo: ");
        entrada = buferTeclado.readLine();
        leerArchivo(entrada);

    }

}
