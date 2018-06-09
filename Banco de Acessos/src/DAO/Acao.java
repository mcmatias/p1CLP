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
	  
	  /*
	  public BeanAcesso realizarAcao(String acaoRealizar) {
		  if (acaoRealizar.equals("Consulta")){
			  // so chamar o bean que ja ta populado 
		  }
		  if (acaoRealizar.equals("Inserir")){
			  // seto novos campos no Bean
			  BeanAcesso novoAcesso = new BeanAcesso();
				String perguntaNome = "Inserir nome do novo Site:";   
				String nomeNovoSite = JOptionPane.showInputDialog(perguntaNome);
				novoAcesso.setNome(nomeNovoSite);
				
				String perguntaUrl = "Inserir url do novo Site:";   
				String novoUrlSite = JOptionPane.showInputDialog(perguntaUrl);
				novoAcesso.setUrl(novoUrlSite);
				
				String perguntaUsuario = "Inserir usuario do novo Site:";   
				String novoUsuarioSite = JOptionPane.showInputDialog(perguntaUsuario);
				novoAcesso.setUsuario(novoUsuarioSite);
				
				String perguntaSenha = "Inserir url do novo Site:";   
				String novoSenhaSite = JOptionPane.showInputDialog(perguntaSenha);
				novoAcesso.setSenha(novoSenhaSite);
				
		  }
		return null;
		  
	  }
	  */
	  
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
				
				String perguntaSenha = "Inserir senha do novo Site:";   
				String novoSenhaSite = JOptionPane.showInputDialog(perguntaSenha);
				novoAcesso.setSenha(novoSenhaSite);
				
				//inserir no txt
		  
		return novoAcesso;
		  
	  }
	  
	  public BeanAcesso deletar(String siteEscolhido) {
		  
	  		BeanAcesso delAcesso = new BeanAcesso();
	  		
	  		delAcesso.setNome(siteEscolhido);
	  		
	  		delAcesso.setExiste(null);
	  		delAcesso.setNome(null);
	  		delAcesso.setSenha(null);
	  		delAcesso.setUrl(null);
	  		delAcesso.setUsuario(null);
	
	  		//apagar do txt
	  
	return delAcesso;
	  
}
	  
	  public BeanAcesso update(String siteEscolhido, BeanAcesso acesso) {
		  
	  		BeanAcesso updtAcesso = new BeanAcesso();
	  		
	  		updtAcesso.setNome(siteEscolhido);
	  		
	
	  		
			String perguntaupdt = "Qual dado deseja fazer o update(URL, Usuario ou Senha)?";   
			String updtSite = JOptionPane.showInputDialog(perguntaupdt);
			
			if (updtSite.equals("URL")) {
				String perguntaupdtURL = "Qual a nova URL?"; 
				String updtUrlSite = JOptionPane.showInputDialog(perguntaupdtURL);
				updtAcesso.setUrl(updtUrlSite);
				updtAcesso.setUsuario(acesso.getUsuario());
				updtAcesso.setSenha(acesso.getSenha());
				return updtAcesso;
				
			}
			
			else if (updtSite.equals("Usuario")) {
				String perguntaupdtUser = "Qual o novo usuario?"; 
				String updtUserSite = JOptionPane.showInputDialog(perguntaupdtUser);
				updtAcesso.setUsuario(updtUserSite);
				updtAcesso.setUrl(acesso.getUrl());
				updtAcesso.setSenha(acesso.getSenha());
				return updtAcesso;
			}

			else if (updtSite.equals("Senha")) {
				String perguntaupdtSenha = "Qual a nova senha?"; 
				String updtSenhaSite = JOptionPane.showInputDialog(perguntaupdtSenha);
				updtAcesso.setSenha(updtSenhaSite);
				updtAcesso.setUrl(acesso.getUrl());
				updtAcesso.setUsuario(acesso.getUsuario());
				return updtAcesso;
			}
			else{
				JOptionPane.showMessageDialog(null, "Site nao encontrado");
				return updtAcesso;
			}

	
	  		//gravar updt no txt
	  
	
	  
}
			

}
