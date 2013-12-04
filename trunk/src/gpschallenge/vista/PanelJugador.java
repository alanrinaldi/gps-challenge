package gpschallenge.vista;

import gpschallenge.componentes.utililidades.Dificultad;
import gpschallenge.componentes.utililidades.TipoVehiculo;
import gpschallenge.componentes.vehiculos.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJugador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private JTextField campoNombre;
    private JTextField textDificultad;
    private JTextField textEstado;
    private JComboBox<Dificultad> campoDificultad;
    private JComboBox<TipoVehiculo> campoEstado;
    
    private EstadoVehiculo estado;
    private Dificultad dificultadnivel;
    
	public PanelJugador(){
		
		setLayout(null);

		JLabel nombre = new JLabel(" NOMBRE ");
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(0,0 , 150, 40);
		add(nombre);
		
		campoNombre = new JTextField(20);
		campoNombre.setBounds(0, 45, 150, 25);
		add(campoNombre);
		
		JLabel vehiculo = new JLabel(" SELECCIONAR VEHICULO ");
		vehiculo.setBackground(Color.LIGHT_GRAY);
		vehiculo.setBounds(0,80 , 150, 40);
		add(vehiculo);
		
		JLabel dificultad = new JLabel(" SELECCIONAR DIFICULTAD ");
		dificultad.setBackground(Color.LIGHT_GRAY);
		dificultad.setBounds(0,160, 180, 40);	
		add(dificultad);
		
		textDificultad = new JTextField(20);
		add(textDificultad);
        campoDificultad =new JComboBox<Dificultad>();
        campoDificultad.setBounds(0,210,100,20);
        campoDificultad.addItem(null);
        campoDificultad.addItem(Dificultad.FACIL);
        campoDificultad.addItem(Dificultad.MODERADO);
        campoDificultad.addItem(Dificultad.DIFICIL);
        add(campoDificultad);
        
        campoDificultad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dificultadnivel =(Dificultad) (campoDificultad.getSelectedItem());
			}
		});
        
        textEstado = new JTextField(20);
		add(textEstado);
		campoEstado =new JComboBox<TipoVehiculo>();
		campoEstado.setBounds(0,130,120,20);
		campoEstado.addItem(null);
		campoEstado.addItem(TipoVehiculo.AUTO);
		campoEstado.addItem(TipoVehiculo.CUATROXCUATRO);
		campoEstado.addItem(TipoVehiculo.MOTO);
        add(campoEstado);
        
        campoEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch ((TipoVehiculo)campoEstado.getSelectedItem()){
				case AUTO:
						estado=Auto.getInstancia();
						break;
				case CUATROXCUATRO:
					estado=CuatroXCuatro.getInstancia();
					break;
				case MOTO:
					estado=Moto.getInstancia();
					break;	
				default:	
					estado=Auto.getInstancia();
					break;
				}
				
			}
		});
        
    }

	public String getNombreJugador() {
		
		return campoNombre.getText();
	}

	public Dificultad getDificultad(){
		return dificultadnivel;
	}
	
	public EstadoVehiculo getEstado(){
		return estado;
	}
		
}
