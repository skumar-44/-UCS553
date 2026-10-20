import java.util.*;

public class main2 {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("abc@gmail.com");
        Optional<String> empty = Optional.empty();

        email.ifPresent(x -> System.out.println(x));
        System.out.println(empty.orElse("default@gmail.com"));

        System.out.println(empty.orElseThrow(
                () -> new NoSuchElementException("Email missing")));
    }
}