package cyfrowePrzetwarzanieSygnalu;

public abstract class SygnalOperacje {

    // dodawanie amplitud sygnalow
    public static Sygnal addingSignals(Sygnal s1, Sygnal s2, int[] tab) {

        Sygnal s3 = new Sygnal(s1.pointsList[0].length);
        s3.type = s1.type;

        s3.signalName = "Suma (" + (tab[0] + 1) + " + " + (tab[1] + 1) + ")";

        for (int i = 0; i < s3.pointsList[0].length; i++) {
            s3.pointsList[0][i] = s1.pointsList[0][i];
            s3.pointsList[1][i] = s1.pointsList[1][i] + s2.pointsList[1][i];
        }
        return s3;
    }

    // odejmowanie amplitud sygnalow
    public static Sygnal substractSignals(Sygnal s1, Sygnal s2, int[] tab) {

        Sygnal s3 = new Sygnal(s1.pointsList[0].length);

        s3.signalName = "Różnica (" + (tab[0] + 1) + " + " + (tab[1] + 1) + ")";

        for (int i = 0; i < s3.pointsList[0].length; i++) {
            s3.pointsList[0][i] = s1.pointsList[0][i];
            s3.pointsList[1][i] = s1.pointsList[1][i] - s2.pointsList[1][i];
        }

        return s3;
    }

    // mnozenie amplitud sygnalow
    public static Sygnal multiplySignals(Sygnal s1, Sygnal s2, int[] tab) {

        Sygnal s3 = new Sygnal(s1.pointsList[0].length);

        s3.signalName = "Iloczyn (" + (tab[0] + 1) + " + " + (tab[1] + 1) + ")";

        for (int i = 0; i < s3.pointsList[0].length; i++) {
            s3.pointsList[0][i] = s1.pointsList[0][i];
            s3.pointsList[1][i] = s1.pointsList[1][i] * s2.pointsList[1][i];
        }

        return s3;
    }

    // dzielenie amplitud sygnalow
    public static Sygnal divisionSignals(Sygnal s1, Sygnal s2, int[] tab) {

        Sygnal s3 = new Sygnal(s1.pointsList[0].length);

        s3.signalName = "Iloraz (" + (tab[0] + 1) + " + " + (tab[1] + 1) + ")";

        for (int i = 0; i < s3.pointsList[0].length; i++) {
            s3.pointsList[0][i] = s1.pointsList[0][i];
            s3.pointsList[1][i] = s1.pointsList[1][i] * s2.pointsList[1][i];
        }

        return s3;
    }


}
