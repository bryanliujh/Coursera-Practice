import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		ArrayList<Integer> result_inorder = new ArrayList<Integer>();
		ArrayList<Integer> result_preorder = new ArrayList<Integer>();
		ArrayList<Integer> result_postorder = new ArrayList<Integer>();
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			inOrderTraversal(0);
                        
			return result_inorder;
		}
		
		void inOrderTraversal(int root){
			if (left[root] != -1) {
				inOrderTraversal(left[root]);
			}
			result_inorder.add(key[root]);
			if (right[root] != -1) {
				inOrderTraversal(right[root]);
			}
		}

		List<Integer> preOrder() {
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
                    
			preOrderTraversal(0);
			return result_preorder;
		}
		
		void preOrderTraversal(int root){
			result_preorder.add(key[root]);
			if (left[root] != -1) {
				preOrderTraversal(left[root]);
			}
			if (right[root] != -1) {
				preOrderTraversal(right[root]);
			}
		}

		List<Integer> postOrder() {
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			postOrderTraversal(0);
			
			return result_postorder;
		}
		
		void postOrderTraversal(int root){
			if (left[root] != -1) {
				postOrderTraversal(left[root]);
			}
			if (right[root] != -1) {
				postOrderTraversal(right[root]);
			}
			result_postorder.add(key[root]);
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
