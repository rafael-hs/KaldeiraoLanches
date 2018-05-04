package Interfaces;

import Model.Pessoa;
import Model.Produto;
import java.util.ArrayList;


public interface AcoesProg {
    
    
    
    public void cadastrarCliente(Pessoa pessoa) throws Exception;
    public void cadastrarFuncionario(Pessoa pessoa) throws Exception;
    
    public void excluirCliente(int id)throws Exception;
    public void excluirFuncionario(int id)throws Exception;
    
    public void editarCliente(int id, Pessoa pessoa)throws Exception;
    public void editarFuncionario(int id, Pessoa pessoa)throws Exception;
    
    public ArrayList<Pessoa> pesquisarCliente(String nome)throws Exception;
    public ArrayList<Pessoa> pesquisarFuncionario(String nome)throws Exception;
    public ArrayList<Pessoa> pesquisarCliente(long telefone,int tipo)throws Exception;
    public ArrayList<Pessoa> pesquisarFuncionario(long telefone,int tipo)throws Exception;
    public ArrayList<Pessoa> ListarCliente()throws Exception;
    public ArrayList<Pessoa> ListarFuncionario()throws Exception;
    
    public void CadastrarPD(Produto produto) throws Exception;
    public void ExcluirPD(int id) throws Exception;
    public void EditarPD(int valor ,Produto produto) throws Exception;
    public ArrayList<Produto> PesquisarPD(String nome) throws Exception;
    public ArrayList<Produto> PesquisarPD(int numeroPD) throws Exception;
    public ArrayList<Produto> ListarPD() throws Exception;
    
}
