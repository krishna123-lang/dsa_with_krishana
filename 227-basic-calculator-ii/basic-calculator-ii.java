class Solution {
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (c < '0' || c > '9' || i == s.length() - 1) {
                    switch (operation) {
                        case '+': stack.push(currentNumber); break;
                        case '-': stack.push(-currentNumber); break;
                        case '*': stack.push(stack.pop() * currentNumber); break;
                        case '/': stack.push(stack.pop() / currentNumber); break;
                    }
                    operation = c;
                    currentNumber = 0;
                }
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }
        return result;  
    }
}