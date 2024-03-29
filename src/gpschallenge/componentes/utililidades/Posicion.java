package gpschallenge.componentes.utililidades;

public class Posicion {
	private Integer x = 0;
	private Integer y = 0;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean esIgual(Posicion p) {
		if ((p.getX() == this.x) && (p.getY() == this.y))
			return true;
		return false;
	}

	public void sumarPosicion(Posicion unaPosicion) {
		this.x += unaPosicion.getX();
		this.y += unaPosicion.getY();

	}

	public void sumarPosicion(int x, int y) {
		this.x += x;
		this.y += y;

	}

	public void restarPosicion(int x, int y) {
		this.x -= x;
		this.y -= y;

	}

	public Posicion restarPosicion(Posicion unaPosicion) {
		Posicion nuevaposicion = new Posicion(x -= unaPosicion.getX(),
				y -= unaPosicion.getY());
		return nuevaposicion;
	}

	public String toString() {
		return (x.toString() + ", " + y.toString());
	}

}
