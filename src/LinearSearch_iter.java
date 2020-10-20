/*
 * Linear Search Iterative Approach
 *
 * @author: Nishi Parameshwara
 **/

import java.util.Scanner;

public class LinearSearch_iter {

    public static void main(String[] args) {
        int[] list = {52, 85, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        System.out.println("Enter the numeric element to search: ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        search(list, 0, list.length - 1, key);
    }

    private static void search(int[] list, int low, int high, int key) {
        for (int i = low; i <= high; i++) {
            if (list[i] == key) {
                //System.out.format("Element present at array index %d", i);
                System.out.println("Element present at array index " + i);
                return;
            }
        }
        System.out.println("Element not present!");
    }
}
