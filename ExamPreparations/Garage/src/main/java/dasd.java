public class dasd {

    public static void main(String[] args) {
        int a = 40;
        int b = 80;
        b = -a - 2 * b;
        int c = 0;
        if (a < b) {
            c = b - a;
        } else {
            c = a - 2 * b;
        }

        System.out.println(c);
    }
}
