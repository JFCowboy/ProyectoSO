package Proyecto;

public abstract class Jugador extends Thread{
	/**
	 * id: numero unico que le corresponde al jugador
	 * name: Nombre del Jugador
	 * alineacion: posicion del jugador en el campo(Volante, Delatero)
	 */
	protected int identificador;
	protected String nombre, alineacion;
	protected Balon brazuca;
	protected Tablero tablero;
	protected boolean termino = false;
	
	public Jugador() {
		super( );
	}
	
	public Jugador(int id, String ubicacion) {
		super();
		this.identificador = id;
		this.alineacion = ubicacion;
		this.nombre = "Jugador"+id;
		
	}
	

	
	public Jugador(int id, String name, String ubicacion, Balon brazuca,
			Tablero tablero) {
		super();
		this.identificador = id;
		this.nombre = name;
		this.alineacion = ubicacion;
		this.brazuca = brazuca;
		this.tablero = tablero;
	}

	public String getUbicacion() {
		return alineacion;
	}

	public void setUbicacion(String ubicacion) {
		this.alineacion = ubicacion;
	}

	public Balon getBrazuca() {
		return brazuca;
	}

	public void setBrazuca(Balon brazuca) {
		this.brazuca = brazuca;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public boolean isTermino() {
		return termino;
	}

	public void setTermino(boolean termino) {
		this.termino = termino;
	}
	
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlineacion() {
		return alineacion;
	}

	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}

	public void desvincularTablero(){
		int numJugadores = tablero.subtractNumJugadores(); 
		if(numJugadores == 0 && tablero.getUbicacionInt()==Tablero.IZQUIERDA){
			termino = true;
		}
	}
	
	public void vincularTablero(){
		tablero.addNumJugadores();
		if(termino){
			tablero.setTermino(true);
		}
	}
	
	public void esperar( int time ){
		try {
			sleep( time );
		} catch (InterruptedException e) {
			System.out.println("no quiero detenerme, ahora te mordere :3" + nombre);
			e.printStackTrace();
		}
	}
	
}
