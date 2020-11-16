/*
 * Merge Sort (Divide and Conquer)
 *
 * @author: Nishi Parameshwara
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] list = {52, 15, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        int[] output = mergeSort(list, list.length);

        for (int i = 0; i <= output.length - 1; i++){
            System.out.print(output[i]);
            System.out.print(" ");
        }
    }

    public static int[] mergeSort(int[] list1, int n) {

        if (n > 1) { //Base case --> empty or one element
            //Only Base case with return is not used as this method has to return an integer array and
            //therefore, we cannot simply use 'return' for base case.

            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = list1[i];
            }

            for (int i = mid; i < n; i++) {
                right[i - mid] = list1[i];
            }

            mergeSort(left, mid);
            //System.out.println("This happens first");
            mergeSort(right, n - mid);
            //System.out.println("This happens second");

            merge(list1, left, right); //array reference for list 1 to left, right
        }
        return list1;
    }

    public static void merge(int[] list2, int[] left, int[] right) {
        int l = 0, m = 0, n = 0;

        //elements are sorted in the original list itself, so sorted list is worked on.
        while (l < left.length && m < right.length) { //compare two lists together
            if (left[l] <= right[m]) {
                list2[n++] = left[l++]; //update final list
            } else {
                list2[n++] = right[m++]; //update final list
            }
        }

        //As two lists are compared together, while loop will not execute if any of the list gets to the final index.
        //This is also an issue due to unequal length of the left and right lists. Therefore, an extra while loop is
        //needed to insert the remaining elements from the longer list in this case or equal length list but with elements
        //still pending to be added to the sorted output list. As the list elements are already sorted and they will be
        //greater than the elements already in the output list, they can inserted without further sorting.

        while (l < left.length){
            list2[n++] = left[l++];
        }

        while (m < right.length){
            list2[n++] = right[m++];
        }
        //return list2; --> not needed as array reference is copied.
    }
}
