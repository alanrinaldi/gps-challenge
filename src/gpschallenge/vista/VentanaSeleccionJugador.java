package gpschallenge.vista;

import gpschallenge.componentes.utililidades.ListaJugadores;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.motor.Jugador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class VentanaSeleccionJugador extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> campoNombres;
	private JPanel contentPane;
	private ArrayList <String> nombres;
	private ListaJugadores Lista;
	private XStream xstream = new XStream(new DomDriver());
	
	
	
	public VentanaSeleccionJugador(){
		
		setLayout(null);
		
		campoNombres =new JComboBox<String>();
		campoNombres.setBounds(100, 120, 100, 20);
		campoNombres.addItem(null);
		Lista = (ListaJugadores) xstream
				.fromXML(new File(
						"Datos/juegosguardados/ListaJugadores.xml"));
		
		nombres = Lista.ObtenerListaJugadores();
		
		if(nombres != null){
			Iterator<String> it = nombres.iterator();
			while (it.hasNext()) {
				campoNombres.addItem(it.next());
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		contentPane.add(campoNombres);
		
		JLabel nombre = new JLabel(" SELECCIONE PARTIDA GUARDADA ");
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(50,50 , 200, 40);
		add(nombre);
		
		
		campoNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton botonContinuar = new JButton("CONTINUAR");
		botonContinuar.setBorder(BorderFactory.createLineBorder(Color.black));
		botonContinuar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		botonContinuar.setBounds(100, 160, 100, 50);
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaContinuacionJuego frame = null;
				try {
					frame = new VentanaContinuacionJuego(new Jugador((String)(campoNombres.getSelectedItem())));
				} catch (EsquinasInvalidasException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);

			}
		});
		add(botonContinuar);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
