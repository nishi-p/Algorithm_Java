/*
 * Insertion Sort
 *
 * @author Nishi Parameshwara
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {52, 15, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        int[] output = insertion(list, list.length);

        for (int i = 0; i <= output.length - 1; i++) {
            System.out.print(output[i]);
            System.out.print(" ");
        }
    }

    public static int[] insertion(int[] list, int length) {
        for (int i = 1; i < length - 1; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 & list[j] > key) {
                list[j + 1] = list[j]; //shift and not swap
                j = j - 1;
            }
            list[j + 1] = key;
        }
        return list;
    }
}
