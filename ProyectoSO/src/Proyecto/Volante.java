package Proyecto;

import java.util.Random;

public class Volante extends Jugador{


	
	public Volante(int id, String ubicacion) {
		super(id, ubicacion);
		System.out.println("Se ha creado Un Volante "+id);
	}

	
	public Volante() {
		super();
		System.out.println("Se ha creado Un Volante ");
	}

	public Volante(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero, Tablero[] tableros) {
		super(id, name, ubicacion, brazuca, tablero, tableros);
		System.out.println("Se ha creado Un Volante "+id);
	}

	@Override
	public void run() {
		Random random = new Random();
		while( !tablero.isTermino() ){
			brazuca.usarCupoVolante();	//Detiene a delanteros y ocupa posicion de 1 volante
			if(tablero.getUbicacionInt() ==  brazuca.getPosicion()){
				brazuca.addJugador( this );
				esperar( random.nextInt(11) );	//Espera a algun otro volante
				if(!brazuca.isMoving()){
					brazuca.mover(  );
				}
				
			}
			brazuca.liberarCupoVolante();
			//Jugador Hidratandose
			esperar( random.nextInt(42) );
			
		}
		
	}

}
