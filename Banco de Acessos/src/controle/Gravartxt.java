package controle;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;


public class Gravartxt {

	  
	    
	        public void escreve(String impressao) throws IOException {
	            //OutputStream os = new FileOutputStream("saida.txt");
	        	BufferedWriter osw = new BufferedWriter(new FileWriter("banco_de_acessos.txt", true));
	            //OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	            
	            
	            //new BufferedWriter(new FileWriter("file.txt", true));

	            bw.write(impressao);
	            bw.newLine();

	            bw.close();
	        }
	    
}
