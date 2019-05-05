package cps;

public class SygnalTrojkatny extends Sygnal {

    double interval = 0; // okres sygnalu
    double kw = 0; // wspolczynnik wypelnienia
    int k = 0; // okresla liczbe pelnych okresow w zadanym zakresie czasu

    public SygnalTrojkatny() {
    }

    public SygnalTrojkatny(double a, double b, double c, double d, double e, int f) {
        super(a, b, c, f);
        super.setSignalName("Sygnal trojkatny");
        interval = d;
        kw = e;
        k = (int) (c / d);
        generateSignal();
    }

    @Override
    public void generateSignal() {
        double Amp = this.getAmplitude();
        double t1 = this.gettBegin();
        double t = 0;

        for (int j = 0; j < this.pointsList[0].length; j++) {

            t = this.pointsList[0][j];

            for (int i = 0; i <= k; i++) {
                if (t >= (i * interval + t1) && this.pointsList[0][j] < (kw * interval + i * interval + t1)) {
                    this.pointsList[1][j] = ((Amp * (t - i * interval - t1)) / (kw * interval));

                } else if (this.pointsList[0][j] >= (kw * interval + t1 + i * interval)
                        && this.pointsList[0][j] < (interval + i * interval + t1)) {
                    this.pointsList[1][j] = ((-Amp * (t - i * interval - t1)) / (interval * (1 - kw)) + Amp / (1 - kw));

                }
            }
        }
    }

}
