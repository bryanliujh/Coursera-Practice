package Week1_2;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;
        
        int max_index = -1;
        int max_index_2 = -1;
        
        for (int i=0; i<n; i++) {
        	if ((max_index == -1) || (numbers[max_index] < numbers[i])) {
        		max_index = i;
        	}
        }
       
        
        for (int j=0; j<n; j++) {
        	if ((j != max_index) && ((max_index_2 == -1) || (numbers[max_index_2] < numbers[j]))) {
        		max_index_2 = j;
        	}
        }
        
        
        max_product = (long) numbers[max_index] * numbers[max_index_2];
       

        return max_product;
    }

    public static void main(String[] args) {
    	
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
    	
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
