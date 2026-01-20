import java.util.NoSuchElementException;
public class DoublyLinkedList<T> {
    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insertFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void insertLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insertAt(T element, int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + length);
        }
        if (index == 0) {
            insertFirst(element);
        } else if (index == length - 1) {
            insertLast(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            length++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Doubly Linked List Is Empty");
        }
        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        length--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Doubly Linked List Is Empty");
        }
        if (length == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        length--;
    }

    public void removeAt(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Doubly Linked List Is Empty");
        }
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " Out Of Bounds For Length " + length);
        }
        if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            length--;
        }
    }

    public void displayList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}