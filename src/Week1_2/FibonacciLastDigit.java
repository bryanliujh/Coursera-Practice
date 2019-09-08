package Week1_2;
import java.util.*;

public class FibonacciLastDigit {
	  private static long calc_fib(int n) {
			if (n <= 1) {
					return n;
				}

			long[] fibArr = new long[n+1];
			fibArr[0] = 0;
			fibArr[1] = 1;

			for (int i = 2; i <= n; i++) {
				fibArr[i] = (fibArr[i - 1] + fibArr[i - 2])%10;
			}

			return fibArr[n];
		  }

		  public static void main(String args[]) {
		    Scanner in = new Scanner(System.in);
		    int n = in.nextInt();

		    System.out.println(calc_fib(n));
		  }
		}
