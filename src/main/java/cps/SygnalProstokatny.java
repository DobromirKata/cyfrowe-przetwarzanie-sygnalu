package cps;

public class SygnalProstokatny extends Sygnal {

        double interval = 0; // okres sygnalu
        double kw = 0; // wspolczynnik wypelnienia
        int k = 0; // okresla liczbe pelnych okresow w zadanym zakresie czasu

        public SygnalProstokatny() {
        }

        public SygnalProstokatny(double a, double b, double c, double d, double e, int f) {
            super(a, b, c, f);
            super.setSignalName("Sygnal prostokatny");
            interval = d;
            kw = e;
            k = (int) (c / d);
            generateSignal();
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
                        this.pointsList[1][j] = 0;
                        // }
                    }
                }
            }
        }
}
