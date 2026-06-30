class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int output = 0;
         
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (curr.equals("+") == false && curr.equals("-") == false && curr.equals("*") == false && curr.equals("/") == false) {
                stack.push(Integer.valueOf(curr));
            } else {
                // prisha note: a will be bigger element bc when later operations pop the previous operation result will be in a
                int a = stack.pop(); 
                int b = stack.pop(); 
                if (curr.equals("+")) {
                    stack.push(b + a);
                } else if (curr.equals("-")) {
                    stack.push(b - a);
                } else if (curr.equals("*")) {
                    stack.push(b * a);
                } else {
                    stack.push(b/a);
                }
            }
        }

        return stack.pop(); 
    }
}
