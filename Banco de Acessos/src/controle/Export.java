package controle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import controle.Gravartxt;
import DAO.Acao;
import DAO.Entrada;


public class Export {
	
	
	
	
	public static void main(String[] args) throws IOException {
	Entrada input = new Entrada();
	
	// pego com o usuario o arq que gostaria de ler
	String arquivo = input.escolheArquivo();
	if (arquivo == null) {
		JOptionPane.showMessageDialog(null, "Operação Cancelada");
	} else {
	Acao acao = new Acao();
	
	InputStream is = new FileInputStream(input.getArquivo());
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	BeanAcesso acesso = new BeanAcesso();
	
	// pego do usuario a acao a ser realizada
	String acaoRealizar = acao.qualAcao();
	if (acaoRealizar == null) {
		JOptionPane.showMessageDialog(null, "Operação Cancelada");
	} else {
	if (acaoRealizar.equals("Inserir")) {
		
		// testo se esse site ja existe no documento
		String siteEscolhido = input.escolherSite();

		
		
		
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		//se nao existir
		if (acesso.getExiste().equals("N")){
			BeanAcesso novoAcesso = acao.inserir(siteEscolhido);
			if (novoAcesso == null){
				JOptionPane.showMessageDialog(null, "Operação Cancelada");
			} else {
			//chamar a funcao de gravar no txt passando novoAcesso como parametro
			String imprimirNome = novoAcesso.getNome().toString();
			String imprimirUrl = novoAcesso.getUrl().toString();
			String impirmirUsuario = novoAcesso.getUsuario().toString();
			String imprimirSenha = novoAcesso.getSenha().toString();
			
			String impressao = System.lineSeparator() + "nome: " + imprimirNome + System.lineSeparator() + "url: " + imprimirUrl + 
					System.lineSeparator() + "usuario: " +impirmirUsuario + System.lineSeparator() 
					+ "senha: " + imprimirSenha + System.lineSeparator() + "**************************" + System.lineSeparator();
			
			Gravartxt saida = new Gravartxt();
			saida.escreve(impressao, arquivo);
			
			
			JOptionPane.showMessageDialog(null, impressao);
		} 
		}else {
			JOptionPane.showMessageDialog(null, "Site já existente");
		}
		
		
	}
	else if (acaoRealizar.equals("Deletar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		//acesso = input.pedeAcesso(br, siteEscolhido);
		
		/*
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		*/
		
		String[] imp = acao.deletar(br, siteEscolhido);
		if (imp[1].equals("Tem")){
			String impressao = imp[0];
			Gravartxt saida = new Gravartxt();
			saida.escreveDelete(impressao, arquivo);
			
			JOptionPane.showMessageDialog(null, "Site Deletado");
		}
		else {
			JOptionPane.showMessageDialog(null, "Site Nao Encontrado");
		}
		
		/*
		String imprimirNome = delAcesso.getNome().toString();
		String imprimirUrl = delAcesso.getUrl().toString();
		String impirmirUsuario = delAcesso.getUsuario().toString();
		String imprimirSenha = delAcesso.getSenha().toString();
		
		String impressao = System.lineSeparator() + "Nome: " + imprimirNome + System.lineSeparator() + "URL: " + imprimirUrl + 
				System.lineSeparator() + "Usuario: " +impirmirUsuario + System.lineSeparator() 
				+ "Senha: " + imprimirSenha + System.lineSeparator();
				
		*/

	}
	
	else if (acaoRealizar.equals("Atualizar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		//acesso = input.pedeAcesso(br, siteEscolhido);
		if (siteEscolhido.equals("Erro")){
			//JOptionPane.showMessageDialog(null, "Operação Cancelada");
		} else {
			
			String[] imp = acao.update(siteEscolhido, br);
			if (imp[1].equals("NTem")) {
				JOptionPane.showMessageDialog(null, "Site nao encontrado");
			}
			
			else {


				String impressao = imp[0];
				Gravartxt saida = new Gravartxt();
				saida.escreveUpd(impressao, arquivo);
				
				JOptionPane.showMessageDialog(null, impressao);
			}
		}
		

	}
	
	else if (acaoRealizar.equals("Consultar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		else {
			String imprimirNome = acesso.getNome().toString();
			String imprimirUrl = acesso.getUrl().toString();
			String impirmirUsuario = acesso.getUsuario().toString();
			String imprimirSenha = acesso.getSenha().toString();
			
			String impressao = "nome: " + imprimirNome + System.lineSeparator() + "url: " + imprimirUrl + 
					System.lineSeparator() + "usuario: " +impirmirUsuario + System.lineSeparator() 
					+ "senha: " + imprimirSenha + System.lineSeparator();
			JOptionPane.showMessageDialog(null, impressao);
		}

	}
	
	else {
		JOptionPane.showMessageDialog(null, "Impossível Realizar Essa Acao");
	}

	

	
	}
	
	}
	
	} 
}