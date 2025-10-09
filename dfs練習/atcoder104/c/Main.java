package dfs練習.atcoder104.c;
import java.util.*;

public class Main {
    
    static List<List<Integer>> list = new ArrayList<>();

    static int g = 0;

    static int d = 0;

    static List<Integer> ansList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        d = sc.nextInt();
        g = sc.nextInt();
        for (int i = 0; i < d; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            List<Integer> pcList = new ArrayList<>();
            pcList.add(0);
            for (int j = 0; j < p; j++) {
                int basePoint = 100 * (i + 1) * (j + 1);
                if (j != p - 1) {
                    pcList.add(basePoint);
                }
                else {
                    pcList.add(basePoint+ c);
                }
            }
            list.add(pcList);
        }
        dfs(0, 0, 0);
        int ans = ansList.stream().sorted().toList().get(0);
        System.out.println(ans);
    }

    static void dfs(int depth, int score, int calc) {
        
        // スコアが満たされていた場合
        if (score >= g) {
            ansList.add(calc);
            return;
        }

        // 最後の深さに達した場合
        if (depth > d - 1) {
            return;
        }

        // 対応するリストを取得
        List<Integer> tgtList = list.get(depth);
        for (int i = 0; i < tgtList.size(); i++) {
            int newScore = score + tgtList.get(i);
            int newCalc = calc + i;
            dfs(depth + 1, newScore, newCalc);
        }

    }
}
