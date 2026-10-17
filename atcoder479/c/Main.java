package atcoder479.c;

import java.util.*;
public class Main {
    
    static class Okazu{
        long a;
        long b;

        Okazu(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static List<Okazu> okazuList;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int w = sc.nextInt();

        long zero = 0;
        Okazu init = new Okazu(zero, zero);

        okazuList = new ArrayList<Okazu>();
        okazuList.add(init);

        for(int i = 0; i < n; i++) {
            Okazu o = new Okazu(sc.nextLong(), sc.nextLong());
            createList(o);
        }

        long ans = okazuList.stream()
        .filter(i -> i.b <= w)
        .map(i -> i.a)
        .sorted(Comparator.reverseOrder()).toList().get(0);

        System.out.println(ans);
        

    }
    
    static void createList(Okazu o) {
        List<Okazu> oCopy = new ArrayList<>();
        oCopy.addAll(okazuList);

        for (int i = 0; i < okazuList.size(); i++) {
            oCopy.set(i, new Okazu(oCopy.get(i).a + o.a, oCopy.get(i).b + o.b));
        }
        okazuList.addAll(oCopy);
    }
}
