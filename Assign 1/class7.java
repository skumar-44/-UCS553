import java.util.Scanner;
public class class7 {
    public static void main (String[]args){
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int cnt = 0;
        while(temp!=0){
          temp/=10;
          cnt++;
        }
        System.out.println("Digits in number "+n+" is "+cnt);
        sc.close();
    }
}
