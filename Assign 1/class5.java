import java.util.Scanner;
public class class5 {
    public static void main(String[]args){
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter first number");
    int a = sc.nextInt();
    System.out.println("Enter second number");
    int b = sc.nextInt();
    System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
    }
    static int gcd(int a,int b){
        while(a!=0&&b!=0){
            if(a>b){
                a%=b;
            }
            else{
                b%=a;
            }
        }
        if(a==0)return b;
        else return a;
    }
}
