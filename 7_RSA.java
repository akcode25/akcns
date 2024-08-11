import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the message to be encrypted: ");
		int msg = sc.nextInt();
		System.out.print("Enter the first prime number (p): ");
		int p = sc.nextInt();
		System.out.print("Enter the second prime number (q): ");
		int q = sc.nextInt();

		int n = p * q;
		int z = (p - 1) * (q - 1);     //ϕ(n)
		
		int d = 0;  //private key
		for (d = 2; d < z; d++) 
			if (gcd(d, z) == 1) break;    //=> d, z - relatively prime

		int e = 0;  //public key
		for (int i = 0; i <= 9; i++) {
			int x = 1 + (i * z);
			if (x % d == 0) {
				e = x / d;
				break;
			}
		}

		BigInteger M = BigInteger.valueOf(msg);
		BigInteger N = BigInteger.valueOf(n);
		BigInteger C = M.modPow(BigInteger.valueOf(e), N);  //C = (M^e) mod n
		BigInteger D = C.modPow(BigInteger.valueOf(d), N);  //M = (C^d) mod n

		System.out.println("\nEncrypted message is : " + C);
		System.out.println("Decrypted message is : " + D);  //.intValue()
		sc.close();
	}

	static int gcd(int a, int b) {
		if (a == 0) return b;
		else return gcd(b % a, a);
	}
}
//(any number < 9) , 3, 5

// 2,3,5 //2,3,11



/*
import java.math.*;
import java.util.*;

class RSA {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted:");
        int msg = scanner.nextInt();
        System.out.println("Enter the first prime number (p):");
        int p = scanner.nextInt();
        System.out.println("Enter the second prime number (q):");
        int q = scanner.nextInt();
        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);

        int d;
        for (d = 2; d < z; d++) {
            if (gcd(d, z) == 1) {
                break;
            }
        }
        System.out.println("the value of d = " + d);

        int e = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % d == 0) {
                e = x / d;
                break;
            }
        }
        System.out.println("the value of e = " + e);

        double c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : " + msgback);

        scanner.close();
    }
    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e,e);
}
}
*/


