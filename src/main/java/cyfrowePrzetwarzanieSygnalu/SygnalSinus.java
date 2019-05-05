package cyfrowePrzetwarzanieSygnalu;

import static java.lang.Math.sin;

public class SygnalSinus extends Sygnal {

    public SygnalSinus() {

    }

    public SygnalSinus(double a, double b, double c, double d, int f) {
        super(a, b, c, f);
        super.setSignalName("Sygnal sinusoidalny");
        interval = d;
        this.generateSignal();
    }

    @Override
    public void generateSignal() {

        double Amp = this.getAmplitude();
        double t;                       // czas aktualnej proki
        double t1 = this.gettBegin();   // poczatek sygnalu - tBegin

        double[][] tmpPointsList = this.getPointsList();

        for (int i = 0; i < tmpPointsList[0].length; i++) {

            t = tmpPointsList[0][i];
            tmpPointsList[1][i] = Amp * Math.sin(((2 * Math.PI) / interval) * (t - t1));
        }

        this.setPointsList(tmpPointsList);

    }

}
