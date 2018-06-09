package DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import controle.BeanAcesso;
import modelo.BeanCountry;
import modelo.BeanCountry;

public class Entrada {
	String arquivo;
	String country;

	public void escolheArquivo() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setDialogTitle("Escolha o arquivo:");
		int ret = chooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION)
			arquivo = chooser.getSelectedFile().getAbsolutePath();
	}

	public BeanAcesso pedeAcesso(BufferedReader br) throws IOException {
		String pergunta = "Escolha um site:";
		BeanAcesso site = new BeanAcesso();
		String siteEscolhido = JOptionPane.showInputDialog(pergunta);

		// le o arquivo
		// InputStream is = new FileInputStream(input.getArquivo());
		// InputStreamReader isr = new InputStreamReader(is);
		// BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		while (s != null) {
			if (s.equals("**************************")) {
				s = br.readLine();
			} else {
				String[] retornoSplit = s.split(":");
				if (retornoSplit[0].equals("nome")) {
					if (siteEscolhido.equals(retornoSplit[1])) {
						site.setNome(retornoSplit[1]);
						s = br.readLine();
						retornoSplit = s.split(":");
					
					//if (retornoSplit[0].equals("url")) {
						site.setUrl(retornoSplit[1]);
						s = br.readLine();
						retornoSplit = s.split(":");
					
					//if (retornoSplit[0].equals("usuario")) {
						site.setUsuario(retornoSplit[1]);
						s = br.readLine();
						retornoSplit = s.split(":");
					
					//if (retornoSplit[0].equals("senha")) {
						site.setSenha(retornoSplit[1]);
						s = br.readLine();
						retornoSplit = s.split(":");
					}
					s = br.readLine();
				}
			}

		}
		// return site;
		br.close();
		return site;

	}

	public String getArquivo() {
		return arquivo;
	}

}