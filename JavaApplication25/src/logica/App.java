/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.*;
import java.io.IOException;
import ucn.*;

/**
 *
 * @author sushipleto
 */
public class App {
    public static void main(String[] args) throws IOException{
	SistemaEnvio sys = new SistemaEnvioImpl();
        leerCiudades(sys);
        leerClientes(sys);
        leerEnvios(sys);
        Sistema(sys);
        SobreescribirTxts(sys);
    }
    
    public static void desplegarMenu(){
        StdOut.println("\n------------------------------------------");
        StdOut.println("Bienvenido al menu de opciones UCN Envíos para una cuarentena segura");
        StdOut.println("(1) Realizar envio");
	StdOut.println("(2) Envios por Tipo ");
        StdOut.println("(3) Envios por Persona ");
        StdOut.println("(4) Envios por ciudad ");
        StdOut.println("(5) Cerrar Menu");
        StdOut.println("------------------------------------------\n");
        StdOut.println("Ingrese la opción: ");
    }
    public static void Sistema(SistemaEnvio sys){
        StdOut.println("!Bienvenido a UCN envios¡\n");
        desplegarMenu();
        String opcion = StdIn.readString();
        while(!opcion.equals("5")) {
            if(opcion.equals("1")) {
                StdOut.println("¿Qué tipo de envío desea realizar? dimensiones o peso (D/P)\n");
                String tipo = StdIn.readString();
                StdOut.println("Ingrese los parametros del paquete a enviar "+"\n");
                if(tipo.equalsIgnoreCase("D")){
                    StdOut.println("Ingrese la dimension 1 en centimetros: ");
                    int dim1 = StdIn.readInt();
                    StdOut.println("Ingrese la dimension 2 en centimetros: ");
                    int dim2 = StdIn.readInt();
                    StdOut.println("Ingrese la dimension 3 en centimetros: ");
                    int dim3 = StdIn.readInt();
                    StdOut.println("Ingrese El rut del remitente: ");
                    String rutRemitente = StdIn.readString();
                    StdOut.println("Ingrese El rut del destinatario: ");
                    String rutDestino = StdIn.readString();
                    if(validarRut(rutRemitente) && validarRut(rutDestino)){
                        try{
                            sys.realizarEnvioD(dim1, dim2, dim3, rutRemitente, rutDestino);
                            StdOut.println("¡Envio realizado con éxito!");
                        }catch(NullPointerException e){
                            StdOut.println(e.getMessage());
                        }
                    }
                }else if(tipo.equalsIgnoreCase("P")){
                    StdOut.println("Ingrese el peso en kilogramos: ");
                    int peso = StdIn.readInt();
                    String rutRemitente = StdIn.readString();
                    StdOut.println("Ingrese El rut del destinatario: ");
                    String rutDestino = StdIn.readString();
                    if(validarRut(rutRemitente) && validarRut(rutDestino)){
                        try{
                            sys.realizarEnvioP(peso, rutRemitente, rutDestino);
                            StdOut.println("¡Envio realizado con éxito!");
                        }catch(NullPointerException e){
                            StdOut.println(e.getMessage());
                        }
                    }
                }

            }else if(opcion.equals("2")) {
                StdOut.println(sys.enviosPorTipo());
            }else if(opcion.equals("3")) {
                StdOut.println("Ingrese el rut de la persona buscada: \n");
                String rutPersona = StdIn.readString();
                try{
                    StdOut.println(sys.enviosPersona(rutPersona));
                }catch(NullPointerException e){
                    StdOut.println(e.getMessage());
                }
            }else if(opcion.equals("4")) {
                StdOut.print("Envios por cada ciudad dentro del sistema: \n");
                StdOut.print(sys.enviosPorCiudad());
            }
            desplegarMenu();
            opcion=StdIn.readString();
        }
        StdOut.println("\n¡Gracias por usar nuestros servicios!\n");
    }
	
    public static boolean validarRut(String rut){
        boolean validacion = false;
        try{
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
        
            char dv = rut.charAt(rut.length() - 1);
        
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
        }catch(java.lang.NumberFormatException e){
        }catch (Exception e) {
        }
        return validacion; 
    }
	
    public static void leerClientes(SistemaEnvio sys)throws IOException{
	ArchivoEntrada arch = new ArchivoEntrada("clientes.txt");
        while(!arch.isEndFile()){
            Registro reg = arch.getRegistro();
            String rut = reg.getString();
            String nombre = reg.getString();
            String apellido = reg.getString();
            String ciudad = reg.getString();
            if(validarRut(rut)){
		try{
                   boolean ingresado = sys.ingresarCliente(rut,nombre,apellido,ciudad);
                }catch (NullPointerException e){
                    
                }
            }
	}
	arch.close();
    }
	
    public static void leerCiudades(SistemaEnvio sys)throws IOException{
	ArchivoEntrada arch = new ArchivoEntrada("ciudades.txt");
        while(!arch.isEndFile()){
            Registro reg = arch.getRegistro();
            String ciudad = reg.getString();
            try{
                sys.ingresarCiudad(ciudad);
            }catch(NullPointerException e){
                
            }
        }
	arch.close();
    }
	
    public static void leerEnvios(SistemaEnvio sys)throws IOException{
        ArchivoEntrada arch = new ArchivoEntrada("envios.txt");
        while(!arch.isEndFile()){
            Registro reg = arch.getRegistro();
            int codigo = reg.getInt();
            String tipo = reg.getString();
            if(tipo.equals("D")){
                String rRemitente = reg.getString();
                String rDestinatario = reg.getString();
                int dim1 = reg.getInt();
                int dim2 = reg.getInt();
                int dim3 = reg.getInt();
                try{
                   sys.ingresarEnvioDimension(codigo, rRemitente, rDestinatario, dim1, dim2, dim3);
                }catch(NullPointerException e){
                    
                }
                
            }else if(tipo.equals("P")){
                String rRemitente = reg.getString();
                String rDestinatario = reg.getString();
                int peso = reg.getInt();
                try{
                    sys.ingresarEnvioPeso(codigo, rRemitente, rDestinatario, peso);
                }catch(NullPointerException e){
                    
                }
            }
        }
	arch.close();
    }
    
    public static void SobreescribirTxts(SistemaEnvio sys) throws IOException{
        ArchivoSalida arch = new ArchivoSalida("clientes.txt");
        int cantidadClientes= sys.totalClientes();
        for (int i = 0; i < cantidadClientes; i++) {
            Registro reg = new Registro(4);
            String[] datos = sys.datosCliente(i);
            reg.agregarCampo(datos[0]);
            reg.agregarCampo(datos[1]);
            reg.agregarCampo(datos[2]);
            reg.agregarCampo(datos[3]);
            arch.writeRegistro(reg);
        }
        arch.close();
        
        ArchivoSalida arch2 = new ArchivoSalida("envios.txt");
        int cantidadEnvios = sys.totalEnvios();
        for (int i = 0; i < cantidadEnvios; i++) {
            String[] datos = sys.datosEnvios(i);
            if(datos[1].equals("D")){
                Registro reg = new Registro(7);
                reg.agregarCampo(datos[0]);
                reg.agregarCampo(datos[1]);
                reg.agregarCampo(datos[2]);
                reg.agregarCampo(datos[3]);
                reg.agregarCampo(datos[4]);
                reg.agregarCampo(datos[5]);
                reg.agregarCampo(datos[6]);
                arch2.writeRegistro(reg);
            }else if(datos[1].equals("P")){
                Registro reg2 = new Registro(5);
                reg2.agregarCampo(datos[0]);
                reg2.agregarCampo(datos[1]);
                reg2.agregarCampo(datos[2]);
                reg2.agregarCampo(datos[3]);
                reg2.agregarCampo(datos[4]);
                arch2.writeRegistro(reg2);
            }
        }
        arch2.close();
    }
}