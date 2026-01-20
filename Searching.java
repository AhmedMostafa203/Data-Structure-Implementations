import java.util.Arrays;
import java.util.Collections;

public class Searching <T extends  Comparable <T> >{
    private T [] array;

    public Searching(T [] array) {
        this.array = array;
    }

    public int linearSearch(T element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) return i;
        }
        return -1;
    }

    public int binarySearch(T key){
        Arrays.sort(array);
        return helperBinarySearch(0 , array.length - 1 , key);
    }

    private int helperBinarySearch(int low , int high , T key){
        if (low <= high){
            int mid = low + (high - low) / 2;
            if (key.equals(array[mid])) return mid;
            if (key.compareTo(array[mid]) > 0) return helperBinarySearch(mid + 1 , high , key);
            return helperBinarySearch(low , mid - 1 , key);
        }
        return -1;
    }
}
