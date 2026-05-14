class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase(); 
        s = s.replaceAll("[^a-zA-Z0-9]", "");
       
       int index = 0; 
       for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) != s.charAt(index)){ 
            return false; 
        } 
        index++; 
       }

       return true; 
    }
}
