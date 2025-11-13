package Home.HW8;

//рекурсивна структура даних
public class B08_01<T> {

    // Внутрішній вузол стеку
    private static class Node<T> {
        T value;
        B08_01<T> next;  // рекурсивне посилання на підстек

        Node(T value, B08_01<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> top; // верхівка стеку

    public B08_01() {
        this.top = null;
    }

    // Перевіряємо чи стек порожній
    public boolean isEmpty() {
        return top == null;
    }

    // Додаємо елемент у стек (push)
    public void push(T value) {
        top = new Node<>(value, this.copy()); //новий вузол
    }

    // Видалення верхнього елемента (pop)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        T value = top.value;
        // "піднімаємо" підстек
        this.top = top.next != null ? top.next.top : null;
        return value;
    }

    //  верхній елемент (peek)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        return top.value;
    }

    // Копія стеку
    private B08_01<T> copy() {
        B08_01<T> copy = new B08_01<>();
        copy.top = this.top;
        return copy;
    }

    // Рекурсивний метод для виведення стеку
    @Override
    public String toString() {
        return isEmpty() ? "[]" : "[" + toStringRecursive(top) + "]";
    }

    private String toStringRecursive(Node<T> node) {
        if (node == null) return "";
        if (node.next == null || node.next.top == null) return node.value.toString();
        return node.value + ", " + toStringRecursive(node.next.top);
    }

    public static void main(String[] args) {
        B08_01<Object> stack = new B08_01<>();
        stack.push("text");
        stack.push(123);
        stack.push(45.6);
        System.out.println("Стек: " + stack);
        System.out.println("Верхівка: " + stack.peek());
        System.out.println("Видалено: " + stack.pop());
        System.out.println("Після pop: " + stack);
    }
}
