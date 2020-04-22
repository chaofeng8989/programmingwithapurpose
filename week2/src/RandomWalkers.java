import java.util.Random;

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        long all = 0;
        for (int x = 0; x < trials; x++){
            int step = 0;
            int i = 0, j = 0;

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
            }
            all += step;

        }
        System.out.println("average number of steps = " + 1.0*all/trials);
    }
}
