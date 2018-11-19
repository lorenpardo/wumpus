package es.huntthewumpus;
import java.util.Scanner;

import es.huntthewumpus.game.Partida;


	public class MainGame {
		
		public static void main(String[] args) {    
			Scanner s= new Scanner(System.in);			
			boolean oroconseguido=false;
			int resulMov=0;
			String volverAJugar="S";
			
	        //creamos partida para jugar
	        Partida partida = new Partida(); 
	        
	        while (volverAJugar.trim().toUpperCase().equals("S")){
	        	// si decidimos iniciar de nuevo e juego, reseteamos los campos
	        	oroconseguido=false;
	        	resulMov=0;
	        	
		        partida.loadTablero();	        
	
		        while (resulMov==0 || resulMov==2){
		        	if(resulMov==2)
		        		oroconseguido=true;
		        	partida.mover();
		        	
			        //si el resultado del movimiento es:
			        // 	0 (seguimos jugando)
			        // 	2 (oro conseguido, seguimos jugando hasta la salida)
		        	resulMov = partida.estadoPartida(oroconseguido);
		        	
		        }
		        
		        if(resulMov==1)
		        {
		        	System.out.print("¿Quiere volver a jugar?: ");
		            volverAJugar=s.next();
		            System.out.println();	                   
		        }
	        }
	        
	        //fin
	        System.out.println();
	        System.out.print("GRACIAS POR JUGAR!!!!: ");
            System.out.println();	                   
	        s.close();     	            
	    }

	}

