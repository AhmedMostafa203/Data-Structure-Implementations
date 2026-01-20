import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree <Integer> tree = new BinarySearchTree<>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        System.out.println(tree.nodesAtLevel(1));
    }

}


