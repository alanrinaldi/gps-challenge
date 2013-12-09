/**
 * 
 */
package gpschallenge.vista;

import gpschallenge.componentes.utililidades.Posicion;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 * @author delpinor
 *
 */
public class CapaTransparente extends JPanel {
	private Posicion posVehiculo;
	private Posicion posMeta;
	private static final long serialVersionUID = -5190233112810400317L;
	private static int ALTO_MAPA = 600;
	private static int ANCHO_MAPA = 600;

	public CapaTransparente(Posicion posMeta) {
		this.posMeta = posMeta;
        setOpaque(false);
        setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(ANCHO_MAPA, ALTO_MAPA));
    }
	public void actualizarPosicion(Posicion posVehiculo){
		this.posVehiculo = posVehiculo;
	}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
   
        Rectangle fill = new Rectangle(getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g.create();
        // Radio del circulo relativo con el ancho del mapa
        int radius = (getWidth()) / 3;
        // Tamaño de los agujeros de la capa negra
        // Se hace coincidir las posiciones de vehiculo con la posicion del circulo.
        int posX = posVehiculo.getX() - radius/2 + radius/15;
        int posY =  posVehiculo.getY() - radius/2 + radius/15;
        Ellipse2D agujeroVehiculo = new Ellipse2D.Float(posX ,  posY, radius, radius);
        Ellipse2D agujeroMeta = new Ellipse2D.Float(posMeta.getX() - radius/14, posMeta.getY() - radius/18, radius/4, radius/4);

        Area area = new Area(fill);
        area.subtract(new Area(agujeroVehiculo));
        area.subtract(new Area(agujeroMeta));
        g2d.fill(area);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.0f));
        g2d.fill(agujeroVehiculo);
        g2d.fill(agujeroMeta);
        g2d.dispose();

    }        
}