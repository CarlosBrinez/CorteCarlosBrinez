package interfaz;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sun.javafx.collections.SetListenerHelper;
/**
 * Diálogo para agregar un nuevo socio al club.
 */
public class DialogoAgregarEstudiante extends JDialog implements ActionListener
{
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante para el comando Afiliar.
	 */
	private static final String AGREGAR = "AGREGAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Campo de texto del codigo del nuevo estudiante.
	 */
	private JTextField txtCodigo;

	/**
	 * Campo de texto del nombre del nuevo estudiante.
	 */
	private JTextField txtNombre;

	/**
	 * Campo de texto del apellido del nuevo estudiante.
	 */
	private JTextField txtApellido;

	/**
	 * Campo de texto de la nota 1 del nuevo estudiante.
	 */
	private JTextField txtNota1;

	/**
	 * Campo de texto de la nota2 del nuevo estudiante.
	 */
	private JTextField txtNota2;

	/**
	 * Botón para agregar el estudiante.
	 */
	private JButton botonAgregar;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del la clase principal de la interfaz.
	 */
	private InterfazAppCalificaciones principal;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el diálogo con todos sus componentes.
	 * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
	 */
	public DialogoAgregarEstudiante( InterfazAppCalificaciones pPrincipal )
	{
		principal = pPrincipal;
		setTitle( "Agregar Nuevo Estudiante" );
		setSize( 350, 250 );
		setLocationRelativeTo( principal );

		JPanel panelGeneral = new JPanel( );
		panelGeneral.setBorder( new CompoundBorder( new TitledBorder( "Datos Estudiante" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
		panelGeneral.setLayout( new BorderLayout( 	) );
		add( panelGeneral );

		JPanel panelDatos = new JPanel( );
		panelDatos.setLayout( new GridLayout( 3, 1, 1, 1) );
		panelGeneral.add( panelDatos, BorderLayout.CENTER );

		JLabel etiquetaNombre = new JLabel( "Nombre:" );
		panelDatos.add( etiquetaNombre );


		txtNombre = new JTextField( );
		panelDatos.add( txtNombre );

		JLabel etiquetaApellido = new JLabel( "Apellido:" );
		panelDatos.add( etiquetaApellido );

		txtApellido = new JTextField( );
		panelDatos.add( txtApellido );


		JLabel etiquetaCodigo = new JLabel( "Código:" );
		panelDatos.add( etiquetaCodigo );

		txtCodigo= new JTextField( );
		panelDatos.add( txtCodigo );

		botonAgregar = new JButton( "Agregar" );
		botonAgregar.setActionCommand( AGREGAR );
		botonAgregar.addActionListener( this );
		panelGeneral.add( botonAgregar, BorderLayout.SOUTH );
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

		if( AGREGAR.equals( actionCommand ) )
		{   


			String strCodigo = txtCodigo.getText( );
			String strNombre = txtNombre.getText( );
			String strApellido = txtApellido.getText( );




			// Valida los campos vacíos

			try
			{


				if( strNombre == null || strNombre.isEmpty( ) || strCodigo == null || strCodigo.isEmpty( ) || strApellido == null || strApellido.isEmpty( ))
				{           	
					JOptionPane.showMessageDialog( this, "Debe ingresar todos los datos correctamente.", "Agregar estudiante", JOptionPane.ERROR_MESSAGE );              
				}

				else
				{
					principal.reqFuncOpcion1( strCodigo, strNombre, strApellido);
					dispose( );
				}
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog( this, "Error en los campos", "Respuesta", JOptionPane.ERROR_MESSAGE );
			}

		}

	}

}
