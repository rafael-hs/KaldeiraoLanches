package Dao;

import Interfaces.AcoesPedido;
import Model.Comanda;
import Model.Pedido;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PedidoDAO implements AcoesPedido {

    public void Cadastrar(Pedido pedido, ArrayList<Comanda> comanda) throws SQLException {
        BDMySQL bd = new BDMySQL();
        Pedido pedidocad = pedido;

        String query = "INSERT INTO pedido("
                + "precoPedido,"
                + "idCliente,"
                + "idFuncionario,"
                + "dataPedido,"
                + "horaPedido,"
                + "statusPedido)"
                + " VALUE (?,?,?,?,?,?)";

        PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        statement.setDouble(1, pedidocad.getPreco());
        statement.setInt(2, pedidocad.getIdcliente());
        statement.setInt(3, pedidocad.getIdfuncionario());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        statement.setString(4, sdf.format(pedidocad.getData()));

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        statement.setString(5, sdf.format(pedidocad.getHora()));
        statement.setString(6, pedidocad.getStatus());
        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            System.out.println("EntrouNext");
            int idpedido = resultSet.getInt(1);
            for (Comanda comanda1 : comanda) {
                String query1 = "INSERT INTO comanda("
                        + "idPedido,"
                        + "idProduto,"
                        + "obsProduto)"
                        + " VALUE (?,?,?)";
                statement = bd.getConnection().prepareStatement(query1);
                statement.setInt(1, idpedido);
                statement.setInt(2, comanda1.getIdProduto());
                statement.setString(3, comanda1.getObs());

                int result = statement.executeUpdate();
                if (result == 0) {
                    throw new SQLException("Erro ao inserir os itens da comanda");
                }
            }
            resultSet.close();
            statement.close();
            bd.fechaConexao();

        } else {
            statement.close();
            bd.fechaConexao();
            throw new SQLException("Houve uma falha ao inserir o endereço no Banco de Dados");
        }

    }

    @Override
    public void Excluir(int id) throws SQLException {
        BDMySQL bd = new BDMySQL();
        String query = "";
        PreparedStatement statement;

        query = "DELETE FROM comanda WHERE comanda.idPedido = ?";
        statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        int result = statement.executeUpdate();

        if (result == 0) {
            statement.close();
            bd.fechaConexao();
            throw new SQLException("Houve uma falha ao deletar a comanda no Banco de Dados");

        } else {
            query = "DELETE FROM pedido WHERE pedido.idPedido = ?";
            statement = bd.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            result = statement.executeUpdate();

            statement.close();
            bd.fechaConexao();
            if (result == 0) {
                throw new SQLException("este Pedido nao existe ou não pode ser excluido");
            }
        }

    }

    @Override
    public void Alterar(Pedido pedido, ArrayList<Comanda> comanda) throws SQLException {
        Pedido pALT = pedido;

        BDMySQL bd = new BDMySQL();

        String query = "";

        PreparedStatement statement;

        query = "UPDATE pedido SET "
                + "pedido.precoPedido = ?,"
                + "pedido.dataPedido = ?,"
                + "pedido.horaPedido = ?,"
                + "pedido.statusPedido = ? "
                + "WHERE pedido.idPedido = ?";

        statement = bd.getConnection().prepareStatement(query);

        statement.setDouble(1, pALT.getPreco());

        SimpleDateFormat sdfData = new SimpleDateFormat("yyyy-MM-dd");
        statement.setString(2, sdfData.format(pALT.getData()));

        SimpleDateFormat sdfHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        statement.setString(3, sdfHora.format(pALT.getHora()));

        statement.setString(4, pALT.getStatus());
        statement.setInt(5, pedido.getIdPedido());

        int result = statement.executeUpdate();

        if (result == 0) {
            statement.close();
            bd.fechaConexao();
            throw new SQLException("Houve uma falha ao atulizar a tabela de Pedido no  banco de dados");
        } else {
            query = "DELETE FROM comanda WHERE idPedido = ? ";
            statement = bd.getConnection().prepareStatement(query);
            statement.setInt(1, pedido.getIdPedido());
            result = statement.executeUpdate();

            if (result == 0) {
                statement.close();
                bd.fechaConexao();
                throw new SQLException("Houve uma falha ao excluir os itens da comanda");
            } else {
                for (Comanda c : comanda) {
                    String query1 = "INSERT INTO comanda("
                            + "idPedido,"
                            + "idProduto,"
                            + "obsProduto)"
                            + " VALUE (?,?,?)";
                    statement = bd.getConnection().prepareStatement(query1);
                    statement.setInt(1, pedido.getIdPedido());
                    statement.setInt(2, c.getIdProduto());
                    statement.setString(3, c.getObs());

                    result = statement.executeUpdate();
                    if (result == 0) {
                        throw new SQLException("Erro ao inserir os itens da comanda");
                    }
                }

                statement.close();
                bd.fechaConexao();
            }
        }

    }

    @Override
    public Pedido Pesquisar(int id) throws SQLException {
        BDMySQL bd = new BDMySQL();
        Pedido pedido = new Pedido();
        String query = "SELECT * FROM pedido "
                + "WHERE idPedido = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            pedido.setIdPedido(resultSet.getInt("idPedido"));
            pedido.setPreco(resultSet.getDouble("precoPedido"));
            pedido.setIdcliente(resultSet.getInt("idCliente"));
            pedido.setIdfuncionario(resultSet.getInt("idFuncionario"));
            pedido.setData(resultSet.getDate("dataPedido"));
            pedido.setHora(resultSet.getDate("horaPedido"));
            pedido.setStatus(resultSet.getString("statusPedido"));

        }
        return pedido;
    }

    public ArrayList<Comanda> PesquisarComanda(int id) throws SQLException {
        BDMySQL bd = new BDMySQL();
        Comanda comanda;
        ArrayList<Comanda> comandalista = new ArrayList<>();
        String query = "SELECT comanda.*, \n"
                + "produto.nomeProduto, \n"
                + "produto.precoProduto, \n"
                + "produto.numProduto\n"
                + "FROM comanda, produto\n"
                + "WhERE comanda.idproduto = produto.idproduto \n"
                + "AND idPedido = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            comanda = new Comanda();
            comanda.setIdPedido(resultSet.getInt("idPedido"));
            comanda.setIdProduto(resultSet.getInt("idProduto"));
            comanda.setObs(resultSet.getString("obsProduto"));
            comanda.setNomeLanche(resultSet.getString("nomeProduto"));
            comanda.setNumLanche(resultSet.getInt("numProduto"));
            comanda.setPrecoLanche(resultSet.getDouble("precoProduto"));
            comandalista.add(comanda);
        }
        return comandalista;
    }

    public ArrayList<Pedido> PesquisarIdCliente(int idcliente) throws SQLException {
        BDMySQL bd = new BDMySQL();
        ArrayList<Pedido> listaped = new ArrayList<>();

        Pedido pedido;

        String query = "SELECT * FROM pedido "
                + "WHERE pedido.idCliente = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, idcliente);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            pedido = new Pedido();
            pedido.setIdPedido(resultSet.getInt("idPedido"));
            pedido.setPreco(resultSet.getDouble("precoPedido"));
            pedido.setIdcliente(resultSet.getInt("idCliente"));
            pedido.setIdfuncionario(resultSet.getInt("idFuncionario"));
            pedido.setData(resultSet.getDate("dataPedido"));
            pedido.setHora(resultSet.getDate("horaPedido"));
            pedido.setStatus(resultSet.getString("statusPedido"));
            listaped.add(pedido);
        }
        return listaped;
    }

    @Override
    public ArrayList<Pedido> listar() throws SQLException {
        BDMySQL bd = new BDMySQL();

        String query = "SELECT *FROM pedido WHERE pedido.idPedido";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<Pedido> listapd = new ArrayList<>();

        while (resultSet.next()) {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(resultSet.getInt("idPedido"));
            pedido.setPreco(resultSet.getDouble("precoPedido"));
            pedido.setIdcliente(resultSet.getInt("idCliente"));
            pedido.setIdfuncionario(resultSet.getInt("idFuncionario"));
            pedido.setData(resultSet.getDate("dataPedido"));
            pedido.setHora(resultSet.getDate("horaPedido"));
            pedido.setStatus(resultSet.getString("statusPedido"));
            listapd.add(pedido);
        }
//        }if(listapd.isEmpty()){
//            throw new SQLException();

        return listapd;

    }

    @Override
    public void Cadastrar(Pedido pedido) throws SQLException {
    }

}
