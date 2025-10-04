package atcoder423.d;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 団体クラス
        class Group {
            int id;
            long in;
            int stay;
            int count;

            long out;

            Group (int id, int in, int stay, int count) {
                this.id = id;
                this.in = in;
                this.stay = stay;
                this.count = count;
            }

            long getOut() {
                return this.out;
            }
        }

        Comparator<Group> comp = Comparator.comparing(Group::getOut);

        // 店クラス
        class Store {

            // 店内にいる団体
            Queue<Group> groupList = new PriorityQueue<>(comp);

            // 最終入店
            long lastIn = 0;

            // 店内人数
            int storeCount = 0;

            // 店内人数取得
//            int getCount() {
//                return this.groupList.stream().map(i -> i.count).reduce(0, Integer::sum);
//            }


            void enter(Group g) {

                // 退店処理
//                this.groupList.removeIf(i -> i.out <= g.in);
                while (true) {
                    Group loopG = this.groupList.peek();
                    if (loopG == null || loopG.out > g.in) {
                        break;
                    }
                    else {
                        this.groupList.poll();
                        this.storeCount -= loopG.count;
                    }
                }

                // 入店可能な場合
                if (this.storeCount + g.count <= k) {

                    // 最終入店のセット
                    this.lastIn = Math.max(this.lastIn, g.in);

                    // 退店時間のセット
                    g.out = this.lastIn + g.stay;

                    // 入店
                    this.groupList.add(g);
                    this.storeCount += g.count;

                    // 出力
                    System.out.println(this.lastIn);
                }

                // 待機
                else  {

                    while (this.storeCount + g.count > k) {

                        // 退店
                        Group s = this.groupList.poll();
                        this.storeCount -= s.count;

                        if (this.storeCount + g.count <= k) {

                            g.out = s.out + g.stay;
                            this.groupList.add(g);
                            this.storeCount += g.count;
                            System.out.println(s.out);
                            this.lastIn = s.out;
                            break;
                        }
                    }
                }
            }
        }

        // 店生成
        Store s = new Store();

        // 各グループでのloop
        for (int i = 0; i < n; i++) {

            // 団体生成
            Group g = new Group(
                    i + 1, sc.nextInt(), sc.nextInt(), sc.nextInt()
            );

            // 団体入店
            s.enter(g);
//        Queue<Integer> q = new PriorityQueue<>();
//        q.add(1);
//        q.add(2);
//        q.removeIf(i -> i == 1);
//        System.out.println(q.stream().count());


        }


    }
}


