public class SinglyLinkedList <T>{
    private static class Node <T> {
        T item;
        Node <T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node <T> head;
    private Node <T> tail;
    private int length;

    public SinglyLinkedList() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void insertFirst(T element){
        Node <T> newNode = new Node<>(element);
        if (length == 0){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

    public void insertLast(T element){
        Node <T> newNode = new Node<>(element);
        if (length == 0){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public void insertAt(T element , int index){
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + length);
        }
        if (index == 0){
            insertFirst(element);
        } else if (index == length - 1) {
            insertLast(element);
        } else {
            Node <T> newNode = new Node<>(element);
            Node <T> temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next  = temp.next;
            temp.next = newNode;
            length ++;
        }
    }

    public void removeFirst(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("List Is Empty");
        } else if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        length --;
    }

    public void removeLast(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("List Is Empty");
        } else if (length == 1) {
            head = tail = null;
        } else {
            Node <T> temp = head;
            while (temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
        }
        length --;
    }

    public void removeAt(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("List Is Empty");
        }
        if (index < 0 || index >= length){
            throw new IndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + length);
        } else if (index == 0){
            removeFirst();
        } else if (index == length - 1){
            removeLast();
        } else {
            Node <T> temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            length --;
        }
    }

    public void reverse(){
        Node <T> curr = head;
        Node <T> prev = null;
        Node <T> next = curr.next;
        tail = curr;
        while (next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public int contains (T element){
        Node <T> temp = head;
        int position = 0;
        while(temp != null){
            if (temp.item.equals(element)){
                return position;
            }
            temp = temp.next;
            position ++;
        }
        return -1;
    }

    public void displayList(){
        Node <T> temp = head;
        while(temp != null){
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}