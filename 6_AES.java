// import java.util.Base64;
// import java.util.Scanner;
// import javax.crypto.Cipher;
// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;

import java.util.*;
import javax.crypto.*;

public class AES {
    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(n);
        return kg.generateKey();
    }
    
    public static String encrypt(String pt, SecretKey sk) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, sk);
        byte[] enBytes = c.doFinal(pt.getBytes());
        return Base64.getEncoder().encodeToString(enBytes);
    }
    
    public static String decrypt(String ct, SecretKey sk) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, sk);
        byte[] deBytes = c.doFinal(Base64.getDecoder().decode(ct));
        return new String(deBytes);
    }
    
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter text to encrypt: ");
            String pt = sc.nextLine();
            
            SecretKey sk = generateKey(128);
            
            String enText = encrypt(pt, sk);
            System.out.println("Encrypted Text: " + enText);
            String deText = decrypt(enText, sk);
            System.out.println("Decrypted Text: " + deText);

            sc.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
