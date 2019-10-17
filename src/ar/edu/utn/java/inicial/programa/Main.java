package ar.edu.utn.java.inicial.programa;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ar.edu.utn.java.inicial.modelo.CorreoElectronico;
import ar.edu.utn.java.inicial.modelo.EnviadorCorreos;

public class Main {

	public static void main(String[] args) {
		// Crear objeto CorreoElectronico
		// Le defino valores cualquiera para direccion y asunto 
		
		// Creo objeto EnviadorCorreo
		// Le pido que envie el correo electronico que creé
		
		//CorreoElectronico correo = new CorreoElectronico();
		
		//correo.setAsunto("Asunto del mail");
		//correo.setDireccionCorreo("E-mail");

		//EnviadorCorreos enviador = new EnviadorCorreos();
		
		//enviador.enviarCorreo(correo);
		
		ArrayList<CorreoElectronico> correos = new ArrayList<>();
		
		Path path = Paths.get("main/resources/emails.txt");
	    try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
	 
	       
	      String currentLine = null;
	      while((currentLine = reader.readLine()) != null){//while there is content on the current line
	        CorreoElectronico correo = new CorreoElectronico();
	        //Descompongo la linea en un array de strings
	        
	        String[] linea = currentLine.split(","); 
	       
	        //La primera posicion del array tiene el email
	        correo.setDireccionCorreo(linea[0]);
	        
	        //La segunda posicion el asunto
	        correo.setAsunto(linea[1]); 
	        
	        //Agrego a la lista de correos lo que encontre en la 
	        //linea del archivo
	        correo.add(correo); 
	        
	        
	    	  System.out.println(currentLine); // print the current line
	      }
	    }catch(IOException ex){
	      ex.printStackTrace(); //handle an exception here
	    }
	
	    EnviadorCorreos enviador = new EnviadorCorreos();
	    for (CorreoElectronico correo : correos) {
	    	enviador.enviarCorreo(correo);
	    	
	    }
	}

}
