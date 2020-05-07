public class KernelFilter {
    private static Picture transform(Picture picture, double[][] pattern) {
        Picture result = new Picture(picture.width(), picture.height());
        int len = pattern.length;
        for (int i = 0; i < picture.width(); i++) {
            for (int j = 0; j < picture.height(); j++) {
                double tobeR = 0, tobeG = 0, tobeB = 0;
                //System.out.println(picture.get(i, j));
                for (int x = -len/2; x <= len/2; x++) {
                    for (int y = -len/2; y <= len/2; y++) {
                        int rgb = picture.getRGB((i + x + picture.width()) % picture.width(), (j + y + picture.height()) % picture.height());
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >>  8) & 0xFF;
                        int b = (rgb >>  0) & 0xFF;
                        tobeR += pattern[len/2 + x][len/2 + y] * r;
                        tobeG += pattern[len/2 + x][len/2 + y] * g;
                        tobeB += pattern[len/2 + x][len/2 + y] * b;
                    }
                }
                int r = (int) Math.round(tobeR);
                int g = (int) Math.round(tobeG);
                int b = (int) Math.round(tobeB);
                if (r > 255) {
                    r = 255;
                } else if (r < 0) {
                    r = 0;
                }
                if (g > 255) {
                    g = 255;
                } else if (g < 0) {
                    g = 0;
                }
                if (b > 255) {
                    b = 255;
                } else if (b < 0) {
                    b = 0;
                }
                int rgb = (r << 16) + (g << 8) + (b << 0);
                result.setRGB(i, j, rgb);
            }
        }
        return result;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] gaussina = {
                {1.0/16, 2.0/16, 1.0/16},
                {2.0/16, 4.0/16, 2.0/16},
                {1.0/16, 2.0/16, 1.0/16}
        };
        return transform(picture, gaussina);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] sharpen = {{0,-1,0},{-1,5,-1},{0,-1,0}};

        return transform(picture, sharpen);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] laplacian = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};

        return transform(picture, laplacian);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] emboss = {{-2,-1,0},{-1,1,1},{0,1,2}};

        return transform(picture, emboss);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] motionBlur = {
                {1.0/9,0,0,0,0,0,0,0,0},
                {0,1.0/9,0,0,0,0,0,0,0},
                {0,0,1.0/9,0,0,0,0,0,0},
                {0,0,0,1.0/9,0,0,0,0,0},
                {0,0,0,0,1.0/9,0,0,0,0},
                {0,0,0,0,0,1.0/9,0,0,0},
                {0,0,0,0,0,0,1.0/9,0,0},
                {0,0,0,0,0,0,0,1.0/9,0},
                {0,0,0,0,0,0,0,0,1.0/9},
        };
        return transform(picture, motionBlur);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture input = new Picture(args[0]);
        input.show();
        Picture output = motionBlur(input);
        output.show();
    }

}