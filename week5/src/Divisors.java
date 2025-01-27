public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0;
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while ((a%b) != 0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return b;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        if (gcd == 0) return 0;
        return Math.abs(a)/gcd * Math.abs(b);

    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int re = 0;
        if (n <= 0) return re;
        for (int i = 1; i <= n; i++) {
            if (areRelativelyPrime(i, n)) re++;
        }
        return re;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
        System.out.printf("lcm(%d, %d) = %d\n", a, b, lcm(a, b));
        System.out.printf("areRelativelyPrime(%d, %d) = %b\n", a, b, areRelativelyPrime(a, b));
        System.out.printf("totient(%d) = %d\n", a, totient(a));
        System.out.printf("totient(%d) = %d\n", b, totient(b));
    }
}