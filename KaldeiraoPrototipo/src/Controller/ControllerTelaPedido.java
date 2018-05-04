/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClienteDAO;
import Dao.FuncionarioDAO;
import Dao.PedidoDAO;
import Model.AcoesPrograma;
import Model.Cliente;
import Model.Comanda;
import Model.Funcionario;
import Model.Produto;
import View.Buscar;
import View.Pedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sala306b
 */
class ControllerTelaPedido implements ActionListener, MouseListener {
    
    ArrayList<Produto> listapd = new ArrayList<>();
    
    Cliente cli;
    Funcionario fun;
    Buscar buscar;
    Pedido telaPedido;
    Model.Pedido pedido;
    double total = 0;
    
    public ControllerTelaPedido(Pedido telaPedido, int idPedido, Buscar buscar) {
        
        telaPedido.getJbFinalizaPedido().setText("Alterar Pedido");
        
        PedidoDAO pedDao = new PedidoDAO();
        try {
            pedido = pedDao.Pesquisar(idPedido);
            telaPedido.getCbStatusPedido().setSelectedItem(pedido.getStatus());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
            ex.printStackTrace();
        }
        
        ClienteDAO cliDao = new ClienteDAO();
        
        try {
            cli = cliDao.Pesquisar(pedido.getIdcliente());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
            ex.printStackTrace();
        }
        
        FuncionarioDAO funDao = new FuncionarioDAO();
        
        try {
            fun = funDao.Pesquisar(pedido.getIdfuncionario());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
            ex.printStackTrace();
        }
        
        try {
            ArrayList<Comanda> comanda = pedDao.PesquisarComanda(idPedido);
            DefaultTableModel tableModel = (DefaultTableModel) telaPedido.getTabPedidosCliente().getModel();
            tableModel.setNumRows(0);
            
            for (Comanda c : comanda) {
                Object[] linha = {c.getNumLanche(), c.getNomeLanche(), c.getObs(), c.getPrecoLanche()};
                tableModel.addRow(linha);
                total = total + c.getPrecoLanche();
                telaPedido.getCtTotalPedidos().setText(NumberFormat.getCurrencyInstance().format(total) + "");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
            ex.printStackTrace();
        }
        
        this.telaPedido = telaPedido;
        this.telaPedido.getCtNomeCliente().setText(cli.getNome());
        this.telaPedido.getCtNomeFuncionario().setText(fun.getNome());
        this.telaPedido.getTabMenuLanches().addMouseListener(this);
        this.telaPedido.getTabPedidosCliente().addMouseListener(this);
        this.telaPedido.getJbAdcionaPedido().addActionListener(this);
        this.telaPedido.getJbFinalizaPedido().addActionListener(this);
        this.telaPedido.getJbRetiraPedido().addActionListener(this);
        this.telaPedido.getCbStatusPedido().addActionListener(this);
        this.telaPedido.getCtTotalPedidos().addActionListener(this);
        this.telaPedido.getCtNomeCliente().addActionListener(this);
        this.telaPedido.getCtNomeFuncionario().addActionListener(this);
        this.telaPedido.addMouseListener(this);
        try {
            Atualizar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
            ex.printStackTrace();
        }
        
    }
    
    public ControllerTelaPedido(Pedido telaPedido, Cliente cli, Funcionario fun, Buscar buscar) throws Exception {
        this.cli = cli;
        this.fun = fun;
        this.buscar = buscar;
        this.telaPedido = telaPedido;
        this.telaPedido.getCtNomeCliente().setText(cli.getNome());
        this.telaPedido.getCtNomeFuncionario().setText(fun.getNome());
        this.telaPedido.getTabMenuLanches().addMouseListener(this);
        this.telaPedido.getTabPedidosCliente().addMouseListener(this);
        this.telaPedido.getJbAdcionaPedido().addActionListener(this);
        this.telaPedido.getJbFinalizaPedido().addActionListener(this);
        this.telaPedido.getJbRetiraPedido().addActionListener(this);
        this.telaPedido.getCbStatusPedido().addActionListener(this);
        this.telaPedido.getCtTotalPedidos().addActionListener(this);
        this.telaPedido.getCtNomeCliente().addActionListener(this);
        this.telaPedido.getCtNomeFuncionario().addActionListener(this);
        this.telaPedido.addMouseListener(this);
        Atualizar();
        
    }
    
    public void atualizaTabelaProduto() throws Exception {
        try {
            AcoesPrograma ap = new AcoesPrograma();
            listapd = ap.ListarPD();
            
            DefaultTableModel tableModel = (DefaultTableModel) telaPedido.getTabMenuLanches().getModel();
            tableModel.setNumRows(0);
            for (Produto listadeprodutoAtt : listapd) {
                
                Object[] linha = {listadeprodutoAtt.getNumero(), listadeprodutoAtt.getNome(), listadeprodutoAtt.getDescricao(), listadeprodutoAtt.getPreco()};
                tableModel.addRow(linha);
            }
            
            telaPedido.getTabMenuLanches().setSize(listapd.size(), 0);
            telaPedido.getTabMenuLanches().setModel(tableModel);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
        }
    }
    
    public void Atualizar() throws Exception {
        
        AcoesPrograma ap = new AcoesPrograma();
        listapd = ap.ListarPD();
        
        DefaultTableModel tableModel = (DefaultTableModel) telaPedido.getTabMenuLanches().getModel();
        tableModel.setNumRows(0);
        for (Produto listadeprodutoAtt : listapd) {
            
            Object[] linha = {listadeprodutoAtt.getNumero(), listadeprodutoAtt.getNome(), listadeprodutoAtt.getDescricao(), listadeprodutoAtt.getPreco()};
            tableModel.addRow(linha);
        }
        
        telaPedido.getTabMenuLanches().setSize(listapd.size(), 0);
        telaPedido.getTabMenuLanches().setModel(tableModel);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPedido.getJbAdcionaPedido()) {
            
            if (telaPedido.getTabMenuLanches().getSelectedRowCount() > 0) {
                int[] linhaselec = telaPedido.getTabMenuLanches().getSelectedRows();
                System.out.println("Linhas selecionadas");
                for (int m : linhaselec) {
                    System.out.println(m);
                }
                DefaultTableModel tablemodel = (DefaultTableModel) telaPedido.getTabPedidosCliente().getModel();
                
                for (int i = 0; i < linhaselec.length; i++) {
                    Object[] linha = {
                        telaPedido.getTabMenuLanches().getValueAt(linhaselec[i], 0),
                        telaPedido.getTabMenuLanches().getValueAt(linhaselec[i], 1),
                        telaPedido.getTabMenuLanches().getValueAt(linhaselec[i], 2),
                        telaPedido.getTabMenuLanches().getValueAt(linhaselec[i], 3)
                    
                    };
                    tablemodel.addRow(linha);
                    
                    total = total + (double) telaPedido.getTabMenuLanches().getValueAt(linhaselec[i], 3);
                    telaPedido.getCtTotalPedidos().setText(NumberFormat.getCurrencyInstance().format(total) + "");
                    System.out.println(total);
                }
                
            }
        } else if (e.getSource() == telaPedido.getJbFinalizaPedido()) {
            
            if (telaPedido.getJbFinalizaPedido().getText().equals("Alterar Pedido")) {
                System.out.println("Entrou alterar pedido");
                PedidoDAO pdao = new PedidoDAO();
                
                pedido.setPreco(total);
                pedido.setData(Calendar.getInstance().getTime());
                pedido.setHora(Calendar.getInstance().getTime());
                pedido.setStatus(telaPedido.getCbStatusPedido().getSelectedItem() + "");
                
                ArrayList<Comanda> comanda = new ArrayList<>();
                
                for (int i = 0; i < telaPedido.getTabPedidosCliente().getRowCount(); i++) {
                    Comanda c = new Comanda();
                    int numeroLanche = (int) telaPedido.getTabPedidosCliente().getValueAt(i, 0);
                    int idProduto = 0;
                    for (Produto p : listapd) {
                        if (p.getNumero() == numeroLanche) {
                            idProduto = p.getIdproduto();
                        }
                    }
                    c.setIdProduto(idProduto);
                    String obs = (String) telaPedido.getTabPedidosCliente().getValueAt(i, 2);
                    c.setObs(obs);
                    comanda.add(c);
                }
                try {
                    pdao.Alterar(pedido, comanda);
                    JOptionPane.showMessageDialog(telaPedido, "Pedido alterado com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
                }
            } else {
                
                System.out.println("Entrou finalizarpedido");
                PedidoDAO pdao = new PedidoDAO();
                Model.Pedido pedido = new Model.Pedido();
                
                pedido.setDescricao(null);
                pedido.setPreco(total);
                pedido.setIdcliente(cli.getIdCliente());
                pedido.setIdfuncionario(fun.getIdFuncionario());
                pedido.setData(Calendar.getInstance().getTime());
                pedido.setHora(Calendar.getInstance().getTime());
                pedido.setStatus(telaPedido.getCbStatusPedido().getSelectedItem() + "");
                System.out.println(pedido.getIdcliente());
                
                ArrayList<Comanda> comanda = new ArrayList<>();
                
                for (int i = 0; i < telaPedido.getTabPedidosCliente().getRowCount(); i++) {
                    Comanda comandaAlt = new Comanda();
                    int numeroLanche = (int) telaPedido.getTabPedidosCliente().getValueAt(i, 0);
                    int idProduto = 0;
                    for (Produto p : listapd) {
                        if (p.getNumero() == numeroLanche) {
                            idProduto = p.getIdproduto();
                        }
                    }
                    comandaAlt.setIdProduto(idProduto);
                    String obs = (String) telaPedido.getTabPedidosCliente().getValueAt(i, 2);
                    comandaAlt.setObs(obs);
                    comanda.add(comandaAlt);
                }
                
                try {
                    pdao.Cadastrar(pedido, comanda);
                    JOptionPane.showMessageDialog(telaPedido, "Pedido Cadastrado com sucesso");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(telaPedido, ex.getMessage());
                }
            }
        } else if (e.getSource() == telaPedido.getJbRetiraPedido()) {
            if (telaPedido.getTabPedidosCliente().getSelectedRowCount() > 0) {
                int[] linhaselec = telaPedido.getTabPedidosCliente().getSelectedRows();
                System.out.println("Linhas selecionadas " + linhaselec.length);
                for (int m : linhaselec) {
                    System.out.println(m);
                }
                DefaultTableModel tablemodel = (DefaultTableModel) telaPedido.getTabPedidosCliente().getModel();
                
                for (int i = linhaselec.length - 1; i >= 0; i--) {
                    System.out.println("removendo linha " + linhaselec[i]);
                    
                    total = total - (double) telaPedido.getTabPedidosCliente().getValueAt(linhaselec[i], 3);
                    telaPedido.getCtTotalPedidos().setText(NumberFormat.getCurrencyInstance().format(total) + "");
                    System.out.println(total);
                    
                    tablemodel.removeRow(linhaselec[i]);
                }
                
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == telaPedido) {
            try {
                atualizaTabelaProduto();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(buscar, ex.getMessage());
            }
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
    
}
