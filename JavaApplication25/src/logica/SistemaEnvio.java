/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author sushipleto
 */
public interface SistemaEnvio {
    
    /**
     *
     * @param nombre
     * @return
     */
    public boolean ingresarCiudad(String nombre);
    
    /**
     *
     * @param rut
     * @param nombre
     * @param apellido
     * @param ciudadViviendo
     * @return
     */
    public boolean ingresarCliente(String rut, String nombre, String apellido, String ciudadViviendo);
    
    /**
     *
     * @param codigoEnvio
     * @param rutRemitente
     * @param rutDestino
     * @param dim1
     * @param dim2
     * @param dim3
     * @return
     */
    public boolean ingresarEnvioDimension(int codigoEnvio, String rutRemitente, String rutDestino, int dim1, int dim2, int dim3);
    
    /**
     *
     * @param codigoEnvio
     * @param rutRemitente
     * @param rutDestino
     * @param pesoGramos
     * @return
     */
    public boolean ingresarEnvioPeso(int codigoEnvio, String rutRemitente, String rutDestino, int pesoGramos);
    
    /**
     *
     * @param dim1
     * @param dim2
     * @param dim3
     * @param rutRemitente
     * @param rutDestino
     * @return
     */
    public boolean realizarEnvioD(int dim1, int dim2, int dim3, String rutRemitente, String rutDestino);
    
    /**
     *
     * @param pesoGramos
     * @param rutRemitente
     * @param rutDestino
     * @return
     */
    public boolean realizarEnvioP(int pesoGramos, String rutRemitente, String rutDestino);
    
    /**
     *
     * @return
     */
    public String enviosPorTipo();
    
    /**
     *
     * @param rutCliente
     * @return
     */
    public String enviosPersona(String rutCliente);
    
    /**
     *
     * @return
     */
    public String enviosPorCiudad();
    
    /**
     *
     * @param i
     * @return
     */
    public String[] datosCliente(int i);
    
    /**
     *
     * @return
     */
    public int totalClientes();
    
    /**
     *
     * @param i
     * @return
     */
    public String[] datosEnvios(int i);
    
    /**
     *
     * @return
     */
    public int totalEnvios();
}
