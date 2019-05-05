package cyfrowePrzetwarzanieSygnalu;

public class ImpulsJednostkowy extends Sygnal {

    public ImpulsJednostkowy() {
    }

    public ImpulsJednostkowy(double amplitude, double begin, int jump, int samples, int freq) {
        this.type = signalType.DYSKRETNY;
        this.signalName = "Impuls jednostkowy";
        this.Amplitude = amplitude;
        this.tBegin = begin;
        this.jumpSample = jump;
        this.numberOfSamples = samples;
        this.samplingFrequency = freq;
        this.timeOffset = 1.0 / this.samplingFrequency;

        this.generateSignal();

    }

    @Override
    public void generateSignal() {

        this.pointsList = new double[2][numberOfSamples];// nowy rozmiar tablicy
        this.pointsList[0][0] = tBegin;// ustawia czas pierwszej probki na tBegin

        // wpisuje czas kolejnej probki (pobiera poprzedni czas i powieksza o
        // timeOffset)
        for (int i = 1; i < this.pointsList[0].length; i++) {
            this.pointsList[0][i] = this.pointsList[0][i - 1] + this.timeOffset;
        }

        // generowanie sygnalu - wszedzie wpisuje 0
        for (int i = 0; i < this.pointsList[0].length; i++) {
            this.pointsList[1][i] = 0;
        }

        this.pointsList[1][this.jumpSample - 1] = this.Amplitude; // tylko w probce w ktorej ma nastapic skok wpisuje
        // wartosc amplitudy

    }

}
