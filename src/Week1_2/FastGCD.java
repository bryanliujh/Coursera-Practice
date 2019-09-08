package Week1_2;

public class FastGCD {
	//Efficient Greatest Common Divisor, each step reduce problem by a factor of 2 (log)
	//Using euclidean algorithm https://www.youtube.com/watch?v=H_2_nqKAZ5w
	//GCD(a,b) = GCD(b, a_prime) where a_prime = remainder of a/b
	public static long GCD(long a, long b) {
		long a_prime;
		
		if (b == 0) {
			return a;
		}
		
		a_prime = a%b;
		
		return GCD(b,a_prime);
	}
	
	public static void main (String[] args) {
		System.out.println(GCD(3918848,1653264));
	}
}
