package gpschallenge.vista;

import gpschallenge.componentes.obstaculos.Afectable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import gpschallenge.motor.Mapa;

public class VistaAfectable extends JLabel {
	private static final long serialVersionUID = -2393117504290151547L;
	private static String URL_POZO = "/gpschallenge/imagenes/pozo.png";
	private static String URL_PIQUETE = "/gpschallenge/imagenes/piquete.png";
	private static String URL_CONTROL = "/gpschallenge/imagenes/control.png";
	private static String URL_FAVORABLE = "/gpschallenge/imagenes/sorpresa.png";
	private static String URL_DESFAVORABLE = "/gpschallenge/imagenes/sorpresa.png";
	private static String URL_CAMBIO = "/gpschallenge/imagenes/sorpresa.png";
	private Afectable afectable = null;

	public VistaAfectable(Afectable unAfectable) {
		this.afectable = unAfectable;
		this.setIcon(this.getImagen());

	}

	/* Obtiene una imagen de acuerdo al tipo de vehiculo */
	public ImageIcon getImagen() {
		String url = null;
		switch (this.afectable.getTipoAfectables()) {
		case POZO:
			url = URL_POZO;
			break;
		case PIQUETE:
			url = URL_PIQUETE;
			break;
		case CONTROLPOLICIAL:
			url = URL_CONTROL;
			break;
		case SORPRESAFAVORABLE:
			url = URL_FAVORABLE;
			break;
		case SORPRESADESFAVORABLE:
			url = URL_DESFAVORABLE;
			break;
		case CAMBIODEVEHICULO:
			url = URL_CAMBIO;
			break;
		default:
			break;
		}
        ImageIcon img = new ImageIcon(getClass().getResource(url));
		return img; 
}}