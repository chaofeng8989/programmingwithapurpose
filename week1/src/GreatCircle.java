
public class GreatCircle {
    public static void main(String[] args) {
        double r = 6371.0;
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double sinx2 = Math.sin(Math.toRadians((x2-x1)/2));
        double coscos = Math.cos(Math.toRadians(x1))*Math.cos(Math.toRadians(x2));
        double siny2 = Math.sin(Math.toRadians((y2-y1)/2));
        double dis = 2 * r * Math.asin(Math.sqrt(sinx2*sinx2 + coscos*siny2*siny2));
        System.out.println(dis + " kilometers");
    }
}