import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Event name: ");
        String name = sc.nextLine();

        System.out.print("Date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        LocalTime start = LocalTime.of(10, 0);
        Optional<String> venue = Optional.empty();

        System.out.println(name + " " + date + " " + start);
        if (date.isAfter(LocalDate.now()))
            System.out.println("Future");
        else if (date.isEqual(LocalDate.now()))
            System.out.println("Today");
        else
            System.out.println("Past");

        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), date));
        System.out.println(start.plusHours(2));
        System.out.println(venue.orElse("Venue not specified"));
    }
}