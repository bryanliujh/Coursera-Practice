package Week9;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private List<String> elems;
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;
    
    //Not a 100% correct way as buckets count is not used, best is to create a List of HashNode
    //Basically the integer is the hash, and the arraylist contains all the chain of words
    private HashMap<Integer, ArrayList<String>> chainHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        out.flush();
    }

    private void processQuery(Query query) {
    	ArrayList<String> listStr = new ArrayList<>();
    	int key;
    	
        switch (query.type) {
            case "add":
            	key = hashFunc(query.s);
            	if (chainHashMap.get(key) == null) {
            		listStr.add(0, query.s);
            		chainHashMap.put(key, listStr);
            	} else {
            		listStr = chainHashMap.get(key);
            		if (!listStr.contains(query.s)) {
            			listStr.add(0, query.s);
            		}
            	}
            	/*
                if (!elems.contains(query.s))
                    elems.add(0, query.s);*/
                break;
            case "del":
            	key = hashFunc(query.s);
            	if (chainHashMap.get(key) != null) {
            		listStr = chainHashMap.get(key);
            		listStr.remove(query.s);
            		chainHashMap.put(key, listStr);
            	}
            	/*
                if (elems.contains(query.s))
                    elems.remove(query.s);*/
            	
                break;
            case "find":
            	key = hashFunc(query.s);
            	if (chainHashMap.get(key) != null) {
            		listStr = chainHashMap.get(key);
            		if (listStr.contains(query.s)) {
            			writeSearchResult(true);
            		} else {
            			writeSearchResult(false);
            		}
            	} else {
            		writeSearchResult(false);
            	}
                
                break;
            case "check":
            	key = query.ind;
            	if (chainHashMap.get(key) != null) {
            		listStr = chainHashMap.get(key);
            		for (String cur : listStr) {
            			out.print(cur + " ");
            		}
            		out.println();
            	} else {
            		out.println();
            	}
            	/*
                for (String cur : elems)
                    if (hashFunc(cur) == query.ind)
                        out.print(cur + " ");*/
                
                // Uncomment the following if you want to play with the program interactively.
                out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        elems = new ArrayList<>();
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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