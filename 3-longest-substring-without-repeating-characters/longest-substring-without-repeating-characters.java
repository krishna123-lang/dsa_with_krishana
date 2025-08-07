class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
        int maxLength = 0;
        int left = 0;

        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;  
    }
}