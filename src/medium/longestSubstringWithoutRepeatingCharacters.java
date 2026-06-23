class Solution {
    public int lengthOfLongestSubstring(String s) {

      int left = 0; 
      int max = 0; 
      HashSet<Character> currList = new HashSet<Character>(); 
      
      for (int right = 0; right < s.length(); right++) {
        char letter = s.charAt(right);
        while (currList.contains(letter)) {
            currList.remove(s.charAt(left));
            left++; 
        }
        currList.add(letter);
        if (right - left + 1 > max) {
            max = right - left + 1; 
        }
      }

      return max;

    }
}
