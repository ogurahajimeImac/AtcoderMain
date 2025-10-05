package dfs練習.atcoder313.b;
import java.util.*;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> map = new ArrayList<>();
    static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            List<Integer> empty = new ArrayList<>();
            list.add(empty);
            map.add(0);
        }

        for (int i = 0; i < m; i++) {
            int strong = sc.nextInt();
            int weak = sc.nextInt();
            list.get(strong - 1).add(weak - 1);
        }

        for (int i = 0; i < n; i++) {
            // mapリセット
            mapReset();
            
            // dfs            
            dfs(i);

            // mapの1の数を数える
            int ans = map.stream().filter(num -> num == 1).reduce(0, Integer::sum);
            if (ans == n) {
                ansList.add(i + 1);
            }
        }

        if (ansList.size() == 1) {
            System.out.println(ansList.get(0));
        }
        else {
            System.out.println(-1);
        }


        
        
    }

    static void mapReset() {
        for (int i = 0; i < map.size(); i++) {
            map.set(i, 0);
        }
    }



    static void dfs(int index) {
        map.set(index, 1);
        for (int child : list.get(index)) {
            if (map.get(child) == 0) {
                dfs(child);
            }
        }
    }
    


}
