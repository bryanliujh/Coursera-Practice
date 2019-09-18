import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
    	int maj_element = -1;
    	
        if (left == right) {
            return maj_element;
        }
        if (left + 1 == right) {
            return a[left];
        }
        
        HashMap<Integer, Integer> majority_dict = new HashMap<Integer, Integer>();
        
        for (int i=left; i<right; i++) {
        	if (majority_dict.get(a[i]) != null) {
        		int current_val = majority_dict.get(a[i]) + 1;
        		majority_dict.put(a[i], current_val);
        	} else {
        		majority_dict.put(a[i], 1);
        	}
        	
        }
        HashMap.Entry<Integer,Integer> hm_max = null;
        
        for (HashMap.Entry<Integer,Integer> hm: majority_dict.entrySet()) {
        	//System.out.println("key: " + hm.getKey());
        	//System.out.println("val: " + hm.getValue());
        	if (hm_max == null || hm.getValue().compareTo(hm_max.getValue()) > 0) {
        		hm_max = hm;
        	}
        }
       
       if (hm_max != null && hm_max.getValue() > a.length/2) {
    	   maj_element = hm_max.getKey();
       }
       
       return maj_element;
              
      
    }

    public static void main(String[] args) {
    	
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        /*int[] a = {2,3,9,2,2};
        
        for (int i=0; i<n; i++) {
        	System.out.println(a[i]);
        }*/
        
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

