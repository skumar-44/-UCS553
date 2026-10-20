
import java.util.*;

class Course {
    String code;
    int capacity;
    HashSet<String> enrolled = new HashSet<>();
    ArrayList<String> prerequisites = new ArrayList<>();
    LinkedList<String> waitlist = new LinkedList<>();

    Course(String code, int capacity, List<String> prereqs) {
        this.code = code;
        this.capacity = capacity;
        this.prerequisites.addAll(prereqs);
    }
}

public class Main1 {
    static HashMap<String, Course> courses = new HashMap<>();
    static HashMap<String, HashSet<String>> completed = new HashMap<>();

    static void addCourse(String code, int capacity, String... prereqs) {
        courses.put(code, new Course(code, capacity, Arrays.asList(prereqs)));
    }

    static void completeCourse(String student, String code) {
        completed.computeIfAbsent(student, k -> new HashSet<>()).add(code);
    }

    static boolean hasPrerequisites(String student, Course c) {
        return completed.getOrDefault(student, new HashSet<>())
                .containsAll(c.prerequisites);
    }

    static void register(String student, String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        if (!hasPrerequisites(student, c)) {
            System.out.println("Prerequisites not completed");
            return;
        }

        if (c.enrolled.contains(student) || c.waitlist.contains(student)) {
            System.out.println("Already registered or waitlisted");
            return;
        }

        if (c.enrolled.size() < c.capacity) {
            c.enrolled.add(student);
            System.out.println(student + " enrolled in " + code);
        } else {
            c.waitlist.addLast(student);
            System.out.println(student + " added to waitlist");
        }
    }

    static void drop(String student, String code) {
        Course c = courses.get(code);

        if (c == null || !c.enrolled.remove(student)) {
            System.out.println("Student not enrolled");
            return;
        }

        System.out.println(student + " dropped " + code);

        if (!c.waitlist.isEmpty()) {
            String next = c.waitlist.removeFirst();
            c.enrolled.add(next);
            System.out.println(next + " promoted from waitlist");
        }
    }

    static void display(String code) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found");
            return;
        }

        System.out.println("Course: " + c.code);
        System.out.println("Enrolled: " + c.enrolled);
        System.out.println("Prerequisites: " + c.prerequisites);
        System.out.println("Waitlist: " + c.waitlist);
    }

    public static void main(String[] args) {
        addCourse("CS101", 2);
        addCourse("CS201", 2, "CS101");
        for (String s : Arrays.asList("S1", "S2", "S3", "S4"))
            completeCourse(s, "CS101");
        for (String s : Arrays.asList("S1", "S2", "S3", "S4"))
            register(s, "CS101");
        display("CS101");
        drop("S1", "CS101");
        display("CS101");
        register("S3", "CS201");
        display("CS201");
    }
}
