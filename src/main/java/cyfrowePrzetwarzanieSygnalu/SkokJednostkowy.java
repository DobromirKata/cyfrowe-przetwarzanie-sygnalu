package cyfrowePrzetwarzanieSygnalu;


public class SkokJednostkowy extends Sygnal {

    double ts = 0; // moment skoku

    public SkokJednostkowy() {
    }

    public SkokJednostkowy(double a, double b, double c, double d, int f) {
        super(a, b, c, f);
        super.setSignalName("Skok jednostkowy");
        ts = d;
        this.generateSignal();
    }

    @Override
    public void generateSignal() {
        for (int i = 0; i < this.pointsList[0].length; i++) {
            if (this.pointsList[0][i] < ts)
                this.pointsList[1][i] = 0;
            else if (this.pointsList[0][i] == ts)
                this.pointsList[1][i] = this.getAmplitude() / 2;
            else if (this.pointsList[0][i] > ts)
                this.pointsList[1][i] = this.getAmplitude();
        }
    }

}