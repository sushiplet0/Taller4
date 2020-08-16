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
    
    public boolean ingresarCiudad(String nombre);
    
    public boolean ingresarCliente(String rut, String nombre, String apellido, String ciudadViviendo);
    
    public boolean ingresarEnvioDimension(int codigoEnvio, String rutRemitente, String rutDestino, int dim1, int dim2, int dim3);
    
    public boolean ingresarEnvioPeso(int codigoEnvio, String rutRemitente, String rutDestino, int pesoGramos);
    
    public boolean realizarEnvioD(int dim1, int dim2, int dim3, String rutRemitente, String rutDestino);
    
    public boolean realizarEnvioP(int pesoGramos, String rutRemitente, String rutDestino);
    
    public String enviosPorTipo();
    
    public String enviosPersona(String rutCliente);
    
    public String enviosPorCiudad();
    
    public String[] datosCliente(int i);
    
    public int totalClientes();
    
    public String[] datosEnvios(int i);
    
    public int totalEnvios();
}
