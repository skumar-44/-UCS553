import java.util.Scanner;


public class class3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number");
        int n  = sc.nextInt();
        int ans =  1;
        for(int i = 2;i<=n;i++){
            ans*=i;
        }
        System.err.println("Factorial of "+n+" is "+ans);
    }
}