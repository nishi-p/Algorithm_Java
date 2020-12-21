/*
 * Selection Sort (Divide and Conquer)
 *
 * @author: Nishi Parameshwara
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] list1 = {52, 85, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        sort(list1);
    }

    public static void sort(int[] list1) {
        for (int i = 0; i < list1.length - 1; i++) {
            //int minimum = i;
            for (int j = i + 1; j < list1.length; j++) {
                if (list1[j] < list1[i]) {
                    //minimum = j
                    //if(minimum != i){
                    // swap(list1[min], list1[i]}

                    //swap i and j
                    int temp = list1[i];
                    list1[i] = list1[j];
                    list1[j] = temp;
                }
            }
        }
        System.out.println("The sorted list is ascending order is: ");
        for (int i = 0; i <= list1.length - 1; i++){
            System.out.print(list1[i]);
            System.out.print(" ");
        }
    }
}
