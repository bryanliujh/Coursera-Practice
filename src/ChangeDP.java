import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int amount) {
        //write your code here
    	int[] coins = {1, 3, 4};
    	
    	//fill the rest of the array element (except first one) with default values
    	int max = amount + 1;
    	
    	//array to store the sub problems (amount + 1 size because need to have 0)
    	int[] dp = new int[amount + 1];
    	Arrays.fill(dp, max);
    	
    	//min number of coins for 0 is 0
    	dp[0] = 0;
    	
    	for(int i = 1; i <= amount; i++) {
    		for (int j = 0; j < coins.length; j++) {
    			//if less than or equal to the subproblem amount try it
    			if (coins[j] <= i) {
    				//use the counter stored in previous dp amount, it is a dynamic programming approach
    				//where we use the subproblem answer to build up to the main problem
    				//need to add 1 because, since we use the coin, we need to add to the counter
    				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
    			}
    		}
    	}
    	
    	//return -1 if we got no answer, since dp[amount] = max if no answer
    	if (dp[amount] > amount) {
    		return -1;
    	}
    	
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        System.out.println(getChange(amount));

    }
}

