
package Interfaces;

import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;


public interface AcoesBDproduto {
   
    public void CadastrarPD(Produto produtoNovo) throws SQLException;
    
    public void ExcluirPD(int id) throws SQLException;
    
    public void AlterarPD(int id, Produto produto) throws SQLException;
    
    public Produto PesquisarPD2(int id) throws SQLException;
    
    public ArrayList<Produto> PesquisarPD(String nome) throws SQLException;
    
    public ArrayList<Produto> PesquisarPD(int numeroPD) throws SQLException;
    
    public ArrayList<Produto> ListarPD() throws SQLException;
    
}
