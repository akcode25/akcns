// import java.util.LinkedHashSet;
// import java.util.Scanner;
// import java.util.Set;

import java.util.*;
public class PlayfairCipher {
    private char[][] matrix = new char[5][5];

    public PlayfairCipher(String key) {
        Set<Character> charset = new LinkedHashSet<>();  //(excluding 'J' neeche)
        for (char c : (key.toUpperCase() + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray()) 
            if (c >= 'A' && c <= 'Z' && c != 'J') charset.add(c);
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
        // text = text.toUpperCase().replace('J', 'I');
        if (text.length() % 2 != 0) text += 'X';  //pairing

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            if (a == b) b = 'X';
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) {         //same row
                result.append(matrix[posA[0]][(posA[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(matrix[posB[0]][(posB[1] + (encrypt ? 1 : 4)) % 5]);
            } 
            else if (posA[1] == posB[1]) {    //same col
                result.append(matrix[(posA[0] + (encrypt ? 1 : 4)) % 5][posA[1]]);
                result.append(matrix[(posB[0] + (encrypt ? 1 : 4)) % 5][posB[1]]);
            } 
            else {                            //rectangle swap
                result.append(matrix[posA[0]][posB[1]]);
                result.append(matrix[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }
    public String encrypt(String pt) {
        return processText(pt, true);
    }
    public String decrypt(String ct) {
        return processText(ct, false);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter key: ");
        String key = sc.nextLine();
        System.out.print("Enter plaintext: ");
        String pt = sc.nextLine();

        PlayfairCipher cipher = new PlayfairCipher(key);

        String ct = cipher.encrypt(pt);
        System.out.println("\nEncrypted text: " + ct);
        String dt = cipher.decrypt(ct);
        System.out.println("Decrypted text: " + dt);

        sc.close();
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

