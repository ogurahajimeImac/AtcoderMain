package atcoder424.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        List<String> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(0);
        }

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.set(a - 1, list.get(a - 1) + 1);
            if (list.get(a - 1) == m) {
                ansList.add(String.valueOf(a));
            }
        }

        String ans = String.join(" ", ansList);
        System.out.print(ans);

    }
}