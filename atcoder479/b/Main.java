package atcoder479.b;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String s = sc.next();
        String loopS;

        int ans = 0;
        int continuos = 0;

        for (int i = 0; i < n; i++) {
            loopS = String.valueOf(s.charAt(i));

            if ("S".equals(loopS)) {
                continuos = 0; 
            } 
            else {
                continuos++;
            }
            ans = Math.max(continuos, ans);
        }

        System.out.println(ans);

        
    }        
}
