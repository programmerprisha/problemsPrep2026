class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false; 
        }

        int[] key = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            key[s1.charAt(i) - 'a']++; 
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(key, window)) {
            return true; 
        }

        // prisha note: s1.length() is fixed k -- this is fixed sliding window problem
        for (int i = s1.length(); i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            // prisha note: removing letter from substring bc checking each character substring of k size
            // like in example lecabee: lec, eca, cab and cab would be answer
            window[s2.charAt(i - s1.length()) - 'a']--;
            if (matches(key, window)) {
                return true; 
            }
        }
    return false; 

    }


    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false; 
            }
        }
        return true; 
    }
}