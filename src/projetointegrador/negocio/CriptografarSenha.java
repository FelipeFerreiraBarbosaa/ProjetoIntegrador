package projetointegrador.negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Recebe a senha como uma string normal e retorna ela criptografada

public class CriptografarSenha {
    
    public String cripto (String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {

                   MessageDigest algorithm = MessageDigest.getInstance("MD5");
                   byte messageDigest[] = algorithm.digest(string.getBytes("UTF-8"));
                   
                   String a = new String(messageDigest, "UTF-8");

                   return a;
         }
    
}
