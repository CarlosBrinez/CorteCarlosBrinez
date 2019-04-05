package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import mundo.AppCalificaciones;
import mundo.Estudiante;

	public class InterfazAppCalificaciones extends JFrame
	{
	    // -----------------------------------------------------------------
	    // Atributos
	    // -----------------------------------------------------------------

	    /**
	     * Clase principal del mundo.
	     */
	    private AppCalificaciones curso;

	    // -----------------------------------------------------------------
	    // Atributos de la interfaz
	    // -----------------------------------------------------------------

	    /**
	     * Panel banner de la aplicación.
	     */
	    private PanelBanner panelBanner;

	    /**
	     * Panel imagen del curso.
	     */
	    private PanelImagen panelImagen;

	    /**
	     * Panel donde se muestran las notas.
	     */
	    private PanelDatos panelDatos;

	    /**
	     * Panel de opciones adicionales.
	     */
	    private PanelAdicionales panelAdicionales;

	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Construye la interfaz de notas del curso. <br>
	     * <b>post: </b> Se inicializaron los componentes gráficos de la aplicación.
	     */
	    public InterfazAppCalificaciones( )
	    {
	        setTitle( "AppCalificaciones" );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setSize( 900, 650 );

	        // Crea la clase principal
	        curso = new AppCalificaciones( );
	        // organizar el panel principal
	        setLayout( new BorderLayout( ) );

	        panelBanner = new PanelBanner( );
	        add( panelBanner, BorderLayout.NORTH );

	        panelImagen = new PanelImagen( );
	        add( panelImagen, BorderLayout.WEST );

	        panelDatos = new PanelDatos( this, curso.TOTAL_EST);
	        add( panelDatos, BorderLayout.CENTER );

	        panelAdicionales = new PanelAdicionales( this );
	        add( panelAdicionales, BorderLayout.SOUTH );

	        setLocationRelativeTo( null );
	        setResizable( false );
	    }

	    // -----------------------------------------------------------------
	    // Métodos
	    // -----------------------------------------------------------------
	    /**
	     * Cambia la nota de un estudiante.
	     * @param pEstudiante Estudiante a modificar. 1 <= pEstudiante <=12.
	     */
	 
  
	    // -----------------------------------------------------------------
	    // Puntos de Extensión
	    // -----------------------------------------------------------------

	    /**
	     * Método para la extensión 1.
	     */
	 
	    public void reqFuncOpcion1(String pCodigo, String pNombre, String pApellido )
	    { 
	    	try{
	    	Estudiante nuevo = new Estudiante(pCodigo, pNombre, pApellido);
	      curso.crearEstudiante(pCodigo, pNombre, pApellido);
	      panelDatos.agregarEstudiante(nuevo);
	      String resultado = "Se creó el estudiante";
	      
	      JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	      
	    	}
	    	
	    	catch(Exception e )
	    	{    
	    		 JOptionPane.showMessageDialog( this,e.getMessage(), "Respuesta", JOptionPane.ERROR_MESSAGE );
	    	}
	    }
	    /**
	     * Método para la extensión 2.
	    */
	    public void reqFuncOpcion2( String pCodigo)
	    {
	        try
	        {
	        	String resultado = curso.buscarEstudiante(pCodigo).toString();
	        	  JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	        }
	        catch(Exception e)
	        {
	        	 JOptionPane.showMessageDialog( this, "No se encontró el estudiante", "Respuesta", JOptionPane.ERROR_MESSAGE );
	        }
	      
	    }
	    public void reqFuncOpcion3( String pCodigo)
	    {
	        try
	        {
	        	 Estudiante buscado = curso.buscarEstudiante(pCodigo);
	        	 if (buscado==null)
	        	 {
	        		 throw new Exception("No se encontró el estudiante");
	        	 }
	        	 DialogoBotonesNotas  nuevo= new DialogoBotonesNotas(this, buscado);
	        	 nuevo.setVisible(true);
	        	 
	        }
	        catch(Exception e)
	        {
	        	 JOptionPane.showMessageDialog( this, "No se encontró el estudiante", "Respuesta", JOptionPane.ERROR_MESSAGE );
	        }
	      
	    }
	    public void reqFuncOpcion4(String nota, Estudiante est )
	    {
	        try
	        {
	        	  est.ponerNota1(Double.parseDouble(nota));	    
	        	  int x = curso.darPosEstudiante(est);
	        	  JOptionPane.showMessageDialog( this, "Se cambió la nota 1 del estudiante" , "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	          
	              panelDatos.refrescar1(x, nota, est.darNotaFinal()+"");
	        	 
	        }
	        catch(Exception e)
	        {   
	        	 JOptionPane.showMessageDialog( this, "No se encontró el estudiante", "Respuesta", JOptionPane.ERROR_MESSAGE );
	        }
	      
	    }
	    
	    public void reqFuncOpcion5(String nota, Estudiante est)
	    {
	        try
	        {
	        	 est.ponerNota2(Double.parseDouble(nota));
	        	 int x = curso.darPosEstudiante(est);
	        	  JOptionPane.showMessageDialog( this, "Se cambió la nota 2 del estudiante" , "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	              panelDatos.refrescar2(x, nota, est.darNotaFinal()+"");
	        	  
	        	  
	        }
	        catch(Exception e)
	        {
	        	 JOptionPane.showMessageDialog( this, "No se encontró el estudiante", "Respuesta", JOptionPane.ERROR_MESSAGE );
	        }
	      
	    }
	    
	    public ArrayList darReprobados( )
	    {   ArrayList<Estudiante> reprobados = curso.darReprobados();
	         
	         return reprobados;
	       
	    }
	    
        
	    // -----------------------------------------------------------------
	    // Main
	    // -----------------------------------------------------------------

	    /**
	     * Ejecuta la aplicación.
	     * @param pArgs Parámetros de la ejecución. No son necesarios.
	     */
	    public static void main( String[] pArgs )
	    {
	        try
	        {
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

	            InterfazAppCalificaciones interfaz = new InterfazAppCalificaciones( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	    }
	}
