package dfs練習.atcoder029.c;

import java.util.*;
public class Main {
    
    static List<List<String>> list = new ArrayList<>();

    static int n;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        List<String> abcList = new ArrayList<>();
        abcList.add("a");
        abcList.add("b");
        abcList.add("c");
        
        for (int i = 0; i < n; i++) {
            list.add(abcList);
        }

        dfs("", 0);
    }
    
    // 追加したい文字列と次の深さを指定する
    static void dfs(String addStr, int index) {

        if (index == n) {
            System.out.println(addStr);
            return;
        }
        for (String s : list.get(index)) {
            dfs(addStr.concat(s), index + 1);
        }
    }
}
