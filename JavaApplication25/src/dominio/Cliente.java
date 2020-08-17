
package dominio;

import logica.ListaEnvios;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public class Cliente {
    private String rut;
    private String nombre;
    private String apellido;
    private String ciudad;
    private ListaEnvios enviados;
    private ListaEnvios recibidos;
    
    /**
     *
     * @param rut
     * @param nombre
     * @param apellido
     * @param ciudad
     */
    public Cliente(String rut, String nombre, String apellido, String ciudad){
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.enviados = new ListaEnvios();
        this.recibidos = new ListaEnvios();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ListaEnvios getEnviados() {
        return enviados;
    }

    public void setEnviados(ListaEnvios enviados) {
        this.enviados = enviados;
    }

    public ListaEnvios getRecibidos() {
        return recibidos;
    }

    public void setRecibidos(ListaEnvios recibidos) {
        this.recibidos = recibidos;
    }
    
}
