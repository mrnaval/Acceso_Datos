//Marc Naval Lloret
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionDatos {

	public GestionDatos() {

	}

	
	public static BufferedReader abrirFicheros (String fichero1) throws FileNotFoundException {
		FileReader file1 = new FileReader(fichero1);
		BufferedReader buffer1= new BufferedReader(file1);
		return buffer1;
	}

	
	public static void cerrarFicheros (BufferedReader buffer1) throws IOException {
		buffer1.close();
	}

	
	public static boolean compararContenido (String fichero1, String fichero2) throws IOException{
		
		BufferedReader[] buffer = new BufferedReader[2];
		
		buffer[0] = abrirFicheros(fichero1);			//Abre fichero1
		buffer[1] = abrirFicheros(fichero2);			//Abre fichero2
		
		String txt1 = buffer[0].readLine();				//Define los strings que usaran los BufferedReader
		String txt2 = buffer[1].readLine();
		
		while (txt1 != null || txt2 != null) {			//Si las dos lineas
			if (!txt1.equals(txt2)) {					//no son iguales 
				return false;							//devuelve falso
			
			}else {										//Si las dos lineas son iguales
				txt1 = buffer[0].readLine();			//sigue leyendo las siguientes dos lineas
				txt2 = buffer[1].readLine();
			}
		}
		cerrarFicheros(buffer[0]);						//Cierra ficheros1
		cerrarFicheros(buffer[1]);						//Cierra ficheros2
		return true;

	}

	public static int buscarPalabra (String fichero1, String palabra, boolean aparicion1) throws IOException{
		
		BufferedReader[] buffer = new BufferedReader[1];			//Abre ficheros
		buffer[0] = abrirFicheros(fichero1);
		
		String txt1 = buffer[0].readLine();
		int linea = 1, lineafinal = -1;
		
		List<String> palabras = new ArrayList<String>();
		
		if(aparicion1) {										//Si 
			while (txt1 != null) {								//Mientras que el documento no se acabe 
				palabras = Arrays.asList(txt1.split(" "));		//Divide las palabras de la frase
				if(palabras.contains(palabra)) {				//Si contiene la palabra que se busca 
					return linea;								//Devuelve la linea en la que esta
				}
				txt1 = buffer[0].readLine();
				linea++;
			}
		}else {													//Si no esta ticado (checkbox)
			
			while (txt1 != null) {								
				palabras = Arrays.asList(txt1.split(" "));		
				if(palabras.contains(palabra)) {				//Si contiene la palabra que se esta buscando 
					lineafinal = linea;							//Guarda la linea donde aparece
				}												//haciendo que en las proximas lineas aparezca,
				txt1 = buffer[0].readLine();					
				linea++;										//Sigua haciendo el bucle hasta que no aparezca
			}
			return lineafinal;									//Devuelve la ultima linea que guarda
		}
		cerrarFicheros(buffer[0]);								//Cerrar ficheros
		return -1;
	}	

}