package Proyecto;

import java.util.Random;

public class Delantero extends Jugador{


	
	public Delantero(int id, String ubicacion) {
		super(id, ubicacion);
		System.out.println("Se ha creado Un Delantero "+id);
	}
	
	public Delantero() {
		super();
		System.out.println("Se ha creado Un Delantero ");
	}

	public Delantero(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero, Tablero[] tableros) {
		super(id, name, ubicacion, brazuca, tablero,tableros);
		System.out.println("Se ha creado Un Delantero "+id);
	}

	@Override
	public void run() {
		Random random = new Random();
		while( !tablero.isTermino() ){
			brazuca.usarCupoDelantero();
			brazuca.usarCupoVolante( 1 );
			brazuca.usarCupoVolante( 1 );
			if(tablero.getUbicacionInt() ==  brazuca.getPosicion()){
				mover();
				//notifyAll();
				//brazuca.liberarCupoDelantero();
			}
			brazuca.liberarCupoVolante( 1 );
			brazuca.liberarCupoVolante( 1 );
			brazuca.liberarCupoDelantero();
			esperar( random.nextInt(42) );
			
		}
		
	}
	
	/**
	 * hace que el delantero se embarque en balon y se mueva de una
	 */
	private synchronized void mover(){
		brazuca.addJugador( this );
		//brazuca.moverJugadores();
		brazuca.mover(  );
	}
	
}
