public class QueueLinkedList<T> {
    private class Node <T>{
        T item;
        Node <T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    Node <T> front;
    Node <T> rear;

    public QueueLinkedList(){
        this.front = this.rear = null;
    }

    public boolean isEmpty(){
        return this.front == null;
    }

    public void enQueue(T element){
        Node <T> newNode = new Node<>(element);
        if (isEmpty()){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void deQueue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is Empty");
        }
        front = front.next;
        if (front == null){
            rear = null;
        }
    }

    public void displayQueue(){
        Node <T> temp = front;
        while(temp != null){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void clear (){
        front = rear = null;
    }

    public boolean search(T element){
        Node <T> temp = front;
        while(temp.item == element){
            if (temp.item == element){
                return true;
            }
        }
        return false;
    }
}

