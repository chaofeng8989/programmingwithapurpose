
public class RightTriangle {
    public static void main(String[] args) {
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);
        System.out.println((a>0 && b>0 && c>0) &&(a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a));
    }

}