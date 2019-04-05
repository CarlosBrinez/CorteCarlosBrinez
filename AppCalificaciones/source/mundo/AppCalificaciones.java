package mundo;

import java.util.ArrayList;

public class AppCalificaciones {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Total de estudiantes en el curso.
	 */
	public final static int TOTAL_EST = 20;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	private ArrayList estudiantes;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un nuevo curso.
	 */
	public AppCalificaciones( )
	{
		estudiantes = new ArrayList<Estudiante>();

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Crea un estudiante del curso.
	 * <b>post: </b> Se creó un objeto estudiante con los valores pasados por parámetro.<br>
	 * @param pCodigo Corresponde al código del estudiante nuevo. pCodigo != null && pCodigo != "".
	 * @param pNombre Corresponde al nombre del estudiante nuevo. pNombre != null && pNombre != "".
	 * @param pApellido Corresponde al apellido del estudiante nuevo. pApellido != null && pApellido != "".
	 * @param pNotas Corresponde a las notas del estudiante. pNota1 y 2  != null.
	 * @throws Exception 
	 */
	public void crearEstudiante (String pCodigo, String pNombre, String pApellido) throws Exception
	{

		Estudiante nuevo =  new Estudiante(pCodigo, pNombre, pApellido);
		if (buscarEstudiante(pCodigo)==null)
		{
			if (estudiantes.size()<=20)	          {
				estudiantes.add(nuevo);
			} 
			else
			{
				throw new Exception("Número máximo de estudiantes");
			}
		}
		else
		{
			throw new Exception("Ya se encuentra registrado el estudiante");
		}
	}

	/**
	 * Crea un estudiante del curso.
	 * @param pCodigo Corresponde al código del estudiante . pCodigo != null && pCodigo != "".
	 * return El estudiante buscado por codigo.
	 */
	public Estudiante buscarEstudiante(String pCodigo)
	{  

		Estudiante buscado = null;
		for (int i =0; i < estudiantes.size();i++)
		{
			Estudiante actual =  (Estudiante) estudiantes.get(i);
			if (actual.darCodigo().equals(pCodigo))
			{
				buscado = actual;
			}

		}
		return buscado;
	}
	public ArrayList darArreglo()
	{
		return estudiantes;
	}

	public ArrayList darReprobados()
	{  ArrayList reprobados = new ArrayList<Estudiante >();
	for (int i=0; i <estudiantes.size();i++)
	{  
		Estudiante actual =  (Estudiante) estudiantes.get(i);
		if (actual.darNotaFinal()<3)
		{
			reprobados.add(actual);
		}
	}
	return reprobados;
	}
	
	public int darPosEstudiante(Estudiante est)
	{	int rta = 0;
		for (int i =0; i < estudiantes.size();i++)
		{
			Estudiante actual =  (Estudiante) estudiantes.get(i);
			if (actual.equals(est))
			{
				 rta = i;
			}

		}
		return rta;
		
	}



}
