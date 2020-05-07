
public class Clock {
    private int h, m;
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException();
        if (s.charAt(2) != ':') throw new IllegalArgumentException();
        String hh = s.substring(0, 2);
        String mm = s.substring(3, 5);
        int h = 0, m = 0;
        try {
            h = Integer.parseInt(hh);
            m = Integer.parseInt(mm);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException();

        this.h = h;
        this.m = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (h < 10 && m < 10) return "0" + h + ":0"+m;
        else if (h < 10) return "0" + h + ":" +m;
        else if (m < 10) return h + ":0" + m;
        else return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (that.h == this.h) return that.m > this.m;
        return that.h > this.h;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        toc(1);
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException();
        if (m + delta > 59) {
            int deltaH = (m + delta) / 60;
            m = (m + delta) % 60;
            h = (h + deltaH) % 24;
        } else {
            m+=delta;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c1 = new Clock(12, 24);
        Clock c2 = new Clock("23:00");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.isEarlierThan(c2));
        c1.tic();
        System.out.println(c1);
        c1.toc(300);
        System.out.println(c1);
    }
}