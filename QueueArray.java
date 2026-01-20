public class QueueArray<T>{
    private final static int DEFAULT_CAPACITY = 10;
    private T [] queue;
    private int front;
    private int rear;
    private int length;

    public QueueArray(int Capacity){
        if (Capacity <= 0){
            throw new IllegalArgumentException(Capacity + " Is Not a Capacity For Queue");
        }
        this.queue = (T[]) new Object[Capacity];
        this.front = 0;
        this.rear = queue.length - 1;
        this.length = 0;
    }

    public QueueArray(){
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public boolean isFull(){
        return length == queue.length;
    }

    public void enQueue(T element){
        if (isFull()){
            throw new IllegalArgumentException("Queue is Full");
        }
        rear = (rear + 1) % queue.length;
        queue [rear] = element;
        length ++;
    }

    public void deQueue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        front = (front + 1) % queue.length;
        length --;
    }

    public void displayQueue(){
        int tempLength = length;
        int tempFront = front;
        while (tempLength > 0){
            System.out.print(queue [tempFront] + " ");
            tempFront = (tempFront + 1) % queue.length;
            tempLength --;
        }
        System.out.println();
    }
}
