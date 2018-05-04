package Model;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArquivoExterno {

    public ArquivoExterno(String nomeDoArquivo){
        
        Desktop desk = null;
        File arq = new File(nomeDoArquivo);
        
        if(Desktop.isDesktopSupported()){
            desk = Desktop.getDesktop();
        }
        if(desk != null){
            try {
                desk.open(arq);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: " + ex.getMessage());
            }
        }
    }  
}