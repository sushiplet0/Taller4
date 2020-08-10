/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.*;
import ucn.*;

/**
 *
 * @author sushipleto
 */
public class App {
    public static void main(String[] args){
        ListaEnvios le = new ListaEnvios();
        //PROBANDING LA LISTA DE ENVIOS
        EnvioD envio = new EnvioD("24","2","2","coquimbo","la serena",14,15,12);
        envio.calcularCosto();
        EnvioP envioP = new EnvioP("95","3","3","coquimbo","copiapo",10000);
        envioP.calcularCosto();
        EnvioD envio3 = new EnvioD("6","2","2","copiapo","la serena",14,12,12);
        envio3.calcularCosto();
        EnvioD envio4 = new EnvioD("14","2","2","chillan","copiapo",14,5,12);
        envio4.calcularCosto();
        EnvioD envio5 = new EnvioD("56","2","2","copiapo","chillan",14,15,32);
        envio5.calcularCosto();
        EnvioP envioP2 = new EnvioP("75","3","3","poto","caca",1000);
        envioP2.calcularCosto();
        le.IngresarEnvio(envio);
        le.IngresarEnvio(envioP);
        le.IngresarEnvio(envio3);
        le.IngresarEnvio(envio4);
        le.IngresarEnvio(envio5);
        le.IngresarEnvio(envioP2);
        StdOut.println("--------------\nEnvios tipo dimensiones:\n");
        StdOut.println(le.enviosTipoD());
        StdOut.println("--------------\nEnvios tipo peso:\n");
        StdOut.println(le.enviosTipoP());
        StdOut.println("--------------\nPaquetes enviados desde la ciudad de Coquimbo:\n");
        StdOut.println(le.enviosCiudadRemitente("coquimbo"));
    }
}
