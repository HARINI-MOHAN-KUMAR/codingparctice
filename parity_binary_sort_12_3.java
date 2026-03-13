import java.util.*;

public class parity_binary_sort_12_3{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();

            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                int x = sc.nextInt();

                int setBits = Integer.bitCount(x);

                if (setBits % 2 == 0) {
                    even.add(x);
                } else {
                    odd.add(x);
                }
            }

            Collections.sort(even);
            Collections.sort(odd);

            for (int x : even) {
                System.out.print(x + " ");
            }

            for (int x : odd) {
                System.out.print(x + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}