public class RevesPuzzle {
    public static String hanoi(int n, int k, boolean left, String[] slots, int[] now) {
        if (n == k) return " ";
        String move;
        if (left) {
            move = n + "L";
            move = "Move disc "+ n +" from A to D";
        } else {
            move = n + "R";
        }
        return hanoi(n-1, !left) + move + hanoi(n-1, !left);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(hanoi(n, false));
    }
}
