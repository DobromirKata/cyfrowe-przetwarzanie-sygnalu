package model;

public class Model {

    public static final String[] SYGNALY = { "Rozklad jednostajny",
            "Szum Gaussowski", "Sygnal sinusoidalny", "Sygnal sinusoidalny wyprostowany jednopolowkowo",
            "Sygnal sinusoidalny wyprostowany dwupolowkowo", "Sygnal prostokatny", "Sygnal prostokatny symetryczny",
            "Sygnal trojkatny", "Skok jednostkowy", "Impuls jednostkowy", "Szum impulsowy"
    };

    private int wybranySygnal = 0;
    private double amplituda = 0;     // amplituda
    private double czasPocz = 0;        // czas poczatkowy
    private double czasSyg = 0;    // czas trwania sygnalu
    private double okres = 0;      // okres
    private double wspWyp = 0;            // wspolczynnik wypelnienia
    private double czasSkoku = 0;            // czas skoku
    private int probkaSkoku = 0;       // probka skoku
    private int iloscProbek = 0;  // liczba probek
    private int czestotliwosc = 0;// czestotliwosc, domyslne 1 Hz
    private double prawdopodobienstwo = 0;   // prawdopodobienstwo wystapienia skoku
    private int histogram = 0;    // przesuniecie wartosci czasu pobrania probki

    public int getWybranySygnal() {
        return wybranySygnal;
    }

    public void setWybranySygnal(int wybranySygnal) {
        this.wybranySygnal = wybranySygnal;
    }

    public double getAmplituda() {
        return amplituda;
    }

    public void setAmplituda(double amplituda) {
        this.amplituda = amplituda;
    }

    public double getCzaspocz() {
        return czasPocz;
    }

    public void setCzaspocz(double czaspocz) {
        this.czasPocz = czaspocz;
    }

    public double getCzassyg() {
        return czasSyg;
    }

    public void setCzassyg(double czassyg) {
        this.czasSyg = czassyg;
    }

    public double getOkres() {
        return okres;
    }

    public void setOkres(double okres) {
        this.okres = okres;
    }

    public double getWspWyp() {
        return wspWyp;
    }

    public void setWspWyp(double wspWyp) {
        this.wspWyp = wspWyp;
    }

    public double getCzasSkoku() {
        return czasSkoku;
    }

    public void setCzasSkoku(double czasSkoku) {
        this.czasSkoku = czasSkoku;
    }

    public int getProbkaSkoku() {
        return probkaSkoku;
    }

    public void setProbkaSkoku(int probkaSkoku) {
        this.probkaSkoku = probkaSkoku;
    }

    public int getIloscProbek() {
        return iloscProbek;
    }

    public void setIloscProbek(int iloscProbek) {
        this.iloscProbek = iloscProbek;
    }

    public int getCzestotliwosc() {
        return czestotliwosc;
    }

    public void setCzestotliwosc(int czestotliwosc) {
        this.czestotliwosc = czestotliwosc;
    }

    public double getPrawdopodobienstwo() {
        return prawdopodobienstwo;
    }

    public void setPrawdopodobienstwo(double prawdopodobienstwo) {
        this.prawdopodobienstwo = prawdopodobienstwo;
    }

    public int getHistogram() {
        return histogram;
    }

    public void setHistogram(int histogram) {
        this.histogram = histogram;
    }
}
