public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int maxCount = (int)Math.cbrt(n)+2;
        long[] array = new long[maxCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i * i;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            if (array[left] + array[right] == n) {
                System.out.println("one ok");
                int l = left +1, r = right - 1;
                while (l <= r) {
                    if (array[l] + array[r] == n) {
                        return true;
                    } else if (array[l] + array[r] > n) {
                        r --;
                    } else {
                        l ++;
                    }
                }
            } else if (array[left] + array[right] > n) {
                right --;
            } else {
                left ++;
            }
            System.out.println(left + ", " + right);
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
        System.out.println(Math.cbrt(n) + "  " + n);
        System.out.println(Integer.MAX_VALUE);
    }
}