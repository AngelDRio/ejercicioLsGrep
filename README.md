# EjercicioLsGrep

Este programa en Java muestra cómo ejecutar y **encadenar dos procesos externos** desde el propio código: el comando `ls`, que lista los archivos de un directorio, y el comando `grep`, que filtra las líneas que contienen un texto determinado.

El objetivo del programa es simular la ejecución del comando de consola:

ls archivosParaLeer | grep -i a

El programa crea dos procesos independientes:
- Uno para ejecutar `ls archivosParaLeer`, que obtiene la lista de archivos del directorio.
- Otro para ejecutar `grep -i a`, que busca los nombres de archivo que contienen la letra “a”, sin distinguir entre mayúsculas y minúsculas (`-i`).

A través de un flujo de salida, el programa **envía la salida de `ls` como entrada al proceso `grep`**, igual que se haría en una tubería (*pipe*) en la terminal.  
Luego, mediante un flujo de entrada, **lee la salida generada por `grep`** y la muestra por pantalla.

De esta forma, el programa demuestra cómo **Java puede comunicarse con procesos del sistema operativo** utilizando los flujos de entrada y salida estándar (`InputStream`, `OutputStream`, `BufferedReader`, `PrintWriter`, etc.).

En resumen, el objetivo del código es ilustrar cómo:
- Ejecutar comandos del sistema (`ls` y `grep`) desde Java.  
- Conectar la salida de un proceso con la entrada de otro.  
- Leer y mostrar el resultado final en la consola.  
- Simular una operación en *pipeline* típica de sistemas Unix o Linux.

Se puede acceder al proyecto en gitHub mediante el siguiente enlace:
[Enlace](https://github.com/AngelDRio/ejercicioLsGrep)

