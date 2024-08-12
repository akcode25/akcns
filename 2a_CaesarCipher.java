// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

public class CaesarCipher {
    static Scanner sc = new Scanner(System.in);    //integer input (key)
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //string input (plaintext) 
    
    public static String processString(String str, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int direction = encrypt ? 1 : -1;

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) 
                ch = (char) ('A' + (ch - 'A' + direction * key + 26) % 26);
            else if (Character.isLowerCase(ch))
                ch = (char) ('a' + (ch-'a' + direction*key + 26) % 26);
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("\nEnter any String: ");
        String str = sc.nextLine();
        System.out.print("Enter the key: ");
        int key = sc.nextInt();
        
        String en = processString(str, key, true);
        System.out.print("Encrypted string: " + en);        
        String de = processString(en, key, false);
        System.out.print("\nDecrypted string: " + de);
    }
}

/*
Step 1: Convert the Character to Its Alphabet Position
            ch - 'A'

Step 2: Apply the Shift (Key) with Direction     
            (ch-'A') + direction * key +26        //so that +ve

Step 3: 0 to 25 only. (not >= 26)
            ((ch-'A') + direction*key +26) % 26

Step 4: ASCII value back
     ('A' + ((ch-'A') + direction*key +26) % 26)

Step 5: Convert Back to a Character
(char)('A' + ((ch-'A') + direction*key +26) % 26) 
*/
