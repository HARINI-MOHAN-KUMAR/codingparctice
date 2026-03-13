import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] prefix = new int[n];
            int[] suffix = new int[n];

            prefix[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] | arr[i];
            }

            suffix[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] | arr[i];
            }

            int minLen = Integer.MAX_VALUE;
            int count = 0;

            for (int l = 0; l < n; l++) {

                int currentOR = 0;

                for (int r = l; r < n; r++) {

                    currentOR = currentOR | arr[r];

                    int outsideOR = 0;

                    if (l > 0) {
                        outsideOR = outsideOR | prefix[l - 1];
                    }

                    if (r < n - 1) {
                        outsideOR = outsideOR | suffix[r + 1];
                    }

                    if (currentOR == outsideOR) {

                        int len = r - l + 1;

                        if (len < minLen) {
                            minLen = len;
                            count = 1;
                        } else if (len == minLen) {
                            count++;
                        }
                    }
                }
            }

            if (count == 0) {
                System.out.println(-1);
            } else {
                System.out.println(minLen + " " + count);
            }
        }

        sc.close();
    }
}