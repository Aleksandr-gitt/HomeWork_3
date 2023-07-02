/**
 *                 ++++++ Реализовать алгоритм сортировки слиянием ++++++
 */

package HomeWork_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер списка для заполнения его рандомными числами :");
        int nums = scan.nextInt();
        scan.close();
        int[] numbers = new int[nums];
        Random rand = new Random();
        for (int i = 0; i < nums; i++) {
            numbers[i]=(rand.nextInt(10, 100));
        }

        System.out.println("Начальный список чисел : ");
        for (int el:numbers) {System.out.print(el+" ");}

        int[] result = mergeSort(numbers);
        
        System.out.println();
        System.out.println("Отсортированный список чисел : ");
        for (int el:result) {System.out.print(el+" ");}
    }



    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}