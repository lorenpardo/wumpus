package es.huntthewumpus.game;

import java.util.Random;
import java.util.Scanner;

/**

 * Esta clase define la partida para poder jugar al juego hunt the wumpus

 * @author: Lorenzo Pardo

 * @version: 19/11/2018
 
 * @see: https://github.com/davidblancochs/wumpus/blob/master/WumpusTest.pdf

 */

public class Partida {
	
	//Campos de la clase
	private int dimensionTablero;
	private int numPozos;
	private int numFlechas;
	private Celda[][] tablero;
	private Scanner s= new Scanner(System.in);
    private Random r= new Random(System.nanoTime());
	
    /**

     * Constructor para crear la partida de hunt de wumpus

     * @param dimensionTablero: El parámetro dimensionTablero define la dimensión del tablero del juego
     
     * @param numPozos: El parámetro numPozos, indica el numero de pozos que hay en el tablero
     
     * @param numFlechas: El parámetro numFlechas define el número de flechas que el jugador podra lanzar

     */
	public Partida(int dimensionTablero, int numPozos, int numFlechas) {
		super();
		this.dimensionTablero = dimensionTablero;
		this.numPozos = numPozos;
		this.numFlechas = numFlechas;
		this.tablero = new Celda[dimensionTablero][dimensionTablero];
	}
	
	public Partida() {
		super();
	}
	
	public int getDimensionTablero() {
		return dimensionTablero;
	}

	public void setDimensionTablero(int dimensionTablero) {
		this.dimensionTablero = dimensionTablero;
	}

	public int getNumPozos() {
		return numPozos;
	}

	
	public int getNumFlechas() {
		return numFlechas;
	}

	public void setNumFlechas(int numFlechas) {
		this.numFlechas = numFlechas;
	}

	public void setNumPozos(int numPozos) {
		this.numPozos = numPozos;
	}

	public Celda[][] getTablero() {
		return tablero;
	}

	public void setTablero(Celda[][] tablero) {
		this.tablero = tablero;
	}

	
    /**

     * Método que configura la partida

     */
	private void configPartida(){        
        System.out.print("Introduce n (dimensiones tablero n x n), minimo valor 3: ");
        setDimensionTablero(s.nextInt());
        System.out.print("Introduce Numero Flechas: ");
        setNumFlechas(s.nextInt());
        System.out.print("Introduce Numero Pozos: ");
        setNumPozos(s.nextInt());
        System.out.println();
        this.tablero = new Celda[dimensionTablero][dimensionTablero];
	}
	
    /**

     * Método que indica las instrucciones del juego

     */
	private void instrucciones(){
        System.out.println("INSTRUCCIONES: ");
        System.out.println("    -Avanzar: w ");
        System.out.println("    -Retrasar: s ");
        System.out.println("    -Derecha: d ");
        System.out.println("    -Izquierda: a ");
        System.out.println("    -Lanzar flecha: m ");
        System.out.println();
        System.out.println("POSICIONES: ");
        System.out.println("    -Jugador: o ");
        System.out.println("    -Brisa: b ");
        System.out.println("    -Hedor: h ");
        System.out.println("    -Oro: g ");
        System.out.println("    -Wumpus: w ");
        System.out.println("    -Pozo: p ");
        System.out.println();
        		
	}
	
    /**

     * Método que inicializa todas las celdas del tablero

     */
	private void initCeldas(){
		//inicializar todas las celdas del tablero de juego a 0
        for (int i = 0; i<dimensionTablero; i++){ 
            for (int j = 0; j<dimensionTablero; j++){
                tablero[i][j]= new Celda(0,0,0,0,0,0,0,0);
            }
        }
	}
	
    /**

     * Método que situa la salida en el tablero de juego

     */
	private void situarSalida(){
		for (int j = 0; j<1; j++){ 
            int x = r.nextInt(dimensionTablero);
            int y = r.nextInt(dimensionTablero);
            if(x==0 || x==dimensionTablero-1 || y==0 || y==dimensionTablero-1 ){
                tablero[x][y].setsalida(1);
                tablero[x][y].setvisitado(1);
            }
            else
                j--;
        }
	}
	
	/**

     * Método que situa aleatoriamente el monstruo wumpu en el tablero de la partida

     */
	private void situarWumpu(){
		// lo situamos aleatoriamente
		for (int j = 0; j<1; j++){ 
            int x = r.nextInt(dimensionTablero);
            int y = r.nextInt(dimensionTablero);
            if(tablero[x][y].getsalida() == 0 && tablero[x][y].getwumpus() == 0)
                tablero[x][y].setwumpus(1);
            else
                j--;
		}
	}
	
	/**

     * Método que situa los pozos en el tablero de la partida

     */
	private void situarPozos(){
		for (int j = 0; j<numPozos; j++){ 
            int x = r.nextInt(dimensionTablero);
            int y = r.nextInt(dimensionTablero);  
            if (tablero[x][y].getsalida() == 0 && tablero[x][y].getwumpus() == 0 && tablero[x][y].getpozo() == 0 && tablero[x][y].getjugador() == 0)
                tablero[x][y].setpozo(1);
            else
                j--;
        }
	}
		
	/**

     * Método que situa el oro en el tablero de la partida

     */
	private void situarOro(){
		for (int j = 0; j<1; j++){ 
            int x = r.nextInt(dimensionTablero);
            int y = r.nextInt(dimensionTablero);  
            if (tablero[x][y].getsalida() == 0 && tablero[x][y].getwumpus() == 0 && tablero[x][y].getpozo() == 0 && tablero[x][y].getjugador() == 0)
                tablero[x][y].setoro(1);
            else
                j--;
        }
	}
	
	/**

     * Método que situa aleatoriamente la posicón inicial del jugador en el tablero de la partida

     */
	private void situarJugador()
	{
		//situar jugador aleatoriamente
		for (int j = 0; j<1; j++){ 
            int x = r.nextInt(dimensionTablero);
            int y = r.nextInt(dimensionTablero);  
            if (tablero[x][y].getsalida() == 0 && tablero[x][y].getwumpus() == 0 && tablero[x][y].getpozo() == 0 && tablero[x][y].getoro() == 0)
                tablero[x][y].setjugador(1);
            else
                j--;

        }
	}
	

	/**

     * Método que situa la brisa y el hedor alrederor del wumpu y de los pozos

     */
	private void situarHerdorAndBrisa(){
		for(int j = 0; j<dimensionTablero; j++) // situar hedor y brisas alrededor del wumper y los pozos
            for(int k = 0; k<dimensionTablero; k++){
                if (tablero[j][k].getwumpus() == 1){ //situamos hedor alrededor del wumpi
                    if(j>0)
                        tablero[j-1][k].sethedor(1);
                    if(j<dimensionTablero-1)
                        tablero[j+1][k].sethedor(1);
                    if(k>0)
                        tablero[j][k-1].sethedor(1);
                    if(k<dimensionTablero-1)
                        tablero[j][k+1].sethedor(1);
                }

                if (tablero[j][k].getpozo() == 1){ //situamos brisa alrededor de los pozos
                    if(j>0)
                        tablero[j-1][k].setbrisa(1);
                    if(j<dimensionTablero-1)
                        tablero[j+1][k].setbrisa(1);
                    if(k>0)
                        tablero[j][k-1].setbrisa(1);
                    if(k<dimensionTablero-1)
                        tablero[j][k+1].setbrisa(1);
                }
            }

	}
	
	/**

     * Método que pinta el tablero

     */
	public void pintarTablero(){
		//dibujar tablero
		for (int u = 0; u<dimensionTablero; u++){ //dibujar tablero
            for (int q = 0; q<dimensionTablero; q++){ 
                if  (tablero[u][q].getvisitado()==0 && tablero[u][q].getjugador()==0){ //ponemos 'x' a lo que todavía no se ha visitado
                    System.out.print('x');
                    System.out.print("  ");
                }
                else{ //en el caso de haber visitado la Celda se dibuja con cada letra el contenido de la Celda

                    if(tablero[u][q].getjugador()==1 ){
                        System.out.print('o');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].getsalida()==1){
                        System.out.print('s');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].getwumpus()==1){
                        System.out.print('w');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].getpozo()==1){
                        System.out.print('p');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].getoro()==1){
                        System.out.print('g');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].getbrisa()==1 && tablero[u][q].getwumpus()==0){
                        System.out.print('b');
                        System.out.print("  ");
                    }
                    else if(tablero[u][q].gethedor()==1 && tablero[u][q].getpozo()==0){
                        System.out.print('h');
                        System.out.print("  ");
                    }
                    else{
                        System.out.print('-');
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }

	}
	
	/**

     * Método que carga el tablero para poder jugar

     */
	public void loadTablero(){
		configPartida();
		instrucciones();
		initCeldas();
		situarSalida();
		situarWumpu();
		situarPozos();
		situarOro();
		situarJugador();
		situarHerdorAndBrisa();
		pintarTablero();		
	}
	
	/**

     * Método que, tras realizar un movimiento, analiza el estado de la partida
     
     * @param oroConseguido: Parámetro que indica si ya hemos conseguido el oro, en la partida
     
     * @return un entero indicando estado de la partida, 0 (seguimos jugando), 1 (se acabo el juego), 2 (oro conseguido, seguimos jugando)

     */
	public int estadoPartida(boolean oroConseguido){

		 //int = 0 --> seguimos jugando
		 //int = 1 --> se acabo el juego
		 //int = 2 --> oro conseguido, seguimos jugando hasta la salida

		int retorno = 0;
		
		//situación de la Celda
        for (int i = 0; i<dimensionTablero; i++){ 
            for (int j = 0; j<dimensionTablero; j++){ 
                if  (getTablero()[i][j].getjugador()==1){
                    if(getTablero()[i][j].getwumpus()==1){
                        System.out.print("WUMPUS fin del juego \n");
                        retorno=1;                 
                    }
                    if(getTablero()[i][j].getpozo()==1){
                        System.out.print("POZO fin del juego \n");
                        retorno=1;
                    }
                    if(getTablero()[i][j].getoro()==1){
                        System.out.print("ORO \n");
                        retorno=2;
                    }
                    if(getTablero()[i][j].getbrisa()==1)
                        System.out.print("BRISA \n");
                    if(getTablero()[i][j].gethedor()==1)
                        System.out.print("HEDOR \n");
                    if(getTablero()[i][j].getsalida()==1 && oroConseguido==true){
                        System.out.print("¡¡¡GANADOR!!! \n");
                        retorno=1;
                    }
                }
            }
        }
        return retorno;

	}
	
	/**

     * Método que se encarga de realizar el movimiento del jugador en la partida

     */
	public void mover(){
		System.out.println();
        System.out.print("Movimiento: ");
        String m = s.next();
        if (m.equals("d")){
            for (int u=0; u<dimensionTablero; u++){ 
                for (int q = dimensionTablero-1; q>-1; q--){ 
                    if(getTablero()[u][q].getjugador()==1 && q<dimensionTablero-1){
                        getTablero()[u][q].setjugador(0);
                        getTablero()[u][q+1].setjugador(1);
                        getTablero()[u][q].setvisitado(1);
                    }
                }
            }
        }

        if (m.equals("a")){
            for (int u = 0; u<dimensionTablero; u++){ 
                for (int q = 0; q<dimensionTablero; q++){ 
                    if(getTablero()[u][q].getjugador()==1 && q>0){
                        getTablero()[u][q].setjugador(0);
                        getTablero()[u][q-1].setjugador(1);
                        getTablero()[u][q].setvisitado(1);
                    }
                }
            }
        }

        if (m.equals("s")){
            for (int u = dimensionTablero-1; u>-1; u--){ 
                for (int q = 0; q<dimensionTablero; q++){ 
                    if(getTablero()[u][q].getjugador()==1 && u<dimensionTablero-1 ){
                        getTablero()[u][q].setjugador(0);
                        getTablero()[u+1][q].setjugador(1);
                        getTablero()[u][q].setvisitado(1);
                    }
                }
            }
        }

        if (m.equals("w")){
            for (int u = 0; u<dimensionTablero; u++){ 
                for (int q = 0; q<dimensionTablero; q++){ 
                    if(getTablero()[u][q].getjugador()==1 && u>0){
                        getTablero()[u][q].setjugador(0);
                        getTablero()[u-1][q].setjugador(1);
                        getTablero()[u][q].setvisitado(1);
                    }
                }
            }
        }

        if (m.equals("m") && getNumFlechas()>0){
            System.out.print("¿Hacia qué dirección quieres matar?: ");
            String v = s.next();

            if (v.equals("d")){
                for (int u=0; u<dimensionTablero; u++){ 
                    for (int q = dimensionTablero-1; q>-1; q--){ 
                        if(getTablero()[u][q].getjugador()==1 && q<dimensionTablero-1){

                            if(getTablero()[u][q+1].getwumpus()==1){
                                System.out.println("WUMPUS ELIMINADO");
                                getTablero()[u][q+1].setwumpus(0);
                                numFlechas--;
                            }
                            else{
                                System.out.println("WUMPUS NO SE ENCUENTRA EN ESTA POSICIÓN");
                                numFlechas--;
                            }

                        }
                    }
                }
            }

            if (v.equals("a")){
                for (int u = 0; u<dimensionTablero; u++){ 
                    for (int q = 0; q<dimensionTablero; q++){ 
                        if(getTablero()[u][q].getjugador()==1 && q>0){
                            if(getTablero()[u][q-1].getwumpus()==1){
                                System.out.println("WUMPUS ELIMINADO");
                                getTablero()[u][q-1].setwumpus(0);
                                numFlechas--;
                            }
                            else{
                                System.out.println("WUMPUS NO SE ENCUENTRA EN ESTA POSICIÓN");
                                numFlechas--;
                            }
                        }
                    }
                }
            }

            if (v.equals("s")){
                for (int u = dimensionTablero-1; u>-1; u--){ 
                    for (int q = 0; q<dimensionTablero; q++){ 
                        if(getTablero()[u][q].getjugador()==1 && u<dimensionTablero-1 ){
                            if(getTablero()[u+1][q].getwumpus()==1){
                                System.out.println("WUMPUS ELIMINADO");
                                getTablero()[u+1][q].setwumpus(0);
                                numFlechas--;
                            }
                            else{
                                System.out.println("WUMPUS NO SE ENCUENTRA EN ESTA POSICIÓN");
                                numFlechas--;
                            }
                        }
                    }
                }
            }

            if (v.equals("w")){
                for (int u = 0; u<dimensionTablero; u++){ 
                    for (int q = 0; q<dimensionTablero; q++){ 
                        if(getTablero()[u][q].getjugador()==1 && u>0){
                            if(getTablero()[u-1][q].getwumpus()==1){
                                System.out.println("WUMPUS ELIMINADO");
                                getTablero()[u-1][q].setwumpus(0);
                                numFlechas--;
                            }
                            else{
                                System.out.println("WUMPUS NO SE ENCUENTRA EN ESTA POSICIÓN");
                                numFlechas--;
                            }
                        }
                    }
                }
            }

        }else if(m.equals("m") && numFlechas<1)
            System.out.println("No quedan flechas");

        System.out.println();
        instrucciones();
        pintarTablero();
        System.out.println();
	}
}
