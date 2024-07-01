
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class PlayfairCipher {
    private char[][] matrix = new char[5][5];

    public PlayfairCipher(String key) {
        Set<Character> charset = new LinkedHashSet<>();
        for (char c : (key.toUpperCase() + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray()) {
            if (c >= 'A' && c <= 'Z' && c != 'J') charset.add(c);
        }
        int i = 0;
        for (char c : charset) matrix[i / 5][i++ % 5] = c;
    }
    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c) return new int[]{i, j};
        return null;
    }

    private String processText(String text, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        if (text.length() % 2 != 0) text += 'X';
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            if (a == b) b = 'X';
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);
            if (posA[0] == posB[0]) {
                result.append(matrix[posA[0]][(posA[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(matrix[posB[0]][(posB[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(matrix[(posA[0] + (encrypt ? 1 : 4)) % 5][posA[1]]);
                result.append(matrix[(posB[0] + (encrypt ? 1 : 4)) % 5][posB[1]]);
            } else {
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }
    public String encrypt(String plaintext) {
        return processText(plaintext, true);
    }
    public String decrypt(String ciphertext) {
        return processText(ciphertext, false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key:");
        String key = scanner.nextLine();
        System.out.println("Enter the plaintext:");
        String plaintext = scanner.nextLine();
        PlayfairCipher cipher = new PlayfairCipher(key);
        String ciphertext = cipher.encrypt(plaintext);
        System.out.println("Encrypted text: " + ciphertext);
        String decryptedText = cipher.decrypt(ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
        scanner.close();
    }
}


/*
op: 

Enter the key:
wearetogether         (monarchy)
Enter the plaintext:
go                    (nitte meeanshi institute of technology)
Encrypted text: HG
Decrypted text: GO
 */

