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
				String perguntaNome = "Inserir nome do novo Site:";   
				String nomeNovoSite = JOptionPane.showInputDialog(perguntaNome);
				String perguntaUrl = "Inserir url do novo Site:";   
				String novoUrlSite = JOptionPane.showInputDialog(perguntaUrl);
				String perguntaUsuario = "Inserir usuario do novo Site:";   
				String novoUsuarioSite = JOptionPane.showInputDialog(perguntaUsuario);
				String perguntaSenha = "Inserir url do novo Site:";   
				String novoSenhaSite = JOptionPane.showInputDialog(perguntaSenha);
		  }
		return null;
		  
	  }
	  
	  public BeanAcesso inserir(String siteEscolhido) {
		  
		  		BeanAcesso novoAcesso = new BeanAcesso();
		  		// se entra aqui, é pq nao existe ai ja seta o nome direto
		  		novoAcesso.setNome(siteEscolhido);
		  
				String perguntaUrl = "Inserir url do novo Site:";   
				String novoUrlSite = JOptionPane.showInputDialog(perguntaUrl);
				novoAcesso.setUrl(novoUrlSite);
				
				String perguntaUsuario = "Inserir usuario do novo Site:";   
				String novoUsuarioSite = JOptionPane.showInputDialog(perguntaUsuario);
				novoAcesso.setUsuario(novoUsuarioSite);
				
				String perguntaSenha = "Inserir url do novo Site:";   
				String novoSenhaSite = JOptionPane.showInputDialog(perguntaSenha);
				novoAcesso.setSenha(novoSenhaSite);
		  
		return novoAcesso;
		  
	  }
			

}
