import java.util.Arrays;

public class Sorting<T extends Comparable<T>> {
    private T[] array;

    public Sorting(T[] array) {
        this.array = array;
    }

    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1].compareTo(array[j]) < 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void insertionSort() {
        for (int i = 0; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public void mergeSort(){
        helperMergeSort(0 , array.length - 1);
    }

    private void helperMergeSort(int left , int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            helperMergeSort(left , mid);
            helperMergeSort(mid + 1 , right);
            merge(left , mid , right);
        }
    }

    private void merge (int left , int mid , int right){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        T [] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T [] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        for (int i = 0; i < leftSize; i++)
            leftArray [i] = array [left + i];
        for (int i = 0; i < rightSize; i++)
            rightArray [i] = array [mid + 1 + i];

        int i = 0 , j = 0 , k = left;
        while(i < leftSize && j < rightSize){
            if (leftArray [i].compareTo(rightArray [j]) <= 0)
                array [k++] = leftArray [i++];
            else
                array [k++] = rightArray [j++];
        }

        while (i < leftSize)
            array [k++] = leftArray [i++];
        while (j < rightSize)
            array [k++] = rightArray [j++];
    }

    public void QuickSort(){
        helperQuickSort(0 , array.length - 1);
    }

    private void helperQuickSort(int left , int right){
        if (left < right){
            int pivot = partition(left , right);
            helperQuickSort(left , pivot - 1);
            helperQuickSort(pivot + 1 , right);
        }
    }

    private int partition(int left , int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(left, randomIndex);
        int i = left + 1;
        int j = right;
        T pivot = array[left];
        while (i <= j) {
            while (i <= j && array[i].compareTo(pivot) <= 0) i++;
            while(i <= j && array[j].compareTo(pivot) > 0) j--;
            if (i < j) swap(i , j);
        }
        swap(left , j);
        return j;
    }

    public void heapsort(){
        buildHeap(array.length);
        for (int i = array.length - 1; i > 0 ; i--) {
            swap(0 , i);
            heapify(i , 0);
        }
    }

    private void buildHeap(int size){
        for (int i = size / 2 - 1; i >= 0 ; i--) {
            heapify(size , i);
        }
    }

    private void heapify(int size , int i){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;

        if (left < size && array[left].compareTo(array[max]) > 0) max = left;
        if (right < size && array[right].compareTo(array[max]) > 0) max = right;
        if (max != i) {
            swap(max , i);
            heapify(size , max);
        }
    }

    private void swap(int pos1 , int pos2){
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array [i]);
            if (i < array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();
    }
}
