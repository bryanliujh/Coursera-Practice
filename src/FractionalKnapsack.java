import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap; 
import java.util.TreeMap; 

/**
 * 
 * @author bryanliu
 *
 *The first line of the input contains the number 𝑛 of items and the capacity 𝑊 of a knapsack. 
 *The next 𝑛 lines define the values and weights of the items. The 𝑖-th line contains integers 𝑣𝑖 
 *and 𝑤𝑖—the value and the weight of 𝑖-th item, respectively.
 * 
 * input
 * 3 (max no.of items) 50 (weight)
 * 60 (value) 20 (weight)
 * 100 50
 * 120 30
 * 
 *
 *output 
 *180 (first item and third item)
 *
 */
public class FractionalKnapsack {
	//public static double value;
	//public static int g_capacity;
	
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int g_capacity = capacity;
        
        //write your code here
        if (capacity == 0) {
        	return value;
        }
       
        //sort the items by values/weights
        SortedMap<Double, Integer> sm = new TreeMap<Double, Integer>(Collections.reverseOrder());
        for (int i = 0; i<weights.length; i++) {
            sm.put((double)values[i]/weights[i], weights[i]);
        }
        for (Map.Entry<Double, Integer> pair: sm.entrySet()) {
        	//value = retValue(pair.getKey(),pair.getValue(),value, g_capacity);
        	double k = pair.getKey();
        	int v = pair.getValue();
        	while (v != 0 && g_capacity !=0) {
        		value += k;
        		v--;
        		g_capacity--;
        	}
        		
        }
        
        /*
        sm.forEach((k,v) -> {
        	value = retValue(k,v);
        });*/

        return (double)Math.round(value * 10000d) / 10000d;
    }
    
    /*
    
    
    static double retValue(double k, int v, double value, int g_capacity) {
    	
    	return value;
    	//System.out.println("Key: " + k + " Value: " + v);
    	
    }
    */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        //int capacity = 1000;
        
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        /*
        int[] values = {500};
        int[] weights = {30};*/
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
