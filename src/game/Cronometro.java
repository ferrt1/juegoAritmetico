package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Cronometro {
  	
	public Timer tiempo;
  	private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    JLabel tempo;
   
   
    
    public void actualizarEtiquetaTiempo() {
		  String texto = (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos <= 9?"0":"")+segundos+":"+(centesimas_segundos <=9?"0":"")+centesimas_segundos;
		  tempo.setText(texto);
		
	}
	
    
    public Cronometro(JLabel a) {
    	this.tempo=a;
    	tiempo = new Timer(10,acciones);
    	tiempo.start();
    } 
    
	public ActionListener acciones  =new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

				centesimas_segundos ++;
	            if(centesimas_segundos == 100){
	                segundos++;
	                centesimas_segundos = 0;
	            }
	            if(segundos == 60){
	                minutos ++;
	                segundos = 0;
	            } 
	            if(minutos == 60){
	                horas ++;
	                minutos = 0;
	            }
	            if(horas == 24){
	                horas = 0;
	            };
	            
	           
	            actualizarEtiquetaTiempo();

		
		};
			
		};
		
		
			
	};