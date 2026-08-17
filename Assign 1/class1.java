import java.util.Scanner;

class class1 {
    public static void main(String args[]) {
        System.out.println("Enter Year");

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        helper(year);
    }

    public static void helper(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println(year + " is a Leap Year");
            } 
            else {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year");
                } 
                else {
                    System.out.println(year + " is not a Leap Year");
                }
            }
        } 
        else {
            System.out.println(year + " is not a Leap Year");
        }
    }
}