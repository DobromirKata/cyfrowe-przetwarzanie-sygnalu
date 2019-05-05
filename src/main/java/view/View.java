package view;

import javax.swing.*;

public class View {
    private JFrame frame;
    private JPanel mainPanel;

    public View() {
        // TODO: Tytuł okna programu
        frame = new JFrame("....");

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setVisible(true);
    }
}
