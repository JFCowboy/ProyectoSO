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
			if(tablero.getUbicacionInt() ==  brazuca.getPosicion()){
				brazuca.addJugador( this );
				brazuca.mover();
				//notifyAll();
			}else{
//				try {
//					this.wait();
//				} catch (InterruptedException e) {
//					System.out.println("NO quiero detenerme, ahora te mordere :3" + name);
//					e.printStackTrace();
//				}
			}
			//brazuca.moverJugadores();
			
		}
		
	}

}
