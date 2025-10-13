package dfs練習.atcoder104.c;
// ボーナス取るか取らないかの2択で場合分けし
// そのあとは高い順に問題を解いていけばよい。ただし、ボーナスは取らないようにする

import java.util.*;

public class Main {
    static int d = 0;
    static int g = 0;
    static int[][] array;
    static List<Integer> ansList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        d = sc.nextInt();
        g = sc.nextInt();
        array = new int[d][2];

        for (int i = 0; i < d; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }

        dfs(new ArrayList<Integer>(), 0, 0, 0);
        int ans = ansList.stream().sorted().toList().get(0);
        System.out.println(ans);
    }


    static void dfs(List<Integer> completeIndex, long sum, int depth, int calcNum) {

        // 終了条件
        if (depth == d) {
            // param
            int newCalcNum = calcNum;
            long newSum = sum;
            boolean isStop = false;
            
            

            for (int i = d - 1; i >= 0; i--) {
                //　条件を満たす場合
                if (newSum >= g) {
                    ansList.add(newCalcNum);
                    return;
                }
                
                // ボーナス取得済みであれば、飛ばす
                if (completeIndex.contains(i)) {
                    continue;
                }
                for (int j = 0; j < array[i][0] - 1; j++) {
                    
                    newSum += 100 * (i + 1);
                    newCalcNum++;

                    // 条件を満たす場合停止
                    if (newSum >= g) {
                        ansList.add(newCalcNum);
                        isStop = true;
                        break;
                    }
                }
                if (isStop) {
                    break;
                }
            }

            return;
        }
        
        ArrayList<Integer> newCompleteIndexNoBonus = new ArrayList<>();
        ArrayList<Integer> newCompleteIndexExistBonus = new ArrayList<>();
        newCompleteIndexNoBonus.addAll(completeIndex);
        newCompleteIndexExistBonus.addAll(completeIndex);
        
        // その階層でボーナスポイントを取らない場合
        dfs(newCompleteIndexNoBonus, sum, depth + 1, calcNum);

        // その階層でボーナスポイントを取得する場合
        newCompleteIndexExistBonus.add(depth);
        dfs(newCompleteIndexExistBonus, sum + array[depth][1] + 100 * (depth + 1) * array[depth][0], depth + 1, calcNum + array[depth][0]);
    }

}
