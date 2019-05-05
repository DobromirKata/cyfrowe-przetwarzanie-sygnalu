package cyfrowePrzetwarzanieSygnalu;

import static java.lang.Math.abs;
import static java.lang.Math.sin;

public class SygnalSinusJednopolowkowy extends SygnalSinus {

    public SygnalSinusJednopolowkowy() {
    }

    public SygnalSinusJednopolowkowy(double a, double b, double c, double d, int f) {
        super(a, b, c, d, f);
        super.setSignalName("Sygnal sinusoidalny - wyprostowany jednopolowkowo");
        this.generateSignal();
    }

    @Override
    public void generateSignal() {

        double Amp = this.getAmplitude();
        double t; // czas aktualnej probki
        double t1 = this.gettBegin(); // poczatek sygnalu - tBegin

        double[][] tmpPointsList = this.getPointsList();

        for (int i = 0; i < tmpPointsList[0].length; i++) {

            t = tmpPointsList[0][i];
            double tmp = sin(((2 * Math.PI) / interval) * (t - t1));
            tmpPointsList[1][i] = (Amp / 2) * (tmp + abs(tmp));
        }

        this.setPointsList(tmpPointsList);

    }

}
