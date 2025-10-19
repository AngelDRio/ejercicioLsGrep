package es.etg.dam.psp.ejerciciolsgrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ejerciciolsgrep {

    // Constantes para los comandos
    private static final String RUTA_DIRECTORIO = "archivosParaLeer";
    private static final String COMANDO_LS = "ls " + RUTA_DIRECTORIO;
    private static final String[] COMANDO_GREP = {"grep", "-i", "a"};

    // Mensajes
    private static final String MENSAJE_TITULO = "Archivos que contienen la letra 'a':";

    public static void main(String[] args) throws IOException, InterruptedException {
        Process procesoLs = Runtime.getRuntime().exec(COMANDO_LS);
        Process procesoGrep = Runtime.getRuntime().exec(COMANDO_GREP);

        enviarSalidaDeLsAGrep(procesoLs, procesoGrep);

        String resultado = leerSalidaDeGrep(procesoGrep);

        System.out.println(MENSAJE_TITULO);
        System.out.println(resultado);
    }

    // Método que envía la salida de LS a la entrada de GREP
    private static void enviarSalidaDeLsAGrep(Process procesoLs, Process procesoGrep) throws IOException {
        BufferedReader lectorLS = new BufferedReader(new InputStreamReader(procesoLs.getInputStream()));
        PrintWriter escritorGrep = new PrintWriter(new OutputStreamWriter(procesoGrep.getOutputStream()));

        String linea;
        while ((linea = lectorLS.readLine()) != null) {
            escritorGrep.println(linea);
        }
        escritorGrep.close();
    }

    // Método que lee la salida de GREP
    private static String leerSalidaDeGrep(Process procesoGrep) throws IOException {
        StringBuilder salida = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(procesoGrep.getInputStream()));
        String linea;
        while ((linea = br.readLine()) != null) {
            salida.append(linea).append("\n");
        }
        br.close();
        return salida.toString();
    }
}


