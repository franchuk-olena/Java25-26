package Home.HW8;

public class B08_02 {

    // Власний рекурсивний стек для символів
    private static class Node {
        char value;
        B08_02 next;

        Node(char value, B08_02 next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node top;

    public B08_02() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char ch) {
        top = new Node(ch, this.copy());
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        char ch = top.value;
        top = top.next != null ? top.next.top : null;
        return ch;
    }

    private B08_02 copy() {
        B08_02 copy = new B08_02();
        copy.top = this.top;
        return copy;
    }

    //Метод для перевірки правильності дужок
    public static boolean checkBrackets(String str) {
        B08_02 stack = new B08_02();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!matches(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    //
    public static void main(String[] args) {
        String test1 = "({[]})";
        String test2 = "([)]";
        String test3 = "((())){}[]";

        System.out.println(test1 + " -> " + checkBrackets(test1));
        System.out.println(test2 + " -> " + checkBrackets(test2));
        System.out.println(test3 + " -> " + checkBrackets(test3));
    }
}
