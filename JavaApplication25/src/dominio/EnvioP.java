
package dominio;

/**
 *
 * @author sushipleto
 */
public class EnvioP extends Envio{
    private int pesoNeto;

    /**
     *
     * @param codigo
     * @param rutR
     * @param rutD
     * @param ciudadEnvio
     * @param ciudadDestino
     * @param pesoN
     */
    public EnvioP(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino, int pesoN) {
        super(codigo, rutR, rutD, ciudadEnvio, ciudadDestino);
        this.pesoNeto = pesoN;
        
    }

    /**
     *
     * @return
     */
    public int getPesoNeto() {
        return pesoNeto;
    }

    /**
     *
     * @param pesoNeto
     */
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
