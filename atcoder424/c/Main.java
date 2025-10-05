package atcoder424.c;

import java.util.*;
public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> map = new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        
        
        for (int i = 0; i <= n; i++) {
            List<Integer> empty = new ArrayList<>();
            list.add(empty);
            map.add(0);
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(i + 1);
            list.get(b).add(i + 1);
        }

        dfs(0);

        int ans = map.stream().filter(i -> i == 1).reduce(0, Integer::sum);
        System.out.println(ans - 1);
        
    }
    static void dfs(int num) {
        map.set(num, 1);

        for (int child : list.get(num)) {
            if (map.get(child) == 0) {
                dfs(child);
            }
        }
    }
}
