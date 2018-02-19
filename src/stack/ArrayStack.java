package stack;

public class ArrayStack<T> implements Stack<T> {
    
    private final int INITIAL_SIZE = 1;
    private int size;
    private int topIndex;
    private T[] storage;
    
    public ArrayStack() {
        storage = (T[]) new Object[INITIAL_SIZE];
        size = storage.length;
        topIndex  = -1;
    }
    
    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }
    
    @Override
    public T top() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return storage[topIndex];
    }
    
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }

        topIndex = topIndex - 1;

        T[] tmp = storage;
        storage = (T[]) new Object[size - 1];
        for (int i = 0; i <= topIndex; i++) {
            storage[i] = tmp[i];
            if (i==0) {
                storage[topIndex] = tmp[i];
            }
        }
        size = storage.length;
    }
    
    @Override
    public void push(T item) {
        topIndex = topIndex + 1;
        if (topIndex >= size) {
            T[] tmp = storage;
            storage = (T[]) new Object[size + 1];
            for (int i = 0; i < topIndex; i++) {
                storage[i] = tmp[i];
            }
            size = storage.length;
        }
        storage[topIndex] = item;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            result += storage[i];
        }
        result += "]";

        return result;
    }
}
