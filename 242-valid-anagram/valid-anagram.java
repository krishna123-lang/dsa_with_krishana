class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length()) return false;
      char[] sai=s.toCharArray();
      char[] tai=t.toCharArray();
      Arrays.sort(sai);
      Arrays.sort(tai);
      return Arrays.equals(sai,tai);  
    }
}