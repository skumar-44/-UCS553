import java.io.*;

public class StudentFileHandling {

    public static void main(String[] args) {

        try (
                FileInputStream fin = new FileInputStream("input.jpg");
                FileOutputStream fout = new FileOutputStream("copy.jpg")) {

            int data;

            while ((data = fin.read()) != -1) {
                fout.write(data);
            }

            System.out.println("Binary file copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (
                FileWriter fw = new FileWriter("students.txt")) {

            fw.write("101, Sparsh, Computer Science\n");
            fw.write("102, Rahul, Electronics\n");
            fw.write("103, Aman, Mechanical\n");

            System.out.println("Student records written successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (
                FileReader fr = new FileReader("students.txt")) {

            int ch;

            System.out.println("\nStudent Records:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
