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

    public View() {
        // TODO: Tytuł okna programu
        frame = new JFrame("....");

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setVisible(true);

        histogramSlider.addChangeListener(e -> histoNum.setText(Integer.toString(histogramSlider.getValue())));
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
        } else if (wybranySygnal == 10) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(false);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(true);
            poleIloscPr.setEnabled(true);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(false);
            histogramSlider.setEnabled(true);
        } else if (wybranySygnal == 11) {
            poleAmplituda.setEnabled(true);
            poleCzasPocz.setEnabled(true);
            poleCzasSyg.setEnabled(true);
            poleOkres.setEnabled(false);
            poleWspWyp.setEnabled(false);
            poleCzasSkoku.setEnabled(false);
            poleProbkaSkoku.setEnabled(false);
            poleIloscPr.setEnabled(false);
            poleCzestotliwosc.setEnabled(true);
            polePrawdopodobienstwo.setEnabled(true);
            histogramSlider.setEnabled(true);
        }
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
}
