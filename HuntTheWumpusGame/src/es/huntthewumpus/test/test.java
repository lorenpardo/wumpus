package es.huntthewumpus.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import es.huntthewumpus.game.Celda;
import es.huntthewumpus.game.Partida;

public class test {
	//vamos a generar un escenario comun para todos los test
	
	Partida partidaTest;
	boolean oroConseguido=false;
	
    @Before 
    public void initialize() {
    	   
    	   int dimensionTablero=3;
	       partidaTest= new Partida();      
	       Celda [][] tablero = new Celda[dimensionTablero][dimensionTablero];
	       //inicializar todas las celdas del tablero de juego a 0
	       for (int i = 0; i<dimensionTablero; i++){ 
	            for (int j = 0; j<dimensionTablero; j++){
	                tablero[i][j]= new Celda(0,0,0,0,0,0,0,0);
	            }
	       }
	       partidaTest.setTablero(tablero);
	       partidaTest.setDimensionTablero(dimensionTablero);
	       tablero[0][0].setsalida(1);
	       tablero[0][0].setbrisa(1);
	       
	       tablero[0][1].setjugador(1);
	       
	       tablero[0][2].sethedor(1);
	       
	       tablero[1][0].setpozo(1);
	       
	       tablero[1][1].setbrisa(1);
	       tablero[1][1].sethedor(1);
	       
	       tablero[1][2].setwumpus(1);
	       
	       tablero[2][0].setbrisa(1);
	       
	       tablero[2][1].setoro(1);
	       
	       tablero[2][2].sethedor(1);  
	       
	       //asi deberia estar el tablero de la partida
	       //| S/B | O   | H |
	       //
	       //| P   | B/H | W |
	       //
	       //| B   | G   | H |
    }
	
    @Test
	public void testEstaEnHedor(){
    	System.out.println("testEstaEnHedor");
		//muevo hacia la derecha
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
    	
    	partidaTest.getTablero()[0][2].setjugador(1);
    	
    	partidaTest.pintarTablero();
    	assertEquals("HEDOR",0, partidaTest.estadoPartida(oroConseguido));
	}
    
    @Test
	public void testEstaEnBrisa(){
		System.out.println("testEstaEnBrisa");
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
		
		partidaTest.getTablero()[0][2].setjugador(0);
		partidaTest.getTablero()[0][2].setvisitado(1);
		
    	partidaTest.getTablero()[1][1].setjugador(0);
    	partidaTest.getTablero()[1][1].setvisitado(1);
    	
    	partidaTest.getTablero()[2][1].setjugador(0);
    	partidaTest.getTablero()[2][1].setvisitado(1);
    	
    	partidaTest.getTablero()[2][0].setjugador(1);
    	
    	partidaTest.pintarTablero();
    	assertEquals("BRISA",0, partidaTest.estadoPartida(oroConseguido));
		
	}
    
	@Test
	public void testEstaEnBrisayHedor(){
		System.out.println("testEstaEnBrisayHedor");
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
		
		partidaTest.getTablero()[0][2].setjugador(0);
		partidaTest.getTablero()[0][2].setvisitado(1);
		
    	partidaTest.getTablero()[1][1].setjugador(1);
    	
    	partidaTest.pintarTablero();
    	assertEquals("BRISA y HEDOR",0, partidaTest.estadoPartida(oroConseguido));
		
	}
	@Test
	public void testCogeOro(){
		System.out.println("testCogeOro");
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
		
		partidaTest.getTablero()[0][2].setjugador(0);
		partidaTest.getTablero()[0][2].setvisitado(1);
		
    	partidaTest.getTablero()[1][1].setjugador(0);
    	partidaTest.getTablero()[1][1].setvisitado(1);
    	
    	partidaTest.getTablero()[2][1].setjugador(1);
    	partidaTest.pintarTablero();
    	assertEquals("ORO",2, partidaTest.estadoPartida(oroConseguido));
		
	}
	@Test
	public void testCaeAlPozo(){
		System.out.println("testEstaEnBrisa");
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
		
		partidaTest.getTablero()[0][2].setjugador(0);
		partidaTest.getTablero()[0][2].setvisitado(1);
		
    	partidaTest.getTablero()[1][1].setjugador(0);
    	partidaTest.getTablero()[1][1].setvisitado(1);
    	
    	partidaTest.getTablero()[2][1].setjugador(0);
    	partidaTest.getTablero()[2][1].setvisitado(1);
    	
    	partidaTest.getTablero()[2][0].setjugador(0);
    	partidaTest.getTablero()[2][0].setvisitado(1);
    	
    	partidaTest.getTablero()[1][0].setjugador(1);
    	
    	partidaTest.pintarTablero();
    	assertEquals("POZO",1, partidaTest.estadoPartida(oroConseguido));
		
	}
	@Test
	public void testComeWumpu(){
		System.out.println("testComeWumpu");
		//muevo hacia la derecha
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
    	
    	partidaTest.getTablero()[0][2].setjugador(0);
    	partidaTest.getTablero()[0][2].setvisitado(1);
    	
    	partidaTest.getTablero()[1][2].setjugador(1);
    	partidaTest.pintarTablero();
    	assertEquals("WUMPU",1, partidaTest.estadoPartida(oroConseguido));
	}
	@Test
	public void testGanaPartida(){
		System.out.println("testGanaPartida");
		oroConseguido=true;
		//muevo hacia la derecha
    	partidaTest.getTablero()[0][1].setjugador(0);
    	partidaTest.getTablero()[0][1].setvisitado(1);
    	
    	partidaTest.getTablero()[0][0].setjugador(1);
    	
    	partidaTest.pintarTablero();
    	assertEquals("GANADOR",1, partidaTest.estadoPartida(oroConseguido));
		
	}
}


