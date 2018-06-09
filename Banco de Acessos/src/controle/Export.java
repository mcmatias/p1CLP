package controle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import controle.GerarTabela;
import DAO.Acao;
import DAO.Entrada;
import modelo.BeanCountry;

public class Export {
	
	
	
	
	public static void main(String[] args) throws IOException {
	Entrada input = new Entrada();
	
	// pego com o usuario o arq que gostaria de ler
	input.escolheArquivo();
	InputStream is = new FileInputStream(input.getArquivo());
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	BeanAcesso acesso = new BeanAcesso();
	
	// pego c o usuario o acesso que gostaria de visualizar
	acesso = input.pedeAcesso(br);
	
	Acao acao = new Acao();
	
	// pego do usuario a acao a ser realizada
	String acaoRealizar = acao.qualAcao();  
	
	// realizo a acao
	acao.realizarAcao(acaoRealizar);
	
	
	
	}
	
}