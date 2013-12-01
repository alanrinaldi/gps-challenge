package gpschallenge.componentes.vehiculos;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import gpschallenge.motor.Mapa;

public class VistaVehiculo extends JLabel {
	private static final long serialVersionUID = -2393117504290151547L;
	private static String URL_AUTO = "/gpschallenge/imagenes/auto.png";
	private static String URL_MOTO = "/gpschallenge/imagenes/moto.png";
	private static String URL_CUATROXCUATRO = "/gpschallenge/imagenes/4x4.png";
	private Vehiculo vehiculo = null;

	public VistaVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/* Obtiene una imagen de acuerdo al tipo de vehiculo */
	private ImageIcon getImagenVehiculo() {
		ImageIcon img = null;
		String url = URL_AUTO;
		switch (this.vehiculo.getTipoVehiculo()) {
		case AUTO:
			url = URL_AUTO;
			break;
		case MOTO:
			url = URL_MOTO;
			break;
		case CUATROXCUATRO:
			url = URL_CUATROXCUATRO;
			break;
		}
		img = new ImageIcon(getClass().getResource(url));
		return img;
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setIcon(this.getImagenVehiculo());
	}
}