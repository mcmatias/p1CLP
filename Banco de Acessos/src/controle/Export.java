package controle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import controle.GerarTabela;
import DAO.Acao;
import DAO.Entrada;
import modelo.BeanCountry;

public class Export {
	
	
	
	
	public static void main(String[] args) throws IOException {
	Entrada input = new Entrada();
	
	// pego com o usuario o arq que gostaria de ler
	input.escolheArquivo();
	Acao acao = new Acao();
	
	InputStream is = new FileInputStream(input.getArquivo());
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	BeanAcesso acesso = new BeanAcesso();
	
	// pego do usuario a acao a ser realizada
	String acaoRealizar = acao.qualAcao(); 
	if (acaoRealizar.equals("Inserir")) {
		
		// testo se esse site ja existe no documento
		String siteEscolhido = input.escolherSite();
		
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		//se nao existir
		if (acesso.getExiste().equals("N")){
			BeanAcesso novoAcesso = acao.inserir(siteEscolhido);
			//chamar a funcao de gravar no txt passando novoAcesso como parametro
			String imprimirNome = novoAcesso.getNome().toString();
			String imprimirUrl = novoAcesso.getUrl().toString();
			String impirmirUsuario = novoAcesso.getUsuario().toString();
			String imprimirSenha = novoAcesso.getSenha().toString();
			
			String impressao = "Nome: " + imprimirNome + System.lineSeparator() + "URL: " + imprimirUrl + 
					System.lineSeparator() + "Usuario: " +impirmirUsuario + System.lineSeparator() 
					+ "Senha: " + imprimirSenha + System.lineSeparator();
			JOptionPane.showMessageDialog(null, impressao);
		}
		else{
			JOptionPane.showMessageDialog(null, "Site já existente");
		}
		
		
	}
	else if (acaoRealizar.equals("Deletar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		BeanAcesso delAcesso = acao.deletar(siteEscolhido);
		String imprimirNome = acesso.getNome().toString();
		String imprimirUrl = acesso.getUrl().toString();
		String impirmirUsuario = acesso.getUsuario().toString();
		String imprimirSenha = acesso.getSenha().toString();
		
		String impressao = "Nome: " + imprimirNome + System.lineSeparator() + "URL: " + imprimirUrl + 
				System.lineSeparator() + "Usuario: " +impirmirUsuario + System.lineSeparator() 
				+ "Senha: " + imprimirSenha + System.lineSeparator();
		JOptionPane.showMessageDialog(null, "Site Deletado");
	}
	
	else if (acaoRealizar.equals("Atualizar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		BeanAcesso updtAcesso = acao.update(siteEscolhido);
		String imprimirNome = updtAcesso.getNome().toString();
		String imprimirUrl = updtAcesso.getUrl().toString();
		String impirmirUsuario = updtAcesso.getUsuario().toString();
		String imprimirSenha = updtAcesso.getSenha().toString();
		
		String impressao = "Nome: " + imprimirNome + System.lineSeparator() + "URL: " + imprimirUrl + 
				System.lineSeparator() + "Usuario: " +impirmirUsuario + System.lineSeparator() 
				+ "Senha: " + imprimirSenha + System.lineSeparator();
		JOptionPane.showMessageDialog(null, impressao);
	}
	
	else if (acaoRealizar.equals("Consultar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		String imprimirNome = acesso.getNome().toString();
		String imprimirUrl = acesso.getUrl().toString();
		String impirmirUsuario = acesso.getUsuario().toString();
		String imprimirSenha = acesso.getSenha().toString();
		
		String impressao = "Nome: " + imprimirNome + System.lineSeparator() + "URL: " + imprimirUrl + 
				System.lineSeparator() + "Usuario: " +impirmirUsuario + System.lineSeparator() 
				+ "Senha: " + imprimirSenha + System.lineSeparator();
		JOptionPane.showMessageDialog(null, impressao);
	}
	
	else {
		JOptionPane.showMessageDialog(null, "Impossível Realizar Essa Acao");
	}

	

	
	
	
	}
	
}