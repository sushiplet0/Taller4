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
    
    public boolean ingresarCiudad();
    
    public boolean ingresarCliente();
    
    public boolean ingresarEnvioDimension();
    
    public boolean ingresarEnvioPeso();
    
    public boolean asociarClientesEnvio();
    
    public boolean realizarEnvioD();
    
    public boolean realizarEnvioP();
    
    public String enviosPorTipo();
    
    public String enviosPersona();
    
    public String enviosPorCiudad();
    
    public boolean registrarCliente();
    
    public String[] datosCliente();
    
    public int totalClientes();
    
    public String[] datosEnvios();
    
    public int totalEnvios();
}
