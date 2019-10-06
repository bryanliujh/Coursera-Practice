import java.util.*;

public class Knapsack {
	
    private static int knapsackBottomUp(int maxWeightConstraint, int[] weights) {
    	int[] values = weights;
    	// + 1 for 0,0 colrow
    	int[][] cache = new int[weights.length+1][maxWeightConstraint+1];
    	
        for (int totalItems = 0; totalItems <= values.length; totalItems++) {
          for (int maxWeight = 0; maxWeight <= maxWeightConstraint; maxWeight++) {
            int currentItem = totalItems - 1;

            if (totalItems == 0 || maxWeight == 0) {
              cache[totalItems][maxWeight] = 0;
            } else if (weights[currentItem] > maxWeight) {
              // go up 1 row as weight of current item exceed max weight
              cache[totalItems][maxWeight] = cache[totalItems - 1][maxWeight];
            } else {
              // With Item -> Go up 1 row & left 'weights[totalItems - 1]' columns
              int withItem = values[currentItem] + cache[totalItems - 1][maxWeight - weights[totalItems - 1]];
              
              //Without Item -> Going up 1 row
              int withoutItem = cache[totalItems - 1][maxWeight];

              cache[totalItems][maxWeight] = Math.max(withItem, withoutItem);
            }
          }
        }

        return cache[values.length][maxWeightConstraint];
      }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        //W is the weight of the knapsack
        // w is the array of weight of each gold bar
        System.out.println(knapsackBottomUp(W, w));
    }
}

