package Dao;

import Interfaces.AcoesBD;
import Model.Funcionario;
import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class FuncionarioDAO  implements AcoesBD{

     @Override
    public void Cadastrar(Pessoa pessoa) throws SQLException {
        Funcionario fun = (Funcionario) pessoa;
        BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO endereco("
                + "ruaEndereco,"
                + "bairroEndereco,"
                + "cepEndereco,"
                + "cidadeEndereco,"
                + "nDaCasaEndereco)"
                + " VALUE (?,?,?,?,?)";
                
                PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1, fun.getRua());
                statement.setString(2, fun.getBairro());
                statement.setString(3, fun.getCep());
                statement.setString(4, fun.getCidade());
                statement.setString(5, fun.getNumCasa());
                
                statement.executeUpdate();
                
                ResultSet resultSet = statement.getGeneratedKeys();
                
                if(!resultSet.next()){
                    resultSet.close();
                    statement.close();
                    bd.fechaConexao();
                    throw new SQLException("Houve uma falha ao inserir o endereço no Banco de Dados");
                    
                }else{
        
               int idEndereco = resultSet.getInt(1);
                    
             query= "INSERT INTO funcionario ("
                + "nomeFuncionario,"
                + "cpfFuncionario,"
                + "celularFuncionario,"
                + "telefoneFuncionario,"
                + "nascFuncionario,"
                + "idFuncionarioEndereco)"
                + "VALUES (?,?,?,?,?,?)";
        
                 statement = bd.getConnection().prepareStatement(query);
                statement.setString(1, fun.getNome());
                statement.setString(2, fun.getCpf());
                statement.setString(3, fun.getCelular());
                statement.setString(4, fun.getTelefone());
                statement.setString(5, fun.getNascimento());
                statement.setInt(6, idEndereco);
               int result = statement.executeUpdate();
                
                if(result != 1){
                  
                       throw new SQLException("Ocorreu um erro ao incluir um Funcionario ao banco de dados");
                   
                }else{
                    
                }
                statement.close();
                bd.fechaConexao();
                
    }
    }

    @Override
    public void Excluir(int id) throws SQLException {
      BDMySQL bd = new BDMySQL();
      
        String query = "";
        PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        
         query = "DELETE FROM funcionario,endereco USING endereco INNER JOIN funcionario "
                + "WHERE endereco.idEndereco = funcionario.idFuncionarioEndereco AND funcionario.idFuncionario = ?";
       
        statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        
        int result ;
        
        
        result = statement.executeUpdate();
        
        
        statement.close();
        bd.fechaConexao();
        
        if(result == 0){
            throw new SQLException("este id de funcionario não existe ou não pode ser excluido");
        }
                
    }
    

    @Override
    public void Alterar(int id, Pessoa pessoaA) throws SQLException {
       Pessoa pessoaALT = (Pessoa) pessoaA;
        BDMySQL bd = new BDMySQL();
        
        String query = "";
        PreparedStatement statement;
        
         query = "UPDATE funcionario,endereco SET "
                + "funcionario.nomeFuncionario = ?,"
                + "funcionario.cpfFuncionario = ?,"
                + "funcionario.celularFuncionario = ?,"
                + "funcionario.telefoneFuncionario = ?,"
                + "funcionario.nascFuncionario = ?,"
                + "endereco.ruaEndereco = ?,"
                + "endereco.bairroEndereco = ?,"
                + "endereco.cepEndereco = ?,"
                + "endereco.cidadeEndereco = ?,"
                + "endereco.nDaCasaEndereco = ? "
                + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco AND funcionario.idFuncionario = ?";
                 statement = bd.getConnection().prepareStatement(query);
                
                statement.setString(1, pessoaALT.getNome());
                statement.setString(2, pessoaALT.getCpf());
                statement.setString(3, pessoaALT.getCelular());
                statement.setString(4, pessoaALT.getTelefone());
                statement.setString(5, pessoaALT.getNascimento());
                statement.setString(6, pessoaALT.getRua());
                statement.setString(7, pessoaALT.getBairro());
                statement.setString(8, pessoaALT.getCep());
                statement.setString(9, pessoaALT.getCidade());
                statement.setString(10, pessoaALT.getNumCasa());
                statement.setInt(11, id);
                
                
                int result = statement.executeUpdate();
                
                statement.close();
                bd.fechaConexao();
                
                if(result == 0){
                    //caso a att dê errado, lança uma exceção
                    
                    throw new SQLException("Houve uma falha ao atualizar as tabelas Funcionario e Endereço no Banco de Dados");
                }
    }

    @Override
    public ArrayList<Pessoa> Pesquisar(String nome) throws SQLException {
        BDMySQL bd = new BDMySQL();
            
            String query = "SELECT * FROM funcionario,endereco "
                    + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco "
                    + "AND nomeFuncionario LIKE ?";
            
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setString(1, nome+"%");
            ResultSet resultSet = statement.executeQuery();
            
            ArrayList<Pessoa> listaPe = new ArrayList<>();
            
       
            
                while(resultSet.next()){
                Funcionario pessoaPESQ = new Funcionario();
                
                pessoaPESQ.setIdFuncionario(resultSet.getInt("idFuncionario"));
                pessoaPESQ.setNome(resultSet.getString("nomeFuncionario"));
                pessoaPESQ.setCpf(resultSet.getString("cpfFuncionario"));
                pessoaPESQ.setCelular(resultSet.getString("celularFuncionario"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneFuncionario"));
                pessoaPESQ.setNascimento(resultSet.getString("nascFuncionario"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                listaPe.add(pessoaPESQ);
                }if(listaPe.isEmpty()){
                      throw new SQLException("Nenhum Funcionario com esse nome no momento");
                }else{
                     
                     
                     return listaPe;
                }
            }
            
    
    

    @Override
    public ArrayList<Pessoa> Pesquisar(long celular, int opcao) throws SQLException {
      BDMySQL bd = new BDMySQL(); 
      
       Funcionario pessoaPESQ = new Funcionario();
       ArrayList<Pessoa> listaPe = new ArrayList<>();
       ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        
            if(opcao == 1){
            String query = "SELECT * FROM funcionario,endereco "
                    + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco "
                    + "AND celularFuncionario = ?";
                    
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setLong(1, celular);
            ResultSet resultSet = statement.executeQuery();
           
                
               while(resultSet.next()){
                
                pessoaPESQ.setIdFuncionario(resultSet.getInt("idFuncionario"));
                pessoaPESQ.setNome(resultSet.getString("nomeFuncionario"));
                pessoaPESQ.setCpf(resultSet.getString("cpfFuncionario"));
                pessoaPESQ.setCelular(resultSet.getString("celularFuncionario"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneFuncionario"));
                pessoaPESQ.setNascimento(resultSet.getString("nascFuncionario"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                listaPe.add(pessoaPESQ);
                }if(listaPe.isEmpty()){
                      throw new SQLException("Nenhum Funcionario com esse nome no momento");
                }else{
                     listaPessoas = new ArrayList(listaPe);
                     
                }
            
            }
            else if(opcao == 2){
                String query = "SELECT * FROM funcionario,endereco "
                    + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco "
                    + "AND telefoneFuncionario = ?";
                
                PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setLong(1, celular);
            ResultSet resultSet = statement.executeQuery();
           
           
            while(resultSet.next()){
                
                pessoaPESQ.setIdFuncionario(resultSet.getInt("idFuncionario"));
                pessoaPESQ.setNome(resultSet.getString("nomeFuncionario"));
                pessoaPESQ.setCpf(resultSet.getString("cpfFuncionario"));
                pessoaPESQ.setCelular(resultSet.getString("celularFuncionario"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneFuncionario"));
                pessoaPESQ.setNascimento(resultSet.getString("nascFuncionario"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                listaPe.add(pessoaPESQ);
                }if(listaPe.isEmpty()){
                      throw new SQLException("Nenhum Funcionario com esse nome no momento");
                }else{
                      listaPessoas = new ArrayList(listaPe);
                      
                }
                
            }
            
            return listaPessoas;
    }

    @Override
    public ArrayList<Pessoa> Listar() throws SQLException {
       BDMySQL bd = new BDMySQL();
      
      String query = "SELECT * FROM funcionario,endereco "
              + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco";
      
      PreparedStatement statement = bd.getConnection().prepareStatement(query);
      ResultSet resultSet = statement.executeQuery();
      
      ArrayList<Pessoa> listaPE = new ArrayList<>();
      
      while(resultSet.next()){
            Funcionario pessoa = new Funcionario(); 
                pessoa.setIdFuncionario(resultSet.getInt("idFuncionario"));
                pessoa.setNome(resultSet.getString("nomeFuncionario"));
                pessoa.setCpf(resultSet.getString("cpfFuncionario"));
                pessoa.setCelular(resultSet.getString("celularFuncionario"));
                pessoa.setTelefone(resultSet.getString("telefoneFuncionario"));
                pessoa.setNascimento(resultSet.getString("nascFuncionario"));
                pessoa.setRua(resultSet.getString("ruaEndereco"));
                pessoa.setBairro(resultSet.getString("bairroEndereco"));
                pessoa.setCep(resultSet.getString("cepEndereco"));
                pessoa.setCidade(resultSet.getString("cidadeEndereco"));
                pessoa.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                
          listaPE.add(pessoa);
      }
            return listaPE;
        
    }

  
     @Override
    public Funcionario Pesquisar(int id) throws SQLException {
    BDMySQL bd = new BDMySQL();
         Funcionario pessoaPESQ = new Funcionario();   
            String query = "SELECT * FROM funcionario,endereco "
                    + "WHERE funcionario.idFuncionarioEndereco = endereco.idEndereco "
                    + "AND idFuncionario = ?";
            
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
                while(resultSet.next()){
                
                pessoaPESQ.setIdFuncionario(resultSet.getInt("idFuncionario"));
                pessoaPESQ.setNome(resultSet.getString("nomeFuncionario"));
                pessoaPESQ.setCpf(resultSet.getString("cpfFuncionario"));
                pessoaPESQ.setCelular(resultSet.getString("celularFuncionario"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneFuncionario"));
                pessoaPESQ.setNascimento(resultSet.getString("nascFuncionario"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                }
                
                     
                     return pessoaPESQ;
    }


   
}
