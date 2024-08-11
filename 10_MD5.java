import java.security.MessageDigest;
import java.util.Scanner;

public class MD5{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text to hash: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] mdBytes = md.digest(text.getBytes());
        StringBuilder hexStr = new StringBuilder();

        for (byte b: mdBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexStr.append('0');
            hexStr.append(hex);
        }
        System.out.println("MD5 hash: " + hexStr.toString());
    }
}


