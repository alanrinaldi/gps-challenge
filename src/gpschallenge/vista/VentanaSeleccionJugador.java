package gpschallenge.vista;

import gpschallenge.componentes.utililidades.XML;
import gpschallenge.componentes.utililidades.ListaUsuarios;
import gpschallenge.excepciones.EsquinasInvalidasException;
import gpschallenge.motor.Juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSeleccionJugador extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> campoNombres;
	private JPanel contentPane;
	private ArrayList<String> jugadores;
	private ListaUsuarios lista;
	
	
	
	public VentanaSeleccionJugador(){
		
		setLayout(null);
		
		campoNombres =new JComboBox<String>();
		campoNombres.setBounds(100, 120, 100, 20);
		lista = (ListaUsuarios)XML.obtenerObjeto("Datos/juegosguardados/ListaUsuarios.xml");
		jugadores = lista.obtenerListaUsuarios();
	
			Iterator<String> it = jugadores.iterator();
			String usuario;
			while (it.hasNext()) {
				usuario = it.next();
				campoNombres.addItem(usuario);
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
		
		
		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.setBorder(BorderFactory.createLineBorder(Color.black));
		btnContinuar.setContentAreaFilled(false);
		// Posicion donde se colocar este boton
		btnContinuar.setBounds(100, 160, 100, 30);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaJuego ventanaJuego = null;
				try {
					
					// Obtengo datos guardados y paso a la vista VentanaJuego.
					Juego juego = (Juego)XML.obtenerObjeto("Datos/juegosguardados/juego"+(String)(campoNombres.getSelectedItem())+".xml");
					ventanaJuego = new VentanaJuego(juego);
				} catch (EsquinasInvalidasException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventanaJuego.setVisible(true);
				dispose();

			}
		});
		add(btnContinuar);
		
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBorder(BorderFactory.createLineBorder(Color.black));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBounds(100, 200, 100, 30);
		btnVolver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Vuelve a la vista principal
				Main inicio = new Main();
				inicio.setVisible(true);
				dispose();
		}});
		add(btnVolver);
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
