class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> window = new HashMap<>(); 
        HashMap<Character, Integer> tMap = new HashMap<>(); 

        for (int x = 0; x < t.length(); x++) {
            char curr = t.charAt(x);
            if (tMap.get(curr) == null) {
                tMap.put(curr, 1);
            } else {
                tMap.put(curr, tMap.get(curr) + 1);
            }
        }


        int length = Integer.MAX_VALUE; 
        int left = 0; 
        int curr = 0; 
        int requirement = tMap.size(); 
        int[] index = {-1, -1};
        

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); 
            if (window.get(c) == null) {
                window.put(c, 1);
            } else {
                window.put(c, window.get(c) + 1);
            }

            if (tMap.containsKey(c) && window.get(c) == tMap.get(c)) {
                curr++; 
            }

            // prisha note: invalid case is when 
            while (curr == requirement) {
                if ((right - left + 1) < length) {
                    length = right - left + 1; 
                    index[0] = left; 
                    index[1] = right; 
                }

                char leftC = s.charAt(left);
                window.put(leftC, window.get(leftC) - 1);
                if (tMap.containsKey(leftC) && window.get(leftC) < tMap.get(leftC)) {
                    curr--; 
                }
                left++; 

            }
        }

        if (length == Integer.MAX_VALUE) {
            return "";
        } 
        return s.substring(index[0], index[1] + 1);
        
    }
}