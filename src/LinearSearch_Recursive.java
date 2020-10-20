/*
 * Linear Search Recursive Approach
 *
 * @author: Nishi Parameshwara
 **/

import java.util.Scanner;

public class LinearSearch_Recursive {
    public static void main(String[] args) {
        int[] list = {52, 85, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        System.out.println("Enter the numeric element to search: ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        search(list, 0, list.length - 1, key);
    }

    private static void search(int[] list, int low, int high, int key) {
        if (high < low){ //Base case
            System.out.println("Element not present!");
            return;
        }

        if (list[low] == key){ //Base case
            System.out.println("Element present at array index " + low);
            return;
        }

        search(list, low + 1, high, key);
        //System.out.println("This will print in accordance with how many recursive calls were made i.e. the number of " +
          //      "recursive calls freed from the stack space.");
    }
}
