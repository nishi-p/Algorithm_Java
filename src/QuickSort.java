/*
 * Quick Sort
 *
 * @author: Nishi Parameshwara
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {52, 15, 5, 2, 66, 1, 59, 78, 105, 45, 31, 10, 280, 24};
        int[] output = quickSort(list, 0, list.length - 1);

        for (int i = 0; i <= output.length - 1; i++){
            System.out.print(output[i]);
            System.out.print(" ");
        }
    }

    public static int[] quickSort(int[] list, int low, int high){
        if(low<high){
            int pivot = partition(list, low, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
        return list;
    }

    public static int partition(int[] list, int low, int high){
        int pivot = list[low];
        int i = low + 1;
        int j = high;

        while(i<j){
            while((i <= j) && (list[i] <= pivot)){
                i++;
            }

            while((list[j] >= pivot) && (j >= i)){
                j--;
            }

            if(i < j) {
                //left mark and right mark have not joined yet but change position to elements wrt to pivot in order to
                //sort
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        //swap pivot value with right mark to get new pivot position
        int temp = list[low];
        list[low] = list[j];
        list[j] = temp;
        return j;
    }
}