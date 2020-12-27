/*
 * Quick Select (Divide and Conquer)
 * Find kth smallest element from the list.
 * Based on QuickSort --> partial sorting
 *
 * @author: Nishi Parameshwara
 **/

import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        int[] list = {52, 15, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24}; //1 2 5 10 15 24 31 45 52 59 66 78 105 280
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the kth smallest element to select: ");
        int n = scan.nextInt();
        int output = quickSort(list, 0, list.length - 1, n);
        System.out.println(output);
    }

    public static int quickSort(int[] list, int low, int high, int n) {
        if (low == high) { //select single element
            return list[low];
        }
        //randomized pivot
        int pivot = low + (int) Math.floor(Math.random() * (high - low + 1));
        pivot = partition(list, low, high, pivot);

        if (n == pivot) {
            return list[n];
        } else if (n < pivot) { //partial sorting
            return quickSort(list, low, pivot - 1, n);
        } else if (n > pivot) {
            return quickSort(list, pivot + 1, high, n);
        }
        else {
            return 0;
        }
    }

    public static void swap(int[] list, int n, int high){
        //if we don’t choose the first or last element as the pivot, we should first swap it with the first or last
        //position before the partitioning begins.
        int temp = list[high];
        list[high] = list[n];
        list[n] = temp;
    }

    public static int partition(int[] list, int low, int high, int n){
        int pivot = list[n];
        //move pivot to the end
        swap(list, n, high);
        int i = low;
        int j = high-1;

        while(i<j){
            while((i <= j) && (list[i] <= pivot)){
                i++;
            }

            while((list[j] >= pivot) && (j >= i)){
                j--;
            }

            if(i < j) {
                swap(list, j, i);
            }
        }
        //swap pivot value with right mark to get new pivot position
        swap(list, i, high);
        return i;
    }
}
