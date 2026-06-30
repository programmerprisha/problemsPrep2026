class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // prisha note: store stack indicies so can access indicies and value
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>(); 

        for (int i = 0; i < temperatures.length; i++) {
            while (stack.isEmpty() == false && temperatures[i] > temperatures[stack.peek()]) {
                int elem = stack.pop(); 
                answer[elem] = i - elem; 
            }
            stack.push(i); 
        }
        return answer; 
    }
}
