package Dao;

import Interfaces.AcoesBD;
import Model.Cliente;
import Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements AcoesBD {

    @Override
    public void Cadastrar(Pessoa pessoa) throws SQLException {
        Cliente cli = (Cliente) pessoa;
        BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO endereco("
                + "ruaEndereco,"
                + "bairroEndereco,"
                + "cepEndereco,"
                + "cidadeEndereco,"
                + "nDaCasaEndereco)"
                + " VALUE (?,?,?,?,?)";

        PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, cli.getRua());
        statement.setString(2, cli.getBairro());
        statement.setString(3, cli.getCep());
        statement.setString(4, cli.getCidade());
        statement.setString(5, cli.getNumCasa());

        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (!resultSet.next()) {
            resultSet.close();
            statement.close();
            bd.fechaConexao();
            throw new SQLException("Houve uma falha ao inserir o endereço no Banco de Dados");

        } else {

            int idEndereco = resultSet.getInt(1);

            query = "INSERT INTO cliente ("
                    + "nomeCliente,"
                    + "cpfCliente,"
                    + "celularCliente,"
                    + "telefoneCliente,"
                    + "nascCliente,"
                    + "idClienteEndereco)"
                    + "VALUES (?,?,?,?,?,?)";

            statement = bd.getConnection().prepareStatement(query);
            statement.setString(1, cli.getNome());
            statement.setString(2, cli.getCpf());
            statement.setString(3, cli.getCelular());
            statement.setString(4, cli.getTelefone());
            statement.setString(5, cli.getNascimento());
            statement.setInt(6, idEndereco);
            int result = statement.executeUpdate();

            if (result != 1) {

                throw new SQLException("Ocorreu um erro ao incluir um Cliente ao banco de dados");

            } else {

            }
            statement.close();
            bd.fechaConexao();

        }
    }

    @Override
    public void Excluir(int id) throws SQLException {
        BDMySQL bd = new BDMySQL();

        String query = "";
        PreparedStatement statement;

        query = "DELETE FROM cliente,endereco USING endereco INNER JOIN cliente "
                + "WHERE endereco.idEndereco = cliente.idClienteEndereco AND cliente.idCliente = ?";

        statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);

        int result;

        result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 1) {
            throw new SQLException("este id de cliente não existe ou não pode ser excluida");
        }

    }

    @Override
    public void Alterar(int id, Pessoa pessoaA) throws SQLException {
        Pessoa pessoaALT = (Pessoa) pessoaA;
        BDMySQL bd = new BDMySQL();

        String query = "";
        PreparedStatement statement;

        query = "UPDATE cliente,endereco SET "
                + "cliente.nomeCliente = ?,"
                + "cliente.cpfCliente = ?,"
                + "cliente.celularCliente = ?,"
                + "cliente.telefoneCliente = ?,"
                + "cliente.nascCliente = ?,"
                + "endereco.ruaEndereco = ?,"
                + "endereco.bairroEndereco = ?,"
                + "endereco.cepEndereco = ?,"
                + "endereco.cidadeEndereco = ?,"
                + "endereco.nDaCasaEndereco = ? "
                + "WHERE cliente.idClienteEndereco = endereco.idEndereco AND cliente.idCliente = ?";
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

        if (result == 0) {
            //caso a att dê errado, lança uma exceção

            throw new SQLException("Houve uma falha ao atualizar as tabelas Cliente e Endereço no Banco de Dados");
        }

    }

    @Override
    public Cliente Pesquisar(int id) throws SQLException {
        BDMySQL bd = new BDMySQL();
        Cliente pessoaPESQ = new Cliente();
        String query = "SELECT * FROM cliente,endereco "
                + "WHERE cliente.idClienteEndereco = endereco.idEndereco "
                + "AND idCliente = ?";

        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {

            pessoaPESQ.setIdCliente(resultSet.getInt("idCliente"));
            pessoaPESQ.setNome(resultSet.getString("nomeCliente"));
            pessoaPESQ.setCpf(resultSet.getString("cpfCliente"));
            pessoaPESQ.setCelular(resultSet.getString("celularCliente"));
            pessoaPESQ.setTelefone(resultSet.getString("telefoneCliente"));
            pessoaPESQ.setNascimento(resultSet.getString("nascCliente"));
            pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
            pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
            pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
            pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
            pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
        }

        return pessoaPESQ;

    }

    @Override
    public ArrayList<Pessoa> Pesquisar(String nome) throws SQLException {
        BDMySQL bd = new BDMySQL();

        String query = "SELECT * FROM cliente,endereco "
                + "WHERE cliente.idClienteEndereco = endereco.idEndereco "
                + "AND nomeCliente LIKE ?";

        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setString(1, nome + "%");
        ResultSet resultSet = statement.executeQuery();

        ArrayList<Pessoa> listaPe = new ArrayList<>();

        while (resultSet.next()) {
            Cliente pessoaPESQ = new Cliente();

            pessoaPESQ.setIdCliente(resultSet.getInt("idCliente"));
            pessoaPESQ.setNome(resultSet.getString("nomeCliente"));
            pessoaPESQ.setCpf(resultSet.getString("cpfCliente"));
            pessoaPESQ.setCelular(resultSet.getString("celularCliente"));
            pessoaPESQ.setTelefone(resultSet.getString("telefoneCliente"));
            pessoaPESQ.setNascimento(resultSet.getString("nascCliente"));
            pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
            pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
            pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
            pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
            pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
            listaPe.add(pessoaPESQ);
        }
        if (listaPe.isEmpty()) {
            throw new SQLException("nenhum cliente encontrado");
        } else {
            return listaPe;
        }

    }

    @Override
    public ArrayList<Pessoa> Pesquisar(long celular, int opcao) throws SQLException {
        BDMySQL bd = new BDMySQL();
        Cliente pessoaPESQ = new Cliente();
        ArrayList<Pessoa> listaPe = new ArrayList<>();
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        if (opcao == 1) {
            String query = "SELECT * FROM cliente,endereco "
                    + "WHERE cliente.idClienteEndereco = endereco.idEndereco "
                    + "AND celularCliente = ?";

            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setLong(1, celular);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                pessoaPESQ.setIdCliente(resultSet.getInt("idCliente"));
                pessoaPESQ.setNome(resultSet.getString("nomeCliente"));
                pessoaPESQ.setCpf(resultSet.getString("cpfCliente"));
                pessoaPESQ.setCelular(resultSet.getString("celularCliente"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneCliente"));
                pessoaPESQ.setNascimento(resultSet.getString("nascCliente"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                listaPe.add(pessoaPESQ);
            }
            if (listaPe.isEmpty()) {
                throw new SQLException("Nenhum Cliente com esse numero de celular.");
            } else {
                listaPessoas = new ArrayList(listaPe);

            }

        } else if (opcao == 2) {
            String query = "SELECT * FROM cliente,endereco "
                    + "WHERE cliente.idClienteEndereco = endereco.idEndereco "
                    + "AND telefoneCliente = ?";

            PreparedStatement statement = bd.getConnection().prepareStatement(query);
            statement.setLong(1, celular);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                pessoaPESQ.setIdCliente(resultSet.getInt("idCliente"));
                pessoaPESQ.setNome(resultSet.getString("nomeCliente"));
                pessoaPESQ.setCpf(resultSet.getString("cpfCliente"));
                pessoaPESQ.setCelular(resultSet.getString("celularCliente"));
                pessoaPESQ.setTelefone(resultSet.getString("telefoneCliente"));
                pessoaPESQ.setNascimento(resultSet.getString("nascCliente"));
                pessoaPESQ.setRua(resultSet.getString("ruaEndereco"));
                pessoaPESQ.setBairro(resultSet.getString("bairroEndereco"));
                pessoaPESQ.setCep(resultSet.getString("cepEndereco"));
                pessoaPESQ.setCidade(resultSet.getString("cidadeEndereco"));
                pessoaPESQ.setNumCasa(resultSet.getString("nDaCasaEndereco"));
                listaPe.add(pessoaPESQ);
            }
            if (listaPe.isEmpty()) {
                throw new SQLException("Nenhum Cliente com esse numero de telefone");
            } else {
                listaPessoas = new ArrayList(listaPe);

            }

        }

        return listaPessoas;
    }

    @Override
    public ArrayList<Pessoa> Listar() throws SQLException {

        BDMySQL bd = new BDMySQL();
//      ArrayList<Cliente> listap = new ArrayList<Pessoa>();

        String query = "SELECT * FROM cliente,endereco "
                + "WHERE cliente.idClienteEndereco = endereco.idEndereco";

        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<Pessoa> listaPE = new ArrayList<>();

        while (resultSet.next()) {
//          Pessoa pessoa  = new Pessoa();
            Cliente cli = new Cliente();
            cli.setIdCliente(resultSet.getInt("idCliente"));
            cli.setNome(resultSet.getString("nomeCliente"));
            cli.setCpf(resultSet.getString("cpfCliente"));
            cli.setCelular(resultSet.getString("celularCliente"));
            cli.setTelefone(resultSet.getString("telefoneCliente"));
            cli.setNascimento(resultSet.getString("nascCliente"));
            cli.setRua(resultSet.getString("ruaEndereco"));
            cli.setBairro(resultSet.getString("bairroEndereco"));
            cli.setCep(resultSet.getString("cepEndereco"));
            cli.setCidade(resultSet.getString("cidadeEndereco"));
            cli.setNumCasa(resultSet.getString("nDaCasaEndereco"));

            listaPE.add(cli);
        }
        //Se a lista estiver vazia, lança uma exceção

        return listaPE;

    }

    public ResultSet relatClientePorTodos(int id, int idPedido) throws SQLException {
        BDMySQL bd = new BDMySQL();
        String query = "SELECT\n"
                + "     cliente.`nomeCliente` AS cliente_nomeCliente,\n"
                + "     endereco.`ruaEndereco` AS endereco_ruaEndereco,\n"
                + "     endereco.`bairroEndereco` AS endereco_bairroEndereco,\n"
                + "     endereco.`cepEndereco` AS endereco_cepEndereco,\n"
                + "     endereco.`cidadeEndereco` AS endereco_cidadeEndereco,\n"
                + "     endereco.`nDaCasaEndereco` AS endereco_nDaCasaEndereco,\n"
                + "     comanda.`obsProduto` AS comanda_obsProduto,\n"
                + "     pedido.`precoPedido` AS pedido_precoPedido,\n"
                + "     pedido.`statusPedido` AS pedido_statusPedido,\n"
                + "     pedido.`dataPedido` AS pedido_dataPedido,\n"
                + "     pedido.`horaPedido` AS pedido_horaPedido,\n"
                + "     cliente.`telefoneCliente` AS cliente_telefoneCliente,\n"
                + "     cliente.`celularCliente` AS cliente_celularCliente,\n"
                + "     pedido.`idPedido` AS pedido_idPedido,\n"
                + "     produto.`nomeProduto` AS produto_nomeProduto,\n"
                + "     produto.`precoProduto` AS produto_precoProduto\n"
                + "FROM\n"
                + "     `endereco` endereco INNER JOIN `cliente` cliente ON endereco.`idEndereco` = cliente.`idClienteEndereco`\n"
                + "     INNER JOIN `pedido` pedido ON cliente.`idCliente` = pedido.`idCliente`\n"
                + "     INNER JOIN `comanda` comanda ON pedido.`idPedido` = comanda.`idPedido`\n"
                + "     INNER JOIN `produto` produto ON comanda.`idProduto` = produto.`idProduto`"
                + "AND pedido.idPedido = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1,idPedido);
        ResultSet rs = statement.executeQuery();

        return rs;

    }

}
