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

public class DialogoCambiarNota1 extends JDialog implements ActionListener {
	/**
     * Botón para buscar el estudiante
     */
    private JButton botonBuscar;

    /**
     * Campo de texto del codigo del nuevo estudiante.
     */
    private JTextField txtCodigo;
    
    private static final String CAMBIAR = "CAMBIAR";

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
    public DialogoCambiarNota1( InterfazAppCalificaciones pPrincipal, Estudiante est )
    {
        principal = pPrincipal;
        estudiante = est;
        setTitle( "Ingrese la nota 1" );
        setSize( 250, 120 );
        setLocationRelativeTo( principal );

        JPanel panelGeneral = new JPanel( );
        panelGeneral.setBorder( new CompoundBorder( new TitledBorder( "Cambiar nota" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
        panelGeneral.setLayout( new BorderLayout( 	) );
        add( panelGeneral );

        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 1, 1, 2, 2) );
        panelGeneral.add( panelDatos, BorderLayout.CENTER );

        JLabel etiquetaNombre = new JLabel( "Nota 1:" );
        panelDatos.add( etiquetaNombre );
       

        txtCodigo= new JTextField( );
        panelDatos.add( txtCodigo );
 
        botonBuscar = new JButton( "Cambiar" );
        botonBuscar.setActionCommand( CAMBIAR );
        botonBuscar.addActionListener( this );
        panelGeneral.add( botonBuscar, BorderLayout.SOUTH );
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

        if( CAMBIAR.equals( actionCommand ) )
        {   
        	
        	
            String strCodigo= txtCodigo.getText();
 
         try{
            // Valida los campos vacíos
            if(  strCodigo== null || strCodigo.isEmpty( ) ||Double.parseDouble(strCodigo)>5|| Double.parseDouble(strCodigo)<0 )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar los datos correctamente.", "Buscar", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                principal.reqFuncOpcion4( strCodigo, estudiante);
                dispose( );
            }
         }
         catch(Exception e)
         {
        	 JOptionPane.showMessageDialog( this, "Erorr en el campo", "Respuesta", JOptionPane.ERROR_MESSAGE );
         }
        }

  }
}
