public class RevesPuzzle {
    private static String hanoi(int n, int k, char source, char destination, char tmp) {
        if (n == k) return "";
        String move = "Move disc " + n + " from " + source + " to " + destination + "\n";
        return hanoi(n-1, k, source, tmp, destination) + move + hanoi(n-1, k, tmp, destination, source);
    }
    private static String reves(int n, char source, char destination, char tmp1, char tmp2) {
        // slots => {source, tmp, tmp, destination};
        if (n == 0) return "";
        int k = n + 1 - (int) Math.round(Math.sqrt(n+n+1));
        return reves(k, source, tmp1, destination, tmp2) + hanoi(n, k, source, destination, tmp2) + reves(k, tmp1, destination, source, tmp2);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(reves(n, 'A', 'D', 'B', 'C'));
    }
}
