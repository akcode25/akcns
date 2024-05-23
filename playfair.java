import java.util.Scanner;

public class playfair {
            private char[][] matrix;
            private String key;
            private String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
            public playfair(String key) {
                this.key = key.toUpperCase().replaceAll("[^A-Z]", "");
                this.matrix = generateMatrix();
            }
            private char[][] generateMatrix() {
                char[][] a = new char[5][5];
                String keyStr = this.key + this.alphabet;
                int row = 0;
                int col = 0;
                for (int i = 0; i < keyStr.length(); i++) {
                    char c = keyStr.charAt(i);
                    if (col == 5) {
                        col = 0;
                        row++;
                    }
                    if (row == 5) break;
                    if (!contains(a, c)) {
                        a[row][col] = c;
                        col++;
                    }
                }
                return a;
            }
            private boolean contains(char[][] a, char c) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (a[i][j] == c) return true;
                    }
                }
                return false;
            }
            public String encrypt(String pt) {
                pt = pt.toUpperCase().replaceAll("[^A-Z]", "");
                pt = pt.replaceAll("J", "I");
                String ciphertext = new String();
                for (int i = 0; i < pt.length(); i += 2) {
                    char a = pt.charAt(i);
                    char b = (i + 1 < pt.length()) ? pt.charAt(i + 1) : 'X';
                    int[] posA = findPosition(a);
                    int[] posB = findPosition(b);
                    char encryptedA, encryptedB;
                    if (posA[0] == posB[0]) {
                        encryptedA = matrix[posA[0]][(posA[1] + 1) % 5];
                        encryptedB = matrix[posB[0]][(posB[1] + 1) % 5];
                    } else if (posA[1] == posB[1]) {
                        encryptedA = matrix[(posA[0] + 1) % 5][posA[1]];
                        encryptedB = matrix[(posB[0] + 1) % 5][posB[1]];
                    } else {
                        encryptedA = matrix[posA[0]][posB[1]];
                        encryptedB = matrix[posB[0]][posA[1]];
                    }
                    ciphertext+=encryptedA;
                    ciphertext+=encryptedB;
                }
                return ciphertext.toString();
            }
            public String decrypt(String ciphertext) {
                String plaintext = new String();
                for (int i = 0; i < ciphertext.length(); i += 2) {
                    char a = ciphertext.charAt(i);
                    char b = ciphertext.charAt(i + 1);
                    int[] posA = findPosition(a);
                    int[] posB = findPosition(b);
                    char decryptedA, decryptedB;
                    if (posA[0] == posB[0]) {
                        decryptedA = matrix[posA[0]][(posA[1] + 4) % 5];
                        decryptedB = matrix[posB[0]][(posB[1] + 4) % 5];
                    } else if (posA[1] == posB[1]) {
                        decryptedA = matrix[(posA[0] + 4) % 5][posA[1]];
                        decryptedB = matrix[(posB[0] + 4) % 5][posB[1]];
                    } else {
                        decryptedA = matrix[posA[0]][posB[1]];
                        decryptedB = matrix[posB[0]][posA[1]];
                    }
                    plaintext+=decryptedA;
                    plaintext+=decryptedB;
                }
                return plaintext.toString();
            }
            private int[] findPosition(char c) {
                int[] pos = new int[2];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (matrix[i][j] == c) {
                            pos[0] = i;
                            pos[1] = j;
                            return pos;
                        }
                    }
                }
                return pos;
            }
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the key:");
                String key = scanner.nextLine();
                System.out.println("Enter the plaintext:");
                String plaintext = scanner.nextLine();
                playfair cipher = new playfair(key);
                String ciphertext = cipher.encrypt(plaintext);
                System.out.println("Encrypted text: " + ciphertext);
                String decryptedText = cipher.decrypt(ciphertext);
                System.out.println("Decrypted text: " + decryptedText);
                scanner.close();
    }

}
