import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
    	boolean[] visited = new boolean[adj.length];
    	explore(x, adj, visited);
    	if (visited[y]) {
    		return 1;
    	}
        return 0;
    }
    
    private static void explore(int x, ArrayList<Integer>[] adj, boolean[] visited) {
    	visited[x] = true;
    	for (int i=0; i<adj[x].size(); i++) {
    		if (!visited[adj[x].get(i)]) {
    			explore(adj[x].get(i), adj, visited);
    		}
    	}
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

