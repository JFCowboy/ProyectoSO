package proyecto;

//CLASES NECESARIAS PARA LA EJECUCION
import javax.swing.*;
import java.util.*;
import java.awt.*;


//CLASE CENTRAL
public class Frame extends JFrame{

	static String PATH = "image/";
	
	//REPRESENTA LO QUE SE VA A IMPRIMIR EN PANTALLA
	private LinkedList<String> cola = null;
	//ETIQUETAS AUXILIARES
	private JLabel etiqueta[] = new JLabel[9];
	//PANEL CENTRAL
	private panelFondo pp = new panelFondo();
	
	//CONSTRUCTOR DE LA CLASE
	public Frame(){
		//TRABAJO DE LOS LAYOUTS EN LOS COMPONENTES
		this.setLayout(new BorderLayout());
		//AGREGADO DEL PANEL AL FRAME
		this.add(pp,BorderLayout.CENTER);
		this.setTitle("Proyecto de SO");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pp.setLayout(new GridLayout(3,3));

		//AGREGADO DE COMPONENTES MUERTOS AL PANEL
		for(int x=0;x<9;++x){
			etiqueta[x] = new JLabel();
			pp.add(new JLabel());
		}
		//REMUEVO  LOS COMPONENTES AUXILIARES Y AGREGO LOS QUE VAN A ENCARGARSE DE LA IMPRESION
		pp.remove(3);
		pp.add(etiqueta[0],3);
		pp.remove(4);
		pp.add(etiqueta[1],4);
		pp.remove(5);
		pp.add(etiqueta[2],5);
		pp.updateUI();
		//HAGO VISIBLE EL PANEL 
		this.setVisible(true);
	}
	
	public Frame(LinkedList<String> colaa){
		this();
		this.cola = colaa;
	}
	
	//CARGADO DE LAS IMAGENES EN EL JLABEL PARA HACERLO VISIBLE EN PANTALLA
	public void print(){	
		//SE LEEN TODOS LOS ELEMENTOS A IMMPRIMIR UNO A UNO
		for(int x=0;x<cola.size();++x){
			//EN EL CASO QUE SEA UN DELANTERO
			if(cola.get(x).equals("DelanteroC")){
				
				//SE IMPRIME EN EL PRIMER CUADRO EL DELANTERO
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroC.png") ) );
				//SE ESPERA MEDIO SEGUNDO MIENTRAS ES VISTO POR EL USUARIO
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				// SE QUITA LA IMAGEN PARA QUE NO SALGAN DOS IMAGENES EN PANTALLA
				etiqueta[0].setIcon(null);
				// SE CARGA EN EL SIGUIENTE CUADRO
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroC.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				//LA MISMA VAINA
				etiqueta[1].setIcon(null);
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroC.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				
			//EN EL CASO VOLANTE
			}else if(cola.get(x).equals("VolanteC")){
				
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteC.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteC.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteC.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
			}else if(cola.get(x).equals("DelanteroCi")){
				
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
			}else if(cola.get(x).equals("VolanteCi")){
				
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteCi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
			}

                        //**************************************************************************
                        
                        if(cola.get(x).equals("DelanteroA")){
				//SE IMPRIME EN EL PRIMER CUADRO EL DELANTERO
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroA.png") ) );
				//SE ESPERA MEDIO SEGUNDO MIENTRAS ES VISTO POR EL USUARIO
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				// SE QUITA LA IMAGEN PARA QUE NO SALGAN DOS IMAGENES EN PANTALLA
				etiqueta[0].setIcon(null);
				// SE CARGA EN EL SIGUIENTE CUADRO
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroA.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				//LA MISMA VAINA
				etiqueta[1].setIcon(null);
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroA.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				
			//EN EL CASO VOLANTE
			}else if(cola.get(x).equals("VolanteA")){
				
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteA.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteA.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteA.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
			}else if(cola.get(x).equals("DelanteroAi")){
				
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"delanteroAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
			}else if(cola.get(x).equals("VolanteAi")){
				
				etiqueta[2].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[2].setIcon(null);
				etiqueta[1].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[1].setIcon(null);
				etiqueta[0].setIcon(new ImageIcon(this.getClass().getResource(Frame.PATH+"volanteAi.png") ) );
				try{
					Thread.sleep(500);
				}catch(InterruptedException ex){}
				etiqueta[0].setIcon(null);
			}

			 

			 

			pp.updateUI();				
	
		}
	}	

	public static void main (String args[]){
		LinkedList<String> cola = new LinkedList<String>();
		cola.add("DelanteroAi");
		cola.add("VolanteCi");
		cola.add("DelanteroA");
		cola.add("VolanteA");
		cola.add("DelanteroC");
		cola.add("DelanteroCi");
		cola.add("VolanteA");
		cola.add("DelanteroC");
		cola.add("VolanteA");
		Frame test = new Frame(cola);
	}

	public void printTermino() {
		JOptionPane.showMessageDialog(this, "El entrenamiento Termino");
	}
}

//CREACION DEL PANEL CON LA IMAGEN DE FONDO 
//SE HACE PARA PODER INSERTAR LA IMAGEN DE FONDO EN EL PINTADO DEL PANEL
class panelFondo extends JPanel{

	public panelFondo(){
		super();
		this.setOpaque(false);
	}	

	@Override
	public void paint(Graphics g){
		//DIBUJADO DE LA IMAGEN
		Image pp = new ImageIcon(this.getClass().getResource(Frame.PATH+"fondo.jpg")).getImage();
		g.drawImage(pp,0,0,null);
		super.paint(g);
	}	

}
