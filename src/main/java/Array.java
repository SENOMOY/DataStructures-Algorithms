/**
 * Created by subhajit.sen on 31-05-2017.
 */
public class Array {

    public int serachElement(int arr[], int element, int length) {
        System.out.println("Searching " + element + " in array...");
        for (int i = 0; i < length; i++)
            if (arr[i] == element) {
                System.out.println("Element " + element + " present at index " + i);
                return i;
            }
        System.out.println("Element " + element + " not present in array");
        return -1;
    }

    public int deleteElement(int arr[], int element, int length) {
        System.out.println("Deleting " + element + " from array");

        int position;
        position = serachElement(arr, element, length);

        if (position == -1) return length;

        for (int j = position; j < length - 1; j++)
            arr[j] = arr[j + 1];

        System.out.println("Element " + element + " deleted from array");
        return length - 1;
    }

    public int addElement(int arr[], int capacity, int element, int length) {

        if (length >= capacity) {
            System.out.println("Array is full, no element can be added");
            return length;
        }
        int new_length = length + 1;
        arr[length] = element;
        System.out.println("New element " + element + " added to the array, new size of array is: " + new_length);
        return new_length;
    }

    public void printArray(int[] arr, int length) {
        System.out.print("Array: ");
        for (int i = 0; i < length; i++)
            System.out.print(" " + arr[i]);
    }

    public void sort(int[] arr, int length) {
        int temp;
        System.out.println("Applying bubble sort -> ascending order");
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public int binarySearch(int[] arr, int start, int length, int element) {
        if (length < start)
            return -1;
        int mid = (start + length) / 2;

        if (element == arr[mid])
            return mid;

        if (element > arr[mid])
            return binarySearch(arr, mid + 1, length, element);

        return binarySearch(arr, start, mid - 1, element);
    }


    public static void main(String[] args) {

        Array ar = new Array();
        int capacity = 20;
        int length = 10;
        int new_length = 0;

        int arr[] = new int[capacity];
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 2;
        arr[3] = 1;
        arr[4] = 6;
        arr[5] = 8;
        arr[6] = 11;
        arr[7] = 12;
        arr[8] = 37;
        arr[9] = 22;
        ar.printArray(arr, length);
        System.out.println();

        ar.serachElement(arr, 2, length);
        System.out.println();

        new_length = ar.addElement(arr, capacity, 9, length);
        ar.printArray(arr, new_length);
        System.out.println();
        System.out.println();

        new_length = ar.deleteElement(arr, 7, new_length);
        ar.printArray(arr, new_length);
        System.out.println();
        System.out.println();

        ar.sort(arr, new_length);
        ar.printArray(arr, new_length);
        System.out.println();
        System.out.println();

        int search_element= 3;
        System.out.println("Binary search for: "+search_element);
        int index_found = ar.binarySearch(arr, 0, new_length, search_element);
        if (index_found == -1) System.out.println("Element not found");
        else System.out.println("Element found at index: " + index_found);


    }

}
