package model;

public class Model {

    public static final String[] SYGNALY = { "Rozklad jednostajny",
            "Szum Gaussowski", "Sygnal sinusoidalny", "Sygnal sinusoidalny wyprostowany jednopolowkowo",
            "Sygnal sinusoidalny wyprostowany dwupolowkowo", "Sygnal prostokatny", "Sygnal prostokatny symetryczny",
            "Sygnal trojkatny", "Skok jednostkowy", "Impuls jednostkowy", "Szum impulsowy"
    };

    private int wybranySygnal = 0;

    public int getWybranySygnal() {
        return wybranySygnal;
    }

    public void setWybranySygnal(int wybranySygnal) {
        this.wybranySygnal = wybranySygnal;
    }



}
