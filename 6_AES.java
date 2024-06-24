

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

/*
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;
import java.util.Scanner;  // Import the Scanner class

public class AES {
    private SecretKey key;
    private final int KEY_SIZE = 128;
    private final int GCM_TAG_LENGTH = 128;  // GCM authentication tag length in bits
    private Cipher encryptionCipher;

    public void init() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        key = keyGenerator.generateKey();
    }

    public String encrypt(String data) throws Exception {
        byte[] dataInBytes = data.getBytes();
        encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(dataInBytes);
        byte[] iv = encryptionCipher.getIV();
        byte[] encryptedIVAndText = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, encryptedIVAndText, iv.length, encryptedBytes.length);
        return encode(encryptedIVAndText);
    }

    public String decrypt(String encryptedData) throws Exception {
        byte[] dataInBytes = decode(encryptedData);
        byte[] iv = new byte[12]; // 96-bit IV is standard for GCM
        System.arraycopy(dataInBytes, 0, iv, 0, iv.length);
        int encryptedSize = dataInBytes.length - iv.length;
        byte[] encryptedBytes = new byte[encryptedSize];
        System.arraycopy(dataInBytes, iv.length, encryptedBytes, 0, encryptedSize);

        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        try {
            AES_ENCRYPTION aes_encryption = new AES_ENCRYPTION();
            aes_encryption.init();

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter text to encrypt:");
            String userInput = scanner.nextLine();  // Read user input

            String encryptedData = aes_encryption.encrypt(userInput);
            String decryptedData = aes_encryption.decrypt(encryptedData);

            System.out.println("Encrypted Data : " + encryptedData);
            System.out.println("Decrypted Data : " + decryptedData);

            scanner.close();  // Close the scanner
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/











