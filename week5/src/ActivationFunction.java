public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0;
        else if (x == 0) return 0.5;
        else return 1;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Math.exp(-x) == -1) return Double.NaN;
        return 1.0 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
//        if (Double.isInfinite(x)) {
//            if (x > 0) return 1;
//            else return -1;
//        }
        if (x >= Double.MAX_VALUE) return 1;
        if (x <= -Double.MAX_VALUE) return -1;
        double ex = Math.exp(x);
        double emx = Math.exp(-x);
        if (ex == emx) return 0;
        return (ex -emx) / (ex + emx);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
//        if (Double.isInfinite(x)) {
//            if (x > 0) return 1;
//            else return -1;
//        }
        if (x >= Double.MAX_VALUE) return 1;
        if (x <= -Double.MAX_VALUE) return -1;
        return 1.0 * x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return x;
        double x24 = x*x/4;
        if (x <= -2) return -1;
        else if (x < 0) return x + x24;
        else if (x < 2) return x - x24;
        else return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        //System.out.println(Double.POSITIVE_INFINITY + 1);
        //System.out.println((Double.POSITIVE_INFINITY+1) / Double.POSITIVE_INFINITY);
        double n = Double.parseDouble(args[0]);
        System.out.printf("heaviside(%f) = %f\n", n, heaviside(n));
        System.out.printf("sigmoid(%f) = %.16f\n", n, sigmoid(n));
        System.out.printf("tanh(%f) = %.16f\n", n, tanh(n));
        System.out.printf("softsign(%f) = %.16f\n", n, softsign(n));
        System.out.printf("sqnl(%f) = %f\n", n, sqnl(n));

    }
}