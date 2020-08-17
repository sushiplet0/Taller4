/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.*;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public class NodoEnvio {
    private NodoEnvio next;
    private NodoEnvio previo;
    private Envio envio;
    
    /**
     *
     * @param envio
     */
    public NodoEnvio(Envio envio){
        this.next = null;
        this.next = null;
        this.envio = envio;
    }

    /**
     *
     * @return
     */
    public NodoEnvio getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(NodoEnvio next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public NodoEnvio getPrevio() {
        return previo;
    }

    /**
     *
     * @param previo
     */
    public void setPrevio(NodoEnvio previo) {
        this.previo = previo;
    }

    /**
     *
     * @return
     */
    public Envio getEnvio() {
        return envio;
    }

    /**
     *
     * @param envio
     */
    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    
}
