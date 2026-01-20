import java.util.EmptyStackException;
public class StackLinkedList<T>{
    private class Node <T> {
        T item;
        Node <T> next;

        public Node(T data){
            this.item = data;
            this.next = null;
        }
    }

    private Node <T> top;

    public StackLinkedList(){
        this.top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(T element){
        Node <T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
    }

    public T peek(){
        return top.item;
    }

    public T pop(){
        T tempData = top.item;
        top = top.next;
        return tempData;
    }

    public void displayStack(){
        Node <T> tempNode = top;
        while(tempNode != null){
            System.out.print(tempNode.item + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}