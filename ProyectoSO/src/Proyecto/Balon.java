package Proyecto;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Balon {
	
	//Semaforos
	private Semaphore cupoVolantes;
	private Semaphore cupoDelantero;
	private Semaphore movimiento;		//Semaforo aplicado exclusivamente al metodo de mover
	
	//Atributos que solo tendran acceso internamente. (estan sin get y set)
	private Jugador jugadores[];
	private int posicion, idxAux;	// idxAux es el Numero de Volantes que han usado el semaforo
	private int idx;  				// idx es el numero jugadores que se han agregado al balon
	private Tablero[] tableros; 	// El balon tiene los dos tableros
	private boolean moviendo;
	
	public Balon( Tablero[] tableros ) {
		this(2, 1, tableros);
	}

	public Balon( int posicion, Tablero[] tableros ) {
		this(2, 1, tableros);
		this.posicion = posicion;
	}
	
	public Balon( int nv, int nd, Tablero[] tableros) {
		super( );
		cupoVolantes = new Semaphore( nv );
		cupoDelantero= new Semaphore( nd );
		movimiento = new Semaphore( 1 );
		jugadores = new Jugador[2];
		idx = 0;
		idxAux = 0;
		posicion = 0;
		this.tableros = tableros;
		moviendo = false;
	}

	public Balon(Semaphore cupoVolantes, Semaphore cupoDelantero) {
		super();
		this.cupoVolantes = cupoVolantes;
		this.cupoDelantero = cupoDelantero;
		jugadores = new Jugador[2];
		idx = 0;
		posicion = 0;
	}

	public Semaphore getCupoVolantes( ) {
		return cupoVolantes;
	}

	public void setCupoVolantes(Semaphore cupoVolantes) {
		this.cupoVolantes = cupoVolantes;
	}

	public Semaphore getCupoDelantero( ) {
		return cupoDelantero;
	}

	public void setCupoDelantero( Semaphore cupoDelantero ) {
		this.cupoDelantero = cupoDelantero;
	}
	
	public Semaphore getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Semaphore movimiento) {
		this.movimiento = movimiento;
	}

	public synchronized void addJugador( Jugador jugador ){
		if(idx >= 2) 
			return;
		jugadores[idx] = jugador;
		idx++;
	}
	
	public synchronized void clearJugadores( Jugador jugador ){
		jugadores[0] = jugadores[1] = null;
		idx = 0;
	}

	@Override
	public String toString() {
		return "Balon [cupoVolantes=" + cupoVolantes + ", cupoDelantero="
				+ cupoDelantero + ", jugadores=" + Arrays.toString(jugadores)
				+ ", idx=" + idx + ", posicion=" + posicion + "]";
	}

	/**
	 * Metodo que realiza los cambios de lado del arco
	 * 1) mueve balon
	 * 2) cambia los tableros de referencia a los jugadores
	 * 3) inicia de nuevo su lista de jugadores agregados
	 */
	public synchronized void mover( )  {
		
		if(moviendo || jugadores[0] == null){
			return;
		}
		moviendo = true;
		posicion = (posicion+1)%2;				//Cambia la posicion del balon
		System.out.println( printMensaje() );	//Imprime mensaje de movimiento
		for(int i = 0; i < idx; i++){			//"Cambia los jugadores de arco"
			int table = jugadores[i].getTablero().getUbicacionInt();
			table = (table+1)%2;
			
			//Este es el proceso de cambio de tablero para cada jugador
			jugadores[i].desvincularTablero();
			jugadores[i].setTablero( tableros[table] );
			jugadores[i].vincularTablero();
		}
		terminar();
	}
	
	public void usarCupoVolante() {
		
		if( idxAux==0 )
			this.usarCupoDelantero();
		//Si el primer volante ya usa el cupo del delantero se aumenta el contador
		idxAux++;
		try {
			cupoVolantes.acquire();
		} catch (InterruptedException e) {
			System.out.println("Exception en el metodo Balon.usarCupoVolante");
			e.printStackTrace();
		}
		
	}

	public void usarCupoDelantero() {
	
		try {
			cupoDelantero.acquire();
		} catch (InterruptedException e) {
			System.out.println("Exception en el metodo Balon.usarCupoDelantero");
			e.printStackTrace();
		}
		
	}

	public void liberarCupoVolante() {
		cupoVolantes.release();
		idxAux--;
		if( idxAux==0 )
			this.liberarCupoDelantero();
	}
	
	public void liberarCupoDelantero() {
		cupoDelantero.release();
	}
	
	private String printMensaje() {
		StringBuilder mensaje = new StringBuilder();
		if( idx==2 ){
			int idx = (jugadores[0].getTablero().getUbicacionInt()+1)%2;
			mensaje.append("El Jugador "+jugadores[0].getNombre()+" Y "+jugadores[1].getNombre()
					+" salen de la porteria de " +jugadores[0].getTablero().getUbicacion()+
					", Realizan una pared y se diriguen a la porteria de "+tableros[idx].getUbicacion()+".");
		}else{
			int idx = (jugadores[0].getTablero().getUbicacionInt()+1)%2;
			mensaje.append("El Jugador "+jugadores[0].getNombre()+" toma el balon y se " +
					"dirigue a la porteria de "+tableros[idx].getUbicacion()+".");
		}
		return mensaje.toString();
	}

	public int getPosicion(){
		return posicion;
	}

	public synchronized void terminar() {
		//Reinicia los Jugadores
		jugadores[0] = jugadores[1] = null;
		idx = 0;
		moviendo = false;
		//Imprimir estado actual del tablero
		System.out.println("TABLERO");
		System.out.println(tableros[0]+"\n"+tableros[1]+"\n***");
		
	}

	public boolean isMoving() {
		
		return moviendo;
	}
	
	
}
