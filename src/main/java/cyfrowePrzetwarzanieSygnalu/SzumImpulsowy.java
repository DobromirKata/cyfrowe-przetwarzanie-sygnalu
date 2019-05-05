package cyfrowePrzetwarzanieSygnalu;

import static java.lang.Math.random;

public class SzumImpulsowy extends Sygnal {
    public SzumImpulsowy() {
    }

    public SzumImpulsowy(double Amplitude, double tBegin, double signalTime, int samplingFrequency,
                          double probability) {
        this.type = signalType.DYSKRETNY;
        this.signalName = "Szum impulsowy";
        this.Amplitude = Amplitude;
        this.tBegin = tBegin;
        this.signalTime = signalTime; // d
        this.samplingFrequency = samplingFrequency;
        this.probability = probability;
        this.numberOfSamples = (int) (this.signalTime * this.samplingFrequency);
        this.timeOffset = 1.0 / this.samplingFrequency;
        // Amp, tBeg, sTime, freq, probab

        this.generateSignal();
    }

    @Override
    public void generateSignal() {
        pointsList = new double[2][numberOfSamples]; // nowy rozmiar tablicy

        pointsList[0][0] = this.tBegin; // ustawia czas pierwszej probki na tBegin

        // wpisuje czas kolejnej probki (pobiera poprzedni czas i powieksza o timeOffset)
        for (int i = 1; i < pointsList[0].length; i++) {
            pointsList[0][i] = pointsList[0][i - 1] + timeOffset;
        }

        // losuje liczbe double <0-1>, jesli mniejsza od prawdopodobienstwa to wpisuje wartosc amplitudy
        for (int i = 0; i < pointsList[0].length; i++) {
            if (random() < this.probability) {
                pointsList[1][i] = this.Amplitude;
            } else {
                pointsList[1][i] = 0;
            }
        }
    }

}