package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import mundo.Estudiante;

/**
 * Panel donde se muestran los datos adicionales y las opciones.
 */
@SuppressWarnings("serial")
public class PanelAdicionales extends JPanel implements ActionListener
{

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando promedio.
	 */
	private static final String AGREGAR= "AGREGAR ESTUDIANTE";

	/**
	 * Comando mayores.
	 */
	private static final String BUSCAR = "BUSCAR ESTUDIANTE";

	/**
	 * Comando opción 1.
	 */
	private static final String REPROBADOS = "REPROBADOS";

	/**
	 * Comando opción 2.
	 */
	private static final String CAMBIAR = "CAMBIAR";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal.
	 */
	private InterfazAppCalificaciones ventana;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón promedio.
	 */
	private JButton btnAgregar;

	/**
	 * Botón número de estudiantes con nota mayor al promedio.
	 */
	private JButton btnBuscar;

	/**
	 * Botón Extensión 1.
	 */
	private JButton btnExtension1;

	/**
	 * Botón Extensión 2.
	 */
	private JButton btnExtension2;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del panel.
	 * @param pPrincipal Ventana principal.
	 */
	public PanelAdicionales( InterfazAppCalificaciones pPrincipal )
	{
		ventana = pPrincipal;
		setBorder( new TitledBorder( "Adicionales" ) );
		setLayout( new GridLayout( 1, 4 ) );

		// Botón Agregar
		btnAgregar = new JButton( "Agregar Estudiante" );
		btnAgregar.addActionListener( this );
		btnAgregar.setActionCommand( PanelAdicionales.AGREGAR);
		add( btnAgregar);

		// Botón Buscar
		btnBuscar = new JButton( "Buscar Estudiante" );
		btnBuscar.addActionListener( this );
		btnBuscar.setActionCommand( PanelAdicionales.BUSCAR );
		add( btnBuscar );

		// Botón Extensión 1
		btnExtension1 = new JButton( "Lista de estudiantes reprobados" );
		btnExtension1.addActionListener( this );
		btnExtension1.setActionCommand( PanelAdicionales.REPROBADOS);
		add( btnExtension1 );

		// Botón Extensión 2
		btnExtension2 = new JButton( "Cambiar Notas" );
		btnExtension2.addActionListener( this );
		btnExtension2.setActionCommand( PanelAdicionales.CAMBIAR );
		add( btnExtension2 );
	}

	@Override


	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Manejo de eventos de los botones.
	 * @param pEvento Evento que generó la acción. pEvento != null.
	 */

	public void actionPerformed( ActionEvent pEvento )
	{
		String comando = pEvento.getActionCommand( );
		if( AGREGAR.equals( comando ) )
		{
			DialogoAgregarEstudiante dialogo = new DialogoAgregarEstudiante(ventana );
			dialogo.setVisible( true );

		}
		else if (BUSCAR.equals(comando))
		{
			DialogoBuscar dialogo1 = new DialogoBuscar(ventana );
			dialogo1.setVisible( true );
		}

		else if (REPROBADOS.equals(comando))
		{
			ArrayList<Estudiante> reprobados = ventana.darReprobados();
			if (reprobados.size()==0)
			{
				JOptionPane.showMessageDialog( this, "No hay estudiantes registrados", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				String resultado = "";
				for(int i =0; i< reprobados.size();i++)

				{
					resultado += reprobados.get(i).toString()+"\n";
				}

				JOptionPane.showMessageDialog( this, resultado, "Lista de estudiantes reprobados", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		else if (CAMBIAR.equals(comando))
		{
			DialogoCambiarNotaEstudiante dialogo1 = new DialogoCambiarNotaEstudiante(ventana);
			dialogo1.setVisible( true );
		}



	}

}
