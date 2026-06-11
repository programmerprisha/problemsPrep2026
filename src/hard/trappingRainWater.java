class Solution {
    public int trap(int[] height) {

        // two pointer approach
        int answer = 0; 
        int maxLeft = height[0]; 
        int leftIndex = 0; 
        int maxRight = height[height.length - 1]; 
        int rightIndex = height.length - 1; 

        while (leftIndex < rightIndex ) {
            if (maxLeft <= maxRight) {
                leftIndex++;  
                if (height[leftIndex] > maxLeft) {
                    maxLeft = height[leftIndex];
                }
                if (maxLeft - height[leftIndex] > 0) {
                    answer+= maxLeft - height[leftIndex];
                }
            } else {
                rightIndex--; 
                if (height[rightIndex] > maxRight) {
                    maxRight = height[rightIndex];
                }
                if (maxRight - height[rightIndex] > 0) {
                    answer+= maxRight - height[rightIndex];
                }
            }
        }

        return answer; 


        
        // prefix sum way
        /*
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];

        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int answer = 0; 
        for (int k = 0; k < height.length; k++) {
            int calc = Math.min(maxLeft[k], maxRight[k]) - height[k];
            if (calc > 0) {
                answer += calc;
            }
        }

        return answer; 
        */


    }
}
