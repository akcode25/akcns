import java.security.MessageDigest;
import java.util.Scanner;
public class SHA {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message to be hashed: ");
        String text = sc.nextLine();
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            // digest.update(text.getBytes("UTF-8"));
            // byte[] hashBytes = digest.digest();
            byte[] hashBytes = md.digest(text.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("SHA-512 Hash: " + hexString.toString());  
    }
}

/*
//or,
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA {
    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to hash: ");
        String input = scanner.nextLine();
        System.out.println("\nSHA-512 Hash: " + encrypt(input));
    }
}
*/


