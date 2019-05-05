package cps;

import java.util.Random;

import static java.lang.Math.sqrt;

public class SzumRozkladGaussa extends Sygnal {

    Random r = new Random();

    public SzumRozkladGaussa() {
    }

    public SzumRozkladGaussa(double a, double b, double c, int f) {
        super(a, b, c, f);
        super.setSignalName("Szum gaussowski");
        this.generateSignal();
    }

    @Override
    public void generateSignal() {

        Random r = new Random();

        double tmpValue = 0;
        double[][] tmpPointsList = this.getPointsList();

        for (int i = 1; i < tmpPointsList[0].length; i++) {
            tmpPointsList[1][i] = myGauss(0.0, this.getAmplitude());
        }

        setPointsList(tmpPointsList);
    }

    // Generator zmiennej losowej o rozkladzie rownomiernym, wartosci oczekiwanej e oraz wariancji v.
    double myRand(double e, double v) {

        return sqrt(12.0 * v) * ((r.nextInt(101) - 50.0) / 100.0) + e;
    }

    double myGauss(double e, double v) {

        int n = 10;
        double x = 0.0;
        for (int i = 0; i < n; i++) {
            x += myRand(0.0, 1.0);
        }
        return x * sqrt(v / (double) n) + e;
    }

}
