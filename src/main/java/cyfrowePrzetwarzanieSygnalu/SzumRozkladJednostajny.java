package cyfrowePrzetwarzanieSygnalu;

import java.util.Random;

import static java.lang.Math.sqrt;

public class SzumRozkladJednostajny extends Sygnal {

    Random r = new Random();

    public SzumRozkladJednostajny() {
    }

    public SzumRozkladJednostajny(double a, double b, double c, int f) {
        super(a, b, c, f);
        super.setSignalName("Szum rozklad jednostajny");
        this.generateSignal();
    }

    @Override
    public void generateSignal() {

        double tmpValue = 0;
        double[][] tmpPointsList = this.getPointsList();

        for (int i = 0; i < tmpPointsList[0].length; i++) {
            tmpPointsList[1][i] = myRand(0, this.getAmplitude());
        }

        setPointsList(tmpPointsList);

    }

    double myRand(double e, double v) {

        return sqrt(12.0 * v) * ((r.nextInt(101) - 50.0) / 100.0) + e;
    }

}
