public class DiscreteDistribution {
    public static void main(String[] args) {
        int inputSize = args.length;
        int[] input = new int[inputSize - 1];
        int need = Integer.parseInt(args[0]);
        int all = 0;
        for (int i = 1; i < inputSize; i++) {
            input[i-1] = Integer.parseInt(args[i]);
            all += input[i-1];
        }
        int[] ran = new int[all];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i]; j++) {
                ran[index++] = i+1;
            }
        }

/*        for (int r : ran) System.out.print(r + " ");
        System.out.println();
*/

        for (int i = 0; i < need; i++) {
            int ranIndex = (int)Math.floor(Math.random() * all);
            System.out.print(ran[ranIndex] + " ");
        }

    }
}
