import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int current_dist = 0;
    	int estimated_dist;
    	int num_refill = 0;
    	int current_refill = 0;
    	int last_refill;
    	int distance_travelled = 0;
    	int n = stops.length;
    	
    	System.out.println(n);
    	
    	if (tank >= dist) {
    		return 0;
    	}
    	
    	while (current_refill <= n-5) {
    		last_refill = current_refill;
    		while(current_refill <=n && (stops[current_refill+1] - stops[last_refill] <= dist)) {
    			current_refill++;
    		}
    		
    		if (current_refill <=n) {
    			num_refill++;
    		}
    	}
    	
    	/*
    	for (int i=0; i<stops.length; i++) {
    		estimated_dist = current_dist+tank;
    		if (estimated_dist < stops[i]) {
    			current_dist += stops[i-1];
    			if (current_dist+tank < stops[i]) {
    				return -1;
    			}
    			num_refills++;
    		} 
    	}*/
    	
        return num_refill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }*/
        
       
        
        int dist = 950;
        int tank = 400;
        int stops[] = {200, 375, 550, 750};

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
