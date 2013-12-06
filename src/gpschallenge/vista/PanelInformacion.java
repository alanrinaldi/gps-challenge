package gpschallenge.vista;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtJugador;
	private JTextField txtDesafio;
	private JTextField txtEstado;
	private JTextField txtMovimientos;
	private JTextField txtPuntaje;

	public PanelInformacion() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Jugador: ");
		lblNombre.setBounds(40, 20, 117, 23);
		add(lblNombre);
		txtJugador = new JTextField();
		txtJugador.setEditable(false);
		txtJugador.setBounds(40, 40, 120, 26);
		add(txtJugador);
		
		
		JLabel lblEstado = new JLabel("Estado del Auto: ");
		lblEstado.setBounds(40, 80, 117, 23);
		add(lblEstado);
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(40, 100, 120, 26);
		add(txtEstado);

		
		JLabel lblDesafio = new JLabel("Desafio: ");
		lblDesafio.setBounds(40, 140, 117, 23);
		add(lblDesafio);
		txtDesafio = new JTextField();
		txtDesafio.setEditable(false);
		txtDesafio.setBounds(40, 160, 120, 26);
		add(txtDesafio);
		
		
		JLabel lblMovimientos = new JLabel("Movimientos: ");
		lblMovimientos.setBounds(40, 200, 117, 23);
		add(lblMovimientos);
		txtMovimientos = new JTextField();
		txtMovimientos.setEditable(false);
		txtMovimientos.setBounds(40, 220, 120, 26);
		add(txtMovimientos);

		
		JLabel lblPuntaje = new JLabel("Puntaje: ");
		lblPuntaje.setBounds(40, 260, 117, 23);
		add(lblPuntaje);
		txtPuntaje = new JTextField();
		txtPuntaje.setEditable(false);
		txtPuntaje.setBounds(40, 280, 120, 26);
		add(txtPuntaje);
	}

	public void actualizarInfo(InfoJuego info) {
		this.txtJugador.setText(info.getJugador());
		this.txtEstado.setText(info.getTipoVehiculo().toString());
		this.txtDesafio.setText(info.getDesafio().toString());
		this.txtMovimientos.setText(info.getMovimientos().toString());
		this.txtPuntaje.setText(info.getPuntaje().toString());
	}
}