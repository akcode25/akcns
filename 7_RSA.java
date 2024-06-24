
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



//2,3,5




/*
import java.math.*;

class RSA {
	public static void main(String args[])
	{
		int p, q, n, z, d = 0, e, i;

		// The number to be encrypted and decrypted
		int msg = 2;
		double c;
		BigInteger msgback;

		// 1st prime number p
		p = 3;

		// 2nd prime number q
		q = 11;//5
		n = p * q;
		z = (p - 1) * (q - 1);
		System.out.println("the value of z = " + z);

		for (e = 2; e < z; e++) {

			// e is for public key exponent
			if (gcd(e, z) == 1) {
				break;
			}
		}
		System.out.println("the value of e = " + e);
		for (i = 0; i <= 9; i++) {
			int x = 1 + (i * z);

			// d is for private key exponent
			if (x % e == 0) {
				d = x / e;
				break;
			}
		}
		System.out.println("the value of d = " + d);
		c = (Math.pow(msg, e)) % n;
		System.out.println("Encrypted message is : " + c);

		// converting int value of n to BigInteger
		BigInteger N = BigInteger.valueOf(n);

		// converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback = (C.pow(d)).mod(N);
		System.out.println("Decrypted message is : "
						+ msgback);
	}

	static int gcd(int e, int z)
	{
		if (e == 0)
			return z;
		else
			return gcd(z % e, e);
	}
}
*/

