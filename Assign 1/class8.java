import java.util.*;
public class class8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        int temp = n;
        int rev = 0;
        while(temp!=0){
            int digit = temp%10;
            temp/=10;
            rev = rev*10+digit;
        }
        System.err.println("Reverse of "+n+" is "+rev);
        sc.close();
    }
}
