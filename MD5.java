import java.security.MessageDigest;
import java.util.Scanner;
public class MD5{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text to hash: ");
        String text = sc.nextLine();
            MessageDigest md = MessageDigest.getInstance("MD5");           
            byte[] messageDigest = md.digest(text.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println("MD5 Hash: " + hexString.toString());
    }
}

