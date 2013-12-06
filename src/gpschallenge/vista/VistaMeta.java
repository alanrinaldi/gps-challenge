package gpschallenge.vista;
import gpschallenge.motor.Meta;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VistaMeta extends JLabel {
	private static final long serialVersionUID = -2393117504290151547L;
	private static String URL_META = "/gpschallenge/imagenes/meta.png";
	private Meta  meta;
	public VistaMeta(Meta meta) {
		this.meta = meta;
		this.setIcon(this.getImagen());
	}

	public ImageIcon getImagen() {
        ImageIcon img = new ImageIcon(getClass().getResource(URL_META));
		return img; 
	}
	public Meta getMeta(){
		return this.meta;
	}
}

