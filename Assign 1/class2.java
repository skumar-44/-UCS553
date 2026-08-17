import java.util.Scanner;

class class2 {
    public static void main(String args[]) {
        System.out.println("Enter Input:");

        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
            System.out.println("It is a char");
        }
        else {
            System.out.println("It is not a char");
        }
        sc.close();
    }
}