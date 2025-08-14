class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (!stack.isEmpty() && stack.peek()[0] == idx) {
                // Same character as the stack top — increment its count (modulo k)
                stack.peek()[1] = (stack.peek()[1] + 1) % k;
                if (stack.peek()[1] == 0) {
                    // Count reached k — pop to remove the group
                    stack.pop();
                }
            } else {
                // New character encountered — push with count 1
                stack.push(new int[] { idx, 1 });
            }
        }
        
        // Rebuild the resulting string from the remaining stack entries
        StringBuilder result = new StringBuilder();
        for (int[] entry : stack) {
            char ch = (char) (entry[0] + 'a');
            int count = entry[1];
            // Append 'count' times
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }
        
        // Since stack is LIFO, reverse to restore original order
        return result.reverse().toString();
    }
}