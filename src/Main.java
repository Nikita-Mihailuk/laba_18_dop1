import java.util.HashSet;

interface Action{
    int action(int a, int b);
}

public class Main {
    public static void main(String[] args) {

        int[] r1 = {0,1,2,3};
        int[] r2 = {1,2,3,4,5};
        int[] rx = {1,2,3,4};

        Action sum = (a,b) -> a + b;
        Action mul = (a,b) -> a * b;
        Action div = (a,b) -> a / b;

       int[] a = actionArray(r1,r2,sum);
       int[] b = actionArray(r1,r2,mul);
       int[] a_rx = actionArray(a,rx,mul);
       int[] a_rx_b = actionArray(a_rx,b,sum);
       int[] rx_r2 = actionArray(rx,r2,sum);
       int[] z = actionArray(a_rx_b,rx_r2,div);

       // коллекция, не содержащая дублирующихся элементов
        HashSet<Integer> set = new HashSet<>();
        for (int num : z) {
            if (num >= 1 && num <= 4) {
                set.add(num);
            }
        }

        System.out.println("Уникальные элементы в массиве, совпадающие с элементами Rx:");
        for (int uniqueNum : set) {
            System.out.print(uniqueNum + " ");
        }

       /*int count = 0;
       for (int n: z) {
           if (n >= 1 && n <= 4){
               System.out.print(n + " ");
               count++;
           }
       }
        System.out.println();
        System.out.println(z.length);
        System.out.println(count);*/
  }
    public  static int[] actionArray(int[] arr1, int[] arr2, Action action){
        int resLength = arr1.length * arr2.length;
        int[] res = new int[resLength];

        int resIndex = 0;

        for (int i : arr1) {
            for (int j : arr2) {
                res[resIndex++] = action.action(i, j);
            }
        }
        return res;
    }
}