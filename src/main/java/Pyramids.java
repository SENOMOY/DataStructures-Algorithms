import java.util.Scanner;

/**
 * Created by subhajit.sen on 08-05-2017.
 */
public class Pyramids {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Pyramids prm = new Pyramids();
        System.out.println("--- Pyramid Half Right ---");
        prm.printPyramidHalfRight(num);
        System.out.println("--- Pyramid Half Left ---");
        prm.printPyramidHalfLeft(num);
        System.out.println("--- Pyramid Full ---");
        prm.printPyramidFull(num);
    }

    public void printPyramidHalfRight(int num) {
        for (int i = 1; i <= num; i++) {
            for (int b = 1; b <= i; b++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printPyramidHalfLeft(int num) {
        int temp = num;
        for (int i = 1; i <= num; i++) {
            temp = temp - 1;
            for (int a = 1; a <= temp; a++) {
                System.out.print(" ");
            }
            for (int b = 1; b <= i; b++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printPyramidFull(int num) {
        for (int i = 0; i < num; i++) {
            for (int k = 0; k < num - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}