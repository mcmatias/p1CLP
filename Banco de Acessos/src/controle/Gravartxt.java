package controle;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;


public class Gravartxt {

	  
	    
	        public void escreve(String impressao, String arquivo) throws IOException {
	            //OutputStream os = new FileOutputStream("saida.txt");
	        	BufferedWriter osw = new BufferedWriter(new FileWriter(arquivo, true));
	            //OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	            
	            
	            //new BufferedWriter(new FileWriter("file.txt", true));

	            bw.write(impressao);
	            bw.newLine();

	            bw.close();
	        }
	        
		    
	        public void escreveUpd(String impressao, String arquivo) throws IOException {
	            //OutputStream os = new FileOutputStream("saida.txt");
	        	BufferedWriter osw = new BufferedWriter(new FileWriter(arquivo, false));
	            //OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	            
	            
	            //new BufferedWriter(new FileWriter("file.txt", true));

	            bw.write(impressao);
	            bw.newLine();

	            bw.close();
	        }
		    
	        public void escreveDelete(String impressao, String arquivo) throws IOException {
	            //OutputStream os = new FileOutputStream("saida.txt");
	        	BufferedWriter osw = new BufferedWriter(new FileWriter(arquivo, false));
	            //OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);
	            
	            
	            //new BufferedWriter(new FileWriter("file.txt", true));

	            bw.write(impressao);
	            bw.newLine();

	            bw.close();
	        }
	    
}
