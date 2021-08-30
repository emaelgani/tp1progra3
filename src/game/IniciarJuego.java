package game;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class IniciarJuego extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarJuego dialog = new IniciarJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the dialog.
	 */
	public IniciarJuego() {
		setResizable(false);

		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// BOTON FACIL
		{
			JButton facilButton = new JButton("FACIL");
			facilButton.setFocusTraversalKeysEnabled(false);
			facilButton.setFocusPainted(false);
			facilButton.setVerifyInputWhenFocusTarget(false);
			facilButton.setFont(new Font("Unispace", Font.ITALIC, 11));
			facilButton.setBackground(new Color(102, 0, 51));
			facilButton.setForeground(new Color(255, 255, 255));
			facilButton.setBounds(235, 151, 111, 23);
			contentPanel.add(facilButton);
			facilButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableroGrafico.main(null, "facil");
					dispose(); // se cierra la ventana una vez seleccionada la dificultad
				}
			});
			
		}
		
		// BOTON NORMAL
		{
			JButton normalButton = new JButton("NORMAL");
			normalButton.setFocusTraversalKeysEnabled(false);
			normalButton.setFocusPainted(false);
			normalButton.setFont(new Font("Unispace", Font.ITALIC, 11));
			normalButton.setBackground(new Color(102, 0, 51));
			normalButton.setForeground(new Color(255, 255, 255));
			normalButton.setBounds(235, 193, 111, 23);
			contentPanel.add(normalButton);
			normalButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableroGrafico.main(null, "normal");
					dispose(); // se cierra la ventana una vez seleccionada la dificultad
				}
			});
			
		}
		
		// BOTON DIFICIL
		{
			JButton dificilButton = new JButton("DIFICIL");
			dificilButton.setFocusTraversalKeysEnabled(false);
			dificilButton.setFocusPainted(false);
			dificilButton.setFont(new Font("Unispace", Font.ITALIC, 11));
			dificilButton.setBackground(new Color(102, 0, 51));
			dificilButton.setForeground(new Color(255, 255, 255));
			dificilButton.setBounds(235, 240, 111, 23);
			contentPanel.add(dificilButton);			
			dificilButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableroGrafico.main(null, "dificil");
					dispose(); // se cierra la ventana una vez seleccionada la dificultad
				}
			});

		}
		
		// BOTON SALIR
		{
			JButton salirButton = new JButton("SALIR");
			salirButton.setFocusTraversalKeysEnabled(false);
			salirButton.setFocusPainted(false);
			salirButton.setFont(new Font("Unispace", Font.ITALIC, 11));
			salirButton.setBackground(new Color(102, 0, 51));
			salirButton.setForeground(new Color(255, 255, 255));
			salirButton.setBounds(235, 286, 111, 23);
			contentPanel.add(salirButton);
			salirButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose(); // se cierra la ventana una vez seleccionada la dificultad
				}
			});
		}
		
		
		// IMAGEN
		{
			JLabel imagen = new JLabel("");
			imagen.setBackground(Color.WHITE);
			contentPanel.add(imagen);
			imagen.setIcon(new ImageIcon(IniciarJuego.class.getResource("/img/fondoJuego1.jpg")));
			imagen.setBounds(0, 0, 600, 400);
		}

		
	}
}
