package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> lista = new ArrayList <>();
    	
    	Collection<String> valores = mapaCadenas. values();
    	
    	for (String elemento : valores)
    	{
    		lista.add(elemento);
    	}
    	lista.sort(null);
    	
    	return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	
		List<String> lista = new ArrayList <>();
		
		Collection<String> valores = mapaCadenas. values();
		
		for (String letra : valores)
		{
			if (letra.length() > 1)
			{
				
				String letraN = ""; 
				for (int j = (letra.length()-1); j >= 0; j--)
				{
					letraN= letraN + letra.charAt(j);
				}
				letra = letraN;
			}
			
			lista.add(letra);
		}
		lista.sort(null);
		List<String> rta = new ArrayList <>();
		
		for (int i = (lista.size()-1); i >= 0; i--)
		{
			String letra = lista.get(i);
			rta.add(letra);
		}
		return rta;
	}
	


    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        boolean esta = mapaCadenas.isEmpty();
        if (esta == true)
        {
        	return null;
        }
        
        else
        {
        	List<String> lista = new ArrayList <>();
        	Collection<String> valores = mapaCadenas. values();
    		
    		for (String letra : valores)
    		{
    			lista.add(letra);
    		}
    	       lista.sort(null);
    	       String rta = lista.get(0);
    	       return rta;
        }
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	boolean esta = mapaCadenas.isEmpty();
        if (esta == true)
        {
        	return null;
        }
        
        else
        {
        	List<String> lista = new ArrayList <>();
        	Collection<String> valores = mapaCadenas. values();
    		
    		for (String letra : valores)
    		{
    			lista.add(letra);
    		}
    	       lista.sort(null);
    	       int len = lista.size();
    	       String rta = lista.get(len-1);
    	       return rta;
        }
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> keys = mapaCadenas.keySet();
    	Collection<String> rta = new ArrayList<>();
		
		for (String letra : keys)
		{
			rta.add(letra.toUpperCase());
		}
		
		return rta;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	Collection<String> valores = mapaCadenas. values();
    	int rta = valores.size();
    	
    	return rta;
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String cadenaNueva = "";
    	
    	for (int i = cadena.length() - 1; i >= 0; i--)
    	{
//    		System.out.println(i);
    		cadenaNueva=  cadenaNueva + cadena.charAt(i);
    	}
//    	System.out.println("a");
    	mapaCadenas.put(cadenaNueva, cadena);
//    	System.out.println("b");
    	
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	Collection<String> keys = mapaCadenas.keySet();
		
		for (String letra : keys)
		{
			String val = mapaCadenas.get(letra);
			if (val==valor)
			{
				mapaCadenas.remove(letra);
			}
		}
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	for (Object l : objetos)
    	{
    		String letra = l.toString();
    		String letraN = "";
    		if (letra.length() > 1)
    		{

   				for (int j = (letra.length()-1); j >= 0; j--)
   				{
   					letraN= letraN + letra.charAt(j);
   				}
    		}
    			
    		mapaCadenas.put(letraN, letra);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Collection<String> keys = mapaCadenas.keySet();
    	Map<String, String> mapa = new HashMap<String, String>( );
		for (String letra : keys)
		{
			String val = mapaCadenas.get(letra);
			String key = letra.toUpperCase();
			mapa.put(key, (val.toUpperCase()));
		}
		mapaCadenas.clear();
		mapaCadenas= mapa;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean rta = true;
    	for (int i=0; i<otroArreglo.length; i++)
		{
    		boolean esta = mapaCadenas.containsValue(otroArreglo[i]);
    		if (esta == false)
    		{
    			rta = false;
    		}
		}
    	return rta;
    }

}
