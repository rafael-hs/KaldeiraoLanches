
package Controller;

import Dao.FuncionarioDAO;
import Model.AcoesPrograma;
import Model.Funcionario;
import Model.Pessoa;
import View.CadastroDeFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerTelaCtFuncionario implements ActionListener, MouseListener {
    public CadastroDeFuncionario cadastrodefuncionario;
    ArrayList<Pessoa> listadefuncionario;
    int valor;
    
    public ControllerTelaCtFuncionario(CadastroDeFuncionario cadastrodefuncionario){
         this.cadastrodefuncionario = cadastrodefuncionario;
        this.cadastrodefuncionario.getJbCadastrar().addActionListener(this);
        this.cadastrodefuncionario.getJbEditar().addActionListener(this);
        this.cadastrodefuncionario.getJbExcluir().addActionListener(this);
        this.cadastrodefuncionario.getJbLimpar().addActionListener(this);
        this.cadastrodefuncionario.getJbPesquisaCliente().addActionListener(this);
        
        this.cadastrodefuncionario.getRbNomeFuncionario().addActionListener(this);
        this.cadastrodefuncionario.getRbTelefoneFuncionario().addActionListener(this);
        this.cadastrodefuncionario.getRbCelularFuncionario().addActionListener(this);
        
        this.cadastrodefuncionario.getTabDadosFuncionario().addMouseListener(this);
        try{
        this.atualizaTabelaFuncionario();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.cadastrodefuncionario, ex.getMessage());
        }
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
 /*--------------*/if(e.getSource() == cadastrodefuncionario.getJbCadastrar()){
           if (cadastrodefuncionario.getCtNomeFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtCpfFormatadoFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtCelularFormatadoFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtRuaFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtBairroFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtCepFormatadoFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtCidadeFuncionario().getText().isEmpty() && cadastrodefuncionario.getCtNumCasaFuncionario().getText().isEmpty()) {
                JOptionPane.showMessageDialog(cadastrodefuncionario, "Preencha os campos para fazer cadastro");
           }else{
             System.out.println("ENTROU NO CADASTRAR");
            try{
                
                Funcionario fun = new Funcionario();
                
                fun.setNome(cadastrodefuncionario.getCtNomeFuncionario().getText());
                
                //---------------------------------------------------------------------------------------------//
                if(cadastrodefuncionario.getCtCpfFormatadoFuncionario().getText().isEmpty()){
                    fun.setCpf("");
                }else{
                    fun.setCpf(cadastrodefuncionario.getCtCpfFormatadoFuncionario().getText());
                }
                //---------------------------------------------------------------------------------------------//
                
                //---------------------------------------------------------------------------------------------//
                if(cadastrodefuncionario.getCtCelularFormatadoFuncionario().getText().isEmpty()){
                    fun.setCelular("");
                }else{
                   fun.setCelular(cadastrodefuncionario.getCtCelularFormatadoFuncionario().getText()); 
                }
                //---------------------------------------------------------------------------------------------//
                
                //---------------------------------------------------------------------------------------------//
                if(cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().getText().isEmpty()){
                    throw new Exception("O numero de telefone não pode estar vazio");
                }else{
                   fun.setTelefone(cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().getText()); 
                }
                //---------------------------------------------------------------------------------------------//
                
                if(cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().getText().isEmpty()){
                    fun.setNascimento("");
                }else{
                    fun.setNascimento(cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().getText());
                }
                
                fun.setRua(cadastrodefuncionario.getCtRuaFuncionario().getText());
                fun.setBairro(cadastrodefuncionario.getCtBairroFuncionario().getText());
                fun.setCep(cadastrodefuncionario.getCtCepFormatadoFuncionario().getText());
                fun.setCidade(cadastrodefuncionario.getCtCidadeFuncionario().getText());
                fun.setNumCasa(cadastrodefuncionario.getCtNumCasaFuncionario().getText());
                
                AcoesPrograma ap = new AcoesPrograma();
                ap.cadastrarFuncionario(fun);
                System.out.println("CADASTRou");
                
                JOptionPane.showMessageDialog(cadastrodefuncionario, "Funcionario cadastrado com Sucesso");
                
                cadastrodefuncionario.getCtNomeFuncionario().setText("");
                cadastrodefuncionario.getCtCpfFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtCelularFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtRuaFuncionario().setText("");
                cadastrodefuncionario.getCtBairroFuncionario().setText("");
                cadastrodefuncionario.getCtCepFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtCidadeFuncionario().setText("");
                cadastrodefuncionario.getCtNumCasaFuncionario().setText("");
                
               Atualizar();
            }catch(Exception ex){
               JOptionPane.showMessageDialog(cadastrodefuncionario,ex.getMessage());
            }
        }
        }
 /*--------------*/else if (e.getSource() == cadastrodefuncionario.getJbLimpar()){
            
            
                 cadastrodefuncionario.getCtNomeFuncionario().setText("");
                cadastrodefuncionario.getCtCpfFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtCelularFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtRuaFuncionario().setText("");
                cadastrodefuncionario.getCtBairroFuncionario().setText("");
                cadastrodefuncionario.getCtCepFormatadoFuncionario().setText("");
                cadastrodefuncionario.getCtCidadeFuncionario().setText("");
                cadastrodefuncionario.getCtNumCasaFuncionario().setText("");
                cadastrodefuncionario.getCtPesquisaFuncionario().setText("");
                
                JOptionPane.showMessageDialog(cadastrodefuncionario, "Campo limpo com sucesso\n"
                        + "tabela atulizada");
                
                cadastrodefuncionario.getGrupoButtonRB().clearSelection();
               
                Atualizar();
    }
/*--------------*/else if(e.getSource() == cadastrodefuncionario.getJbPesquisaCliente()){
/*------------*/if(cadastrodefuncionario.getRbNomeFuncionario().isSelected()){
        if (cadastrodefuncionario.getCtPesquisaFuncionario().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodefuncionario, "Digite um nome para pesquisar");
                }else{
           try{
            AcoesPrograma ap = new AcoesPrograma();
            System.out.println("entrou nome");
            String nomep = cadastrodefuncionario.getCtPesquisaFuncionario().getText();
            
            try {
                listadefuncionario = ap.pesquisarFuncionario(nomep);
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
            }
            
            DefaultTableModel tableModel = (DefaultTableModel) cadastrodefuncionario.getTabDadosFuncionario().getModel();
                        tableModel.setNumRows(0);
                    for(Pessoa listadefuncionarioAtt : listadefuncionario) {
                        Funcionario funcionario = (Funcionario) listadefuncionarioAtt;
                        Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(),funcionario.getCpf(),funcionario.getCelular(),
                            funcionario.getTelefone(),funcionario.getNascimento()};
                        tableModel.addRow(linha);
                    }
                    
                    cadastrodefuncionario.getTabDadosFuncionario().setSize(listadefuncionario.size(),0);
                    cadastrodefuncionario.getTabDadosFuncionario().setModel(tableModel);
                }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
                }
          }
        }
/*------------*/else if(cadastrodefuncionario.getRbTelefoneFuncionario().isSelected()){
    if (cadastrodefuncionario.getCtPesquisaFuncionario().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodefuncionario, "Digite um telefone para pesquisar");
                }else{
        
    
            int rbresultado = 2;
            try{
                AcoesPrograma ap = new AcoesPrograma();
                System.out.println("Entroutelefone");
                int telefone = Integer.parseInt(cadastrodefuncionario.getCtPesquisaFuncionario().getText());
                
                listadefuncionario = ap.pesquisarFuncionario(telefone,rbresultado);
                
                DefaultTableModel tableModel = (DefaultTableModel) cadastrodefuncionario.getTabDadosFuncionario().getModel();
                        tableModel.setNumRows(0);
                    for(Pessoa listadefuncionarioAtt : listadefuncionario) {
                        Funcionario funcionario = (Funcionario) listadefuncionarioAtt;
                        Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(),funcionario.getCpf(),funcionario.getCelular(),
                            funcionario.getTelefone(),funcionario.getNascimento()};
                        tableModel.addRow(linha);
                    }
                
                    cadastrodefuncionario.getTabDadosFuncionario().setSize(listadefuncionario.size(),0);
                    cadastrodefuncionario.getTabDadosFuncionario().setModel(tableModel);
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
              }
            }
        }
/*------------*/else if(cadastrodefuncionario.getRbCelularFuncionario().isSelected()){
    if (cadastrodefuncionario.getCtPesquisaFuncionario().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(cadastrodefuncionario, "Digite um celular para pesquisar");
                }else{
            int rbresultado = 1;
            
            try{
            AcoesPrograma ap = new AcoesPrograma();
                
//            if(e.getSource() == cadastrodecliente.getRbNomeCliente()){
                System.out.println("ENTROU2");
             int telefone = Integer.parseInt(cadastrodefuncionario.getCtPesquisaFuncionario().getText());
           try {
               listadefuncionario = ap.pesquisarFuncionario(telefone,rbresultado);
           } catch (Exception ex) {
               JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
           }
           
                DefaultTableModel tableModel = (DefaultTableModel) cadastrodefuncionario.getTabDadosFuncionario().getModel();
                        tableModel.setNumRows(0);
                    for(Pessoa listadefuncionarioAtt : listadefuncionario) {
                        Funcionario funcionario = (Funcionario) listadefuncionarioAtt;
                        Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(),funcionario.getCpf(),funcionario.getCelular(),
                            funcionario.getTelefone(),funcionario.getNascimento()};
                        tableModel.addRow(linha);
                    }
                
                    cadastrodefuncionario.getTabDadosFuncionario().setSize(listadefuncionario.size(),0);
                    cadastrodefuncionario.getTabDadosFuncionario().setModel(tableModel);
                }
            catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
                }
             }
            
        }
}   
/*------------*/else if(e.getSource() == cadastrodefuncionario.getJbEditar()){
    AcoesPrograma ap = new AcoesPrograma();
            
            try{
                
               Funcionario fun = new Funcionario();
                fun.setNome(cadastrodefuncionario.getCtNomeFuncionario().getText());
                fun.setCpf(cadastrodefuncionario.getCtCpfFormatadoFuncionario().getText());
                fun.setCelular(cadastrodefuncionario.getCtCelularFormatadoFuncionario().getText());
                fun.setTelefone(cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().getText());
                fun.setNascimento(cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().getText());
                fun.setRua(cadastrodefuncionario.getCtRuaFuncionario().getText());
                fun.setBairro(cadastrodefuncionario.getCtBairroFuncionario().getText());
                fun.setCep(cadastrodefuncionario.getCtCepFormatadoFuncionario().getText());
                fun.setCidade(cadastrodefuncionario.getCtCidadeFuncionario().getText());
                fun.setNumCasa(cadastrodefuncionario.getCtNumCasaFuncionario().getText());
                
                
                ap.editarFuncionario(valor,fun);
                Atualizar();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
            }
}  
/*------------*/else if(e.getSource() == cadastrodefuncionario.getJbExcluir()){
    AcoesPrograma ap = new AcoesPrograma();
           try {
               ap.excluirFuncionario(valor);
               Atualizar();
           } catch (Exception ex) {
               JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
           }

}        
}

    @Override
    public void mouseClicked(MouseEvent e) {
        int linha = cadastrodefuncionario.getTabDadosFuncionario().getSelectedRow();
        valor = (int) cadastrodefuncionario.getTabDadosFuncionario().getValueAt(linha, 0);
        System.out.println(valor);
        Funcionario fun = new Funcionario();
        FuncionarioDAO fdao = new FuncionarioDAO();
        
            try {
                fun = fdao.Pesquisar(valor);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex1.getMessage());
            }
            
            cadastrodefuncionario.getCtNomeFuncionario().setText(fun.getNome());
                cadastrodefuncionario.getCtCpfFormatadoFuncionario().setText(fun.getCpf());
                cadastrodefuncionario.getCtCelularFormatadoFuncionario().setText(fun.getCelular()+"");
                cadastrodefuncionario.getCtTelefoneFormatadoFuncionario().setText(fun.getTelefone()+"");
                cadastrodefuncionario.getCtNascimentoFormatadoFuncionario().setText(fun.getNascimento());
                cadastrodefuncionario.getCtRuaFuncionario().setText(fun.getRua());
                cadastrodefuncionario.getCtBairroFuncionario().setText(fun.getBairro());
                cadastrodefuncionario.getCtCepFormatadoFuncionario().setText(fun.getCep());
                cadastrodefuncionario.getCtCidadeFuncionario().setText(fun.getCidade());
                cadastrodefuncionario.getCtNumCasaFuncionario().setText(fun.getNumCasa());
        
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
    
    public void atualizaTabelaFuncionario() throws Exception{
        try{
                AcoesPrograma  ap = new AcoesPrograma();
                listadefuncionario  =  ap.ListarFuncionario();
                
             
             
                   DefaultTableModel tableModel = (DefaultTableModel) cadastrodefuncionario.getTabDadosFuncionario().getModel();
                        tableModel.setNumRows(0);
                    for(Pessoa listadefuncionarioAtt : listadefuncionario) {
                        Funcionario funcionario = (Funcionario) listadefuncionarioAtt;
                        Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(),funcionario.getCpf(),funcionario.getCelular(),
                            funcionario.getTelefone(),funcionario.getNascimento()};
                        tableModel.addRow(linha);
                    }
                
                    cadastrodefuncionario.getTabDadosFuncionario().setSize(listadefuncionario.size(),0);
                    cadastrodefuncionario.getTabDadosFuncionario().setModel(tableModel);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
            }
    }
    public void Atualizar() {

        AcoesPrograma ap = new AcoesPrograma();
        try {
            listadefuncionario = ap.ListarFuncionario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastrodefuncionario, ex.getMessage());
        }

        DefaultTableModel tableModel = (DefaultTableModel) cadastrodefuncionario.getTabDadosFuncionario().getModel();
        tableModel.setNumRows(0);
        for(Pessoa listadefuncionarioAtt : listadefuncionario) {
                        Funcionario funcionario = (Funcionario) listadefuncionarioAtt;
                        Object[] linha = {funcionario.getIdFuncionario(), funcionario.getNome(),funcionario.getCpf(),funcionario.getCelular(),
                            funcionario.getTelefone(),funcionario.getNascimento()};
                        tableModel.addRow(linha);
                    }

       cadastrodefuncionario.getTabDadosFuncionario().setSize(listadefuncionario.size(), 0);
        cadastrodefuncionario.getTabDadosFuncionario().setModel(tableModel);

    }
}
    

