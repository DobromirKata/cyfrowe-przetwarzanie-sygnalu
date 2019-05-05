package cyfrowePrzetwarzanieSygnalu;

public class SygnalProstokatnySymetryczny extends SygnalProstokatny {

    public SygnalProstokatnySymetryczny(double a, double b, double c, double d, double e, int f) {
        super(a, b, c, d, e, f);
        super.setSignalName("Sygnal prostokatny symetryczny");
    }

    @Override
    public void generateSignal() {
        double Amp = this.getAmplitude();
        double t1 = this.gettBegin();

        for (int j = 0; j < this.pointsList[0].length; j++) {
            for (int i = 0; i <= k; i++) {
                if (this.pointsList[0][j] >= (i * interval + t1)
                        && this.pointsList[0][j] < (kw * interval + i * interval + t1)) {
                    this.pointsList[1][j] = Amp;
                } else if (this.pointsList[0][j] >= (kw * interval + t1 + i * interval)
                        && this.pointsList[0][j] < (interval + i * interval + t1)) {
                    this.pointsList[1][j] = -Amp;
                    // }
                }
            }
        }
    }
}
