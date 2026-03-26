import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        int n=s.length();
        for(int i=1;i<=n-k;i++){
            String a=s.substring(i,i+k);
            if(a.compareTo(smallest)<0){
                smallest=a;
            }
            if(a.compareTo(largest)>0){
                largest=a;
            }
        }
        
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
