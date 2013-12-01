package gpschallenge.componentes.utililidades;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author delpinor
 * 
 */
public class ObjetoAfectable extends JButton {
	private static final long serialVersionUID = 4319292719084191934L;
	protected ImageIcon getImagen(String url) {
		ImageIcon img = new ImageIcon(getClass().getResource(url));
		return img;
	}
}
