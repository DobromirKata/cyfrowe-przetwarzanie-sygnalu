package model;

import cps.*;

public class Model {

    public static final String[] SYGNALY = { "Rozklad jednostajny",
            "Szum Gaussowski", "Sygnal sinusoidalny", "Sygnal sinusoidalny wyprostowany jednopolowkowo",
            "Sygnal sinusoidalny wyprostowany dwupolowkowo", "Sygnal prostokatny", "Sygnal prostokatny symetryczny",
            "Sygnal trojkatny", "Skok jednostkowy", "Impuls jednostkowy", "Szum impulsowy"
    };

    private int wybranySygnal = 0;
    private double amplituda = 0;       // amplituda
    private double czasPocz = 0;        // czas poczatkowy
    private double czasSyg = 0;         // czas trwania sygnalu
    private double okres = 0;           // okres
    private double wspWyp = 0;          // wspolczynnik wypelnienia
    private double czasSkoku = 0;       // czas skoku
    private int probkaSkoku = 0;        // probka skoku
    private int iloscProbek = 0;        // liczba probek
    private int czestotliwosc = 0;      // czestotliwosc, domyslne 1 Hz
    private double prawdopodobienstwo = 0;   // prawdopodobienstwo wystapienia skoku
    private int histogram = 0;          // przesuniecie wartosci czasu pobrania probki

    public Sygnal generujSygnal() {
        switch (wybranySygnal) {

            case 1:
                return new SzumRozkladGaussa(amplituda, czasPocz, czasSyg, czestotliwosc);
            case 2:
                return new SygnalSinus(amplituda, czasPocz, czasSyg, okres, czestotliwosc);
            case 3:
                return new SygnalSinusJednopolowkowy(amplituda, czasPocz, czasSyg, okres, czestotliwosc);
            case 4:
                return new SygnalSinusDwupolowkowy(amplituda, czasPocz, czasSyg, okres, czestotliwosc);
            case 5:
                return new SygnalProstokatny(amplituda, czasPocz, czasSyg, okres, wspWyp, czestotliwosc);
            case 6:
                return new SygnalProstokatnySymetryczny(amplituda, czasPocz, czasSyg, okres, wspWyp, czestotliwosc);
            case 7:
                return new SygnalTrojkatny(amplituda, czasPocz, czasSyg, okres, wspWyp, czestotliwosc);
            case 8:
                return new SkokJednostkowy(amplituda, czasPocz, czasSyg, czasSyg, czestotliwosc);
            case 9:
                return new ImpulsJednostkowy(amplituda, czasPocz, probkaSkoku, iloscProbek, czestotliwosc);
            case 10:
                return new SzumImpulsowy(amplituda, czasPocz, czasSyg, czestotliwosc, prawdopodobienstwo);
                /*
            case 11:
                return new SygnalDyskretny(amplituda, czasPocz, probkaSkoku, iloscProbek, czestotliwosc);
            case 12:
                return new SygnalDyskretny(amplituda, czasPocz, czasSyg, czestotliwosc, prawdopodobienstwo);
                */
            default:
                return new SzumRozkladJednostajny(amplituda, czasPocz, czasSyg, czestotliwosc);

            // SygnalDyskretny s10 = new SygnalDyskretny(Amplituda, tBegin, ns, samples, freq);
            // plotChart.plotChartAndHistogram(s10);
            // signalList.add(s10);
            // SygnalDyskretny s11 = new SygnalDyskretny(Amplituda, tBegin, signalTime, freq, probability);
            // plotChart.plotChartAndHistogram(s11);
            // signalList.add(s11);
        }
    }


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
