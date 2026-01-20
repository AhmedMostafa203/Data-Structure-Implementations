import java.util.Arrays;
public class arrayList<T> {
    private final static int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public arrayList() {
        this(DEFAULT_CAPACITY);
    }

    public arrayList(int Capacity) {
        if (Capacity <= 0){
            throw new IllegalArgumentException(Capacity + " Is Not a Capacity For Array");
        }
        this.array = (T[]) new Object[Capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private void ensureCapacity() {
        if (isFull()) {
            array = Arrays.copyOf(array, (array.length >> 1) + array.length);
        }
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void set(T element, int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + size);
        }
        array[index] = element;
    }

    public void insert(T element, int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + size);
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void remove(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + size);
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + size);
        }
        return array[index];
    }

    public boolean contains(T element){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void displayArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}