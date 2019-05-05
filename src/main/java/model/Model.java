package model;

public class Model {

    public static final String[] SYGNALY = { "Rozklad jednostajny",
            "Szum Gaussowski", "Sygnal sinusoidalny", "Sygnal sinusoidalny wyprostowany jednopolowkowo",
            "Sygnal sinusoidalny wyprostowany dwupolowkowo", "Sygnal prostokatny", "Sygnal prostokatny symetryczny",
            "Sygnal trojkatny", "Skok jednostkowy", "Impuls jednostkowy", "Szum impulsowy"
    };

    private int wybranySygnal = 0;
    private double amplituda = 0;     // amplituda
    private double czaspocz = 0;        // czas poczatkowy
    private double czassyg = 0;    // czas trwania sygnalu
    private double okres = 0;      // okres
    private double wspwyp = 0;            // wspolczynnik wypelnienia
    private double czasskoku = 0;            // czas skoku
    private int probkaskoku = 0;       // probka skoku
    private int iloscprobek = 0;  // liczba probek
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
        return czaspocz;
    }

    public void setCzaspocz(double czaspocz) {
        this.czaspocz = czaspocz;
    }

    public double getCzassyg() {
        return czassyg;
    }

    public void setCzassyg(double czassyg) {
        this.czassyg = czassyg;
    }

    public double getOkres() {
        return okres;
    }

    public void setOkres(double okres) {
        this.okres = okres;
    }

    public double getWspwyp() {
        return wspwyp;
    }

    public void setWspwyp(double wspwyp) {
        this.wspwyp = wspwyp;
    }

    public double getCzasskoku() {
        return czasskoku;
    }

    public void setCzasskoku(double czasskoku) {
        this.czasskoku = czasskoku;
    }

    public int getProbkaskoku() {
        return probkaskoku;
    }

    public void setProbkaskoku(int probkaskoku) {
        this.probkaskoku = probkaskoku;
    }

    public int getIloscprobek() {
        return iloscprobek;
    }

    public void setIloscprobek(int iloscprobek) {
        this.iloscprobek = iloscprobek;
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
