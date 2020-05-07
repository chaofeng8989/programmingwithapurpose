public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        String pattern = "CAG";
        int max = 0;
        int index = 0;
        while (true) {
            int start = dna.indexOf(pattern, index);
            if (start == -1) break;
            int tmp = start;
            while (dna.indexOf(pattern, tmp) == tmp) tmp+=3;
            max = Math.max(max, (tmp-start)/3);
            index = tmp;
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replaceAll("\\s", "");
        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9) {
            return "not human";
        } else if (maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats <= 39) {
            return "high risk";
        } else if (maxRepeats <= 180) {
            return "Huntington's";
        } else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String input = in.readAll();
        String removeSpace = removeWhitespace(input);
        int max = maxRepeats(removeSpace);
        System.out.println("max repeats = " + max);
        System.out.println(diagnose(max));
    }

}