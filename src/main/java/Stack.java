import static java.lang.System.arraycopy;

public class Stack {
    private int size;
    private int[] elements = new int[0];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(final int element) {
        if (size >= elements.length)
            increaseSize();
        elements[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new Underflow();
        return elements[--size];
    }

    public int getSize() {
        return size;
    }

    private void increaseSize() {
        int[] newElements = new int[size + 1];
        arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public static class Underflow extends RuntimeException {
    }
}
