/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.*;
import java.util.*;
import ucn.*;

/**
 *
 * @author sushipleto
 */
public class SistemaEnvioImpl implements SistemaEnvio{
    private ListaEnvios listaEnvios;
    private ArrayList<Ciudad> ListaCiudades;
    private LinkedList<Cliente> ListaClientes;
    
    public SistemaEnvioImpl(){
        this.listaEnvios = new ListaEnvios();
        this.ListaCiudades = new ArrayList<Ciudad>();
        this.ListaClientes = new LinkedList<Cliente>();
    }
    @Override
    public boolean ingresarCiudad(String nombre) {
        Ciudad ciudad = new Ciudad(nombre);
        if(ListaCiudades.contains(ciudad)){
            throw new NullPointerException ("Ciudad ya registrada.");
        }else{
            ListaCiudades.add(ciudad);
            return true;
        }
    }

    @Override
    public boolean ingresarCliente(String rut, String nombre, String apellido, String ciudadViviendo) {
        boolean ciudadExistente = false;
        for(Ciudad ciudad:ListaCiudades){
            if(ciudad.getNombre().equals(ciudadViviendo)){
                ciudadExistente = true;
                break;
            }
        }
        if(ciudadExistente){
            Cliente cliente = new Cliente(rut,nombre,apellido,ciudadViviendo);
            if(ListaClientes.contains(cliente)){
                throw new NullPointerException("Cliente ya registrado.");
            }else{
                ListaClientes.add(cliente);
                return true;
            }
        }else{
            throw new NullPointerException("La ciudad donde vive no está registrada en el sistema.");
        }
    }

    @Override
    public boolean ingresarEnvioDimension(int codigoEnvio, String rutRemitente, String rutDestino, int dim1, int dim2, int dim3) {
        if(dim1<=60 && dim2 <= 60 && dim3 <= 60){
            Cliente clienteR = null;
            Cliente clienteD = null;
            for(Cliente cliente:ListaClientes){
                if(cliente.getRut().equals(rutRemitente)){
                    clienteR = cliente;
                }
                if(cliente.getRut().equals(rutDestino)){
                    clienteD = cliente;
                }
            }
            if(clienteR != null && clienteD != null){
                EnvioD envio = new EnvioD(codigoEnvio,rutRemitente,rutDestino,clienteR.getCiudad(),clienteD.getCiudad(),dim1,dim2,dim3);
                envio.calcularCosto();
                listaEnvios.IngresarEnvio(envio);
                clienteR.getEnviados().IngresarEnvio(envio);
                clienteD.getRecibidos().IngresarEnvio(envio);
                return true;
            }else{
                throw new NullPointerException("Clientes no encontrados en el sistema.");
            }
        }else{
            throw new NullPointerException("Las dimensiones del envio superan los 60 cm permitidos.");
        }
    }

    @Override
    public boolean ingresarEnvioPeso(int codigoEnvio, String rutRemitente, String rutDestino, int pesoGramos) {
        if(pesoGramos<=20000){
            Cliente clienteR = null;
            Cliente clienteD = null;
            for(Cliente cliente:ListaClientes){
                if(cliente.getRut().equals(rutRemitente)){
                    clienteR = cliente;
                }
                if(cliente.getRut().equals(rutDestino)){
                    clienteD = cliente;
                }
            }
            if(clienteR != null && clienteD != null){
                EnvioP envio = new EnvioP(codigoEnvio,rutRemitente,rutDestino,clienteR.getCiudad(),clienteD.getCiudad(),pesoGramos);
                envio.calcularCosto();
                listaEnvios.IngresarEnvio(envio);
                clienteR.getEnviados().IngresarEnvio(envio);
                clienteD.getRecibidos().IngresarEnvio(envio);
                return true;
            }else{
                throw new NullPointerException("Clientes no encontrados en el sistema.");
            }
        }else{
            throw new NullPointerException("El peso del envío supera los 20.000 gramos (20kg).");
        }
    }

    @Override
    public boolean realizarEnvioD(int dim1, int dim2, int dim3, String rutRemitente, String rutDestino) {
        if(dim1<=60 && dim2 <= 60 && dim3 <= 60){
            Cliente clienteR = null;
            Cliente clienteD = null;
            for(Cliente cliente:ListaClientes){
                if(cliente.getRut().equals(rutRemitente)){
                    clienteR = cliente;
                }
                if(cliente.getRut().equals(rutDestino)){
                    clienteD = cliente;
                }
            }
            if(clienteD!=null){
                if(clienteR==null){
                    StdOut.println("Cliente remitente no registrado en el sistema, ¿desea registrarlo? (si/no)");
                    String res = StdIn.readString();
                    String ciudadEnvio = null;
                    if(res.equalsIgnoreCase("si")){
                        StdOut.println("Ingrese nombre: ");
                        String nombre = StdIn.readString();
                        StdOut.println("Ingrese apellido: ");
                        String apellido = StdIn.readString();
                        StdOut.println("Ingrese ciudad donde vive: ");
                        String ciudad = StdIn.readString();
                        ingresarCliente(rutRemitente,nombre,apellido,ciudad);
                    }else if(res.equalsIgnoreCase("no")){
                        StdOut.println("Ingrese ciudad de envio: ");
                        ciudadEnvio = StdIn.readString();
                    }
                    int codigoEnvio = listaEnvios.getLast().getEnvio().getCodigo()+1;
                    EnvioD envio = new EnvioD(codigoEnvio,rutRemitente,rutDestino,ciudadEnvio,clienteD.getCiudad(),dim1,dim2,dim3);
                    envio.calcularCosto();
                    listaEnvios.IngresarEnvio(envio);
                    clienteD.getRecibidos().IngresarEnvio(envio);
                    return true;
                }else{
                    int codigoEnvio = listaEnvios.getLast().getEnvio().getCodigo()+1;
                    EnvioD envio = new EnvioD(codigoEnvio,rutRemitente,rutDestino,clienteR.getCiudad(),clienteD.getCiudad(),dim1,dim2,dim3);
                    envio.calcularCosto();
                    listaEnvios.IngresarEnvio(envio);
                    clienteR.getEnviados().IngresarEnvio(envio);
                    clienteD.getRecibidos().IngresarEnvio(envio);
                    return true;
                }
                
            }else{
                throw new NullPointerException("Cliente destino no registrado en el sistema, envío cancelado.");
            }
        }else{
            throw new NullPointerException("Las dimensiones del envio superan los 60 cm permitidos, envío cancelado.");
        }
    }

    @Override
    public boolean realizarEnvioP(int pesoGramos, String rutRemitente, String rutDestino) {
         if(pesoGramos<=20000){
            Cliente clienteR = null;
            Cliente clienteD = null;
            for(Cliente cliente:ListaClientes){
                if(cliente.getRut().equals(rutRemitente)){
                    clienteR = cliente;
                }
                if(cliente.getRut().equals(rutDestino)){
                    clienteD = cliente;
                }
            }
            if(clienteD!=null){
                if(clienteR==null){
                    StdOut.println("Cliente remitente no registrado en el sistema, ¿desea registrarlo? (si/no)");
                    String res = StdIn.readString();
                    String ciudadEnvio = null;
                    if(res.equalsIgnoreCase("si")){
                        StdOut.println("Ingrese nombre: ");
                        String nombre = StdIn.readString();
                        StdOut.println("Ingrese apellido: ");
                        String apellido = StdIn.readString();
                        StdOut.println("Ingrese ciudad donde vive: ");
                        String ciudad = StdIn.readString();
                        ingresarCliente(rutRemitente,nombre,apellido,ciudad);
                    }else if(res.equalsIgnoreCase("no")){
                        StdOut.println("Ingrese ciudad de envio: ");
                        ciudadEnvio = StdIn.readString();
                    }
                    int codigoEnvio = listaEnvios.getLast().getEnvio().getCodigo()+1;
                    EnvioP envio = new EnvioP(codigoEnvio,rutRemitente,rutDestino,ciudadEnvio,clienteD.getCiudad(),pesoGramos);
                    envio.calcularCosto();
                    listaEnvios.IngresarEnvio(envio);
                    clienteD.getRecibidos().IngresarEnvio(envio);
                    return true;
                }else{
                    int codigoEnvio = listaEnvios.getLast().getEnvio().getCodigo()+1;
                    EnvioP envio = new EnvioP(codigoEnvio,rutRemitente,rutDestino,clienteR.getCiudad(),clienteD.getCiudad(),pesoGramos);
                    envio.calcularCosto();
                    listaEnvios.IngresarEnvio(envio);
                    clienteR.getEnviados().IngresarEnvio(envio);
                    clienteD.getRecibidos().IngresarEnvio(envio);
                    return true;
                }
                
            }else{
                throw new NullPointerException("Cliente destino no registrado en el sistema, envío cancelado.");
            }
        }else{
            throw new NullPointerException("Las dimensiones del envio superan los 60 cm permitidos, envío cancelado.");
        }
    }

    @Override
    public String enviosPorTipo() {
        String salida = "\n";
        salida += "Envios de tipo dimensiones: \n\n"+listaEnvios.enviosTipoD()+"\n------------------------\n"+"\nEnvios de tipo peso: \n"+listaEnvios.enviosTipoP()+"\n";
        return salida;
    }

    @Override
    public String enviosPersona(String rutCliente) {
        String salida = "";
        Cliente clienteBuscado = null;
        for(Cliente cliente:ListaClientes){
            if(cliente.getRut().equals(rutCliente)){
                clienteBuscado = cliente;
                break;
            }
        }
        if(clienteBuscado!=null){
            salida += "\nEnvios realizados por el cliente "+clienteBuscado.getNombre()+" "+clienteBuscado.getApellido()+": \n"+listaEnvios.enviosPersonaEnviados(rutCliente);
            salida+="\n------------------------\n";
            salida+= "\nEnvios recibidos por el cliente "+clienteBuscado.getNombre()+" "+clienteBuscado.getApellido()+": \n"+listaEnvios.enviosPersonaRecibidos(rutCliente)+"\n";
            salida+="------------------------\n";
            return salida;
        }else{
            throw new NullPointerException("Cliente no encontrado en el sistema.");
        }
    }

    @Override
    public String enviosPorCiudad() {
        String salida = "\n";
        for(Ciudad ciudad:ListaCiudades){
            salida+= "Envios realizados en la ciudad de "+ciudad.getNombre()+":\n"+listaEnvios.enviosCiudadRemitente(ciudad.getNombre());
            salida+="\nEnvios recibidos en la ciudad de "+ciudad.getNombre()+":\n"+listaEnvios.enviosCiudadDestino(ciudad.getNombre())+"\n";
            salida+="------------------------\n";
        }
        return salida;
    }

    @Override
    public String[] datosCliente(int i) {
        Cliente cliente = ListaClientes.get(i);
        String rut = cliente.getRut();
        String nombre = cliente.getNombre();
        String apellido = cliente.getApellido();
        String ciudad = cliente.getCiudad();
        String[] datos = {rut,nombre,apellido,ciudad};
        return datos;
    }

    @Override
    public int totalClientes() {
        return ListaClientes.size();
    }

    @Override
    public String[] datosEnvios(int i) {
        Envio envio = listaEnvios.getEnvioI(i);
        String codigo = Integer.toString(envio.getCodigo());
        String tipo;
        String rutRemitente = envio.getRutRemitente();
        String rutDestino = envio.getRutDestino();
        
        if(envio instanceof EnvioD){
            EnvioD envioDimension = (EnvioD) envio;
            tipo = "D";
            String dim1 = Integer.toString(envioDimension.getDimension1());
            String dim2 = Integer.toString(envioDimension.getDimension2());
            String dim3 = Integer.toString(envioDimension.getDimension3());
            String[] datosEnvio = {codigo,tipo,rutRemitente,rutDestino,dim1,dim2,dim3};
            return datosEnvio;
        }else if(envio instanceof EnvioP){
            EnvioP envioPeso = (EnvioP) envio;
            tipo = "P";
            String pesoNeto = Integer.toString(envioPeso.getPesoNeto());
            String[] datosEnvio ={codigo,tipo,rutRemitente,rutDestino,pesoNeto};
            return datosEnvio;
        }
        else{
            return null;
        }
    }

    @Override
    public int totalEnvios() {
        return listaEnvios.totalEnvios();
    }
    
}
