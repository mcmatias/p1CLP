package DAO;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import controle.BeanAcesso;

public class Acao {
	
	  public String qualAcao(){
			String pergunta = "Qual acao deseja realizar:";   
			String acao = JOptionPane.showInputDialog(pergunta);
			
		return acao;	
	  }
	  
	  public BeanAcesso realizarAcao(String acaoRealizar) {
		  if (acaoRealizar.equals("Consulta")){
			  // so chamar o bean que ja ta populado 
		  }
		  if (acaoRealizar.equals("Inserir")){
			  // seto novos campos no Bean
		  }
		return null;
		  
	  }
			

}
