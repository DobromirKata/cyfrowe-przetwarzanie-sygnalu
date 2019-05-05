package view;

import javax.swing.*;

public class View {
    private JFrame frame;
    private JPanel mainPanel;
    private JComboBox wyborSygnalu;
    private JSpinner poleAmplituda;
    private JSpinner poleCzasPocz;
    private JSpinner poleCzasSyg;
    private JSpinner poleWspWyp;
    private JSpinner poleOkres;
    private JSpinner poleCzasSkoku;
    private JSpinner poleProbkaSkoku;
    private JSpinner poleIloscPr;
    private JSpinner poleCzestotliwosc;
    private JSlider histogramSlider;
    private JButton generujButton;
    private JButton wczytajButton;
    private JButton wyświetlButton;
    private JButton zapiszButton;
    private JList list1;
    private JLabel histoNum;
    private JSpinner polePrawdopodobienstwo;
    private JPanel iloscProbekHistog;
    private JButton dodajButton;
    private JButton odejmijButton;
    private JButton mnozenieButton;
    private JButton dzielenieButton;

    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public View() {
        // TODO: Tytuł okna programu
        frame = new JFrame("....");

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setVisible(true);

        ustawTypy();
        aktualizujPrzyciski(0);

        histogramSlider.addChangeListener(e -> histoNum.setText(Integer.toString(histogramSlider.getValue())));
        list1.setModel(listModel);
    }
    
    public void aktualizujPrzyciski(int wybranySygnal) {
        wybranySygnal = wybranySygnal + 1;
        if (wybranySygnal >= 1 && wybranySygnal <= 2) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(true);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(false);
            poleIloscPr.setEnabled(false);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleAmplituda.setValue(1.0);
            poleCzasPocz.setValue(0.0);
            poleCzasSyg.setValue(200.0);
            poleCzestotliwosc.setValue(1);
        } else if (wybranySygnal >= 3 && wybranySygnal <= 5) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(true);
            poleOkres.setEnabled(true);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(false);
            poleIloscPr.setEnabled(false);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleAmplituda.setValue(1.0);
            poleCzasPocz.setValue(0.0);
            poleCzasSyg.setValue(200.0);
            poleOkres.setValue(200.0);
            poleCzestotliwosc.setValue(1);
        } else if (wybranySygnal >= 6 && wybranySygnal <= 8) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(true);
            poleOkres.setEnabled(true);
            poleWspWyp.setEnabled(true);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(false);
            poleIloscPr.setEnabled(false);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleAmplituda.setValue(1.0);
            poleCzasPocz.setValue(0.0);
            poleCzasSyg.setValue(200.0);
            poleOkres.setValue(200.0);
            poleWspWyp.setValue(0.5);
            poleCzestotliwosc.setValue(1);
        } else if (wybranySygnal == 9) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(true);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(true);
            poleProbkaSkoku.setEnabled(false);
            poleIloscPr.setEnabled(false);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleAmplituda.setValue(1.0);
            poleCzasPocz.setValue(0.0);
            poleCzasSyg.setValue(200.0);
            poleCzasSkoku.setValue(100.0);
            poleCzestotliwosc.setValue(1);
        } else if (wybranySygnal == 10) {
            poleAmplituda.setEnabled(false);
            poleCzasPocz.setEnabled(false);
            poleCzasSyg.setEnabled(false);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(true);
            poleIloscPr.setEnabled(true);
            poleCzestotliwosc.setEnabled(false);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleProbkaSkoku.setValue(100);
            poleIloscPr.setValue(200);
        } else if (wybranySygnal == 11) {
            poleAmplituda.setEnabled(false);
            poleCzasPocz.setEnabled(false);
            poleCzasSyg.setEnabled(false);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(true);
            poleIloscPr.setEnabled(true);
            poleCzestotliwosc.setEnabled(false);
            polePrawdopodobienstwo.setEnabled(true);
            histogramSlider.setEnabled(true);
            //            Domyślne wartości
            poleProbkaSkoku.setValue(100);
            poleIloscPr.setValue(200);
            polePrawdopodobienstwo.setValue(0.05);
        }
    }

    private void ustawTypy() {

        poleAmplituda.setModel(new SpinnerNumberModel(1.0, 0.1, 999999.0, 0.1));
        poleCzasPocz.setModel(new SpinnerNumberModel(0.0, 0.0, 999999.0, 0.1));
        poleCzasSyg.setModel(new SpinnerNumberModel(0.1, 0.1, 999999.0, 0.1));
        poleWspWyp.setModel(new SpinnerNumberModel(0.0, 0, 1, 0.1));
        poleOkres.setModel(new SpinnerNumberModel(0.0, -999999.0, 999999.0, 0.1));
        poleCzasSkoku.setModel(new SpinnerNumberModel(0.0, -999999.0, 999999.0, 0.1));
        poleProbkaSkoku.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        poleIloscPr.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        poleCzestotliwosc.setModel(new SpinnerNumberModel(1, 1, 999999, 1));
        polePrawdopodobienstwo.setModel(new SpinnerNumberModel(200, 2, Integer.MAX_VALUE, 1));


    }



    public JComboBox getWyborSygnalu() {
        return wyborSygnalu;
    }

    public JSpinner getPoleAmplituda() {
        return poleAmplituda;
    }

    public JSpinner getPoleCzasPocz() {
        return poleCzasPocz;
    }

    public JSpinner getPoleCzasSyg() {
        return poleCzasSyg;
    }

    public JSpinner getPoleWspWyp() {
        return poleWspWyp;
    }

    public JSpinner getPoleOkres() {
        return poleOkres;
    }

    public JSpinner getPoleCzasSkoku() {
        return poleCzasSkoku;
    }

    public JSpinner getPoleProbkaSkoku() {
        return poleProbkaSkoku;
    }

    public JSpinner getPoleIloscPr() {
        return poleIloscPr;
    }

    public JSpinner getPoleCzestotliwosc() {
        return poleCzestotliwosc;
    }

    public JSlider getHistogramSlider() {
        return histogramSlider;
    }

    public JButton getGenerujButton() {
        return generujButton;
    }

    public JButton getWczytajButton() {
        return wczytajButton;
    }

    public JButton getWyświetlButton() {
        return wyświetlButton;
    }

    public JButton getZapiszButton() {
        return zapiszButton;
    }

    public JList getList1() {
        return list1;
    }

    public JLabel getHistoNum() {
        return histoNum;
    }

    public JSpinner getPolePrawdopodobienstwo() {
        return polePrawdopodobienstwo;
    }

    public JPanel getIloscProbekHistog() {
        return iloscProbekHistog;
    }

    public JButton getDodajButton() {
        return dodajButton;
    }

    public JButton getOdejmijButton() {
        return odejmijButton;
    }

    public JButton getMnozenieButton() {
        return mnozenieButton;
    }

    public JButton getDzielenieButton() {
        return dzielenieButton;
    }

    public void addToList(String text) {
        listModel.addElement(text);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

