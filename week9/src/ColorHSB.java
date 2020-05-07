public class ColorHSB {
    private int h, s, b;
    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) throw new IllegalArgumentException();
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return s == 0 || b == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException();
        return Math.min(
                 (this.h - that.h) * (this.h - that.h),
                (360 - Math.abs(this.h - that.h)) * (360 - Math.abs(this.h - that.h)))
                + (this.s - that.s) * (this.s - that.s)
                + (this.b - that.b) * (this.b - that.b);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB initialColor = new ColorHSB(h, s, b);
        int currentMinDis = Integer.MAX_VALUE;
        ColorHSB currentMin = null;
        String minName = "";
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h1 = StdIn.readInt();
            int s1 = StdIn.readInt();
            int b1 = StdIn.readInt();
            ColorHSB tmp = new ColorHSB(h1, s1, b1);
            int nowDis = initialColor.distanceSquaredTo(tmp);
            //System.out.println(tmp + " "+ nowDis);
            if (currentMin == null) {
                currentMin = tmp;
                currentMinDis = nowDis;
                minName = name;
            } else if (currentMinDis > nowDis) {
                currentMin = tmp;
                currentMinDis = nowDis;
                minName = name;
            }
        }
        System.out.println(minName + " " + currentMin);
    }

}