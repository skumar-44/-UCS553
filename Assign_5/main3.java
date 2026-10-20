import java.util.*;

class Result<T extends Number> {
    private T marks;

    Result(T marks) {
        this.marks = Objects.requireNonNull(marks);
    }

    double average(T total, int subjects) {
        return total.doubleValue() / subjects;
    }

    boolean passed(double threshold) {
        return marks.doubleValue() >= threshold;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class main3 {
    public static void main(String[] args) {
        Result<Double> r = new Result<>(85.5);
        r.getMarks().ifPresent(System.out::println);
        System.out.println(r.average(85.5, 1));
        System.out.println(r.passed(40));
    }
}