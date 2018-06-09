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
			String novoAcesso = acao.inserir(siteEscolhido).toString(); //coloquei em string p gravar no txt
			//chamar a funcao de gravar no txt passando novoAcesso como parametro
		}
		else{
			JOptionPane.showMessageDialog(null, "Site já existente");
		}
		
		
	}
	else if (acaoRealizar.equals("Consultar")){
		// pego c o usuario o acesso que gostaria de visualizar
		String siteEscolhido = input.escolherSite();
		acesso = input.pedeAcesso(br, siteEscolhido);
		
		
		if (acesso.getExiste().equals("N")) {
			JOptionPane.showMessageDialog(null, "Site nao encontrado");
		}
		JOptionPane.showMessageDialog(null, acesso);
	}

	

	
	
	
	}
	
}