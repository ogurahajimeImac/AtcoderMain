package atcoder479.a;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        int element = 0;

        for (int i = 0;i < n; i++) {
            element = sc.nextInt();
            if (i % 2 == 0) {
                sum += element;         
            }
        }

        System.out.println(sum);
                
    }

}
