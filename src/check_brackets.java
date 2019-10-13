import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    char type;
    int position;
}

class check_brackets {
		
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        HashMap<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        bracketMap.put(')', '(');

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            	opening_brackets_stack.push(new Bracket(next, position));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
            	if (opening_brackets_stack.isEmpty()) {
            		System.out.println(position+1);
            		return;
            	}
            	else if (opening_brackets_stack.pop().type != bracketMap.get(next)) {
            		System.out.println(position+1);
            		return;
            	}
                       	
            }
        }
        
        
        if (!opening_brackets_stack.isEmpty()) { 
        	System.out.println(opening_brackets_stack.pop().position + 1);
        	return;
        } 
        else {
        	System.out.println("Success");
        	return;
        }
        
    }
    
 
}
