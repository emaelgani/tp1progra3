package game;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class TableroGrafico {
	CreacionDeTablero tablero;
	private JFrame frame;
	private int cantidadDeIntentos;
	private int record;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, String dificultad) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroGrafico window = new TableroGrafico(dificultad);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 */
	public TableroGrafico(String dificultad) {
		initialize(dificultad);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String dificultad) {
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// recuadro intentos
		
		JLabel intentos = new JLabel("Intentos: " + getCantidadDeIntentos());
		intentos.setFont(new Font("Unispace", Font.ITALIC, 14));
		intentos.setForeground(new Color(255, 255, 255));
		intentos.setBounds(10, 8, 131, 14);
		frame.getContentPane().add(intentos); 
		
		// recuadro record
		
		JLabel record = new JLabel("Record: " + getRecord());
		record.setForeground(new Color(255, 255, 255));
		record.setFont(new Font("Unispace", Font.ITALIC, 14));
		record.setBounds(151, 8, 141, 14);
		frame.getContentPane().add(record);
		
	

		//INSTANCIO ACA EL TABLERO
		if(dificultad.equals("facil")) {
			tablero = new CreacionDeTablero(3,3);
			setCantidadDeIntentos(10);
			intentos.setText("Intentos: " + getCantidadDeIntentos()); 
			
		}
		if(dificultad.equals("normal")) {
			tablero = new CreacionDeTablero(4,4);
			setCantidadDeIntentos(15);
			intentos.setText("Intentos: " + getCantidadDeIntentos());
			
		}
		
		if(dificultad.equals("dificil")) {
			tablero = new CreacionDeTablero(5,5);
			setCantidadDeIntentos(20);
			intentos.setText("Intentos: " + getCantidadDeIntentos());
			
		}
		
		//FUNCION QUE UBICA A LOS BOTONES EN EL FRAME RECIBIENDO SUS UBICACIONES
		ubicarBotones(frame, tablero.getMatrizButton(), tablero.getUbicaciones(), tablero.getTablero());
		
		//FUNCION QUE ACTUALIZA EL TEXTO DE CADA BOTON
		actualizarBotones(tablero.getMatrizButton(), tablero.getTablero());
		
		//FUNCION QUE AGREGA EL EVENTO A CADA BOTON
		agregarEventos(tablero.getMatrizButton(), tablero.getTablero(), intentos, record);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(TableroGrafico.class.getResource("/img/fondoJuego1.jpg")));
		imagen.setBounds(0, 0, 600, 400);
		frame.getContentPane().add(imagen);
		

		
	}
	
	//----------FUNCION QUE ESTABLECE EL EVENTO A CADA BOTON-------------
	private void agregarEventos(JButton matrizButton[][], TableroLogica tb, JLabel intentos, JLabel record ) {
			
		
		for(int fila=0; fila<matrizButton[0].length; fila++) {
			for(int col=0; col<matrizButton[fila].length; col++) {
			
	
				matrizButton[fila][col].addActionListener( new ActionListener()  {
					
					public void actionPerformed(ActionEvent e) {
					
						String nombreBoton = ((JButton) e.getSource()).getName();
						int fila = Integer.parseInt(nombreBoton.charAt(0)+"");
						int columna = Integer.parseInt(nombreBoton.charAt(2)+"");
						System.out.println("fila: "+fila+", columna: "+columna );
						
						// INTENTOS REDUCIDOS
						if(getCantidadDeIntentos()>0) {
							tb.cambiarEstados(fila, columna);
							setCantidadDeIntentos(getCantidadDeIntentos()-1); 
							setRecord(getRecord()+5); 
							actualizarBotones(matrizButton, tb);
							// intentos y record modificados en pantalla
							intentos.setText("Intentos: " +  Integer.toString ( getCantidadDeIntentos()) );
							record.setText("Record: " +  Integer.toString ( getRecord()) );
							 
						}
						System.out.println("Intentos: "+ getCantidadDeIntentos()); 
						
						// PERDISTE
						if(getCantidadDeIntentos()==0) {
							System.out.println("Has perdido!");
							JOptionPane.showMessageDialog(frame, "Has perdido!!! Te has quedado sin intentos.","PERDISTE", JOptionPane.ERROR_MESSAGE);
							System.exit(0);
						}
						
						// GANASTE
						else if(tb.haGanado()) {
							System.out.println("Has ganado!");
							JOptionPane.showMessageDialog(null, "Has Ganado!!!");
							System.exit(0);
						}
						
					}

				});
		
		}
		
	}
	}
	
	
	//----------FUNCION QUE SETEA EL TEXTO DE LOS BOTONES---------
	private void actualizarBotones(JButton matrizButton[][], TableroLogica tb) {
		
		for(int fila=0; fila<tb.getFilas(); fila++) {
			for(int col=0; col<tb.getColumnas(); col++) {
				//matrizButton[fila][col].setText(tb.devolverEstado(fila, col)+"");
				if(tb.devolverEstado(fila, col)) {
					matrizButton[fila][col].setBackground(new Color(0,255,19));
					matrizButton[fila][col].setForeground(new Color(0,255,19));
				}else {
					matrizButton[fila][col].setBackground(new Color(255,50,50));
					matrizButton[fila][col].setForeground(new Color(255,50,50));
				}
			}
			
		}
	}
	
	//--------FUNCION QUE UBICA A LOS BOTONES EN EL FRAME-------------------
	private void ubicarBotones(JFrame frame, JButton matrizButton[][], int ubicaciones[][], TableroLogica tb) {
		int contadorDeBotones=0;
		for(int fila=0; fila<tb.getFilas(); fila++) {
			for(int col=0; col<tb.getColumnas(); col++) {
				matrizButton[fila][col].setBounds(ubicaciones[contadorDeBotones][0], ubicaciones[contadorDeBotones][1], ubicaciones[contadorDeBotones][2], ubicaciones[contadorDeBotones][3]);
				frame.getContentPane().add(matrizButton[fila][col]);
				matrizButton[fila][col].setName(fila+"/"+col);
				contadorDeBotones++;
			}
		
		}
		
	}
	

	public int getCantidadDeIntentos() {
		return cantidadDeIntentos;
	}

	public void setCantidadDeIntentos(int cantidadDeIntentos) {
		this.cantidadDeIntentos = cantidadDeIntentos;
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}
}
