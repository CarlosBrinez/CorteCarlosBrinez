package mundo;
public class Estudiante {


    /**
     * Código del estudiante.
     */
    private String codigo;

    /**
     * Nombre del estudiante
     */
    private String nombre;
    
    /**
     * Apellido del estudiante
     */
    private String apellido;

    /**
     * Nota1 del estudiante.
     */
    private double nota1;
 
    /**
     * Nota2 del estudiante.
     */
    private double nota2;
    
    /**
     * promediodel estudiante.
     */
    private double notaFinal;
   
  

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Crea un estudiante. <br>
     * <b>post: </b> Se creó un objeto estudiante con los valores pasados por parámetro.<br>
     * @param pCodigo Corresponde al código del estudiante nuevo. pCodigo != null && pCodigo != "".
     * @param pNombre Corresponde al nombre del estudiante nuevo. pNombre != null && pNombre != "".
     * @param pApellido Corresponde al apellido del estudiante nuevo. pApellido != null && pApellido != "".
     * @param pNota1 y pNota2 Corresponde a las notas del estudiante. pNota1 y 2 != null.
     */
    public Estudiante( String pCodigo, String pNombre,String pApellido)
    {
        codigo = pCodigo;
        nombre = pNombre;
        apellido = pApellido;
        nota1 = 0.0;
        nota2 = 0.0;
        notaFinal = (nota1+nota2)/2;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del estudiante. <br>
     * @return El nombre del estudiante.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna el apellido del estudiante. <br>
     * @return El apellido del estudiante.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna la nota1 del estudiante . <br>
     * @return La nota1 del estudiante.
     */
    public double darNota1( )
    {
        return nota1;
    }
    /**
     * Retorna la nota2 del estudiante. <br>
     * @return La nota2 del estudiante.
     */
    public double darNota2( )
    {
        return nota2;
    }
    /**
     * Retorna el codiog del estudiante. <br>
     * @return El codigo del estudiante.
     */
    public String darCodigo( )
    {
        return codigo;
    }
    /**
     * Retorna El promedio del estudiante. <br>
     * @return Promedio del estudiante.
     */
    public double darNotaFinal ()
    {
        return notaFinal;
    }

  
    public String toString( )
    {
        String estudiante = codigo  + " " + nombre + " " + apellido+ " " + notaFinal;
        return estudiante;
    }
    public void ponerNota1(double pNota)
    {
    	nota1=pNota;
        notaFinal = (nota1 +nota2)/2;
    }
    
    public void ponerNota2(double pNota)
    {
    	nota2=pNota;
        notaFinal = (nota1 +nota2)/2;
    }
    
}