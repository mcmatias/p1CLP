package DAO;

public class Criptografar {

	public String criptografar(String updtSenhaSite) {
		
		
        int iCriptografia;
        String sCriptografada = "";
        
        
		char[] cSenha = new char[updtSenhaSite.length()];

		int[] iAscii = new int[updtSenhaSite.length()];

		for (int i = 0; i < cSenha.length; i++) {
			iAscii[i] = (int) updtSenhaSite.charAt(i);
		}
		
        for(int i = 0; i < cSenha.length; i++){
           
                iCriptografia = iAscii[i] + 3;
            
            cSenha[i] = (char) iCriptografia;
            sCriptografada += cSenha[i];
        }
        
		return sCriptografada;
	}

}
