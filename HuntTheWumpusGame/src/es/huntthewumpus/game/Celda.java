package es.huntthewumpus.game;

/**

 * Esta clase defines celdas que tendra un tablero de la partida para poder jugar

 * @author: Lorenzo Pardo

 * @version: 19/11/2018
 
 * @see: https://github.com/davidblancochs/wumpus/blob/master/WumpusTest.pdf

 */
public class Celda {
	private int oro;
    private int wumpus;
    private int pozo;
    private int brisa;
    private int hedor;
    private int jugador;
    private int visitado;
    private int salida;
    
    /**

     * Constructor para crear la partida de hunt de wumpus

     * @param oro: El parámetro oro define si la celda tiene el oro
     
     * @param wumpu: El parámetro wumpu define si la celda esta el wumpu
     
     * @param pozo: El parámetro pozo define si la celda es un pozo
     
     * @param brisa: El parámetro brisa define si la celda tiene brisa, porque cerca hay un pozo
     
     * @param hedor: El parámetro hedor define si la celda tiene hedor, porque cerca esta el wumpu
     
     * @param jugador: El parámetro jugador define si en la celda esta el jugador
     
     * @param visitado: El parámetro visitado define si la celda ha sido visitada por el jugador
     
     * @param salida: El parámetro salida define si la celda es la salida del juego

     */
    public Celda(int oro, int wumpus, int pozo, int brisa, int hedor, int jugador, int visitado, int salida){
        oro = 0;
        wumpus = 0;
        pozo = 0;
        brisa = 0;
        hedor = 0;
        jugador= 0;
        visitado=0;
        salida=0;

    }

    public int getoro() {
        return oro;
    }

    public int getwumpus() {
        return wumpus;
    }

    public int getpozo() {
        return pozo;
    }

    public int getbrisa() {
        return brisa;
    }

    public int gethedor() {
        return hedor;
    }

    public int getjugador() {
        return jugador;
    }
    
    public int getvisitado() {
        return visitado;
    }
    
    public int getsalida() {
        return salida;
    }

    public void setoro(int oro){
        this.oro = oro;
    }

    public void setwumpus(int wumpus) {
        this.wumpus = wumpus;
    }

    public void setpozo(int pozo) {
        this.pozo = pozo;
    }

    public void setbrisa(int brisa) {
        this.brisa = brisa;
    }

    public void sethedor(int hedor) {
        this.hedor = hedor;
    }

    public void setjugador(int jugador) {
        this.jugador = jugador;
    }
    
    public void setvisitado(int visitado) {
        this.visitado = visitado;
    }
    
    public void setsalida(int salida) {
        this.salida = salida;
    }
}
