package gpschallenge.vista;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class PanelJugador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPopupMenu popup = new JPopupMenu();
    JTextField txt = new JTextField( 10 );
	
	public PanelJugador(){
		
		setLayout(null);

		JLabel nombre = new JLabel(" NOMBRE ");
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(0,0 , 150, 40);
		add(nombre);

		JLabel vehiculo = new JLabel(" SELECCIONAR VEHICULO ");
		vehiculo.setBackground(Color.LIGHT_GRAY);
		vehiculo.setBounds(0,60 , 150, 40);
		add(vehiculo);
		
		JLabel dificultad = new JLabel(" SELECCIONAR DIFICULTAD ");
		dificultad.setBackground(Color.LIGHT_GRAY);
		dificultad.setBounds(0,120, 180, 40);	
		add(dificultad);
	
		add(txt);
	    
		ActionListener al = new ActionListener() {
            public void actionPerformed( ActionEvent evt ){
                txt.setText( ((JMenuItem)evt.getSource()).getText() );
            }
        };
        
        
        
        JMenuItem elemento = new JMenuItem( "Facil" );
        elemento.addActionListener( al );
        elemento.setMnemonic( 'F' );
        popup.add( elemento );
        elemento = new JMenuItem( "Moderado" );
        elemento.addActionListener( al );
        elemento.setMnemonic( 'M' );
        popup.add( elemento );
        elemento = new JMenuItem( "Dificil" );
        elemento.addActionListener( al );
        elemento.setMnemonic( 'D' );
        popup.add( elemento );
        popup.addSeparator();
        enableEvents( AWTEvent.MOUSE_EVENT_MASK );
        
       
        
        
    }


    protected void processMouseEvent( MouseEvent evt ){
        if ( evt.isPopupTrigger() )
            popup.show( evt.getComponent(),evt.getX(),evt.getY() );
        else
            super.processMouseEvent( evt );
    }
	
		
}
