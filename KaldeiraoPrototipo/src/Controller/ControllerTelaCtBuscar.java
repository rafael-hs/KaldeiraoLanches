package Controller;

import Dao.ClienteDAO;
import Dao.FuncionarioDAO;
import Dao.PedidoDAO;
import Model.AcoesPrograma;
import Model.Cliente;
import Model.Comanda;
import Model.Funcionario;
import Model.Pedido;
import Model.Pessoa;
import View.Buscar;
import View.TelaDeApresentacao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ControllerTelaCtBuscar implements ActionListener, MouseListener {

    Cliente cli = new Cliente();
    Funcionario fun = new Funcionario();
    public Buscar buscar;
    ArrayList<Pessoa> listadepessoas;
    ArrayList<Pessoa> listadefun;
    ArrayList<Pedido> listaped;
    int valor;
    int valor2;
    int valor3;

    public ControllerTelaCtBuscar(Buscar buscar) throws Exception {
        this.buscar = buscar;
        this.buscar.getJbFazerPedido().addActionListener(this);
        this.buscar.getJbExcluirPedido().addActionListener(this);
        this.buscar.getJbEditarPedido().addActionListener(this);
        this.buscar.getTabDadosClienteBuscar().addMouseListener(this);
        this.buscar.getTabDadosFuncionarioBuscar().addMouseListener(this);
        this.buscar.getTabPedidosBuscar().addMouseListener(this);
        this.buscar.getJbPesquisaCliente().addActionListener(this);
        this.buscar.getRbNomeCliente().addActionListener(this);
        this.buscar.getRbTelefoneCliente().addActionListener(this);
        this.buscar.getJbLimpar().addActionListener(this);
        this.buscar.getPtDetalhesPedidoEndereco().addMouseListener(this);
        this.buscar.getJbGerarRelatorio().addActionListener(this);
        this.atualizaTabela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscar.getJbFazerPedido()) {
            if (buscar.getTabDadosClienteBuscar().getSelectedRowCount() == 1 && buscar.getTabDadosFuncionarioBuscar().getSelectedRowCount() == 1) {
                buscar.sair();
                View.Pedido telaPedido = new View.Pedido();
                new Thread(telaPedido).start();
                try {
                    new ControllerTelaPedido(telaPedido, cli, fun, buscar);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(buscar, "Selecione um funcionário e um cliente para fazer o pedido");
            }

//          
        } else if (e.getSource() == buscar.getJbPesquisaCliente()) {
            if (buscar.getCtPesquisaCliente().getText().isEmpty()) {
                JOptionPane.showMessageDialog(buscar, "Digite uma algo para pesquisar e selecione uma opção e digite ");
            } else {
                /*------------*/
                if (buscar.getRbNomeCliente().isSelected()) {

                    try {
                        AcoesPrograma ap = new AcoesPrograma();
                        System.out.println("ENTROU2");
                        String nomep = buscar.getCtPesquisaCliente().getText();
                        try {
                            listadepessoas = ap.pesquisarCliente(nomep);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(buscar, ex.getMessage());
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabDadosClienteBuscar().getModel();
                        tableModel.setNumRows(0);
                        for (Pessoa listadeclienteAtt : listadepessoas) {
                            Cliente cliente = (Cliente) listadeclienteAtt;
                            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCelular(),
                                cliente.getTelefone(), cliente.getNascimento()};
                            tableModel.addRow(linha);
                        }

                        buscar.getTabDadosClienteBuscar().setSize(listadepessoas.size(), 0);
                        buscar.getTabDadosClienteBuscar().setModel(tableModel);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(buscar, ex.getMessage());
                    }

     /*------------*/                } else if (buscar.getRbTelefoneCliente().isSelected()) {
                    if (buscar.getCtPesquisaCliente().getText().equals("")) {
                        JOptionPane.showMessageDialog(buscar, "Digite um telefone para pesquisar");
                    } else {
                        ArrayList<Pessoa> rbtel = new ArrayList<>();

                        try {
                            AcoesPrograma ap = new AcoesPrograma();
                            System.out.println("ENTROUtelefone");
                            int telefone = Integer.parseInt(buscar.getCtPesquisaCliente().getText());
                            try {
                                rbtel = ap.pesquisarCliente(telefone, 2);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(buscar, ex.getMessage());
                            }

                            DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabDadosClienteBuscar().getModel();
                            tableModel.setNumRows(0);
                            for (Pessoa listadeclienteAtt : rbtel) {
                                Cliente cliente = (Cliente) listadeclienteAtt;
                                Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCelular(),
                                    cliente.getTelefone(), cliente.getNascimento()};
                                tableModel.addRow(linha);
                            }

                            buscar.getTabDadosClienteBuscar().setSize(rbtel.size(), 0);
                            buscar.getTabDadosClienteBuscar().setModel(tableModel);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(buscar, ex.getMessage());
                        }
                    }
                }
            }
        } else if (e.getSource() == buscar.getJbEditarPedido()) {
            if (buscar.getTabPedidosBuscar().getSelectedRowCount() == 1) {
                int linha = buscar.getTabPedidosBuscar().getSelectedRow();
                int idPedido = Integer.parseInt(buscar.getTabPedidosBuscar().getValueAt(linha, 0)+ "");
                buscar.sair();
                View.Pedido telaPedido = new View.Pedido();
                new Thread(telaPedido).start();
                try {
                    new ControllerTelaPedido(telaPedido, idPedido , buscar);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
                }

        } 

    
    }
        else if (e.getSource() == buscar.getJbExcluirPedido()) {
            PedidoDAO pdao = new PedidoDAO();
            try {
                pdao.Excluir(valor3);
                atualizaTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }

        } 
        else if (e.getSource() == buscar.getJbLimpar()) {
                System.out.println("entrou limpar");
            buscar.getGrupoRB().clearSelection();
            buscar.getPtDetalhesPedidoEndereco().setText("");
            buscar.getCtPesquisaCliente().setText("");
            try {
                atualizaTabela();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }
        }else if(e.getSource() == buscar.getJbGerarRelatorio()){
            if(buscar.getTabDadosClienteBuscar().getSelectedRowCount() == 1 && buscar.getTabPedidosBuscar().getSelectedRowCount() == 1){
                try{
                JasperReport report = JasperCompileManager.compileReport("pedido.jrxml");

                ClienteDAO cdao = new ClienteDAO();
                JRResultSetDataSource resultado = new JRResultSetDataSource(cdao.relatClientePorTodos(valor,valor3));
                JasperPrint print = JasperFillManager.fillReport(report, null, resultado);

                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        /*-------------*/
        if (e.getSource() == buscar.getTabDadosClienteBuscar()) {
            int linha = buscar.getTabDadosClienteBuscar().getSelectedRow();
            valor = (int) buscar.getTabDadosClienteBuscar().getValueAt(linha, 0);
            System.out.println(valor);

            ClienteDAO cdao = new ClienteDAO();
            try {
                cli = cdao.Pesquisar(valor);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }

            String endereco = "Rua: " + cli.getRua() + "\n"
                    + "Numero: " + cli.getNumCasa() + "\n"
                    + "Bairro: " + cli.getBairro() + "\n"
                    + "Cidade: " + cli.getCidade() + "\n"
                    + "Cep:    " + cli.getCep();

            buscar.getPtDetalhesPedidoEndereco().setText(endereco);
            PedidoDAO Pdao = new PedidoDAO();
            ArrayList<Pedido> pedido = new ArrayList<>();

            try {
                pedido = Pdao.PesquisarIdCliente(valor);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }
            DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabPedidosBuscar().getModel();
            tableModel.setNumRows(0);
            for (Pedido listap : pedido) {
                Object[] linhatab = {listap.getIdPedido(), listap.getData(), listap.getStatus(), listap.getPreco()};
                tableModel.addRow(linhatab);

            }

            buscar.getTabPedidosBuscar().setSize(pedido.size(), 0);
            buscar.getTabPedidosBuscar().setModel(tableModel);

        } /*-------------*/ else if (e.getSource() == buscar.getTabDadosFuncionarioBuscar()) {

            int linha2 = buscar.getTabDadosFuncionarioBuscar().getSelectedRow();
            valor2 = (int) buscar.getTabDadosFuncionarioBuscar().getValueAt(linha2, 0);
            System.out.println(valor2 + "val2");

            FuncionarioDAO fdao = new FuncionarioDAO();

            try {
                fun = fdao.Pesquisar(valor2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }
        } /*-------------*/ else if (e.getSource() == buscar.getTabPedidosBuscar()) {
            Comanda comanda = new Comanda();
             ArrayList<Comanda> comandalista = new ArrayList<>();
            int linha3 = buscar.getTabPedidosBuscar().getSelectedRow();
            valor3 = (int) buscar.getTabPedidosBuscar().getValueAt(linha3, 0);
            System.out.println(valor3 + "Valor variavel tabped");

            PedidoDAO pdao = new PedidoDAO();
            
            try {
                System.out.println("COMANDA");
                comandalista = pdao.PesquisarComanda(valor3);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }
             DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabBuscarComanda().getModel();
            tableModel.setNumRows(0);
            for (Comanda listac : comandalista) {
                Object[] linhatab = {listac.getNomeLanche(), listac.getObs()};
                tableModel.addRow(linhatab);

            }

            buscar.getTabBuscarComanda().setSize(comandalista.size(), 0);
            buscar.getTabBuscarComanda().setModel(tableModel);
        }
      

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void atualizaTabela() throws Exception {
        AcoesPrograma ap = new AcoesPrograma();
        try {

            listadepessoas = ap.ListarCliente();

            DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabDadosClienteBuscar().getModel();
            tableModel.setNumRows(0);
            for (Pessoa listadecliente : listadepessoas) {
                Cliente cliente = (Cliente) listadecliente;
                Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCelular(),
                    cliente.getTelefone(), cliente.getNascimento()};
                tableModel.addRow(linha);
            }

            buscar.getTabDadosClienteBuscar().setSize(listadepessoas.size(), 0);
            buscar.getTabDadosClienteBuscar().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(buscar, ex.getMessage());
        }
        //_______________________________________________________________________________________//

        listadefun = ap.ListarFuncionario();

        DefaultTableModel tableModel2 = (DefaultTableModel) buscar.getTabDadosFuncionarioBuscar().getModel();
        tableModel2.setNumRows(0);
        for (Pessoa listadefuncionario : listadefun) {
            Funcionario funcionario = (Funcionario) listadefuncionario;
            Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(), funcionario.getCelular(),
                funcionario.getTelefone(), funcionario.getNascimento()};
            tableModel2.addRow(linha);
        }

        buscar.getTabDadosFuncionarioBuscar().setSize(listadefun.size(), 0);
        buscar.getTabDadosFuncionarioBuscar().setModel(tableModel2);

                    //_______________________________________________________________________________________//
        PedidoDAO pdDao = new PedidoDAO();

        listaped = pdDao.listar();

        DefaultTableModel tableModel3 = (DefaultTableModel) buscar.getTabPedidosBuscar().getModel();
        tableModel3.setNumRows(0);
        for (Pedido listadePD : listaped) {
            Pedido pedido = (Pedido) listadePD;
            Object[] linha = {pedido.getIdPedido(), pedido.getData(), pedido.getStatus(), pedido.getPreco()};
            tableModel3.addRow(linha);
        }

        buscar.getTabPedidosBuscar().setSize(listaped.size(), 0);
        buscar.getTabPedidosBuscar().setModel(tableModel3);
        
        DefaultTableModel tableModel4 = (DefaultTableModel) buscar.getTabBuscarComanda().getModel();
        tableModel4.setNumRows(0);

    }

    public void Atualizar() throws Exception {

        AcoesPrograma ap = new AcoesPrograma();

        listadepessoas = ap.ListarCliente();

        DefaultTableModel tableModel = (DefaultTableModel) buscar.getTabDadosClienteBuscar().getModel();
        tableModel.setNumRows(0);
        for (Pessoa listadecliente : listadepessoas) {
            Cliente cliente = (Cliente) listadecliente;
            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                cliente.getTelefone(), cliente.getNascimento()};
            tableModel.addRow(linha);
        }

        buscar.getTabDadosClienteBuscar().setSize(listadepessoas.size(), 0);
        buscar.getTabDadosClienteBuscar().setModel(tableModel);

                    //_______________________________________________________________________________________//
        listadefun = ap.ListarFuncionario();

        DefaultTableModel tableModel3 = (DefaultTableModel) buscar.getTabDadosFuncionarioBuscar().getModel();
        tableModel3.setNumRows(0);
        for (Pessoa listadefuncionario : listadefun) {
            Funcionario funcionario = (Funcionario) listadefuncionario;
            Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(), funcionario.getCpf(), funcionario.getCelular(),
                funcionario.getTelefone(), funcionario.getNascimento()};
            tableModel.addRow(linha);
        }

        buscar.getTabDadosFuncionarioBuscar().setSize(listadefun.size(), 0);
        buscar.getTabDadosFuncionarioBuscar().setModel(tableModel3);

                    //_______________________________________________________________________________________//
        PedidoDAO pdDao = new PedidoDAO();

        listaped = pdDao.listar();

        DefaultTableModel tableModel4 = (DefaultTableModel) buscar.getTabPedidosBuscar().getModel();
        tableModel4.setNumRows(0);
        for (Pedido listadePD : listaped) {
            Pedido pedido = (Pedido) listadePD;
            Object[] linha = {pedido.getIdPedido(), pedido.getData(), pedido.getStatus(), pedido.getPreco()};
            tableModel4.addRow(linha);
        }

        buscar.getTabPedidosBuscar().setSize(listaped.size(), 0);
        buscar.getTabPedidosBuscar().setModel(tableModel4);

    }
}
