package Proyecto;

public class Tablero {

	public static int IZQUIERDA = 0;
	public static int DERECHA = 1;
	private int numJugadoresTotal;
	private String ubicacion;
	private int ubicacionInt;
	private boolean termino = false;
	
	public Tablero(String nombreTablero, int numeroJugadores, int ubicacionInt) {
		ubicacion = nombreTablero;
		numJugadoresTotal = numeroJugadores;
		this.ubicacionInt = ubicacionInt;
	}

	@Override
	public String toString() {
		return "Tablero [numJugadoresTotal=" + numJugadoresTotal
				+ ", ubicacion=" + ubicacion + ", ubicacionInt=" + ubicacionInt
				+ ", termino=" + termino + "]";
	}
	
	public synchronized int addNumJugadores(){
		numJugadoresTotal++;
		return numJugadoresTotal;
	}
	
	/**
	 * Reduce el numero de jugadores que tiene en total 
	 * 
	 * @return el numero de jugadores que quedaron
	 */
	public synchronized int subtractNumJugadores(){
		numJugadoresTotal--;
		return numJugadoresTotal;
	}

	public int getNumJugadoresTotal() {
		return numJugadoresTotal;
	}

	public void setNumJugadoresTotal(int numJugadoresTotal) {
		this.numJugadoresTotal = numJugadoresTotal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getUbicacionInt() {
		return ubicacionInt;
	}

	public void setUbicacionInt(int ubicacionInt) {
		this.ubicacionInt = ubicacionInt;
	}

	public boolean isTermino() {
		return termino;
	}

	public void setTermino( boolean termino ) {
		this.termino = termino;
	}

}
