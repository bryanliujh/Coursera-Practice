import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      int size = data.length;
      for (int i=size/2; i>-1; i--) {
    	  SiftDown(i, size);
      }
     
      
    }
    
    
    private int getLeftChildIndex(int parentIndex) {
    	return 2 * parentIndex + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
    	return 2 * parentIndex + 2;
    }
    
    private void SiftDown(int i, int size) {
    	int minIndex = i;
    	int l = getLeftChildIndex(i);
    	
    	//if left child is within index range and value of left child is lesser than value of minimum index
    	//let min index be l
    	if (l <= size - 1 && data[l] < data[minIndex]) {
    		minIndex = l;
    	}
    	
    	int r = getRightChildIndex(i);
    	if (r <= size - 1 && data[r] < data[minIndex]) {
    		minIndex = r;
    	}
    	
    	//if min index is swapped and no longer i then append the swap history
    	if (i != minIndex) {
    		int temp = data[i];
    		data[i] = data[minIndex];
    		data[minIndex] = temp;
    		swaps.add(new Swap(i, minIndex));
    		SiftDown(minIndex, size);
    	}

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
