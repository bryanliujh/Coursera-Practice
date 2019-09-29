import java.util.*;

/**
 * Edit distance is the min no. of operations to transform a string into another string
 * e.g. A = "horse" B = "ros"
 * 
 * horse -> rorse (replace "h" with r)
 * rorse -> rose (remove "r")
 * rose -> ros (remove "e")
 * 
 * edit distance = 3 operations
 * 
 * 
 * e.g. "horse"
 * (-1, 0) = " "
 * (0, 0) = "h"
 * (0, 1) = "ho"
 * (0, 2) = "hor"
 * (0, 3) = "hors"
 * (0, 4) = "horse"
 * 
 * 
 *-------------------------------------------
 * Situation 1: Do nothing
 * 
 * A[0, 5] -> B[0, 5]
 * "benyam"   "ephrem"
 * 
 * always look at last character (m), no operations needed because character same
 * 
 * 
 * A[0, 3] -> B[0, 2]
 * "beny"     "eph"
 * 
 * ----------------------------------------- 
 * Situation 2: Replace
 * 
 * A[0, 2] -> B[0, 1]
 * "ben"     "ep"
 * 
 * ignore the last character, transform ben to ep and replace last character y to h
 * 
 * ----------------------------------------- 
 * Situation 3: Insert
 * 
 * A[0, 3] -> B[0, 1]
 * "beny"     "ep"
 * 
 * transform beny to ep, then insert h at the end of ep
 * 
 * ----------------------------------------- 
 * Situation 4: Delete
 * 
 * A[0, 2] -> B[0, 2]
 * "ben"     "eph"
 * 
 * transform beny to eph and then delete the last character y
 * 
 */
  

/**
 * 
 * Implementation
 * 
 * 1) Create the dynamic programming table
 * 2) Initialise all entries to -1
 * 3) Begin the compuations (from top down in recursion)
 *
 *
 *   The dynamic programming table will hold the edit distance between prefixes of the strings.
 *   e.g.
 *   A: "benyam"
 *   B: "ephrem"
 *   
 *   Then (A_idx, B_idx) entry (3, 2) in the table compares the edit distance between
 *   strings "beny" (index 0 to 3) of A and "eph" (index 0 to 2) of string B.
 *
 *
 */


class EditDistance {

  public static int EditDistance(String A, String B) {
    //write your code here
	int[][] distanceBetweenPrefixes = new int[A.length()][B.length()];
	for (int[] row: distanceBetweenPrefixes) {
		Arrays.fill(row, -1);
	}
 
    return computeDistanceBetweenPrefixes(A, A.length() - 1, B, B.length() - 1, distanceBetweenPrefixes);
  }
  
  
  public static int computeDistanceBetweenPrefixes(String A, int A_idx, String B, int B_idx, int[][] distanceBetweenPrefixes) {
	
	  
	//if substring A is (0,0) we have empty string vs B, therefore return length of B and vice versa
	if (A_idx < 0) {
		return B_idx + 1;
	} else if (B_idx < 0) {
		return A_idx + 1;
	}
	  
	//if edit distance not computed, compute it
	if (distanceBetweenPrefixes[A_idx][B_idx] == -1) {
		
	    /**
	      Check if characters equivalent. Then we don't need to perform any "fix-ups".
	      Just process the edit distance for both strings without this character since
	      (A_idx, B_idx) will == (A_idx - 1, B_index - 1).
	    */
	    if (A.charAt(A_idx) == B.charAt(B_idx)){
	        distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
	    } else {
	     /**
	        Example:
	          Subproblem -> (A_idx, B_idx) -> (3, 2)
	          A: "benyam" ("beny")
	          B: "ephrem" ("eph")
	          Transform "beny" into "eph"
	          "y" in string A does not match "h" in string B
	          
	        If the characters don't match we have 3 options to fix this problem:
	        
	        substituteLast: (replace)
	          Transform
	            (A_idx, B_idx)
	            "beny" into "eph"
	          By transforming
	            (A_idx - 1, B_idx - 1)
	            "ben" into "ep"
	          And then substituting A's last character ("y") with B's last character ("h") to make them the same string.
	        
	        addLast: (insert)
	          Transform
	            (A_idx, B_idx)
	            "beny" into "eph"
	          By transforming
	            (A_idx, B_idx - 1)
	            "beny" into "ep"
	          And then adding B's last character ("h") to the end of the transformed A (now "ep") to make them the same string.
	       
	        deleteLast: (delete)
	          Transform
	            (A_idx, B_idx)
	            "beny" into "eph"
	          By transforming
	            (A_idx - 1, B_idx)
	            "ben" into "eph"
	          And then we delete A's last character ("y") to make them the same string
	          
	        Summary: All 3 of these are the ways that we can fix the character mismatch. We can have many mismatches throughout
	        the recursion but this forms out "policy" for determining the answer to a subproblem
	      */
	      int substituteLast = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
	      int addLast = computeDistanceBetweenPrefixes(A, A_idx, B, B_idx - 1, distanceBetweenPrefixes);
	      int deleteLast = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx, distanceBetweenPrefixes);
	      
	      /*
	        We want to take the minimum of these 3 options to fix the problem (we add 1 to the smallest action because
	        again we are indexed off 0)
	      */
	      distanceBetweenPrefixes[A_idx][B_idx] = 1 + Math.min(substituteLast , Math.min(addLast, deleteLast));
	    }
		
		
	}
	
	
	return distanceBetweenPrefixes[A_idx][B_idx];
  }
  
  
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String A = scan.next();
    String B = scan.next();

    System.out.println(EditDistance(A, B));
  }

}
