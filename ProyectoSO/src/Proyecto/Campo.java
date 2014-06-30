package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Clase principal la en la cual se inician y coordinan las variables globales.  
 * @author JuanFelipe
 *
 */
public class Campo {

	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String linea;
	
		while(true){
			System.out.println("Menu");
			System.out.println("Ingrese 1 para terminar, otro valor para continuar.");
			linea = bf.readLine();
			if(linea.equals("1"))
				break;
			simularJuego(bf);
		}
	}

	/**
	 * Metodo para la simulacion de la dinamica del juego
	 * @param bf
	 * @throws IOException
	 */
	private static void simularJuego(BufferedReader bf) throws IOException {
		
		//StringTokenizer st;
		String linea;
		System.out.println("Ingrese el numero de volantes en el arco de Colombia");
		linea = bf.readLine();
		Integer volantesCol = Integer.parseInt(linea);
		
		System.out.println("Ingrese el numero de delanteros en el arco de Colombia");
		linea = bf.readLine();
		Integer delanterosCol = Integer.parseInt(linea);
		
		System.out.println("Ingrese el numero de volantes en el arco de Alemania");
		linea = bf.readLine();
		Integer volantesAle = Integer.parseInt(linea);
		
		System.out.println("Ingrese el numero de delanteros en el arco de Alemania");
		linea = bf.readLine();
		Integer delanterosAle = Integer.parseInt(linea);
		
		int derecha = volantesCol + delanterosCol;
		int izquierda = volantesAle + delanterosAle;
		
		//Numero tableros, el 0 es para Colombia el 1 es para Alemania
		Tablero[] tableros = new Tablero[2];  
		String nombreTablero0 = "Colombia";
		String nombreTablero1 = "Alemania";
		tableros[0] = new Tablero(nombreTablero0, derecha,0);
		tableros[1] = new Tablero(nombreTablero1, izquierda,1);
		
		Balon balon = new Balon(tableros);
		
		Jugador[] jugadoresCol = new Jugador[derecha];
		Jugador[] jugadoresAle = new Jugador[izquierda];
		Thread hilos [] = new Thread[derecha + izquierda];
		
		int idxCol, idxAle, idxH;
		idxCol = idxAle = idxH = 0;
		
		//*********************Crear Jugadores del lado Derecho******************************
		//Crear Volantes
		for( ; idxCol < volantesCol ; idxCol++){
			
			jugadoresCol[idxCol] = new Volante(idxCol, "Col"+idxCol, "Volante", balon, tableros[0] );
			hilos[idxH++] = new Thread(jugadoresCol[idxCol]);
		}
		//Crear Delanteros
		for( ; idxCol < derecha ; idxCol++){
			jugadoresCol[idxCol] = new Delantero(idxCol, "Col"+idxCol, "Delantero", balon, tableros[0]);
			hilos[idxH++] = new Thread(jugadoresCol[idxCol]);
		}
		
		//*********************Crear Jugadores del lado Izquierdo******************************
		//Crear Volantes
		for( ; idxAle < volantesAle ; idxAle++) {
			jugadoresAle[idxAle] = new Volante(idxAle, "Ale"+idxAle, "Volante", balon, tableros[1]);
			hilos[idxH++] = new Thread(jugadoresAle[idxAle]);
		}
		//Crear Delanteros
		for( ; idxAle < izquierda ; idxAle++) {
			jugadoresAle[idxAle] = new Delantero(idxAle, "Ale"+idxAle, "Delantero", balon, tableros[1]);
			hilos[idxH++] = new Thread(jugadoresAle[idxAle]);
		}
		
		for(int k = 0; k < idxH; k++){
			hilos[k].start();
		}
		
		for(int k = 0; k < idxH; k++){
			try {
				hilos[k].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
