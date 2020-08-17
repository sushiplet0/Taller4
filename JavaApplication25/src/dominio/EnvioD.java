
package dominio;

/**
 *
 * @author Paula Veloso y Pablo Ríos
 */
public class EnvioD extends Envio{
    private int dimension1;
    private int dimension2;
    private int dimension3;
    
    /**
     *
     * @param codigo
     * @param rutR
     * @param rutD
     * @param ciudadEnvio
     * @param ciudadDestino
     * @param dim1
     * @param dim2
     * @param dim3
     */
    public EnvioD(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino,int dim1, int dim2, int dim3) {
        super(codigo, rutR, rutD, ciudadEnvio, ciudadDestino);
        this.dimension1 = dim1;
        this.dimension2 = dim2;
        this.dimension3 = dim3;
    }

    /**
     *
     * @return
     */
    public int getDimension1() {
        return dimension1;
    }

    /**
     *
     * @param dimension1
     */
    public void setDimension1(int dimension1) {
        this.dimension1 = dimension1;
    }

    /**
     *
     * @return
     */
    public int getDimension2() {
        return dimension2;
    }

    /**
     *
     * @param dimension2
     */
    public void setDimension2(int dimension2) {
        this.dimension2 = dimension2;
    }

    /**
     *
     * @return
     */
    public int getDimension3() {
        return dimension3;
    }

    /**
     *
     * @param dimension3
     */
    public void setDimension3(int dimension3) {
        this.dimension3 = dimension3;
    }

    @Override
    public void calcularCosto() {
        int costo = (dimension1 + dimension2 + dimension3) * 50;
        super.setCosto(costo);
    }

    @Override
    public String toString() {
        String r = "Tipo de envío: Envio por dimensiones(D) | ";
        int codigo = super.getCodigo();
        int costo = super.getCosto();
        r+= "Código de envio: "+codigo+" | Costo de envio: "+costo;
        return r;
    }
    
    
}
