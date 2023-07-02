/**
 *                          Пусть дан произвольный список целых чисел.

                            1) Нужно удалить из него чётные числа
                            2) Найти минимальное значение
                            3) Найти максимальное значение
                            4) Найти среднее значение
 */

package HomeWork_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> listNum = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер списка для заполнения его рандомными числами :");
        int count = scan.nextInt();
        scan.close();
        Random rand = new Random();
        for(int i =0;i<count;i++){
            listNum.add(rand.nextInt(1,10));
        }
        System.out.println("Начальный список чисел : " + listNum);

        ArrayList<Integer> Newlist = new ArrayList();
        for(int el : listNum){
            if (el%2!=0){
                Newlist.add(el);;    
            }
        } 
        System.out.println("Список без четных чисел : " + Newlist);    
        
        listNum.sort(null);
        
        Iterator<Integer> it = listNum.iterator();
        int sum = 0;
        while(it.hasNext()){
            sum+=it.next();
        }

        int minNum = listNum.get(0);
        System.out.println("Минимальное значение : " + minNum);
        
        int maxNum = listNum.get(count-1);
        System.out.println("Максимальное значение : " + maxNum);

        Double average = (double) sum/count;
        System.out.println("Среднее значение : " + average);
        
     

        
    }
    
}
