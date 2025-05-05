/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author erikespvel
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funciones {

    public static void createFolder(String folderName) {
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = path + separador + folderName;
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    public static void createFile(String path, String fileName, String content) {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        try {
            FileWriter writer = new FileWriter(fichero, true); // true = añadir
            writer.write(content + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static String[] showListFiles(String path) {
        File carpeta = new File(path);

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            return new String[]{"La ruta no existe o no es una carpeta válida."};
        }

        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            return new String[]{"La carpeta está vacía."};
        }

        String[] nombres = new String[archivos.length];
        for (int i = 0; i < archivos.length; i++) {
            nombres[i] = archivos[i].getName();
        }

        return nombres;
    }

    public static String showFile(String path, String fileName) {
        StringBuilder texto = new StringBuilder();
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = reader.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return texto.toString();
    }

    public static boolean overWriteFile(String path, String fileName, String newContent) {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        if (!fichero.exists()) {
            return false;
        }
        try {
            FileWriter writer = new FileWriter(fichero, false); // false = sobrescribir
            writer.write(newContent);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el fichero: " + e.getMessage());
            return false;
        }
    }

    public static void deleteFile(String path, String fileName) {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        if (fichero.exists()) {
            fichero.delete();
        }
    }

    public static int countChars(String path, String fileName) {
        return showFile(path, fileName).length();
    }

    public static int countWords(String path, String fileName) {
        String contenido = showFile(path, fileName).trim();
        return contenido.isEmpty() ? 0 : contenido.split("\\s+").length;
    }

    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        String contenido = showFile(path, fileName);
        String nuevoContenido = contenido.replace(oldWord, newWord);
        overWriteFile(path, fileName, nuevoContenido);
        return nuevoContenido;
    }

    public static void printPDF(String path, String fileName) {
        File file = new File(path, fileName);
        if (!file.exists()) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        try {
            // Leer el contenido del archivo .txt
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            br.close();

            // Crear documento PDF
            String pdfPath = path + "/" + fileName.replace(".txt", "") + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            // Agregar contenido al PDF
            document.add(new Paragraph(contenido.toString()));

            document.close();
            System.out.println("PDF creado correctamente en: " + pdfPath);

        } catch (IOException | DocumentException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

}
