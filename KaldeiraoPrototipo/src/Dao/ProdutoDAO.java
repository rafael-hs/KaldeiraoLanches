
package Dao;

import Interfaces.AcoesBDproduto;
import Model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDAO implements AcoesBDproduto {

    @Override
    public void CadastrarPD(Produto produtoNovo) throws SQLException {
       BDMySQL bd = new BDMySQL();
       Produto prod = produtoNovo;
       
       String query = "INSERT INTO produto("
               + "nomeProduto,"
               + "precoProduto,"
               + "numProduto,"
               + "descricaoProduto)"
               + " VALUE (?,?,?,?)";
       
       PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       statement.setString(1, prod.getNome());
       statement.setDouble(2, prod.getPreco());
       statement.setInt(3, prod.getNumero());
       statement.setString(4, prod.getDescricao());
       statement.executeUpdate();
       
       ResultSet resultSet = statement.getGeneratedKeys();
       
       if(!resultSet.next()){
           resultSet.close();
           statement.close();
           bd.fechaConexao();
           throw new SQLException("Houve uma falha ao inserir o produto no banco de dados");
       }else{
       statement.close();
       bd.fechaConexao();
       
       }
    }

    @Override
    public void ExcluirPD(int id) throws SQLException {
       BDMySQL bd = new BDMySQL();
       String query = "";
       PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
       
       query = "DELETE FROM produto WHERE produto.idProduto = ?";
       statement = bd.getConnection().prepareStatement(query);
       statement.setInt(1, id);
       
       int result = statement.executeUpdate();
       
      
       
       statement.close();
       bd.fechaConexao();
       
       if(result == 0){
           throw new SQLException("Este produto não existe ou não pode ser excluido");
       }
    }

    @Override
    public void AlterarPD(int id, Produto produto) throws SQLException {
        Produto produtoALT = (Produto) produto;
        BDMySQL bd = new BDMySQL();
        
        String query = "";
        PreparedStatement statement;
        
        query = "UPDATE produto SET "
                + "produto.nomeProduto = ?,"
                + "produto.precoProduto = ?,"
                + "produto.numProduto = ?,"
                + "produto.descricaoProduto = ?"
                + "WHERE produto.idProduto = ?";
        
                statement = bd.getConnection().prepareStatement(query);
                
                statement.setString(1, produtoALT.getNome());
                statement.setDouble(2, produtoALT.getPreco());
                statement.setInt(3, produtoALT.getNumero());
                statement.setString(4, produtoALT.getDescricao());
                statement.setInt(5, id);
                
                int result = statement.executeUpdate();
                
                statement.close();
                bd.fechaConexao();
                
                if(result == 0){
                    //caso a att dê errado, o metodo lança uma exceção
                    throw new SQLException("Houve uma falha ao atualizar a tabela de Produto no banco de dados");
                }
                
    }

    @Override
    public Produto PesquisarPD2(int id) throws SQLException{
        BDMySQL bd = new BDMySQL();
         Produto produtoPESQ = new Produto();   
            String query = "SELECT * FROM produto "
                    + "WHERE produto.idProduto = ?";
            
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
                while(resultSet.next()){
                 produtoPESQ.setIdproduto(resultSet.getInt("idProduto"));
                 produtoPESQ.setNumero(resultSet.getInt("numProduto"));
                 produtoPESQ.setNome(resultSet.getString("nomeProduto"));
                 produtoPESQ.setDescricao(resultSet.getString("descricaoProduto"));
                 produtoPESQ.setPreco(resultSet.getDouble("precoProduto"));
                }
                
                return produtoPESQ;
    }
    
    @Override
    public ArrayList<Produto> PesquisarPD(String nome) throws SQLException {
        BDMySQL bd = new BDMySQL();
            
            String query = "SELECT * FROM produto WHERE produto.nomeProduto LIKE ?";
            
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setString(1, nome+"%");
            ResultSet resultSet = statement.executeQuery();
            
            ArrayList<Produto> listaProd = new ArrayList<>();
            
            while(resultSet.next()){
                Produto produtoPESQ = new Produto();
                 produtoPESQ.setIdproduto(resultSet.getInt("idProduto"));
                produtoPESQ.setNome(resultSet.getString("nomeProduto"));
                produtoPESQ.setPreco(resultSet.getDouble("precoProduto"));
                produtoPESQ.setNumero(resultSet.getInt("numProduto"));
                produtoPESQ.setDescricao(resultSet.getString("descricaoProduto"));
                listaProd.add(produtoPESQ);
            }if(listaProd.isEmpty()){
                throw new SQLException("Nenhum Produto encontrado com esse nome no Banco de dados");
            }else{
                return listaProd; 
            }
                    
    }
    @Override
    public ArrayList<Produto> PesquisarPD(int numeroPD) throws SQLException{
        BDMySQL bd = new BDMySQL();
        
            String query = "SELECT * FROM produto WHERE produto.numProduto = ?";
            
            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setInt(1, numeroPD);
            ResultSet resultSet = statement.executeQuery();
            
            ArrayList<Produto> listaProd = new ArrayList<>();
            
            while(resultSet.next()){
                Produto produtoPESQ = new Produto();
                 produtoPESQ.setIdproduto(resultSet.getInt("idProduto"));
                produtoPESQ.setNome(resultSet.getString("nomeProduto"));
                produtoPESQ.setPreco(resultSet.getDouble("precoProduto"));
                produtoPESQ.setNumero(resultSet.getInt("numProduto"));
                produtoPESQ.setDescricao(resultSet.getString("descricaoProduto"));
                listaProd.add(produtoPESQ);
            }if(listaProd.isEmpty()){
                throw new SQLException("Nenhum Produto encontrado com esse nome no Banco de dados");
            }else{
                return listaProd; 
            }
        
        
    }

    @Override
    public ArrayList<Produto> ListarPD() throws SQLException {
        BDMySQL bd = new BDMySQL();
        
        String query = "SELECT * FROM produto WHERE produto.idProduto";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        ArrayList<Produto> listaProd = new ArrayList<>();
        
        while(resultSet.next()){
            Produto produtoPESQ = new Produto();
                 produtoPESQ.setIdproduto(resultSet.getInt("idProduto"));
                produtoPESQ.setNome(resultSet.getString("nomeProduto"));
                produtoPESQ.setPreco(resultSet.getDouble("precoProduto"));
                produtoPESQ.setNumero(resultSet.getInt("numProduto"));
                produtoPESQ.setDescricao(resultSet.getString("descricaoProduto"));
                listaProd.add(produtoPESQ);
            }
                return listaProd; 
            
        }
    }
    

