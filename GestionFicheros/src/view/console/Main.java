/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.Funciones;

/**
 *
 * @author erikespvel
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String opcion;
        do {
            System.out.println("\nMENU");
            System.out.println("1. Create Folder");
            System.out.println("2. Create File");
            System.out.println("3. Show List Files");
            System.out.println("4. Show File");
            System.out.println("5. Overwrite File");
            System.out.println("6. Delete File");
            System.out.println("7. Count Chars");
            System.out.println("8. Count Words");
            System.out.println("9. Swap Words");
            System.out.println("10. PrintPDF(");
            System.out.println("z. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la carpeta: ");
                    String carpeta = sc.nextLine();
                    Funciones.createFolder(carpeta);
                    break;

                case "2":
                    System.out.print("Ruta: ");
                    String ruta = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    System.out.print("Contenido: ");
                    String contenido = sc.nextLine();
                    Funciones.createFile(ruta, nombreArchivo, contenido);
                    break;

                case "3":
                    System.out.print("Ruta: ");
                    String ruta3 = sc.nextLine();
                    String[] archivos = Funciones.showListFiles(ruta3);
                    if (archivos.length == 0) {
                        System.out.println("No hay archivos.");
                    } else {
                        System.out.println("Archivos en la carpeta:");
                        for (String archivo : archivos) {
                            System.out.println(archivo);
                        }
                    }
                    break;

                case "4":
                    System.out.print("Ruta: ");
                    String ruta4 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo4 = sc.nextLine();
                    System.out.println("Contenido:");
                    System.out.println(Funciones.showFile(ruta4, archivo4));
                    break;

                case "5":
                    System.out.print("Ruta: ");
                    String ruta5 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo5 = sc.nextLine();
                    System.out.print("Nuevo contenido: ");
                    String nuevoContenido = sc.nextLine();
                    boolean sobreEscrito = Funciones.overWriteFile(ruta5, archivo5, nuevoContenido);
                    System.out.println(sobreEscrito ? "Archivo sobrescrito." : "Archivo no encontrado.");
                    break;

                case "6":
                    System.out.print("Ruta: ");
                    String ruta6 = sc.nextLine();
                    System.out.print("Nombre del archivo a borrar: ");
                    String archivo6 = sc.nextLine();
                    Funciones.deleteFile(ruta6, archivo6);
                    System.out.println("Archivo borrado (si existia).");
                    break;

                case "7":
                    System.out.print("Ruta: ");
                    String ruta7 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo7 = sc.nextLine();
                    int chars = Funciones.countChars(ruta7, archivo7);
                    System.out.println("Numero de caracteres: " + chars);
                    break;

                case "8":
                    System.out.print("Ruta: ");
                    String ruta8 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo8 = sc.nextLine();
                    int palabras = Funciones.countWords(ruta8, archivo8);
                    System.out.println("Numero de palabras: " + palabras);
                    break;

                case "9":
                    System.out.print("Ruta: ");
                    String ruta9 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo9 = sc.nextLine();
                    System.out.print("Palabra a reemplazar: ");
                    String vieja = sc.nextLine();
                    System.out.print("Nueva palabra: ");
                    String nueva = sc.nextLine();
                    String resultado = Funciones.swapWords(ruta9, archivo9, vieja, nueva);
                    System.out.println("Nuevo contenido del archivo:");
                    System.out.println(resultado);
                    break;

                case "10":
                    System.out.print("Ruta: ");
                    String ruta10 = sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String archivo10 = sc.nextLine();
                    Funciones.printPDF(ruta10, archivo10);
                    break;

                case "z":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (!opcion.equals("z"));
    }
}
