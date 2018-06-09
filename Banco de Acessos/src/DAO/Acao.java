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
		  		
		  		Criptografar senhaCriptografada = new Criptografar(); 
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
				String senhaCrip = (senhaCriptografada.criptografar(novoSenhaSite)).toString();
				novoAcesso.setSenha(senhaCrip);
				
				//inserir no txt
		  
		return novoAcesso;
		  
	  }
	  
	  public String[] deletar(BufferedReader br, String siteEscolhido) throws IOException{
		  
	  		BeanAcesso delAcesso = new BeanAcesso();
	  		String [] arqFlag = {"", "NTem"};
	  		delAcesso.setNome(siteEscolhido);
	  		
			String s = br.readLine();
			while (s != null) {
				if (s.equals("**************************")) {
					arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
					s = br.readLine();
				} else {
					String[] retornoSplit = s.split(":");
					if (retornoSplit[0].equals("nome")) {
						if ((siteEscolhido.trim()).equals(retornoSplit[1].trim())) {
							arqFlag[1] = "Tem";
							s = br.readLine();
							s = br.readLine();
							s = br.readLine();
							s = br.readLine();
							s = br.readLine();
							
						}//se nao for o que eu to procurando, ver a prox linha
						arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
						s = br.readLine();
						delAcesso.setExiste("N");
					}
					arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
					s = br.readLine();
					//site.setExiste("N");
				}

			}
			

			// return site;
			br.close();
			return arqFlag;
			
		  
}
	  
	  public String[] update(String siteEscolhido, BufferedReader br) throws IOException{
		  
	  		BeanAcesso updtAcesso = new BeanAcesso();
	  		
	  		Criptografar senhaCriptografada = new Criptografar(); 
	  		
	  		updtAcesso.setNome(siteEscolhido);
	  		
	  		String [] arqFlag = {"", "NTem"};
	  		
	  		
	  		//
			String s = br.readLine();
			while (s != null) {
				if (s.equals("**************************")) {
					arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
					s = br.readLine();
				} else {
					String[] retornoSplit = s.split(":");
					if (retornoSplit[0].equals("nome")) {
						if ((siteEscolhido.trim()).equals(retornoSplit[1].trim())) {
							updtAcesso.setExiste("S");
							arqFlag[1] = "Tem"; 
							updtAcesso.setNome(retornoSplit[1]);
							arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
							s = br.readLine();
							retornoSplit = s.split(":");
						
							String perguntaupdt = "Qual dado deseja fazer o update(URL, Usuario ou Senha)?";   
							String updtSite = JOptionPane.showInputDialog(perguntaupdt);
						//if (retornoSplit[0].equals("url")) {
							 if (updtSite.equals("URL")) {
								String perguntaupdtURL = "Qual a nova URL?"; 
								String updtUrlSite = JOptionPane.showInputDialog(perguntaupdtURL);
								updtAcesso.setUrl(updtUrlSite);
								String ss = "url: " + (updtAcesso.getUrl()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setUsuario(retornoSplit[1]);
								ss = "usuario: " + (updtAcesso.getUsuario()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setSenha(retornoSplit[1]);
								ss = "senha: " + (updtAcesso.getSenha()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								
							}
							
						
						//if (retornoSplit[0].equals("usuario")) {
							else if (updtSite.equals("Usuario")) {
								String perguntaupdtUser = "Qual o novo usuario?"; 
								String updtUserSite = JOptionPane.showInputDialog(perguntaupdtUser);
								updtAcesso.setUrl(retornoSplit[1]);
								String ss = "url: " + (updtAcesso.getUrl()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setUsuario(updtUserSite);
								ss = "usuario: " + (updtAcesso.getUsuario()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setSenha(retornoSplit[1]);
								ss = "senha: " + (updtAcesso.getSenha()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
							}
		
						
						//if (retornoSplit[0].equals("senha")) {

							else if (updtSite.equals("Senha")) {
								String perguntaupdtSenha = "Qual a nova senha?"; 
								String updtSenhaSite = JOptionPane.showInputDialog(perguntaupdtSenha);
								String senhaCrip = (senhaCriptografada.criptografar(updtSenhaSite)).toString();
								updtAcesso.setUrl(retornoSplit[1]);
								String ss = "url: " + (updtAcesso.getUrl()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setUsuario(retornoSplit[1]);
								ss = "usuario: " + (updtAcesso.getUsuario()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
								updtAcesso.setSenha(senhaCrip);
								ss = "senha: " + (updtAcesso.getSenha()).toString();
								arqFlag[0] = arqFlag[0] + ss + System.lineSeparator();
								s = br.readLine();
								retornoSplit = s.split(":");
							}
							else{
								JOptionPane.showMessageDialog(null, "Site nao encontrado");
				
							}

						}//se nao for o que eu to procurando, ver a prox linha
						arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
						s = br.readLine();
						updtAcesso.setExiste("N");
					}
					arqFlag[0] = arqFlag[0] + s + System.lineSeparator();
					s = br.readLine();
					//site.setExiste("N");
				}

			}
			return arqFlag;

	  		//gravar updt no tx
	  
	
	  
}
			

}
