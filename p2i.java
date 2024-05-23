import java.awt.Point; 
import java.util.Scanner; 
public class p2i 
{ 
private int length = 0; 
private String [][] table; 
public static void main(String args[]) 
{ 
p2i pf = new p2i(); 
} 

private p2i() 
{ 
System.out.print("Enter the key for playfair cipher: "); 
Scanner sc = new Scanner(System.in); 
String key = parseString(sc); 
while(key.equals("")) 
key = parseString(sc); 
table = this.cipherTable(key); 
System.out.print("Enter the plaintext to be encipher: "); 
String input = parseString(sc); 
while(input.equals("")) 
input = parseString(sc); 
String output = cipher(input); 
String decodedOutput = decode(output); 
//output the results to user 
this.keyTable(table); 
this.printResults(output,decodedOutput); 
} 

//parses an input string to remove numbers, punctuation, 
//replaces any J's with I's and makes string all caps 
private String parseString(Scanner sc) 
{ 
String parse = sc.nextLine(); 
//converts all the letters in upper case 
parse = parse.toUpperCase(); 
//the string to be substituted by space for each match (A to Z) 
parse = parse.replaceAll("[^A-Z]", ""); 
//replace the letter J by I 
parse = parse.replace("J", "I"); 
return parse; 
} 
//creates the cipher table based on some input string (already parsed) 
private String[][] cipherTable(String key) 
{ 
//creates a matrix of 5*5 
String[][] playfairTable = new String[5][5]; 
String keyString = key + 
"ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
//fill string array with empty string 
for(int i = 0; i < 5; i++) //rows
for(int j = 0; j < 5; j++) //columns
playfairTable[i][j] = ""; 
for(int k = 0; k < keyString.length(); k++) 
{ 
boolean repeat = false; //to see whether a character is already being placed in table
boolean used = false; //to see if a character has been successfully placed in the table
for(int i = 0; i < 5; i++) 
{ 
for(int j = 0; j < 5; j++) 
{ 
if(playfairTable[i][j].equals("" + keyString.charAt(k))) 
{ 
repeat = true; 
} 
else if(playfairTable[i][j].equals("") && !repeat && !used) 
{ 
playfairTable[i][j] = "" + keyString.charAt(k); 
used = true; 
} 
} 
} 
} 
return playfairTable; 
} 
//cipher: takes input (all upper-case), encodes it, and returnsthe output 
private String cipher(String in) 
{ 
length = (int) in.length() / 2 + in.length() % 2; //ensures that input string is in even length to divide it into pairs(or) digraphs
//insert x between double-letter digraphs & redefines "length" 
for(int i = 0; i < (length - 1); i++) //loops over each pair of characters
{ 
if(in.charAt(2 * i) == in.charAt(2 * i + 1)) 
{ 
in = new StringBuffer(in).insert(2 * i + 1, 'X').toString(); 
length = (int) in.length() / 2 + in.length() % 2; 
} 
} 
//------------makes plaintext of even length-------------- 
//creates an array of digraphs 
String[] digraph = new String[length]; 
//loop iterates over the plaintext 
for(int j = 0; j < length ; j++) 
{ 
//checks the plaintext is of even length or not 
if(j == (length - 1) && in.length() / 2 == (length - 1)) 
//if not addends X at the end of the plaintext 
in = in + "X";

digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1); //converting char to string and storing in digraph array
} 
//encodes the digraphs and returns the output 
String out = ""; 
String[] encDigraphs = new String[length]; 
encDigraphs = encodeDigraph(digraph); 
for(int k = 0; k < length; k++) 
out = out + encDigraphs[k]; 
return out; 
} 
//---------------encryption logic----------------- 
//encodes the digraph input with the cipher's specifications 
private String[] encodeDigraph(String di[]) 
{ 
String[] encipher = new String[length]; 
for(int i = 0; i < length; i++) 
{ 
char a = di[i].charAt(0); 
char b = di[i].charAt(1); 
int r1 = (int) getPoint(a).getX(); //row index
int r2 = (int) getPoint(b).getX(); //row index
int c1 = (int) getPoint(a).getY(); //column index
int c2 = (int) getPoint(b).getY(); //column index
//executes if the letters of digraph appear in the same row 
//in such case shift columns to right 
if(r1 == r2) 
{ 
c1 = (c1 + 1) % 5; 
c2 = (c2 + 1) % 5; 
} 
//executes if the letters of digraph appear in the same column 
//in such case shift rows down 
else if(c1 == c2) 
{ 
r1 = (r1 + 1) % 5; 
r2 = (r2 + 1) % 5; 
} 
//executes if the letters of digraph appear in the different row and different column 
//in such case swap the first column with the second column
else 
{ 
int temp = c1; 
c1 = c2; 
c2 = temp; 
} 
//performs the table look-up and puts those values into the encoded array 
encipher[i] = table[r1][c1] + "" + table[r2][c2]; 
} 
return encipher; 
} 
//-----------------------decryption logic--------------------- 
// decodes the output given from the cipher and decode methods (opp. of encoding process) 
private String decode(String out) 
{ 
String decoded = ""; 
for(int i = 0; i < out.length() / 2; i++) 
{ 
char a = out.charAt(2*i); 
char b = out.charAt(2*i+1); 
int r1 = (int) getPoint(a).getX(); 
int r2 = (int) getPoint(b).getX(); 
int c1 = (int) getPoint(a).getY(); 
int c2 = (int) getPoint(b).getY(); 
if(r1 == r2) 
{ 
c1 = (c1 + 4) % 5; 
c2 = (c2 + 4) % 5; 
} 
else if(c1 == c2) 
{ 
r1 = (r1 + 4) % 5; 
r2 = (r2 + 4) % 5; 
} 
else 
{ 
//swapping logic 
int temp = c1; 
c1 = c2; 
c2 = temp; 
} 
decoded = decoded + table[r1][c1] + table[r2][c2]; 
} 
return decoded; 
} 

private Point getPoint(char c) //returns a point object,which stores row and column indices of char c
{ 
Point pt = new Point(0,0); 
for(int i = 0; i < 5; i++) 
for(int j = 0; j < 5; j++) 
if(c == table[i][j].charAt(0)) 
pt = new Point(i,j); 
return pt; 
} 

private void keyTable(String[][] printTable) 
{ 
System.out.println("Playfair Cipher Key Matrix: "); 
System.out.println(); 
for(int i = 0; i < 5; i++) 
{ 
//loop iterates for column 
for(int j = 0; j < 5; j++) 
{ 
//prints the key-table in matrix form 
System.out.print(printTable[i][j]+" "); 
} 
System.out.println(); 
} 
System.out.println(); 
}

private void printResults(String encipher, String dec) 
{ 
System.out.print("Encrypted Message: "); 
System.out.println(encipher); 
System.out.println(); 
System.out.print("Decrypted Message: "); 
System.out.println(dec); 
} 
}
