package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import mundo.Estudiante;

/**
 * Panel donde se muestran los datos.
 */
@SuppressWarnings("serial")
public class PanelDatos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal.
     */
    private InterfazAppCalificaciones ventana;

    /**
     * Número de estudiantes en el curso.
     */
    private int numEstudiantes;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------


    /**
     * Etiquetas de las notas1 de los estudiantes.
     */
    private JLabel etiquetasNombres[];
    
    private JLabel etiquetasNotas1[];
    
    private JLabel etiquetasNotas2[];
    
    private JLabel etiquetasPromedios [];
    
    private JLabel etiquetasApellidos [];
    
    private JLabel etiquetasCodigos [];

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pVentana Ventana principal. pVentana != null.
     * @param pNumeroNotas Número de notas a manejar. pNumeroNotas >0
     */
    public PanelDatos( InterfazAppCalificaciones pVentana, int pNumero )
    {
        // Guarda los datos
        ventana = pVentana;
        numEstudiantes =0;
        etiquetasNombres = new JLabel[pNumero];
        etiquetasApellidos = new JLabel[pNumero];
        etiquetasNotas1 = new JLabel[pNumero];
        etiquetasNotas2 = new JLabel[pNumero];
        etiquetasPromedios = new JLabel[pNumero];
        etiquetasCodigos= new JLabel[pNumero];
        setBorder( new TitledBorder( "Estudiantes"));
        setLayout(new GridLayout(pNumero+1, 6 , 10, 5));
        JLabel txtCode = new JLabel ("Código");
        txtCode.setHorizontalAlignment(JLabel.CENTER);
        add(txtCode);
        
        JLabel txtName = new JLabel ("Name");
        txtName.setHorizontalAlignment(JLabel.CENTER);
        
        add(txtName);
        
        JLabel txtApellido = new JLabel ("Apellido");
        txtApellido.setHorizontalAlignment(JLabel.CENTER);
        add(txtApellido);
        
        JLabel txtNota1 = new JLabel ("Nota1");
        txtNota1.setHorizontalAlignment(JLabel.CENTER);
        add(txtNota1);
       
        JLabel txtNota2 = new JLabel ("Nota2");
        txtNota2.setHorizontalAlignment(JLabel.CENTER);
        add(txtNota2);
       
        JLabel txtPromedio = new JLabel ("Nota Final");
        txtPromedio.setHorizontalAlignment(JLabel.CENTER);
        add(txtPromedio);

        
        for( int i = 0; i < pNumero; i++ )
        {
      
        etiquetasCodigos[ i ] = new JLabel( "" );
        etiquetasCodigos[ i ].setHorizontalAlignment( JLabel.CENTER );
        add( etiquetasCodigos[ i ] );	
           
        etiquetasNombres[ i ] = new JLabel( "" );
        etiquetasNombres[ i ].setHorizontalAlignment( JLabel.CENTER );  
        add( etiquetasNombres[ i ] );   
        
        etiquetasApellidos[ i ] = new JLabel( "" );
        etiquetasApellidos[ i ].setHorizontalAlignment( JLabel.CENTER );
        add( etiquetasApellidos[ i ] );
        
        etiquetasNotas1[ i ] = new JLabel( "" );
        etiquetasNotas1[ i ].setHorizontalAlignment( JLabel.CENTER );
        add( etiquetasNotas1[ i ] );
        
        etiquetasNotas2[ i ] = new JLabel( "" );
        etiquetasNotas2[ i ].setHorizontalAlignment( JLabel.CENTER );
        add( etiquetasNotas2[ i ] );
            
        etiquetasPromedios[ i ] = new JLabel( "" );
        etiquetasPromedios[ i ].setHorizontalAlignment( JLabel.CENTER );
        add( etiquetasPromedios[ i ] );
        
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    
    /**
     * Actualiza las notas en la interfaz.
     * @param pNota Nota del estudiante.
     * @param pNumeroEstudiante Número de estudiante. 1 <= pNumeroEstudiante <= 12.
     */
    public void agregarEstudiante(Estudiante estudiante)
    {   numEstudiantes++;
        etiquetasCodigos[numEstudiantes - 1 ].setText( estudiante.darCodigo());
    	etiquetasNombres[numEstudiantes - 1 ].setText( estudiante.darNombre());
    	etiquetasApellidos[numEstudiantes - 1 ].setText( estudiante.darApellido());	
    	etiquetasNotas1[numEstudiantes - 1 ].setText( estudiante.darNota1()+"");
    	etiquetasNotas2[numEstudiantes - 1 ].setText( estudiante.darNota2()+"");
    	etiquetasPromedios[numEstudiantes - 1 ].setText( estudiante.darNotaFinal()+"");
    }

    /**
     * Manejo de eventos de los botones.
     * @param pEvento Evento que generó la acción. pEvento != null.
     */
    
    public void refrescar1(int x, String rta, String promedio)
    {  	etiquetasNotas1[x].setText(rta);
	    etiquetasPromedios[x].setText(promedio);
    }
    public void refrescar2(int x, String rta, String promedio)
    {
    	etiquetasNotas2[x].setText(rta);
    	etiquetasPromedios[x].setText(promedio);
    }
    
    public void actionPerformed( ActionEvent pEvento )
    {
    	
    }
}