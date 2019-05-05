package cyfrowePrzetwarzanieSygnalu;

import static java.lang.Math.abs;

public class Sygnal {


    protected enum signalType {
        CIAGLY, DYSKRETNY
    }

    protected signalType type = signalType.CIAGLY;
    protected String signalName;
    protected double Amplitude = 0;     // amplituda
    protected double tBegin = 0;        // czas poczatkowy
    protected double signalTime = 0;    // czas trwania sygnalu
    protected double interval = 0;      // okres
    protected double kw = 0;            // wspolczynnik wypelnienia
    protected double ts = 0;            // czas skoku
    protected int jumpSample = 0;       // probka skoku
    protected int numberOfSamples = 0;  // liczba probek
    protected int samplingFrequency = 0;// czestotliwosc, domyslne 1 Hz
    protected double probability = 0;   // prawdopodobienstwo wystapienia skoku
    protected double timeOffset = 0;    // przesuniecie wartosci czasu pobrania probki

    protected double[][] pointsList;

    public Sygnal() {
    }

    public Sygnal(int listlength) {
        pointsList = new double[2][listlength];
    }

    // tworzy tabele na podstawie czasu poczatkowego, czasu trwania sygnalu i
    // probkowania
    public Sygnal(double a, double b, double t, int f) {
        Amplitude = a;
        tBegin = b;
        signalTime = t;
        samplingFrequency = f;
        this.timeOffset = 1.0 / samplingFrequency;

        // probkowanie * dlugosc sygnalu + 1 (zeby pobralo probke na koncu sygnalu
        this.numberOfSamples = (int) ((samplingFrequency * t) + 1);
        pointsList = new double[2][numberOfSamples];

        // ustawia czas pierwszej probki na tBegin
        pointsList[0][0] = tBegin;

        // wpisuje czas kolejnej probki (pobiera poprzedni czas i powieksza o
        // timeOffset)
        for (int i = 1; i < numberOfSamples; i++) {
            pointsList[0][i] = pointsList[0][i - 1] + timeOffset;
        }

    }

    public void generateSignal() {

    }

    public double oblSredniaWartoscSygnalu() {
        double sum = 0.0;

        for (double x : pointsList[1]) {
            sum += x;
        }

        return sum / pointsList[0].length;
    }

    public double oblWartoscSredniaBezwzglednaSygnalu() {
        double sum = 0.0;

        for (double x : pointsList[1]) {
            sum += abs(x);
        }

        return sum / pointsList[0].length;
    }

    public double oblMocSygnalu() {
        double sum = 0.0;

        for (double x : pointsList[1]) {
            sum += (x * x);
        }

        return sum / pointsList[0].length;
    }

    public double oblWartoscSkutecznaSygnalu() {

        return Math.sqrt(this.oblMocSygnalu());
    }

    public double oblWariancjaSygnalu() {

        double srednia = oblSredniaWartoscSygnalu();
        double tmp = 0.0;
        double wartosc = 0.0;

        for (int i = 0; i < this.pointsList[0].length; i++) {
            tmp = (this.pointsList[1][i] - srednia);
            wartosc = wartosc + (tmp * tmp);
        }

        return wartosc / this.pointsList[0].length;
    }

    public String StringToJlist() {
        return this.signalName + " (Amp = " + this.Amplitude + "; tStart = " + this.tBegin + "; signalTime = " + this.signalTime + ")";
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public double getAmplitude() {
        return Amplitude;
    }

    public void setAmplitude(double Amplitude) {
        this.Amplitude = Amplitude;
    }

    public double gettBegin() {
        return tBegin;
    }

    public void settBegin(double tBegin) {
        this.tBegin = tBegin;
    }

    public double getSignalTime() {
        return signalTime;
    }

    public void setSignalTime(int signalTime) {
        this.signalTime = signalTime;
    }

    public double[][] getPointsList() {
        return pointsList;
    }

    public void setPointsList(double[][] pointsList) {
        this.pointsList = pointsList;
    }

    public double getTimeOffset() {
        return timeOffset;
    }

    public int getSamplingFrequency() {
        return samplingFrequency;
    }

    public void setSamplingFrequency(int samplingFrequency) {
        this.samplingFrequency = samplingFrequency;
    }


}
