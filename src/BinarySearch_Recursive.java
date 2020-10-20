/*
 * Binary Search Recursive Approach
 *
 * @author: Nishi Parameshwara
 */

import java.util.Scanner;

public class BinarySearch_Recursive {

    public static void main(String[] args) {
        int[] list = {1,2,5,10,24,31,45,52,59,66,78,85,105,280}; //sorted list
        System.out.println("Enter the numeric element to search: ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        search(list, 0, list.length - 1, key);
    }

    private static void search(int[] list, int low, int high, int key) {
        if (high < low) { //Base case
            //low -> lower index with smaller value than key and low + 1 -> higher index with higher value than key.
            System.out.println("Element not present, but if present in this sorted array, it would be between indexes " +
                    (low - 1) + " and " + low);
            //System.out.println("Element not present!");
            return;
        }

        int mid = (low + high) / 2;
        if (list[mid] == key) {
                System.out.println("Element found at array index " + mid);
        } else {
            if (key > list[mid]) {
                search(list,mid + 1, high, key);
            } else {
                search(list,low, mid - 1, key);
            }
        }
    }
}
