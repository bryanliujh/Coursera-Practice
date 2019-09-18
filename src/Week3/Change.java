package Week3;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
    	int[] coins = {10,5,1};
    	int counter = 0;
        //write your code here
    	for (int coin : coins) {
    		while (m - coin >= 0) {
    			m -= coin;
    			counter++;
    		}
    		
    	}
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


