package dfs練習.atcoder059.c;

//　方針がたたなかった、、泣
import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // パラメータ受け取り
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // 1つ目が正の場合
        // インデックスの偶数までの和は1以上、奇数までの和は-1以下である必要がある
        long ansPlus = 0;
        long sum = 0;
        for (int i = 0; i < n ; i++) {

            // ループの数
            int loopNum = list.get(i);

            // 偶数の場合
            if (i % 2 == 0) {
                sum += loopNum;
                // 0以下の場合1になるように変更
                if (sum <= 0) {
                    ansPlus += 1 - sum;
                    sum = 1;
                }
            }
            //　奇数の場合
            else {
                sum += loopNum;
                if (sum >= 0) {
                    ansPlus += sum + 1;
                    sum = -1;
                }
            }
        }

        // 1つ目が負の場合
        long ansMinus = 0;
        sum = 0;
        for (int i = 0; i < n ; i++) {

            // ループの数
            int loopNum = list.get(i);

            // 偶数の場合
            if (i % 2 == 0) {
                sum += loopNum;
                // 0以上の場合--1になるように変更
                if (sum >= 0) {
                    ansMinus += sum + 1;
                    sum = -1;
                }
            }
            //　奇数の場合
            else {
                sum += loopNum;
                if (sum <= 0) {
                    ansMinus += 1 - sum;
                    sum = 1;
                }
            }
        }

        System.out.println(Math.min(ansPlus, ansMinus));

    }
}
