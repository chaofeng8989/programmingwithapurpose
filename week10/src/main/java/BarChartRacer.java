import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BarChartRacer {
    public static void main(String[] args) {
        String fileName = args[0];
        int n = Integer.parseInt(args[1]);
        display(fileName, n);
    }
    private static void display(String fileName, int n)  {
        In in = new In(fileName);
        String title = "", xlabel ="", source ="";
        title = in.readLine();
        xlabel = in.readLine();
        source = in.readLine();
        in.readLine();
        BarChart chart = new BarChart(title, xlabel, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (in.hasNextLine()) {
            chart.reset();
            int num = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[num];

            int year = 0;


            for (int i = 0; i < num; i++) {
                String content = "";
                content = in.readLine();
                String[] data = content.split(",");
                year = Integer.parseInt(data[0].substring(0, 4));
                String name = data[1];
                String country = data[2];
                int value = Integer.parseInt(data[3]);
                String category = data[4];
                bars[i] = new Bar(name, value, category);
                //System.out.println("(" + bars[i].getName() + ", " + bars[i].getValue() + ", " + bars[i].getCategory() + ") ");
            }
            in.readLine();
            Arrays.sort(bars);
            for (int i = 0; i < n; i++) {
                Bar b = bars[bars.length-1-i];
                chart.add(b.getName(), b.getValue(), b.getCategory());
            }

            chart.setCaption(""+year);
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(30);

        }
        //System.out.println("total lines = " + lines);
    }
}
