package dfs練習.atcoder054.c;
// 課題：訪問済みの管理方法に困った
// ループ処理の頭で終端条件を設定する→全種類訪問していれば終了

import java.util.*;
public class Main {

    // 対応関係格納用
    static List<List<Integer>> list = new ArrayList<>();

    // 要素数
    static int n;

    static int ans = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        // リスト作成
        for (int i = 0; i < n; i++) {
            
            List<Integer> empty = new ArrayList<>();
            list.add(empty);
        }

        // 要素追加
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a - 1).add(b - 1);
            list.get(b - 1).add(a - 1);
        }

        // 探索
        List<Integer> init = new ArrayList<>();
        init.add(0);
        dfs(0, init);

        // 出力
        System.out.println(ans);
    }

    // 探索
    // 突っ込んでから訪問スタイル
    static void dfs(int index, List<Integer> map) {

        // すでに全部訪問していればカウント
        if (map.size() == n) {
            ans++;
            return;
        }
        
        // 訪問先リスト
        List<Integer> visitList = list.get(index);

        // ループ
        for (int distination : visitList) {

            // 未訪問の場合
            if (!map.contains(distination)) {
                List<Integer> newMap = new ArrayList<>();
                newMap.addAll(map);
                newMap.add(distination);
                dfs(distination, newMap);
            }

        }
    }
    
}
