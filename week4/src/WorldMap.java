public class WorldMap {
    public static void main(String[] args) {
        int boundingX = StdIn.readInt();
        int boundingY = StdIn.readInt();
        StdDraw.setCanvasSize(boundingX, boundingY);
        StdDraw.setXscale(0, boundingX);
        StdDraw.setYscale(0, boundingY);
        //System.out.println(boundingX +", " + boundingY);
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            //System.out.println("name: " + name);
            int numberOfVertices = StdIn.readInt();
            double[] x = new double[numberOfVertices];
            double[] y = new double[numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
    }
}
