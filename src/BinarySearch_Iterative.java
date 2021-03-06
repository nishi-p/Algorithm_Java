/*
 * Binary Search Iterative Approach (Divide and Conquer)
 *
 * @author: Nishi Parameshwara
 **/

import java.util.Scanner;

public class BinarySearch_Iterative {

    public static void main(String[] args) {
        int[] list = {1,2,5,10,24,31,45,52,59,66,78,85,105,280}; //sorted list
        System.out.println("Enter the numeric element to search: ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        search(list, 0, list.length - 1, key);
    }

    private static void search(int[] list, int low, int high, int key) {
        while (high > low) { //Base case
            int mid = (low + high) / 2;
            if (list[mid] == key) {
                System.out.println("Element found at array index " + mid);
                return;
            } else {
                if (key > list[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        System.out.println("Element not present!");
    }
}
