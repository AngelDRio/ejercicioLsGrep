package es.etg.dam.psp.ejerciciolsgrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ejerciciolsgrep {

    // Constantes para los comandos
    private static final String RUTA_DIRECTORIO = "archivosParaLeer"; // carpeta dentro del proyecto
    private static final String COMANDO_LS = "ls " + RUTA_DIRECTORIO;
    private static final String[] COMANDO_GREP = {"grep", "-i", "a"}; // -i = insensible mayúsculas

    // Mensajes
    private static final String MENSAJE_TITULO = "Archivos que contienen la letra 'a':";

    public static void main(String[] args) throws IOException, InterruptedException {
        Process procesoLS = Runtime.getRuntime().exec(COMANDO_LS);
        Process procesoGREP = Runtime.getRuntime().exec(COMANDO_GREP);

        enviarSalidaDeLsAGrep(procesoLS, procesoGREP);

        String resultado = leerSalidaDeGrep(procesoGREP);

        System.out.println(MENSAJE_TITULO);
        System.out.println(resultado);
    }

    // Método que envía la salida de LS a la entrada de GREP
    private static void enviarSalidaDeLsAGrep(Process procesoLS, Process procesoGREP) throws IOException {
        BufferedReader lectorLS = new BufferedReader(new InputStreamReader(procesoLS.getInputStream()));
        PrintWriter escritorGREP = new PrintWriter(new OutputStreamWriter(procesoGREP.getOutputStream()));

        String linea;
        while ((linea = lectorLS.readLine()) != null) {
            escritorGREP.println(linea);
        }

        escritorGREP.close(); // fuerza EOF para que grep termine
    }

    // Método que lee la salida de GREP
    private static String leerSalidaDeGrep(Process procesoGREP) throws IOException {
        StringBuilder salida = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(procesoGREP.getInputStream()));
        String linea;
        while ((linea = br.readLine()) != null) {
            salida.append(linea).append("\n");
        }
        br.close();
        return salida.toString();
    }
}


