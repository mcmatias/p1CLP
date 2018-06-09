package controle;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

import modelo.BeanCountry;

public class GerarTabela {

	  
	    
	        public void escreve(String linhahtml) throws IOException {
	            OutputStream os = new FileOutputStream("saida.hmtl");
	            OutputStreamWriter osw = new OutputStreamWriter(os);
	            BufferedWriter bw = new BufferedWriter(osw);

	            bw.write(linhahtml);
	            bw.newLine();

	            bw.close();
	        }
	    
}
