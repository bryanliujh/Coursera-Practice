import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		int totLen[];
		
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			totLen = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int lengthOfPath(int i) {
			int parent_element = parent[i];
			
			if (parent_element == -1) {
				return 1;
			}
			
			//cache those lengths that are already calculated to make it more efficient
			if (totLen[parent_element] != 0) {
				return totLen[parent_element];
			}
			
			totLen[parent_element] = 1 + lengthOfPath(parent_element); 
			
			return totLen[parent_element];
		}
		
		
		int computeHeight() {
			int maxHeight = 0;
			for (int i=0; i<parent.length; i++) {
				if (lengthOfPath(i) > maxHeight) {
					maxHeight = lengthOfPath(i);
				}
			}
			
			return maxHeight;	
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
