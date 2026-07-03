class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] tracker = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            tracker[i][0] = position[i];
            tracker[i][1] = speed[i];

        }
        
        // learned how to sort 2D array based on one parameter (position)
        Arrays.sort(tracker, (a,b) -> Integer.compare(b[0], a[0]));

        int fleetsCount = 1; 
        double prevTime = (double)(target - tracker[0][0]) / tracker[0][1];
        for (int i = 1; i < position.length; i++) {
            double currTime = (double) (target - tracker[i][0]) / tracker[i][1];
            if (currTime > prevTime) {
                fleetsCount++; 
                prevTime = currTime; 
            }
        }

        return fleetsCount; 
    }
}
