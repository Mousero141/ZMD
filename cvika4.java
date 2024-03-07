 public static double countMSE(double[][] original, double[][] modified) {
        if (original.length != modified.length || original[0].length != modified[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        int rows = original.length;
        int cols = original[0].length;

        double sumSquaredError = 0.0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double error = original[i][j] - modified[i][j];
                sumSquaredError += error * error;
            }
        }

        return sumSquaredError / (rows * cols);
    }

    public static double countMAE(double[][] original, double[][] modified) {
        if (original.length != modified.length || original[0].length != modified[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        int rows = original.length;
        int cols = original[0].length;

        double sumAbsoluteError = 0.0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double error = Math.abs(original[i][j] - modified[i][j]);
                sumAbsoluteError += error;
            }
        }

        return sumAbsoluteError / (rows * cols);
    }

    public static double countSAE(double[][] original, double[][] modified) {
        if (original.length != modified.length || original[0].length != modified[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }

        int rows = original.length;
        int cols = original[0].length;

        double sumAbsoluteError = 0.0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double error = Math.abs(original[i][j] - modified[i][j]);
                sumAbsoluteError += error;
            }
        }

        return sumAbsoluteError;
    }

    public static double countPSNR(double MSE) {
        double maxPixelValue = 255.0;

        return 20 * Math.log10(maxPixelValue / Math.sqrt(MSE));
    }

    public static double countPSNRforRGB(double mseRED, double mseGREEN, double mseBLUE) {
        double maxPixelValue = 255.0;

        double mseAverage = (mseRED + mseGREEN + mseBLUE) / 3.0;

        return 20 * Math.log10(maxPixelValue / Math.sqrt(mseAverage));
    }
