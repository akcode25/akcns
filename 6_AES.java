
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class AES {
public static SecretKey generateKey(int n) throws Exception {
KeyGenerator kg = KeyGenerator.getInstance("AES");
kg.init(n);
return kg.generateKey();
}
public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
return Base64.getEncoder().encodeToString(encryptedBytes);
}
public static String decrypt(String cipherText, SecretKey secretKey) throws Exception {
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
return new String(decryptedBytes);
}
public static void main(String[] args) {
try {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter text to encrypt:");
String plainText = scanner.nextLine();
SecretKey secretKey = generateKey(128);
String encryptedText = encrypt(plainText, secretKey);
System.out.println("Encrypted Text: " + encryptedText);
String decryptedText = decrypt(encryptedText, secretKey);
System.out.println("Decrypted Text: " + decryptedText);
scanner.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}


/*
//scam wala

import java.util.Scanner;
import java.util.Base64;
import java.security.MessageDigest;


public class AES{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to encrypt");
        String plainText = scanner.nextLine();
        String encrypt = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(plainText.getBytes()));
        System.out.println("Encryption text:"+encrypt);
        System.out.println("Decryption text:"+plainText);
    }
}

*/







/*
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class AES {
 // Method to generate a secret key
 public static SecretKey generateKey(int n) throws Exception {
 KeyGenerator kg = KeyGenerator.getInstance("AES");
 kg.init(n);
 SecretKey sk = kg.generateKey();
 return sk;
 }
 // Method to encrypt a plaintext using a secret key
 public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
 Cipher cipher = Cipher.getInstance("AES");
 cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
 return Base64.getEncoder().encodeToString(encryptedBytes);
 }
 // Method to decrypt a ciphertext using a secret key
 public static String decrypt(String cipherText, SecretKey secretKey) throws Exception 
{
 Cipher cipher = Cipher.getInstance("AES");
 cipher.init(Cipher.DECRYPT_MODE, secretKey);
 byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
 return new String(decryptedBytes);
 }
 // Main method to demonstrate encryption and decryption
 public static void main(String[] args) {
 try {
 String plainText = "nmit";
 SecretKey secretKey = generateKey(128);
 String encryptedText = encrypt(plainText, secretKey);
 System.out.println("Encrypted Text: " + encryptedText);
 String decryptedText = decrypt(encryptedText, secretKey);
 System.out.println("Decrypted Text: " + decryptedText);
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}
*/













