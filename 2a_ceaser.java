import java.util.*;
class p2a{
    static String encrypt (String s, int key){
        String ans="";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i); 
            char add= '.';
            if(Character.isUpperCase(c))
                add= (char)('A'+(c-'A'+key)%26);
            else if (Character.isLowerCase(c))
                add=(char)('a'+(c-'a'+key)%26);
            else 
                add=c;
            ans+=add;
        }
        return ans;
    }

    static String decryp(String s, int key){
        return encrypt(s, 26-key);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter thh plaintext: ");
        String pt= sc.nextLine();
        System.out.println("Enter thh key: ");
        int key= sc.nextInt();  //shift
        sc.close();
        String en=encrypt(pt, key);
        System.out.println("\nEncrypted text is: "+en);
        System.out.println("\nThe decrypted msg is: "+decryp(en, key));
    }

}