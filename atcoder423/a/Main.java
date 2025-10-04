package atcoder423.a;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int c = sc.nextInt();

        int count = x / (1000 + c);
        System.out.println(count * 1000);

    }
}