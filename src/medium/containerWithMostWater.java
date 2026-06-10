class Solution {
    public int maxArea(int[] heights) {
        int left = 0; 
        int right = heights.length - 1; 

        int answer = 0; 

        while (left < right) {
            int currHeight = 0; 
            if (heights[left] > heights[right]) {
                currHeight = heights[right];
            } else {
                currHeight = heights[left];
            }

            int currAnswer = (right - left) * currHeight; 
            if (answer < currAnswer) {
                answer = currAnswer;
            }

            if (heights[left] > heights[right]) {
                right--; 
            } else {
                left++;
            }
        }

        return answer; 
        
    }
}
