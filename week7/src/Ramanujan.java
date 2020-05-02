public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n <= 0) return false;
        int maxCount = (int)Math.cbrt(n)+2;
        long[] array = new long[maxCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = (long)i * i * i;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            int result = Long.compareUnsigned(array[left] + array[right], n);
            if (result == 0)  {
                int l = left +1, r = right - 1;
                while (l < r) {
                    int result2 = Long.compareUnsigned(array[l] + array[r], n);

                    if (result2 == 0) {
                        return true;
                    } else if (result2 > 0) {
                        r --;
                    } else {
                        l ++;
                    }
                }
                right--;
                left++;
            } else if (result > 0) {
                right --;
            } else {
                left ++;
            }
//            System.out.println(left + ", " + right);
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseUnsignedLong(args[0]);
        System.out.println(isRamanujan(n));
//        System.out.println(isRamanujan(1729));
//        System.out.println(isRamanujan(3458));
//        System.out.println(isRamanujan(4104));
//        System.out.println(isRamanujan(216125));


    }
}