import java.util.Scanner;

public class class9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number and exponent");
        int base = sc.nextInt();
        int exponent = sc.nextInt();

        int result = (int) Math.pow(base, exponent);

        System.out.println("Answer: " + result);

        sc.close();
    }
}