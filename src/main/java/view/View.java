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
    private JSlider slider1;
    private JButton generujButton;
    private JButton wczytajButton;
    private JButton wyświetlButton;
    private JButton zapiszButton;
    private JList list1;
    private JLabel histoNum;

    public View() {
        // TODO: Tytuł okna programu
        frame = new JFrame("....");

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setVisible(true);
    }
}
