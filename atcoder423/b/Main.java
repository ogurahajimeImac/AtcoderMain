package atcoder423.b;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (Integer i : list){
            if (i == 0) {
                count++;
            }
            else {
                break;
            }
        }
        if (count == n) {
            System.out.println(0);
        }
        else {
            Collections.reverse(list);

            for (Integer i : list){
                if (i == 0) {
                    count++;
                }
                else {
                    break;
                }
            }

            System.out.println((n - 1) - count);
        }




    }
}
