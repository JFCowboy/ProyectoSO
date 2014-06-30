package Proyecto;

public class Volante extends Jugador{


	
	public Volante(int id, String ubicacion) {
		super(id, ubicacion);
		System.out.println("Se a creado Un Volante "+id);
	}

	
	public Volante() {
		super();
		System.out.println("Se a creado Un Volante ");
	}

	public Volante(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero) {
		super(id, name, ubicacion, brazuca, tablero);
		System.out.println("Se a creado Un Volante "+id);
	}

	@Override
	public void run() {
		
		while( !tablero.isTermino() ){
			brazuca.usarCupoVolante();	//Detiene a delanteros y ocupa posicion de 1 volante
			if(tablero.getUbicacionInt() ==  brazuca.getPosicion()){
				brazuca.addJugador( this );
				esperar(10);	//Espera a algun otro volante
				if(!brazuca.isMoving()){
					brazuca.mover(  );
				}
				
			}
			brazuca.liberarCupoVolante();
			//Jugador Hidratandose
			esperar(100);
			
		}
		
	}

}
