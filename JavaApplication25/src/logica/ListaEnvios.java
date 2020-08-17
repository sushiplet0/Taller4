
package logica;

import dominio.*;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public class ListaEnvios {
    private NodoEnvio first;
    private NodoEnvio last;
    public ListaEnvios(){
        this.first = null;
        this.last = null;
    }

    /**
     *
     * @param envio
     */
    public void IngresarEnvio(Envio envio){
        NodoEnvio nuevoEnvio = new NodoEnvio(envio);
        if(first == null){
            first = nuevoEnvio;
            last = nuevoEnvio;
            nuevoEnvio.setNext(nuevoEnvio);
            nuevoEnvio.setPrevio(nuevoEnvio);
        }else{
            nuevoEnvio.setPrevio(last);
            nuevoEnvio.setNext(last.getNext());
            last.getNext().setPrevio(nuevoEnvio);
            last.setNext(nuevoEnvio);
            last = nuevoEnvio;
        }
    }
    
    /**
     *
     * @return
     */
    public NodoEnvio getLast() {
        return last;
    }
    
    /**
     *
     * @return
     */
    public int totalEnvios(){
        int contador = 1;
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            contador++;
            aux = aux.getNext();
        }
        return contador;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public Envio getEnvioI(int i){
        int contador = 0;
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(contador==i){
                break;
            }
            contador++;
            aux = aux.getNext();
        }
        if(contador==0){
            return first.getEnvio();
        }else{
            return aux.getEnvio();
        }
    }
    
    /**
     *
     * @return
     */
    public String enviosTipoD(){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio() instanceof EnvioD){
                EnvioD envio = (EnvioD)aux.getEnvio();
                r+= envio.toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio() instanceof EnvioD){
            r+= aux.getEnvio().toString();
        }
        return r;
    }
    
    /**
     *
     * @return
     */
    public String enviosTipoP(){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio() instanceof EnvioP){
                EnvioP envio = (EnvioP)aux.getEnvio();
                r+= envio.toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio() instanceof EnvioP){
            r+= aux.getEnvio().toString();
        }
        return r;
    }

    /**
     *
     * @param rut
     * @return
     */
    public String enviosPersonaEnviados(String rut){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio().getRutRemitente().equals(rut)){
                r+= aux.getEnvio().toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio().getRutRemitente().equals(rut)){
            r+= aux.getEnvio().toString();
        }
        return r;
    }

    /**
     *
     * @param rut
     * @return
     */
    public String enviosPersonaRecibidos(String rut){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio().getRutDestino().equals(rut)){
                r+= aux.getEnvio().toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio().getRutDestino().equals(rut)){
            r+= aux.getEnvio().toString();
        }
        return r;
    }

    /**
     *
     * @param ciudad
     * @return
     */
    public String enviosCiudadRemitente(String ciudad){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio().getCiudadEnvio().equals(ciudad)){
                r+= aux.getEnvio().toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio().getCiudadEnvio().equals(ciudad)){
            r+= aux.getEnvio().toString()+"\n";
        }
        return r;
    }

    /**
     *
     * @param ciudad
     * @return
     */
    public String enviosCiudadDestino(String ciudad){
        String r = "";
        NodoEnvio aux = first;
        while(aux.getNext()!=first){
            if(aux.getEnvio().getCiudadDestino().equals(ciudad)){
                r+= aux.getEnvio().toString()+"\n";
            }
            aux = aux.getNext();
        }
        if(aux.getEnvio().getCiudadDestino().equals(ciudad)){
            r+= aux.getEnvio().toString()+"\n";
        }
        return r;
    }
}
