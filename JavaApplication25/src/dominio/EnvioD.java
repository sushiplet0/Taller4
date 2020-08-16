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
public class EnvioD extends Envio{
    private int dimension1;
    private int dimension2;
    private int dimension3;
    public EnvioD(int codigo, String rutR, String rutD, String ciudadEnvio, String ciudadDestino,int dim1, int dim2, int dim3) {
        super(codigo, rutR, rutD, ciudadEnvio, ciudadDestino);
        this.dimension1 = dim1;
        this.dimension2 = dim2;
        this.dimension3 = dim3;
    }

    public int getDimension1() {
        return dimension1;
    }

    public void setDimension1(int dimension1) {
        this.dimension1 = dimension1;
    }

    public int getDimension2() {
        return dimension2;
    }

    public void setDimension2(int dimension2) {
        this.dimension2 = dimension2;
    }

    public int getDimension3() {
        return dimension3;
    }

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
