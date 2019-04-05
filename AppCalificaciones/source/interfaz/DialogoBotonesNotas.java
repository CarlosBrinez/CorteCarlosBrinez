package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.Estudiante;

public class DialogoBotonesNotas extends JDialog implements ActionListener {
	private JButton botonNota1;

	private JButton botonNota2;

	private JTextField txtCodigo;

	private static final String NOTA1= "NOTA1";
	private static final String NOTA2 = "NOTA2";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del la clase principal de la interfaz.
	 */
	private InterfazAppCalificaciones principal;
	private Estudiante estudiante;




	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el diálogo con todos sus componentes.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
	 */
	public DialogoBotonesNotas ( InterfazAppCalificaciones pPrincipal, Estudiante est)
	{
		principal = pPrincipal;
		estudiante = est;
		setTitle( "¿Qué nota desea cambiar?" );
		setSize( 250, 120 );
		setLocationRelativeTo( principal );
		setLayout(new GridLayout(1,2,3,3));




		botonNota1 = new JButton( "Nota1" );
		botonNota1.setActionCommand( NOTA1 );
		botonNota1.addActionListener( this );
		add( botonNota1, BorderLayout.SOUTH );

		botonNota2 = new JButton( "Nota2" );
		botonNota2.setActionCommand( NOTA2 );
		botonNota2.addActionListener( this );
		add( botonNota2, BorderLayout.SOUTH );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de procesar eventos ejecutados por el usuario.
	 * @param pEvento Evento realizado por el usuario. pEvento != null.
	 */
	public void actionPerformed( ActionEvent pEvento )
	{
		String actionCommand = pEvento.getActionCommand( );

		if( NOTA1.equals( actionCommand ) )
		{   



			DialogoCambiarNota1  nuevo= new DialogoCambiarNota1(principal, estudiante);
			nuevo.setVisible(true);
			dispose( );


		}
		else if( NOTA2.equals( actionCommand ) )
		{   

			DialogoCambiarNota2  nuevo= new DialogoCambiarNota2(principal,estudiante);
			nuevo.setVisible(true);

			dispose( );
		}
	}
}

