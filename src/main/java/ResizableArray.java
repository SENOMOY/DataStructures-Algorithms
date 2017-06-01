import java.util.List;
import java.util.Scanner;

/**
 * Created by subhajit.sen on 13-05-2017.
 */
public class ResizableArray {
    private int[] items = new int[5];
    private int size = items.length;

    public int size() {
        return size;
    }

    public void set(int index, int item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            items[index] = item;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            return items[index];
        }
    }

    private void ensureCapacity() {
        if (size == items.length) {
            int[] copy = new int[size * 2];
            size = size * 2;
            System.arraycopy(items, 0, copy, 0, size);
            items = copy;
        }

    }

    public void append(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
    }

    public static void main(String[] args) {

        ResizableArray rsa = new ResizableArray();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rsa.size(); i++) {
            int item = scanner.nextInt();
            rsa.set(i, item);
        }

        for (int i = 0; i < rsa.size(); i++) {
            System.out.print(rsa.get(i)+" ");
        }
    }
}
