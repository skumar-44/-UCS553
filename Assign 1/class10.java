import java.util.Scanner;
public class class10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter a String");
        String s = sc.nextLine();
        helper(s);
        sc.close();
    }
    static void helper(String s){
        for(int i = 0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
              System.err.println("Not a palindrome");
              return;
            }
        }
        System.err.println("Is a palindrome");
        
    }
}
