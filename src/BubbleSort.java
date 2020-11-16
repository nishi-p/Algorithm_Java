/*
 * Bubble Sort
 *
 * @author Nishi Parameshwara
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {52, 15, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        int[] output = bubble(list, list.length);

        for (int i = 0; i <= output.length - 1; i++){
            System.out.print(output[i]);
            System.out.print(" ");
        }
    }

    public static int[] bubble(int[] list, int length){
        for(int i = length - 1; i >= 0; i++){
            for(int j = 0; j <= i; j++){
                if (list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }
}
