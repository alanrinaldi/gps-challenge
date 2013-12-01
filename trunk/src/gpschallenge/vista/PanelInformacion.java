package gpschallenge.vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField cantMovimientos;
	private JTextField estadoVehiculo;

	public PanelInformacion() {
		setLayout(null);

		JLabel movimientos = new JLabel("Movimientos: ");
		movimientos.setBounds(40, 40, 117, 23);
		add(movimientos);

		cantMovimientos = new JTextField();
		cantMovimientos.setEditable(false);
		cantMovimientos.setBounds(40, 65, 120, 26);
		add(cantMovimientos);

		JLabel estado = new JLabel("Estado del Auto: ");
		estado.setBounds(40, 90, 117, 23);
		add(estado);

		estadoVehiculo = new JTextField();
		estadoVehiculo.setEditable(false);
		estadoVehiculo.setBounds(40, 115, 120, 26);
		add(estadoVehiculo);

	}

	public void actualizarMovimientos(int movimientos) {
		this.cantMovimientos.setText(String.valueOf(movimientos));
	}

	public void actualizarEstado(String estado) {
		this.estadoVehiculo.setText(estado);
		
	}
}