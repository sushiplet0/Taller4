
package dominio;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public abstract class Envio {
    private int codigo;
    private String rutRemitente;
    private String rutDestino;
    private String ciudadEnvio;
    private String ciudadDestino;
    private int costo;
    
    /**
     *
     * @param codigo
     * @param rutR
     * @param rutD
     * @param ciudadEnvio
     * @param ciudadDestino
     */
    public Envio(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino){
        this.codigo = codigo;
        this.rutRemitente = rutR;
        this.rutDestino = rutD;
        this.ciudadEnvio = ciudadEnvio;
        this.ciudadDestino = ciudadDestino;
        this.costo = 0;
    }

    /**
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getRutRemitente() {
        return rutRemitente;
    }

    /**
     *
     * @param rutRemitente
     */
    public void setRutRemitente(String rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    /**
     *
     * @return
     */
    public String getRutDestino() {
        return rutDestino;
    }

    /**
     *
     * @param rutDestino
     */
    public void setRutDestino(String rutDestino) {
        this.rutDestino = rutDestino;
    }

    /**
     *
     * @return
     */
    public int getCosto() {
        return costo;
    }

    /**
     *
     * @param costo
     */
    public void setCosto(int costo){
        this.costo = costo;
    }

    /**
     *
     * @return
     */
    public String getCiudadEnvio() {
        return ciudadEnvio;
    }

    /**
     *
     * @param ciudadEnvio
     */
    public void setCiudadEnvio(String ciudadEnvio) {
        this.ciudadEnvio = ciudadEnvio;
    }

    /**
     *
     * @return
     */
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    /**
     *
     * @param ciudadDestino
     */
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    
    /**
     *
     */
    public abstract void calcularCosto();

    
}
