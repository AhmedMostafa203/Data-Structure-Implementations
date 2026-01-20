import java.util.EmptyStackException;
public class StackArray<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private T [] stack;
    private int top;

    public StackArray(int Capacity){
        if (Capacity <= 0){
            throw new IllegalArgumentException(Capacity + " Is Not a Capacity For Stack");
        }
        this.stack = (T[]) new Object[Capacity];
        this.top = -1;
    }

    public StackArray(){
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == stack.length;
    }

    public T getTop(){
        return stack[top];
    }

    public void push(T element){
        if (isFull()){
            throw new ArrayStoreException("Stack is Full");
        }
        stack[++top] = element;
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public void displayStack(){
        for (int i = top ; i >= 0 ; i--) {
            System.out.print(stack [i] + " ");
        }
        System.out.println();
    }
}
