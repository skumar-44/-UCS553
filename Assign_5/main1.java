public class main1 {
    static <T extends Number> double sum(T[] arr) {
        double s = 0;
        for (T x : arr)
            s += x.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        Integer[] a = { 1, 2, 3 };
        Float[] b = { 1.5f, 2.5f };
        Double[] c = { 2.5, 3.5 };
        System.out.println(sum(a));
        System.out.println(sum(b));
        System.out.println(sum(c));
    }
}
