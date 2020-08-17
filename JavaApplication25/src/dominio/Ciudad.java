
package dominio;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public class Ciudad {
    private String nombre;
    
    /**
     *
     * @param nombre
     */
    public Ciudad(String nombre){
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
