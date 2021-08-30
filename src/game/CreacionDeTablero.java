package game;

import javax.swing.JButton;

public class CreacionDeTablero {
	private TableroLogica tb;
	private JButton matrizButton[][];
	private int ubicaciones[][];
	private int cantidadBotones;
	private int filas;
	private int columnas;
	
	
	public CreacionDeTablero(int filas, int columnas) {
		this.tb = new TableroLogica(filas, columnas);
		if (filas == 4 && columnas == 4) {
			this.matrizButton = this.creacionMatrizButtonIntermedio();
			this.ubicaciones= this.ubicacionesIntermedio();
			this.cantidadBotones=16;
			this.filas=filas;
			this.columnas=columnas;
		}
		if (filas == 3 && columnas == 3) {
			this.matrizButton = this.creacionMatrizButtonFacil();
			this.ubicaciones= this.ubicacionesFacil();
			this.cantidadBotones=9;
			this.filas=filas;
			this.columnas=columnas;
		}
		if (filas == 5 && columnas == 5) {
			this.matrizButton = this.creacionMatrizButtonDificil();
			this.ubicaciones= this.ubicacionesDificil();
			this.cantidadBotones=25;
			this.filas=filas;
			this.columnas=columnas;
		}
	}

	
	///-------------------METODOS PARA EL TABLERO EN MODO FÁCIL--------------------
		private JButton[][] creacionMatrizButtonFacil() {
			JButton btn0_0 = new JButton("");
			JButton btn0_1 = new JButton("");
			JButton btn0_2 = new JButton("");
			JButton btn1_0 = new JButton("");
			JButton btn1_1 = new JButton("");
			JButton btn1_2 = new JButton("");
			JButton btn2_0 = new JButton("");
			JButton btn2_1 = new JButton("");
			JButton btn2_2 = new JButton("");
	
			JButton[][] matriz = { { btn0_0, btn0_1, btn0_2}, { btn1_0, btn1_1, btn1_2 },
					{ btn2_0, btn2_1, btn2_2} };
			return matriz;
		}

		private int[][] ubicacionesFacil() {
			int ubicaciones[][] = { 
					{ 115, 82, 89, 23 }, { 235, 82, 89, 23 }, { 353, 82, 89, 23 },
					{ 115, 121, 89, 23 }, {235, 121, 89, 23 }, { 353, 121, 89, 23 },
					{ 115, 155, 89, 23 }, { 235, 155, 89, 23 }, {353, 155, 89, 23 }
					 };
			return ubicaciones;
		}
		
		//-------------------------------FIN DE MÉTODOS PARA EL TABLERO EN FÁCIL-------------------------------
	
	///-------------------METODOS PARA EL TABLERO EN MODO NORMAL--------------------
	private JButton[][] creacionMatrizButtonIntermedio() {
		JButton btn0_0 = new JButton("");
		JButton btn0_1 = new JButton("");
		JButton btn0_2 = new JButton("");
		JButton btn0_3 = new JButton("");
		JButton btn1_0 = new JButton("");
		JButton btn1_1 = new JButton("");
		JButton btn1_2 = new JButton("");
		JButton btn2_0 = new JButton("");
		JButton btn1_3 = new JButton("");
		JButton btn2_1 = new JButton("");
		JButton btn2_2 = new JButton("");
		JButton btn2_3 = new JButton("");
		JButton btn3_0 = new JButton("");
		JButton btn3_1 = new JButton("");
		JButton btn3_2 = new JButton("");
		JButton btn3_3 = new JButton("");
		JButton[][] matriz = { { btn0_0, btn0_1, btn0_2, btn0_3 }, { btn1_0, btn1_1, btn1_2, btn1_3 },
				{ btn2_0, btn2_1, btn2_2, btn2_3 }, { btn3_0, btn3_1, btn3_2, btn3_3 } };
		return matriz;
	}

	private int[][] ubicacionesIntermedio() {
		int ubicaciones[][] = {
				{ 89, 78, 89, 23 }, { 189, 78, 89, 23 }, { 288, 78, 89, 23 }, {387, 78, 89, 23 },
				{ 89, 112, 89, 23 }, { 189, 112, 89, 23 }, {288, 112, 89, 23 }, { 387, 112, 89, 23 },
				{ 89, 146, 89, 23 },{ 189, 146, 89, 23}, { 288, 146, 89, 23 }, { 387, 146, 89, 23 }, 
				{ 89, 180, 89, 23 },{ 189, 180, 89, 23 }, { 288, 180, 89, 23 }, { 387, 180, 89, 23} };
		return ubicaciones;
	}
	
	//-------------------------------FIN DE MÉTODOS PARA EL TABLERO EN INTERMEDIO-------------------------------
	
	
		///-------------------METODOS PARA EL TABLERO EN MODO DIFICIL--------------------
		private JButton[][] creacionMatrizButtonDificil() {
			JButton btn0_0 = new JButton("");
			JButton btn0_1 = new JButton("");
			JButton btn0_2 = new JButton("");
			JButton btn0_3 = new JButton("");
			JButton btn0_4 = new JButton("");
			JButton btn1_0 = new JButton("");
			JButton btn1_1 = new JButton("");
			JButton btn1_2 = new JButton("");
			JButton btn1_3 = new JButton("");
			JButton btn1_4 = new JButton("");
			JButton btn2_0 = new JButton("");
			JButton btn2_1 = new JButton("");
			JButton btn2_2 = new JButton("");
			JButton btn2_3 = new JButton("");
			JButton btn2_4 = new JButton("");
			JButton btn3_0 = new JButton("");
			JButton btn3_1 = new JButton("");
			JButton btn3_2 = new JButton("");
			JButton btn3_3 = new JButton("");
			JButton btn3_4 = new JButton("");
			JButton btn4_0 = new JButton("");
			JButton btn4_1 = new JButton("");
			JButton btn4_2 = new JButton("");
			JButton btn4_3 = new JButton("");
			JButton btn4_4 = new JButton("");
			JButton[][] matriz = {
					{ btn0_0, btn0_1, btn0_2, btn0_3, btn0_4 }, { btn1_0, btn1_1, btn1_2, btn1_3, btn1_4 },
					{ btn2_0, btn2_1, btn2_2, btn2_3, btn2_4 }, { btn3_0, btn3_1, btn3_2, btn3_3, btn3_4 },
					{ btn4_0, btn4_1, btn4_2, btn4_3, btn4_4 }};
			return matriz;
		}

		private int[][] ubicacionesDificil() {
			int ubicaciones[][] = {
					{ 30, 90, 89, 23 }, { 134, 90, 89, 23}, { 233, 90, 89, 23 }, {342, 90, 89, 23 }, { 441, 90, 89, 23 },
					{ 30, 124, 89, 23 }, {129, 124, 89, 23}, {233, 124, 89, 23}, { 342, 124, 89, 23 }, { 441, 124, 89, 23 },
					{ 30, 158, 89, 23 }, { 129, 158, 89, 23}, { 233, 158, 89, 23 }, { 342, 158, 89, 23 }, { 441, 158, 89, 23 },
					{ 30, 192, 89, 23 }, { 129, 192, 89, 23}, {233, 192, 89, 23 }, { 342, 192, 89, 23 }, { 441, 192, 89, 23 },
					{ 30, 226, 89, 23 }, { 129, 226, 89, 23}, { 233, 226, 89, 23 }, { 342, 226, 89, 23 }, { 441, 226, 89, 23},
					};
			return ubicaciones;
		}
		
		//-------------------------------FIN DE MÉTODOS PARA EL TABLERO EN DIFICIL-------------------------------
	
	
	
	
	public TableroLogica getTablero() {
		return this.tb;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public JButton[][] getMatrizButton() {
		return this.matrizButton;
	}

	
	public int[][] getUbicaciones(){
		return this.ubicaciones;
	}
	
	public int cantidadDeBotones() {
		return this.cantidadBotones;
	}
	
	public int getFilas() {
		return this.filas;
	}
	
	public int getColumnas() {
		return this.columnas;
	}
}

