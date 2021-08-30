package game;

import java.util.Random;
public class TableroLogica {

	private Boolean tablero[][];
	private Random random;
	private int fila;
	private int columna;
	
	public TableroLogica(int fila, int columna) {
		this.random = new Random();
		this.fila = fila;
		this.columna = columna;
		this.tablero = new Boolean[fila][columna];
		this.cargarEstados();
	}

	// Debe modificarse para que sea al azar
	private void cargarEstados() {
		for (int fila = 0; fila < this.fila; fila++) {
			for (int columna = 0; columna < this.columna; columna++) {
				tablero[fila][columna] = random.nextBoolean();
				//tablero[fila][columna] = true;
			}
		}
		/*
		tablero[1][0] = false;
		tablero[0][1] = false;
		tablero[1][1] = false;
		tablero[1][2] = false;
		tablero[2][1] = false;
		*/
	}

	public void reiniciarTablero() {
		this.cargarEstados();
	}
	
	public boolean haGanado() {
		for(int fila=0; fila<this.fila; fila++) {
			for(int col=0; col<this.columna; col++) {
				if(!this.tablero[fila][col]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void cambiarEstados(int fila, int columna) throws IllegalArgumentException {
		
		
		this.tablero[fila][columna] = !this.tablero[fila][columna];
		
		if(fila<this.fila-1) {
			this.tablero[fila+1][columna] = !this.tablero[fila+1][columna];
		}
		if(fila>0) {
			this.tablero[fila-1][columna] = !this.tablero[fila-1][columna];
		}
		if(columna>0) {
			this.tablero[fila][columna-1] = !this.tablero[fila][columna-1];
		}
		if(columna<this.columna-1) {
			this.tablero[fila][columna+1] = !this.tablero[fila][columna+1];
		}

		
	}
	
	public boolean devolverEstado(int fila, int columna) {
		return this.tablero[fila][columna];
	}
	
	
	
	public int getFilas() {
		return this.fila;
	}
	
	public int getColumnas() {
		return this.columna;
	}
}
