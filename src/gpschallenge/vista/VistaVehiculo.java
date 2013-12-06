package gpschallenge.vista;

import gpschallenge.componentes.vehiculos.Vehiculo;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import gpschallenge.motor.Mapa;

public class VistaVehiculo extends JLabel {
	private static final long serialVersionUID = -2393117504290151547L;
	private static String URL_AUTO = "/gpschallenge/imagenes/auto.png";
	private static String URL_MOTO = "/gpschallenge/imagenes/moto.png";
	private static String URL_CUATROXCUATRO = "/gpschallenge/imagenes/4x4.png";

	public VistaVehiculo() {
	}

	/* Obtiene una imagen de acuerdo al tipo de vehiculo */
	private ImageIcon getImagen() {
		String url = "";
		switch (Vehiculo.getInstancia().getEstado().getClass().getSimpleName()) {
		case "Auto":
			url = URL_AUTO;
			break;
		case "Moto":
			url = URL_MOTO;
			break;
		case "CuatroXCuatro":
			url = URL_CUATROXCUATRO;
			break;
		}
		ImageIcon img = new ImageIcon(getClass().getResource(url));
		return img;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setIcon(this.getImagen());
	}
}