package Week3;
import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	
    	int dist_travelled = 0;
    	int n = stops.length;
    	int i = 0;
    	int num_refill = 0;
    	
    	if (tank >= dist) {
    		return 0;
    	}
    	
    	while (dist_travelled + tank < dist) {
    		if (i<n && stops[i] <= dist_travelled + tank) {
    			i++;
    		} else if (i<n) {
    			dist_travelled = stops[i-1];
    			num_refill++;
    			if (dist_travelled + tank < stops[i]) {
    				return -1;
    			}
    		} else {
    			num_refill++;
    			dist_travelled = stops[i-1];
    			if (dist_travelled + tank < dist) {
    				return -1;
    			}
    		}
    	}
    	
    	
    	
        return num_refill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
       
        /*
        int dist = 10;
        int tank = 3;
        int stops[] = {1, 2, 5, 9};*/
        
        /*
        int dist = 950;
        int tank = 400;
        int stops[] = {200, 375, 550, 750};*/
        
        /*
        int dist = 700;
        int tank = 200;
        int stops[] = {100, 200, 300, 400};*/
        

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
