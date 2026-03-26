import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int m = n / 2;

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int i = 0; i < m; i++)
                freq1[s.charAt(i) - 'a']++;

            for (int i = (n % 2 == 0 ? m : m + 1); i < n; i++)
                freq2[s.charAt(i) - 'a']++;

            System.out.println(Arrays.equals(freq1, freq2) ? "YES" : "NO");
        }

        sc.close();
    }
}
