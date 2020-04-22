import java.util.Random;

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int i = 0, j = 0;
        System.out.println("(" + i + ", " + j + ")");
        int step = 0;
        while (Math.abs(i) +  Math.abs(j) < r) {
            int direction = (int) Math.floor(Math.random()*4);
            switch (direction) {
                case 0:
                    i++;
                    break;
                case 1:
                    i--;
                    break;
                case 2:
                    j++;
                    break;
                case 3:
                    j--;
                    break;
            }
            step++;
            System.out.println("(" + i + ", " + j + ")");
        }
        System.out.println("steps = " + step);
    }
}
