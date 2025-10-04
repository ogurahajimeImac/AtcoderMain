package atcoder423.c;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i + 1 <= r) {
                listLeft.add(sc.nextInt());
            }else {
                listRight.add(sc.nextInt());
            }
        }

        Collections.reverse(listRight);

        boolean start = false;
        for (Integer i : listLeft) {
            if (i == 0) {
                start = true;
            }
            if (start) {
                count = count + (i + 1);
            }
        }
        start = false;
        for (Integer i : listRight) {
            if (i == 0) {
                start = true;
            }
            if (start) {
                count = count + (i + 1);
            }
        }

        System.out.println(count);




    }
}

