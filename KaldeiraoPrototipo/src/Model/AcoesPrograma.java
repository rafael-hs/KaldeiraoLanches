package Model;


import Dao.ClienteDAO;
import Dao.FuncionarioDAO;
import Dao.ProdutoDAO;
import Interfaces.AcoesProg;
import java.util.ArrayList;

public class AcoesPrograma implements AcoesProg {

    @Override
    public void cadastrarCliente(Pessoa pessoa) throws Exception {
       Cliente cliente = (Cliente) pessoa;
       
       if(cliente.getNome().isEmpty()){
           throw new Exception("O nome do cliente é OBRIGATÓRIO!");
       }else if(cliente.getNome().length() <3){
           throw new Exception("O nome do cliente tem que haver no minimo 3 letras!");
       }
       else if(String.valueOf(cliente.getTelefone()).length() != 9 ){
           throw new Exception("O numero de telefone precisa ter OITO numeros!");
       }
       else if (cliente.getRua().isEmpty()){
           throw new Exception("O nome da rua não pode estar vazio!");
       }
       else if(cliente.getBairro().isEmpty()){
           throw new Exception("O nome do bairro não pode estar vazio!");
       }
       else if(cliente.getCep().isEmpty()){
           throw new Exception("O Cep não pode estar vazio!");
       }
       else if(cliente.getCidade().isEmpty()){
           throw new Exception("O nome da cidade não pode estar vazio!");
       }
       else if(cliente.getNumCasa().isEmpty()){
           throw new Exception("O numero da casa não pode estar vazio!");
       }
       else{
           ClienteDAO cdao = new ClienteDAO();
           cdao.Cadastrar(cliente);  
       }
        
    }

    @Override
    public void cadastrarFuncionario(Pessoa pessoa) throws Exception {
      Funcionario funcionario = (Funcionario) pessoa;
      
      if(funcionario.getNome().isEmpty()){
           throw new Exception("O nome do funcionario é OBRIGATÓRIO!");
       }
       else if(funcionario.getNome().length() <3){
           throw new Exception("O nome do funcionario tem que haver no minimo 3 letras!");
       }
       else if(String.valueOf(funcionario.getTelefone()).length() != 9 ){
           throw new Exception("O numero de telefone precisa ter OITO numeros!");
       }
       else if (funcionario.getRua().isEmpty()){
           throw new Exception("O nome da rua não pode estar vazio!");
       }
       else if(funcionario.getBairro().isEmpty()){
           throw new Exception("O nome do bairro não pode estar vazio!");
       }
       else if(funcionario.getCep().isEmpty()){
           throw new Exception("O Cep não pode estar vazio!");
       }
       else if(funcionario.getCidade().isEmpty()){
           throw new Exception("O nome da cidade não pode estar vazio!");
       }
       else if(funcionario.getNumCasa().isEmpty()){
           throw new Exception("O numero da casa não pode estar vazio!");
       
       }else{
          FuncionarioDAO fdao = new FuncionarioDAO();
          fdao.Cadastrar(funcionario);  
       }
    }

    @Override
    public void excluirCliente(int id) throws Exception {
        if(id == -1 ){
            throw new Exception("esse cliente não existe, informe um cliente VÁLIDO");
        }
        
        ClienteDAO cdao = new ClienteDAO();
        cdao.Excluir(id);
    }

    @Override
    public void excluirFuncionario(int id) throws Exception {
      
        if(id == -1 ){
            throw new Exception("esse cliente não existe, informe um cliente VÁLIDO");
        }
        
        FuncionarioDAO fdao = new FuncionarioDAO();
        fdao.Excluir(id);
    }

    @Override
    public void editarCliente(int id, Pessoa pessoa) throws Exception {
      Cliente cliente = (Cliente) pessoa;
      if(cliente.getIdCliente() == -1 ){
            throw new Exception("esse cliente não existe, informe um cliente VÁLIDO");
        }
      ClienteDAO cdao = new ClienteDAO();
      cdao.Alterar(id, cliente);
    }

    @Override
    public void editarFuncionario(int id, Pessoa pessoa) throws Exception {
         Funcionario funcionario = (Funcionario) pessoa;
      if(funcionario.getIdFuncionario() == -1 ){
            throw new Exception("esse cliente não existe, informe um cliente VÁLIDO");
        }
      FuncionarioDAO fdao = new FuncionarioDAO();
      fdao.Alterar(id, funcionario);
    }

    @Override
    public ArrayList<Pessoa> pesquisarCliente(String nome) throws Exception {
      
      ClienteDAO cdao = new ClienteDAO();
      return cdao.Pesquisar(nome);
    }

    @Override
    public ArrayList<Pessoa> pesquisarFuncionario(String nome) throws Exception {
      
      FuncionarioDAO fdao = new FuncionarioDAO();
      return fdao.Pesquisar(nome);
    }

    @Override
    public ArrayList<Pessoa> pesquisarCliente(long telefone,int tipo) throws Exception {
        if(tipo == 0){
            throw new Exception("só é possivel pesquisar por telefone ou celular, tente novamente");
        }else if(tipo == -1){
            throw new Exception("só é possivel pesquisar por telefone ou celular, tente novamente");
        }
//            else if(telefone == -1){
//            throw new Exception("Digite numeros para pesquisar por telefone");
//        }
//            else if(telefone == 0){
//            throw new Exception("digite um numero para pesquisar");
//        }
//        }else if(telefone > 10 && tipo ==1){
//            throw new Exception("só é possivel pesquisar celulares com 9 numeros, tente novamente");
//        }else if(telefone < 9 && tipo ==2){
//            throw new Exception("só é possivel pesquisar telefones com 8 numeros, tente novamente");
//        }
        ClienteDAO cdao = new ClienteDAO();
        return cdao.Pesquisar(telefone, tipo);
    }

    @Override
    public ArrayList<Pessoa> pesquisarFuncionario(long telefone,int tipo) throws Exception {
      if(tipo == 0){
            throw new Exception("só é possivel pesquisar por telefone ou celular, tente novamente");
        }else if(tipo == -1){
            throw new Exception("só é possivel pesquisar por telefone ou celular, tente novamente");
//        }else if(telefone > 9 && tipo ==1){
//            throw new Exception("só é possivel pesquisar celulares com 9 numeros, tente novamente");
//        }else if(telefone > 8 && tipo ==2){
//            throw new Exception("só é possivel pesquisar telefones com 8 numeros, tente novamente");
        }
        FuncionarioDAO fdao = new FuncionarioDAO();
        return fdao.Pesquisar(telefone, tipo);
    }

    @Override
    public ArrayList<Pessoa> ListarCliente() throws Exception {
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    ClienteDAO cdao = new ClienteDAO();
    
    return cdao.Listar();
    }

    @Override
    public ArrayList<Pessoa> ListarFuncionario() throws Exception {
    FuncionarioDAO fdao = new FuncionarioDAO();
    return fdao.Listar();
    }

    @Override
    public void CadastrarPD(Produto produto) throws Exception {
    
    if(produto.getNome().isEmpty()){
    throw new Exception("O nome do produto não pode está vazio");
    }
    else if(produto.getPreco() <= 0){
        throw new Exception("O preço não pode ser ZERO ou menor que ZERO!");
    }
    else if(produto.getNumero() > 500){
        throw new Exception("O numero maximo é quinhentos favor excluir um produto com numeração menor que quinhentos");
    }
    else if(produto.getDescricao().isEmpty()){
        throw new Exception("A descrição do produto não pode estar vazia");
    }
    else if(produto.getNumero() <= 0){
        throw new Exception("O numero de cardapio do produto não pode ser menor ou igual a ZERO!");
    }
    else{
      ProdutoDAO pdao = new ProdutoDAO();
      pdao.CadastrarPD(produto);  
    }
        
    }

    @Override
    public void ExcluirPD(int id) throws Exception {
        
        if(id == -1 ){
            throw new Exception("esse produto não existe, informe um produto VÁLIDO");
        }
        
        ProdutoDAO pdao = new ProdutoDAO();
        pdao.ExcluirPD(id);
    }

    @Override
    public void EditarPD(int valor, Produto produto) throws Exception {
    if(produto == null){
        throw new Exception("Não é possivel Editar esse produto ou não existe");
    }
    
    ProdutoDAO pdao = new ProdutoDAO();
    pdao.AlterarPD(valor, produto);
    
    }

    @Override
    public ArrayList<Produto> PesquisarPD(String nome) throws Exception {
     if(nome.isEmpty()){
         throw new Exception("Não é possivel pesquisar por um nome VAZIO");
     } 
     ProdutoDAO pdao = new ProdutoDAO();
     return pdao.PesquisarPD(nome);
    }
    @Override
    public ArrayList<Produto> PesquisarPD(int id) throws Exception{
       
        ProdutoDAO pdao = new ProdutoDAO();
        return pdao.PesquisarPD(id);
    }

    @Override
    public ArrayList<Produto> ListarPD() throws Exception {
      ProdutoDAO pdao = new ProdutoDAO();
      return pdao.ListarPD();
    }
    
    
}
