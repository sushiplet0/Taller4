/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author sushipleto
 */
public class EnvioP extends Envio{
    private int pesoNeto;

    public EnvioP(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino, int pesoN) {
        super(codigo, rutR, rutD, ciudadEnvio, ciudadDestino);
        this.pesoNeto = pesoN;
        
    }

    public int getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(int pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    @Override
    public void calcularCosto() {
        int costo = (pesoNeto/1000) * 1000;
        super.setCosto(costo);
    }
    
    @Override
    public String toString() {
        String r = "Tipo de envío: Envio por peso(P) | ";
        int codigo = super.getCodigo();
        int costo = super.getCosto();
        r+= "Código de envio: "+codigo+" | Costo de envio: "+costo;
        return r;
    }

}
