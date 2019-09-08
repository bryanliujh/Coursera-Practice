package Week1_2;
import java.util.*;
//The product of the two numbers is the product of the LCM and the GCD.
public class LCM {
	public static long GCD(long a, long b) {
		long a_prime;
		
		if (b == 0) {
			return a;
		}
		
		a_prime = a%b;
		
		return GCD(b,a_prime);
	}
	
	
  private static long calc_lcm(long a, long b) {
	  return (long)(a*b / GCD(a,b));
  
  }
  public static void main(String args[]) {
	    Scanner scanner = new Scanner(System.in);
	    long a = scanner.nextInt();
	    long b = scanner.nextInt();

	    System.out.println(calc_lcm(a, b));
	  }

}
