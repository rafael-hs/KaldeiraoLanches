
package Interfaces;

import Model.Comanda;
import Model.Pedido;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AcoesPedido {
    public void Cadastrar(Pedido pedido) throws SQLException;
    
    public void Excluir(int id) throws SQLException;
    
    public void Alterar(Pedido pedido, ArrayList<Comanda> comanda) throws SQLException;
    
    public Pedido Pesquisar(int id) throws SQLException;
    
    public ArrayList<Pedido> listar() throws SQLException;
}
