
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class botones {

	private JFrame frame;
	private JFrame frame2;
	private int rows  = 0; //Esto es para ingresar la cantidad de filas, hay que cambiarlo para que sea un inputq	
	private int column = 0; // columnas
	private JTextField columnas;
	private JTextField filas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					botones window = new botones();
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
	public botones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Aqui Inicia el codigo del boton como tal
		JButton BotonCrearAll = new JButton("Boton General" );
		
		columnas = new JTextField();
		frame.getContentPane().add(columnas);
		columnas.setColumns(10);
		frame.getContentPane().add(BotonCrearAll); //Esta es la frame donde va el boton creador.
		
		filas = new JTextField();
		frame.getContentPane().add(filas);
		filas.setColumns(10);
		
	
		BotonCrearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
				//Esta tiene que ser una frame aparte.
				column = Integer.parseInt(columnas.getText());
				rows = Integer.parseInt(filas.getText());
				
				frame2 = new JFrame();
				frame2.setBounds(100, 100, 450, 300);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.getContentPane().setLayout(new GridLayout(column, rows, 0, 0));
				frame2.setVisible(true);
				
				int cantBotones = rows*column; //La cantidad de botones.
				JButton[] Botones = new JButton [cantBotones];
				for (int i = 0; i<cantBotones; i++){
					String nombreBoton = ("Boton no. " + i);
					Botones[i]= new JButton(nombreBoton);
					frame2.getContentPane().add(Botones[i]);
					
				}	
				
			}
		});
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		//Aqui termina
		
	}

}
