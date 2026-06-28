class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        int index = 0; 

        while (index < s.length()) {
            char curr = s.charAt(index);
            if (curr == '(' || curr == '{' || curr == '[') {
                stack.push(curr); 
            } else {
                if (stack.isEmpty()) {
                    return false; 
                } 
                char topRemoved = stack.pop(); 
                if ((topRemoved != '(' && curr == ')') || (topRemoved != '{' && curr == '}') || (topRemoved != '[' && curr == ']')) { 
                    return false; 
                }
            }
            index++; 
        }

        return stack.isEmpty(); 
    }
}
