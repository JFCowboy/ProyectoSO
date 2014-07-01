package Proyecto;

package OperativeSystems.Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Clase principal la en la cual se inician y coordinan las variables globales.  
 * @author JuanFelipe
 *
 */
public class Campo {

	static String asteriscosLargo = "*************************************************************";
	static String asteriscosCorto = "**************************";
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String linea;
	
		while(true){
			System.out.println(asteriscosLargo);
			System.out.println(asteriscosCorto+"Menu"+asteriscosCorto);
			System.out.println("Ingrese 0 para terminar, otro valor para continuar.");
			linea = bf.readLine();
			if(linea.equals("0"))
				break;
			simularJuego(bf);
			System.out.println(asteriscosLargo);
		}
	}

	/**
	 * Metodo para la simulacion de la dinamica del juego
	 * @param bf
	 * @throws IOException
	 */
	private static void simularJuego(BufferedReader bf) throws IOException {
		
		//Numero tableros, el 0 es para Colombia el 1 es para Alemania por defecto
		Tablero[] tableros = new Tablero[2];
		String linea = "";
		String nombreTablero0 = "Colombia";
		String nombreTablero1 = "Alemania";
		int ladoBalon = 0; 
		
		while( true ){
			//	Valores del campo
			System.out.println(asteriscosCorto+"Valores Del Campo"+asteriscosCorto);
			System.out.println("1er equipo: "+ nombreTablero0);
			System.out.println("2do equipo: "+ nombreTablero1);
			System.out.println("Balon Lado de "+(ladoBalon==0?nombreTablero0:nombreTablero1));
			System.out.println(asteriscosCorto);
			System.out.println("Ingrese 1 para confirmar valores, Otro valor para Modificar");
			linea = bf.readLine();
		
			if( linea.equals("1") )
				break;
			
			System.out.printf("Para modificar nombre Equipo 1 (%s) oprima 1.\n",nombreTablero0);
			linea = bf.readLine();
			if( linea.equals("1") ){
				System.out.print("Ingrese nombre del Equipo 1: ");
				nombreTablero0 = bf.readLine();
			}
			
			System.out.printf("Para modificar nombre Equipo 2 (%s) oprima 1.\n",nombreTablero1);
			linea = bf.readLine();
			if( linea.equals("1") ){
				System.out.print("Ingrese nombre del Equipo 2: ");
				nombreTablero1 = bf.readLine();
			}
			
			System.out.printf("Para modificar Lado del balon (%s) oprima 1.\n",(ladoBalon==0?"Izquierdo":"Derecho"));
			linea = bf.readLine();
			if( linea.equals("1") ){
				linea = "2";
				while( !linea.equals("0") && !linea.equals("1") ){
					System.out.print("Ingrese el lado del balon (0 lado izquierdo, 1 lado derecho): ");
					linea = bf.readLine();
				}
				ladoBalon = Integer.parseInt(linea);
			}
		}
		
		
		System.out.println("Ingrese el numero de volantes en el arco de "+nombreTablero0);
		linea = bf.readLine();
		Integer volantesCol = Integer.parseInt(linea);
		
		while(volantesCol<2){
			
			System.out.println("No de volantes no válido. (>=2)\n"
					+ "Ingrese el número de volantes en el arco de "+nombreTablero0+" nuevamente");
			linea = bf.readLine();
			volantesCol = Integer.parseInt(linea);
			
		}
		
		System.out.println("Ingrese el numero de delanteros en el arco de "+nombreTablero0);
		linea = bf.readLine();
		Integer delanterosCol = Integer.parseInt(linea);
		
		System.out.println("Ingrese el numero de volantes en el arco de "+nombreTablero1);
		linea = bf.readLine();
		Integer volantesAle = Integer.parseInt(linea);
		
while(volantesAle<2){
			
			System.out.println("No de volantes no válido. (>=2) \n"
					+ "Ingrese el número de volantes en el arco de "+nombreTablero1+" nuevamente");
			linea = bf.readLine();
			volantesAle = Integer.parseInt(linea);
			
		}
		
		System.out.println("Ingrese el numero de delanteros en el arco de "+nombreTablero1);
		linea = bf.readLine();
		Integer delanterosAle = Integer.parseInt(linea);
		
		int derecha = volantesCol + delanterosCol;
		int izquierda = volantesAle + delanterosAle;
		
		tableros[0] = new Tablero(nombreTablero0, derecha,0);
		tableros[1] = new Tablero(nombreTablero1, izquierda,1);
		Balon balon = new Balon(ladoBalon);
		
		Jugador[] jugadoresCol = new Jugador[derecha];
		Jugador[] jugadoresAle = new Jugador[izquierda];
		Thread hilos [] = new Thread[derecha + izquierda];
		
		int idxCol, idxAle, idxH;
		idxCol = idxAle = idxH = 0;
		
		//*********************Crear Jugadores del lado Derecho******************************
		//Crear Volantes
		for( ; idxCol < volantesCol ; idxCol++){
			
			jugadoresCol[idxCol] = new Volante(idxCol, "Col"+idxCol, "Volante", balon, tableros[0],tableros );
			hilos[idxH++] = new Thread(jugadoresCol[idxCol]);
		}
		//Crear Delanteros
		for( ; idxCol < derecha ; idxCol++){
			jugadoresCol[idxCol] = new Delantero(idxCol, "Col"+idxCol, "Delantero", balon, tableros[0],tableros);
			hilos[idxH++] = new Thread(jugadoresCol[idxCol]);
		}
		
		//*********************Crear Jugadores del lado Izquierdo******************************
		//Crear Volantes
		for( ; idxAle < volantesAle ; idxAle++) {
			jugadoresAle[idxAle] = new Volante(idxAle, "Ale"+idxAle, "Volante", balon, tableros[1],tableros);
			hilos[idxH++] = new Thread(jugadoresAle[idxAle]);
		}
		//Crear Delanteros
		for( ; idxAle < izquierda ; idxAle++) {
			jugadoresAle[idxAle] = new Delantero(idxAle, "Ale"+idxAle, "Delantero", balon, tableros[1],tableros);
			hilos[idxH++] = new Thread(jugadoresAle[idxAle]);
		}
		
		System.out.println(asteriscosCorto+" INICIO ENTRENAMIENTO "+asteriscosCorto);
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
		System.out.println(asteriscosCorto+" FIN ENTRENAMIENTO "+asteriscosCorto);
	}

}
