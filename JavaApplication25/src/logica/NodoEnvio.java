/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.*;

/**
 *
 * @author sushipleto
 */
public class NodoEnvio {
    private NodoEnvio next;
    private NodoEnvio previo;
    private Envio envio;
    
    public NodoEnvio(Envio envio){
        this.next = null;
        this.next = null;
        this.envio = envio;
    }

    public NodoEnvio getNext() {
        return next;
    }

    public void setNext(NodoEnvio next) {
        this.next = next;
    }

    public NodoEnvio getPrevio() {
        return previo;
    }

    public void setPrevio(NodoEnvio previo) {
        this.previo = previo;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    
}
