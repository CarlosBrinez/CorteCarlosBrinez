package interfaz;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de la imagen del curso.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta usada para mostrar la imagen.
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelImagen( )
    {
        setBorder( new EmptyBorder( 3, 3, 3, 3 ) );
        etiquetaImagen = new JLabel( new ImageIcon( "./data/imagenClase.jpg" ) );
        JPanel panelBorde = new JPanel( );
        panelBorde.setBorder( new TitledBorder( "" ) );
        panelBorde.add( etiquetaImagen );
        add( panelBorde );
    }
}

