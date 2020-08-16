/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author sushipleto
 */
public abstract class Envio {
    private int codigo;
    private String rutRemitente;
    private String rutDestino;
    private String ciudadEnvio;
    private String ciudadDestino;
    private int costo;
    public Envio(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino){
        this.codigo = codigo;
        this.rutRemitente = rutR;
        this.rutDestino = rutD;
        this.ciudadEnvio = ciudadEnvio;
        this.ciudadDestino = ciudadDestino;
        this.costo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getRutRemitente() {
        return rutRemitente;
    }

    public void setRutRemitente(String rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    public String getRutDestino() {
        return rutDestino;
    }

    public void setRutDestino(String rutDestino) {
        this.rutDestino = rutDestino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo){
        this.costo = costo;
    }

    public String getCiudadEnvio() {
        return ciudadEnvio;
    }

    public void setCiudadEnvio(String ciudadEnvio) {
        this.ciudadEnvio = ciudadEnvio;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    
    public abstract void calcularCosto();

    
}
