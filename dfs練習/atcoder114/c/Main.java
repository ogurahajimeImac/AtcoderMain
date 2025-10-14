package dfs練習.atcoder114.c;
import java.util.*;

public class Main {

    static int n = 0;
    static List<List<Integer>> list = new ArrayList<>();
    static List<String> basisList = new ArrayList<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // 1桁と2桁の場合を投入
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        List<Integer> depth3List = new ArrayList<>();
        depth3List.add(357);
        depth3List.add(375);
        depth3List.add(537);
        depth3List.add(573);
        depth3List.add(735);
        depth3List.add(753);
        list.add(depth3List);

        basisList.add("3");
        basisList.add("5");
        basisList.add("7");

        
        // 4桁以上のリスト作成
        dfs(3);
        
        int ans = 0;
        for (List<Integer> l : list) {
            for (int num : l) {
                if (num <= n) {
                    ans++;
                } else {
                    System.out.println(ans);
                    return;
                }
            }
        }
        
        // 上限などは上で拾えないため、こちらで出力
        System.out.println(ans);
    }

    // depthは桁数を指す
    static void dfs(int depth) {
        
        // 10桁になった時点でリスト作成終了
        if (depth >= 9) {
            return;
        }

        // リスト取得
        List<Integer> tgtDepthList = list.get(depth - 1);

        // depthのリスト
        List<String> newStrList = new ArrayList<>();

        for (int i : tgtDepthList) {
            String strNum = String.valueOf(i);
            for (int j = 0; j <= strNum.length(); j++) {
                for (String s : basisList) {
                    String addStr = strNum.substring(0, j) + s + strNum.substring(j, strNum.length());
                    newStrList.add(addStr);
                }
            }
        }
        List<Integer> newDepthList = newStrList.stream().distinct().map(i -> Integer.valueOf(i)).sorted().toList();
        list.add(newDepthList);
        dfs(depth + 1);


    }
}
