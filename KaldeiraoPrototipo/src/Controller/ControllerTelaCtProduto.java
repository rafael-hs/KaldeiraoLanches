package Controller;

import Dao.ProdutoDAO;
import Model.AcoesPrograma;
import Model.Produto;
import View.CadastroDeProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerTelaCtProduto implements ActionListener, MouseListener {
    public CadastroDeProduto cadastrodeproduto;
    ArrayList<Produto> listadeprodutos;
    int valor;
    
    
    public ControllerTelaCtProduto(CadastroDeProduto cadastrodeproduto){
        this.cadastrodeproduto = cadastrodeproduto;
        this.cadastrodeproduto.getJbAdcionar().addActionListener(this);
        this.cadastrodeproduto.getJbEditar().addActionListener(this);
        this.cadastrodeproduto.getJbExcluir().addActionListener(this);
        this.cadastrodeproduto.getJbLimpar().addActionListener(this);
        this.cadastrodeproduto.getJbPesquisaLanche().addActionListener(this);
        
        this.cadastrodeproduto.getRbNomeLanche().addActionListener(this);
        this.cadastrodeproduto.getRbNumLanche().addActionListener(this);
        
        
        this.cadastrodeproduto.getTabProdutos().addMouseListener(this);
        try{
        this.atualizaTabelaProduto();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.cadastrodeproduto, ex.getMessage());
        }
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
/*--------------*/if(e.getSource() == cadastrodeproduto.getJbAdcionar()){
         System.out.println("ENTROU NO CADASTRAR");
         
         Produto p = new Produto();
         
         p.setNumero(Integer.parseInt(cadastrodeproduto.getCtNumLanche().getText()));
         p.setNome(cadastrodeproduto.getCtNomeLanche().getText());
         p.setDescricao(cadastrodeproduto.getCtDescricaoLanche().getText());
         p.setPreco(Double.parseDouble(cadastrodeproduto.getCtPrecoLanche().getText()));
         
         AcoesPrograma ap = new AcoesPrograma();
         try {
             ap.CadastrarPD(p);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
         }
           System.out.println("CADASTRou");
           JOptionPane.showMessageDialog(cadastrodeproduto,"Produto adicionado com sucesso");
         
           cadastrodeproduto.getCtNumLanche().setText("");
           cadastrodeproduto.getCtNomeLanche().setText("");
           cadastrodeproduto.getCtDescricaoLanche().setText("");
           cadastrodeproduto.getCtPrecoLanche().setText("");
           
           Atualizar();
     }
/*-----------*/else if(e.getSource() == cadastrodeproduto.getJbLimpar()){
           cadastrodeproduto.getCtNumLanche().setText("");
           cadastrodeproduto.getCtNomeLanche().setText("");
           cadastrodeproduto.getCtDescricaoLanche().setText("");
           cadastrodeproduto.getCtPrecoLanche().setText("");
           cadastrodeproduto.getCtPesquisarTabelaLanches().setText("");
           JOptionPane.showMessageDialog(cadastrodeproduto, "Campo limpo com sucesso\n"
                        + "tabela atulizada");
                
                cadastrodeproduto.getGrupoButtonRB().clearSelection();
           
           Atualizar();
           
           
}     
/*-----------*/else if(e.getSource() == cadastrodeproduto.getJbPesquisaLanche()){
/*-----------*/if(cadastrodeproduto.getRbNumLanche().isSelected()){
    if(cadastrodeproduto.getCtPesquisarTabelaLanches().getText().isEmpty()){
                    JOptionPane.showMessageDialog(cadastrodeproduto,"Digite um numero para pesquisar");
                }else{
            try{
                AcoesPrograma ap = new AcoesPrograma();
                System.out.println("entrou numero do lanche");
                int numProd = Integer.parseInt(cadastrodeproduto.getCtPesquisarTabelaLanches().getText());
                
                try{
                    listadeprodutos = ap.PesquisarPD(numProd);
                    
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
                }
                
            
            DefaultTableModel tableModel = (DefaultTableModel) cadastrodeproduto.getTabProdutos().getModel();
                    tableModel.setNumRows(0);
                for (Produto listadeproduto : listadeprodutos) {
                    
                    Object[] linha = {listadeproduto.getIdproduto(),listadeproduto.getNumero(), listadeproduto.getNome(), listadeproduto.getDescricao(), listadeproduto.getPreco()};
                    tableModel.addRow(linha);
                }
                
                cadastrodeproduto.getTabProdutos().setSize(listadeprodutos.size(), 0);
                cadastrodeproduto.getTabProdutos().setModel(tableModel);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
            }
    }
}

/*--------------*/else if(cadastrodeproduto.getRbNomeLanche().isSelected()){
                
              try{
                 AcoesPrograma ap = new AcoesPrograma();
                  System.out.println("Entrou nome do lanche");
                  String nomeProd = cadastrodeproduto.getCtPesquisarTabelaLanches().getText();
                  
                  listadeprodutos = ap.PesquisarPD(nomeProd);
                  
                  DefaultTableModel tableModel = (DefaultTableModel) cadastrodeproduto.getTabProdutos().getModel();
                        tableModel.setNumRows(0);
                  for (Produto listadeproduto : listadeprodutos) {
                      Object[] linha = {listadeproduto.getIdproduto(),listadeproduto.getNumero(), listadeproduto.getNome(), listadeproduto.getDescricao(), listadeproduto.getPreco()};
                           tableModel.addRow(linha);
                  }
                  
                  cadastrodeproduto.getTabProdutos().setSize(listadeprodutos.size(), 0);
                  cadastrodeproduto.getTabProdutos().setModel(tableModel);
      
              }catch(Exception ex){
                  JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
              }      
            
    
}



}/*------------*/else if(e.getSource() == cadastrodeproduto.getJbEditar()){
         AcoesPrograma ap =  new AcoesPrograma();
    
    try{
        Produto prod = new Produto();
        prod.setNumero(Integer.parseInt(cadastrodeproduto.getCtNumLanche().getText()));
        prod.setNome(cadastrodeproduto.getCtNomeLanche().getText());
        prod.setDescricao(cadastrodeproduto.getCtDescricaoLanche().getText());
        prod.setPreco(Double.parseDouble(cadastrodeproduto.getCtPrecoLanche().getText()));
        
        ap.EditarPD(valor, prod);
        Atualizar();
    }catch(Exception ex){
        JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
    }
}
/*------------*/else if(e.getSource() == cadastrodeproduto.getJbExcluir()){
                
            AcoesPrograma ap =  new AcoesPrograma();
            try {
             ap.ExcluirPD(valor);
             Atualizar();
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
         }
}
     
     
     
     
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
        int linha = cadastrodeproduto.getTabProdutos().getSelectedRow();
        valor = (int) cadastrodeproduto.getTabProdutos().getValueAt(linha, 0);
        System.out.println(valor);
        Produto prod = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();
        
        try {
        prod = pdao.PesquisarPD2(valor);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
        }
        
       
        cadastrodeproduto.getCtNumLanche().setText(prod.getNumero()+""); 
        cadastrodeproduto.getCtNomeLanche().setText(prod.getNome());
        cadastrodeproduto.getCtDescricaoLanche().setText(prod.getDescricao());
        cadastrodeproduto.getCtPrecoLanche().setText(prod.getPreco()+"");
        
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
    


public void atualizaTabelaProduto() throws Exception{
        try{
                AcoesPrograma  ap = new AcoesPrograma();
                listadeprodutos  =  ap.ListarPD();
                
             
             
                   DefaultTableModel tableModel = (DefaultTableModel) cadastrodeproduto.getTabProdutos().getModel();
                        tableModel.setNumRows(0);
                    for(Produto listadeprodutoAtt : listadeprodutos) {
                        
                        Object[] linha = {listadeprodutoAtt.getIdproduto(),listadeprodutoAtt.getNumero(),listadeprodutoAtt.getNome(),listadeprodutoAtt.getDescricao(),listadeprodutoAtt.getPreco()};
                        tableModel.addRow(linha);
                    }
                
                    cadastrodeproduto.getTabProdutos().setSize(listadeprodutos.size(),0);
                    cadastrodeproduto.getTabProdutos().setModel(tableModel);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
            }
    }
    public void Atualizar() {

        AcoesPrograma ap = new AcoesPrograma();
        try {
            listadeprodutos = ap.ListarPD();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodeproduto, ex.getMessage());
        }
        
        DefaultTableModel tableModel = (DefaultTableModel) cadastrodeproduto.getTabProdutos().getModel();
                        tableModel.setNumRows(0);
                    for(Produto listadeprodutoAtt : listadeprodutos) {
                        
                        Object[] linha = {listadeprodutoAtt.getIdproduto(),listadeprodutoAtt.getNumero(),listadeprodutoAtt.getNome(),listadeprodutoAtt.getDescricao(),listadeprodutoAtt.getPreco()};
                        tableModel.addRow(linha);
                    }
        

                     cadastrodeproduto.getTabProdutos().setSize(listadeprodutos.size(),0);
                     cadastrodeproduto.getTabProdutos().setModel(tableModel);

    }
}