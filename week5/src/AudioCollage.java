public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] re = a.clone();
        for (int i = 0; i < re.length; i++) {
            re[i] *= alpha;
        }
        return re;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] re = new double[a.length];
        for (int i = 0; i < re.length; i++) {
            re[a.length - 1 - i] = a[i];
        }
        return re;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] re = new double[a.length + b.length];
        for (int i = 0; i < a.length; i ++) {
            re[i] = a[i];
        }
        for (int i = 0; i < b.length; i ++) {
            re[i+a.length] = b[i];
        }
        return re;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int len = Math.max(a.length, b.length);
        double[] re = new double[len];
        for (int i = 0; i < len; i++) {
            if (i < a.length) re[i] += a[i];
            if (i < b.length) re[i] += b[i];
        }
        return re;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] re = new double[(int)Math.floor(a.length / alpha)];
        for (int i = 0; i < re.length; i++) {
            re[i] = a[(int)Math.floor(i * alpha)];
        }

        return re;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] exposure = StdAudio.read("exposure.wav");

        double[] beatboxFast = changeSpeed(beatbox, 1.2);
        double[] buzzerSlow = changeSpeed(buzzer, 0.80);
        double[] re = mix(beatboxFast, buzzerSlow);
        re = mix(re, chimes);
        re = merge(re, cow);
        re = reverse(re);
        re = amplify(re, 0.7);
        StdAudio.play(re);
    }
}