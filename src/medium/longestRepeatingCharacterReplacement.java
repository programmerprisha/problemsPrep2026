class Solution {
    public int characterReplacement(String s, int k) {
        // prisha note: variable sliding window
        int answer = 0; 
        HashSet<Character> set = new HashSet<>(); 
        for (char c: s.toCharArray()) {
            set.add(c);
        }

        for (char c : set) {
            int count = 0; 
            int left = 0; 
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == c) {
                    count++; 
                }

                while ((right - left + 1) - count > k) {
                    if (s.charAt(left) == c) {
                        count--; 
                    }
                    left++;
                }

                answer = Math.max(answer, right - left + 1);
            }
        }
        return answer; 
    }
}
