import java.util.*;

public class LCS2 {
	
    private static int lcs2(int[] a, int[] b) {
        //Write your code here
    	/*
    	 * a will be the rows while b will be the cols
    	 * +1 to leave room for " "
    	 * 
    	 */
    	
    	int dp[][] = new int[a.length + 1][b.length + 1];
    	
    	for (int aRow = 0; aRow <= a.length; aRow++) {
    		for (int bCol = 0; bCol <= b.length; bCol++) {
    			if (aRow == 0 || bCol == 0) {
    				/*
    	            Base case...empty strings being solved against.
    	              lcs("", anything...) == 0
    	              lcs(anything..., "") == 0
    	              lcs("", "") == 0
    	          */
    				dp[aRow][bCol] = 0;
    			} else if (a[aRow - 1] == b[bCol - 1]) {
    				/*
    				 * aRow/bCol will not be negative since above check for 0
    				 * Character matched and remove both and lengthen by 1
    				 */
    				dp[aRow][bCol] = dp[aRow - 1][bCol - 1] + 1;
    			} else {
    				/*
    				 * character mismatched, take the max
    				 */
    				dp[aRow][bCol] = Math.max(dp[aRow - 1][bCol], dp[aRow][bCol -1]);
    			}
    		}
    		
    	}
    	
    	
        return dp[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

