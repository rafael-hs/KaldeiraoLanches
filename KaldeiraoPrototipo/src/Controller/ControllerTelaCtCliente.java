package Controller;

import Dao.ClienteDAO;
import Model.AcoesPrograma;
import Model.Cliente;
import Model.Pessoa;
import View.CadastroDeCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerTelaCtCliente implements ActionListener, MouseListener {

    public CadastroDeCliente cadastrodecliente;
    ArrayList<Pessoa> listadecliente;
    ArrayList<Pessoa> listadeid;
    int valor;

    public ControllerTelaCtCliente(CadastroDeCliente cadastrodecliente) {
        this.cadastrodecliente = cadastrodecliente;
        this.cadastrodecliente.getJbCadastrar().addActionListener(this);
        this.cadastrodecliente.getJbEditar().addActionListener(this);
        this.cadastrodecliente.getJbExcluir().addActionListener(this);
        this.cadastrodecliente.getJbLimpar().addActionListener(this);
        this.cadastrodecliente.getJbPesquisaCliente().addActionListener(this);

        this.cadastrodecliente.getRbNomeCliente().addActionListener(this);
        this.cadastrodecliente.getRbTelefoneCliente().addActionListener(this);
        this.cadastrodecliente.getRbCelularCliente().addActionListener(this);

        this.cadastrodecliente.getTabDadosCliente().addMouseListener(this);
        try {
            this.atualizaTabelaCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this.cadastrodecliente, ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrodecliente.getJbCadastrar()) {
            if (cadastrodecliente.getCtNomeCliente().getText().isEmpty() && cadastrodecliente.getCtCpfFormatadoCliente().getText().isEmpty() && cadastrodecliente.getCtCelularFormatadoCliente().getText().isEmpty() && cadastrodecliente.getCtTelefoneFormatadoCliente().getText().isEmpty() && cadastrodecliente.getCtNascimentoFormatadoCliente().getText().isEmpty() && cadastrodecliente.getCtRuaCliente().getText().isEmpty() && cadastrodecliente.getCtBairroCliente().getText().isEmpty() && cadastrodecliente.getCtCepFormatadoCliente().getText().isEmpty() && cadastrodecliente.getCtCidadeCliente().getText().isEmpty() && cadastrodecliente.getCtNumCasaCliente().getText().isEmpty()) {
                JOptionPane.showMessageDialog(cadastrodecliente, "Preencha os campos para fazer cadastro");
            } else {
                System.out.println("ENTROU NO CADASTRAR");
                try {

                    Cliente cl = new Cliente();

                    cl.setNome(cadastrodecliente.getCtNomeCliente().getText());

                    //---------------------------------------------------------------------------------------------//
                    if (cadastrodecliente.getCtCpfFormatadoCliente().getText().isEmpty()) {
                        cl.setCpf("");
                    } else {
                        cl.setCpf(cadastrodecliente.getCtCpfFormatadoCliente().getText());
                    }
                //---------------------------------------------------------------------------------------------//

                    //---------------------------------------------------------------------------------------------//
                    if (cadastrodecliente.getCtCelularFormatadoCliente().getText().isEmpty()) {
                        cl.setCelular("");
                    } else {
                        cl.setCelular(cadastrodecliente.getCtCelularFormatadoCliente().getText());
                    }
                //---------------------------------------------------------------------------------------------//

                    //---------------------------------------------------------------------------------------------//
                    if (cadastrodecliente.getCtTelefoneFormatadoCliente().getText().isEmpty()) {
                        throw new Exception("O numero de telefone não pode estar vazio");
                    } else {
                        cl.setTelefone(cadastrodecliente.getCtTelefoneFormatadoCliente().getText());
                    }
                    //---------------------------------------------------------------------------------------------//
                    
                    if (cadastrodecliente.getCtNascimentoFormatadoCliente().getText().isEmpty()) {
                        cl.setNascimento("");
                    } else {
                        cl.setNascimento(cadastrodecliente.getCtNascimentoFormatadoCliente().getText());
                    }
                    
                    cl.setRua(cadastrodecliente.getCtRuaCliente().getText());
                    cl.setBairro(cadastrodecliente.getCtBairroCliente().getText());
                    cl.setCep(cadastrodecliente.getCtCepFormatadoCliente().getText());
                    cl.setCidade(cadastrodecliente.getCtCidadeCliente().getText());
                    cl.setNumCasa(cadastrodecliente.getCtNumCasaCliente().getText());

                    
                    AcoesPrograma ap = new AcoesPrograma();
                    ap.cadastrarCliente(cl);
                    System.out.println("CADASTRADO");

                    JOptionPane.showMessageDialog(cadastrodecliente, "Cliente cadastrado com Sucesso");

                    cadastrodecliente.getCtNomeCliente().setText("");
                    cadastrodecliente.getCtCpfFormatadoCliente().setText("");
                    cadastrodecliente.getCtCelularFormatadoCliente().setText("");
                    cadastrodecliente.getCtTelefoneFormatadoCliente().setText("");
                    cadastrodecliente.getCtNascimentoFormatadoCliente().setText("");
                    cadastrodecliente.getCtRuaCliente().setText("");
                    cadastrodecliente.getCtBairroCliente().setText("");
                    cadastrodecliente.getCtCepFormatadoCliente().setText("");
                    cadastrodecliente.getCtCidadeCliente().setText("");
                    cadastrodecliente.getCtNumCasaCliente().setText("");

                    Atualizar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                }
            }
        } else if (e.getSource() == cadastrodecliente.getJbExcluir()) {
            AcoesPrograma ap = new AcoesPrograma();
            try {
                ap.excluirCliente(valor);
                Atualizar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
            }

        } else if (e.getSource() == cadastrodecliente.getJbEditar()) {
            AcoesPrograma ap = new AcoesPrograma();

            try {

                Cliente cl = new Cliente();
                cl.setNome(cadastrodecliente.getCtNomeCliente().getText());
                cl.setCpf(cadastrodecliente.getCtCpfFormatadoCliente().getText());
                cl.setCelular(cadastrodecliente.getCtCelularFormatadoCliente().getText());
                cl.setTelefone(cadastrodecliente.getCtTelefoneFormatadoCliente().getText());
                cl.setNascimento(cadastrodecliente.getCtNascimentoFormatadoCliente().getText());
                cl.setRua(cadastrodecliente.getCtRuaCliente().getText());
                cl.setBairro(cadastrodecliente.getCtBairroCliente().getText());
                cl.setCep(cadastrodecliente.getCtCepFormatadoCliente().getText());
                cl.setCidade(cadastrodecliente.getCtCidadeCliente().getText());
                cl.setNumCasa(cadastrodecliente.getCtNumCasaCliente().getText());

                ap.editarCliente(valor, cl);
                Atualizar();

                cadastrodecliente.getCtNomeCliente().setText("");
                cadastrodecliente.getCtCpfFormatadoCliente().setText("");
                cadastrodecliente.getCtCelularFormatadoCliente().setText("");
                cadastrodecliente.getCtTelefoneFormatadoCliente().setText("");
                cadastrodecliente.getCtNascimentoFormatadoCliente().setText("");
                cadastrodecliente.getCtRuaCliente().setText("");
                cadastrodecliente.getCtBairroCliente().setText("");
                cadastrodecliente.getCtCepFormatadoCliente().setText("");
                cadastrodecliente.getCtCidadeCliente().setText("");
                cadastrodecliente.getCtNumCasaCliente().setText("");
                cadastrodecliente.getCtPesquisaCliente().setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
            }
        } else if (e.getSource() == cadastrodecliente.getJbLimpar()) {

            cadastrodecliente.getCtNomeCliente().setText("");
            cadastrodecliente.getCtCpfFormatadoCliente().setText("");
            cadastrodecliente.getCtCelularFormatadoCliente().setText("");
            cadastrodecliente.getCtTelefoneFormatadoCliente().setText("");
            cadastrodecliente.getCtNascimentoFormatadoCliente().setText("");
            cadastrodecliente.getCtRuaCliente().setText("");
            cadastrodecliente.getCtBairroCliente().setText("");
            cadastrodecliente.getCtCepFormatadoCliente().setText("");
            cadastrodecliente.getCtCidadeCliente().setText("");
            cadastrodecliente.getCtNumCasaCliente().setText("");
            cadastrodecliente.getCtPesquisaCliente().setText("");

            JOptionPane.showMessageDialog(cadastrodecliente, "Campo limpo com sucesso\n"
                    + "tabela atulizada");

            cadastrodecliente.getGrupoRB().clearSelection();
            Atualizar();

            /*------------*/        } else if (e.getSource() == cadastrodecliente.getJbPesquisaCliente()) {

            /*------------*/            if (cadastrodecliente.getRbNomeCliente().isSelected()) {
                if (cadastrodecliente.getCtPesquisaCliente().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodecliente, "Digite um nome para pesquisar");
                } else {
                    try {
                        AcoesPrograma ap = new AcoesPrograma();
                        System.out.println("ENTROU2");
                        String nomep = cadastrodecliente.getCtPesquisaCliente().getText();
                        try {
                            listadeid = ap.pesquisarCliente(nomep);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) cadastrodecliente.getTabDadosCliente().getModel();
                        tableModel.setNumRows(0);
                        for (Pessoa listadeclienteAtt : listadeid) {
                            Cliente cliente = (Cliente) listadeclienteAtt;
                            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                                cliente.getTelefone(), cliente.getNascimento()};
                            tableModel.addRow(linha);
                        }

                        cadastrodecliente.getTabDadosCliente().setSize(listadeid.size(), 0);
                        cadastrodecliente.getTabDadosCliente().setModel(tableModel);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                    }
                }

                /*------------*/            } else if (cadastrodecliente.getRbTelefoneCliente().isSelected()) {
                if (cadastrodecliente.getCtPesquisaCliente().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodecliente, "Digite um telefone para pesquisar");
                } else {
                    ArrayList<Pessoa> rbtel = new ArrayList<>();
                    int rbresultado = 2;
                    try {
                        AcoesPrograma ap = new AcoesPrograma();

                        System.out.println("ENTROUtelefone");
                        int telefone = Integer.parseInt(cadastrodecliente.getCtPesquisaCliente().getText());
                        try {
                            rbtel = ap.pesquisarCliente(telefone, rbresultado);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) cadastrodecliente.getTabDadosCliente().getModel();
                        tableModel.setNumRows(0);
                        for (Pessoa listadeclienteAtt : rbtel) {
                            Cliente cliente = (Cliente) listadeclienteAtt;
                            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                                cliente.getTelefone(), cliente.getNascimento()};
                            tableModel.addRow(linha);
                        }

                        cadastrodecliente.getTabDadosCliente().setSize(rbtel.size(), 0);
                        cadastrodecliente.getTabDadosCliente().setModel(tableModel);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                    }

                }

                /*------------*/            } else if (cadastrodecliente.getRbCelularCliente().isSelected()) {
                if (cadastrodecliente.getCtPesquisaCliente().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodecliente, "Digite um celular para pesquisar");
                } else {
                    ArrayList<Pessoa> rbcel = new ArrayList<>();
                    int rbresultado = 1;
                    try {
                        AcoesPrograma ap = new AcoesPrograma();

//            if(e.getSource() == cadastrodecliente.getRbNomeCliente()){
                        System.out.println("ENTROU2");
                        int celular = Integer.parseInt(cadastrodecliente.getCtPesquisaCliente().getText());
                        try {
                            rbcel = ap.pesquisarCliente(celular, rbresultado);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                        }

                        DefaultTableModel tableModel = (DefaultTableModel) cadastrodecliente.getTabDadosCliente().getModel();
                        tableModel.setNumRows(0);
                        for (Pessoa listadeclienteAtt : rbcel) {
                            Cliente cliente = (Cliente) listadeclienteAtt;
                            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                                cliente.getTelefone(), cliente.getNascimento()};
                            tableModel.addRow(linha);
                        }

                        cadastrodecliente.getTabDadosCliente().setSize(rbcel.size(), 0);
                        cadastrodecliente.getTabDadosCliente().setModel(tableModel);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
                    }

                }
            }

        }

    }

    public void atualizaTabelaCliente() throws Exception {
        try {
            AcoesPrograma ap = new AcoesPrograma();
            listadecliente = ap.ListarCliente();

            DefaultTableModel tableModel = (DefaultTableModel) cadastrodecliente.getTabDadosCliente().getModel();
            tableModel.setNumRows(0);
            for (Pessoa listadeclienteAtt : listadecliente) {
                Cliente cliente = (Cliente) listadeclienteAtt;
                Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                    cliente.getTelefone(), cliente.getNascimento()};
                tableModel.addRow(linha);
            }

            cadastrodecliente.getTabDadosCliente().setSize(listadecliente.size(), 0);
            cadastrodecliente.getTabDadosCliente().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
        }
    }

    public void Atualizar() {

        AcoesPrograma ap = new AcoesPrograma();
        try {
            listadecliente = ap.ListarCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
        }

        DefaultTableModel tableModel = (DefaultTableModel) cadastrodecliente.getTabDadosCliente().getModel();
        tableModel.setNumRows(0);
        for (Pessoa listadeclienteAtt : listadecliente) {
            Cliente cliente = (Cliente) listadeclienteAtt;
            Object[] linha = {cliente.getIdCliente(), cliente.getNome(), cliente.getCpf(), cliente.getCelular(),
                cliente.getTelefone(), cliente.getNascimento()};
            tableModel.addRow(linha);
        }

        cadastrodecliente.getTabDadosCliente().setSize(listadecliente.size(), 0);
        cadastrodecliente.getTabDadosCliente().setModel(tableModel);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int linha = cadastrodecliente.getTabDadosCliente().getSelectedRow();
        valor = (int) cadastrodecliente.getTabDadosCliente().getValueAt(linha, 0);
        System.out.println(valor);
        Cliente cl = new Cliente();
        ClienteDAO cdao = new ClienteDAO();

        try {
            cl = cdao.Pesquisar(valor);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(cadastrodecliente, ex.getMessage());
        }

        cadastrodecliente.getCtNomeCliente().setText(cl.getNome());
        cadastrodecliente.getCtCpfFormatadoCliente().setText(cl.getCpf());
        cadastrodecliente.getCtCelularFormatadoCliente().setText(cl.getCelular() + "");
        cadastrodecliente.getCtTelefoneFormatadoCliente().setText(cl.getTelefone() + "");
        cadastrodecliente.getCtNascimentoFormatadoCliente().setText(cl.getNascimento());
        cadastrodecliente.getCtRuaCliente().setText(cl.getRua());
        cadastrodecliente.getCtBairroCliente().setText(cl.getBairro());
        cadastrodecliente.getCtCepFormatadoCliente().setText(cl.getCep());
        cadastrodecliente.getCtCidadeCliente().setText(cl.getCidade());
        cadastrodecliente.getCtNumCasaCliente().setText(cl.getNumCasa());
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

}
