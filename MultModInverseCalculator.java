import java.util.Scanner;

public class MultModInverseCalculator {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number whose inverse you would like to find.");
		int base = input.nextInt();
		System.out.println("Enter the modulo with which to find the inverse.");
		int mod = input.nextInt();
		if(GCD(base,mod)!=1)
		{
			System.out.println("There is no modular multiplicative inverse of " + base + " mod " + mod + ".");
			System.exit(0);
		}

		int[] coefficients = new int[2];
		coefficients = findInverse(base,mod);
		if(base*coefficients[0]%mod == 1)
		{
			System.out.println("The multiplicative inverse of your number is: " + coefficients[0]);
		}
		else
		{
			System.out.println("The multiplicative inverse of your number is: " + coefficients[1]);	
		}
	}

	/**
	 * Finds the coefficients of ax+by=d for a (mod b) where d is the gcd(a,b)
	 * @param a is the base of which we want the inverse
	 * @param b is the modulo
	 * @return the array of coefficients
	 */
	public static int[] findInverse(int a, int b)
	{
		int x = 0, y = 1, lastx = 1, lasty = 0;
		while(b!=0)
		{
			int quotient = a/b;

			int temp = a;
			a = b;
			b=temp%b;

			temp = x;
			x=lastx-quotient*x;
			lastx=temp;

			temp = y;
			y=lasty-quotient*y;
			lasty=temp;
		}

		int[] coefficients = {lastx, lasty, a};
		return coefficients;
	}
	/**
	 * Finds the gcd of a and b
	 * @param a is one number
	 * @param b is the second number
	 * @return the greatest common divisor of the two inputs
	 */
	public static long GCD (int a, int b) {

		long gcd = 0;
		int r = 0;

		a = Math.abs (a);
		b = Math.abs (b);

		while (true) {
			if (b == 0) {
				gcd = a;
				break;
			}
			else {
				r = a % b;
				a = b;
				b = r;
			}
		}

		return gcd;

	}
}