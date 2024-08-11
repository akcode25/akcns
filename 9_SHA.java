import java.security.*;
import java.util.*;

public class SHA {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Msg to hash: ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] hashBytes = md.digest(text.getBytes());  //UTF-8
        StringBuilder hexStr = new StringBuilder();

        for (byte b: hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexStr.append('0');
            hexStr.append(hex);
        }
        System.out.println("SHA-512 hash: "+hexStr.toString());
    }
}
