
package Interfaces;

import Model.Cliente;
import Model.Pessoa;
import java.sql.SQLException;
import java.util.ArrayList;


public interface AcoesBD {
    
    
    
    public void Cadastrar(Pessoa pessoa) throws SQLException;
    
    public void Excluir(int id) throws SQLException;
    
    public void Alterar(int id, Pessoa pessoaA) throws SQLException;
    
    public Pessoa Pesquisar(int id) throws SQLException;
    
    public ArrayList<Pessoa> Pesquisar(String nome) throws SQLException;
    
    public ArrayList<Pessoa> Pesquisar(long celular, int telefone) throws SQLException;
    
    public  ArrayList<Pessoa> Listar() throws SQLException;
    
    
        
    
}
