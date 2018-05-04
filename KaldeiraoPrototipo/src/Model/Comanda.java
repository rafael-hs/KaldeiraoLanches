
package Model;

public class Comanda {
    
    private int numLanche;
    private String nomeLanche;
    private Double precoLanche;
    private int idProduto;
    private int idPedido;
    private String obs;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getNumLanche() {
        return numLanche;
    }

    public void setNumLanche(int numLanche) {
        this.numLanche = numLanche;
    }

    public String getNomeLanche() {
        return nomeLanche;
    }

    public void setNomeLanche(String nomeLanche) {
        this.nomeLanche = nomeLanche;
    }

    public Double getPrecoLanche() {
        return precoLanche;
    }

    public void setPrecoLanche(Double precoLanche) {
        this.precoLanche = precoLanche;
    }
    
    
    
}
