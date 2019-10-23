import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;
        ArrayList<Integer> inOrderArrayList = new ArrayList<Integer>();
        int[] key, left, right;
        boolean redflag;
        
        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            if (nodes > 0) {
	            key = new int[nodes];
				left = new int[nodes];
				right = new int[nodes];
	            //tree = new Node[nodes];
	            for (int i = 0; i < nodes; i++) {
	                //tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
	            	key[i] = in.nextInt();
					left[i] = in.nextInt();
					right[i] = in.nextInt();
	            }
            } else {
            	key = new int[1];
				left = new int[1];
				right = new int[1];
				
				key[0] = 0;
				left[0] = -1;
				right[0] = -1;
				
            }
        }
        
        void inOrderTraversal(int root) {
        	if (left[root] != -1) {
        		if (key[left[root]] >= key[root]) {
        			redflag = true;
        		} 
        		inOrderTraversal(left[root]);
        	}
        	inOrderArrayList.add(key[root]);
        	if (right[root] != -1) {
        		inOrderTraversal(right[root]);
        	}
        	
        }

        boolean isBinarySearchTree() {
          // Implement correct algorithm here
          inOrderTraversal(0);
          
          if (redflag) {
        	  return false;
          }
          
          //copy arraylist like this
          ArrayList<Integer> in_order_unsort = new ArrayList<Integer>(inOrderArrayList.size());
          for (int i : inOrderArrayList) {
        	  in_order_unsort.add(i);
          }
          
          Collections.sort(inOrderArrayList);
          
          return inOrderArrayList.equals(in_order_unsort);
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
